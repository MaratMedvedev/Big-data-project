#!/usr/bin/env python
# coding: utf-8
"""
Solution for stage3
"""
import os
from pprint import pprint
import numpy as np

from pyspark.sql import SparkSession
from pyspark import keyword_only
from pyspark.ml import Transformer
from pyspark.ml.param.shared import HasInputCol, HasOutputCol, Param,\
    Params, TypeConverters
from pyspark.ml.util import DefaultParamsReadable, DefaultParamsWritable
from pyspark.sql import DataFrame
from pyspark.ml.param.shared import HasInputCols, HasOutputCols

from pyspark.sql.functions import when

import pyspark.sql.functions as F
from pyspark.ml import Pipeline
from pyspark.ml.feature import OneHotEncoder, StringIndexer, VectorAssembler
from pyspark.sql.types import StringType

from pyspark.ml.regression import LinearRegression
from pyspark.ml.tuning import ParamGridBuilder, CrossValidator

from pyspark.ml.regression import DecisionTreeRegressor
from pyspark.ml.evaluation import RegressionEvaluator

TEAM = 28

WAREHOUSE = "project/hive/warehouse"


spark = SparkSession.builder\
            .appName(f"{TEAM} - spark ML")\
            .master("yarn")\
            .config("hive.metastore.uris",
                    "thrift://hadoop-02.uni.innopolis.ru:9883")\
            .config("spark.sql.warehouse.dir", WAREHOUSE)\
            .config("spark.sql.avro.compression.codec", "snappy")\
            .enableHiveSupport()\
            .getOrCreate()


# In[2]:


print(spark.catalog.listTables("team28_projectdb"))


# In[3]:


property_details = spark.read.format("avro").\
    table('team28_projectdb.property_details_part_buck')
q1_results = spark.read.format("avro").table('team28_projectdb.q1_results')
q2_results = spark.read.format("avro").table('team28_projectdb.q2_results')
q3_results = spark.read.format("avro").table('team28_projectdb.q3_results')
q4_results = spark.read.format("avro").table('team28_projectdb.q4_results')
q5_results = spark.read.format("avro").table('team28_projectdb.q5_results')
target_price_prediction = spark.read.format("avro").\
    table('team28_projectdb.target_price_prediction_fixed')


# In[4]:


property_details.printSchema()
q1_results.printSchema()
q2_results.printSchema()
q3_results.printSchema()
q4_results.printSchema()
q5_results.printSchema()
target_price_prediction.printSchema()


# In[5]:


property_details.show(3)


# In[6]:


q1_results.show(2)


# In[7]:


q2_results.show(2)


# In[8]:


q3_results.show(2)


# In[9]:


q4_results.show(2)


# In[10]:


q5_results.show(2)


# In[11]:


target_price_prediction.show(3)


# In[12]:


df = property_details.join(target_price_prediction,
                           property_details.id == target_price_prediction.
                           property_id, "inner")
df.show(1)


# In[13]:


df = df.drop("id")
df = df.drop("property_id")
df.show(1)


# In[14]:

class EcefCoordinatesTransformer(Transformer, HasInputCol, HasOutputCol,
                                 DefaultParamsReadable,
                                 DefaultParamsWritable):
    """
    Transforms lattitude and longitude into ECEF coordinates
    """

    input_cols = Param(Params._dummy(), "input_cols", "input columns names.",
                       typeConverter=TypeConverters.toString)
    output_cols = Param(Params._dummy(), "output_cols",
                        "output columns names.",
                        typeConverter=TypeConverters.toString)

    @keyword_only
    def __init__(self, input_cols: str = "input", output_cols: str = "output"):
        super().__init__()
        print(input_cols, output_cols)
        self._setDefault(input_cols=None, output_cols=None)

        kwargs = self._input_kwargs
        print("Input kwargs: ", kwargs)
        self.set_params(**kwargs)

    @keyword_only
    def set_params(self, input_cols: str = "input",
                   output_cols: str = "output"):
        """
        Setting input and ouput columns
        """
        print(input_cols, output_cols)
        kwargs = self._input_kwargs
        self._set(**kwargs)

    def get_input_cols(self):
        """
        Returns input columns
        """
        return self.getOrDefault(self.input_cols)

    def get_output_cols(self):
        """
        Returns output columns
        """
        return self.getOrDefault(self.output_cols)

    def _transform(self, dataset: DataFrame):
        input_cols = self.get_input_cols().split(',')
        output_cols = self.get_output_cols().split(',')
        assert len(input_cols) == 2,\
            "Expected two input columns: latitude and longitude."
        assert len(output_cols) == 2, "Expected two output columns: x and y."

        def ecef_transform(longitude, latitude):
            axis = 6378137.0  # semi-major axis of the WGS-84 ellipsoid in meters
            ecc = 0.081819190842622  # eccentricity of the WGS-84 ellipsoid

            longitude_rad = F.radians(longitude)
            latitude_rad = F.radians(latitude)

            # calculate the radius of curvature in the prime vertical
            radius = axis / (1 - ecc**2 * latitude_rad**2)**0.5

            x_coord = radius * F.cos(latitude_rad) * F.cos(longitude_rad)
            y_coord = radius * F.cos(latitude_rad) * F.sin(longitude_rad)

            return x_coord, y_coord

        x_coord, y_coord = ecef_transform(dataset[input_cols[0]],
                                          dataset[input_cols[1]])
        dataset = dataset.withColumn(output_cols[0], x_coord)
        dataset = dataset.withColumn(output_cols[1], y_coord)
        dataset = dataset.drop(input_cols[0])
        dataset = dataset.drop(input_cols[1])

        return dataset


# In[15]:

class MultiBooleanToIntTransformer(Transformer, HasInputCols, HasOutputCols,
                                   DefaultParamsReadable,
                                   DefaultParamsWritable):
    """
    Transforms boolean values to integers
    """
    input_cols = Param(Params._dummy(), "input_cols", "input columns names.",
                       typeConverter=TypeConverters.toString)
    output_cols = Param(Params._dummy(), "output_cols",
                        "output columns names.",
                        typeConverter=TypeConverters.toString)

    @keyword_only
    def __init__(self, input_cols: str = "input", output_cols: str = "output"):
        super().__init__()
        self._setDefault(input_cols=None, output_cols=None)
        print(input_cols, output_cols)
        kwargs = self._input_kwargs
        self.set_params(**kwargs)

    @keyword_only
    def set_params(self, input_cols: str = "input",
                   output_cols: str = "output"):
        """
        Setting input and ouput columns
        """
        print(input_cols, output_cols)
        kwargs = self._input_kwargs
        self._set(**kwargs)

    def get_input_cols(self):
        """
        Returns input columns
        """
        return self.getOrDefault(self.input_cols)

    def get_output_cols(self):
        """
        Returns output columns
        """
        return self.getOrDefault(self.output_cols)

    def _transform(self, dataset: DataFrame):
        input_cols = self.get_input_cols().split(',')
        output_cols = self.get_output_cols().split(',')

        assert len(input_cols) == len(output_cols),\
            "The number of input and output columns must match."

        # apply the transformation to each input column and create
        # corresponding output columns
        for input_col, output_col in zip(input_cols, output_cols):
            transform_logic = when(df[input_col], 1).otherwise(0)
            dataset = dataset.withColumn(output_col, transform_logic)

        return dataset


# In[16]:


class AddressTransformer(Transformer, HasInputCol, HasOutputCol,
                         DefaultParamsReadable, DefaultParamsWritable):
    """
    Transforms full adress to the city
    """
    input_cols = Param(Params._dummy(), "input_cols", "input columns names.",
                       typeConverter=TypeConverters.toString)
    output_cols = Param(Params._dummy(), "output_cols",
                        "output columns names.",
                        typeConverter=TypeConverters.toString)

    @keyword_only
    def __init__(self, input_cols: str = "input", output_cols: str = "output"):
        super().__init__()
        print(input_cols, output_cols)
        self._setDefault(input_cols=None, output_cols=None)
        kwargs = self._input_kwargs
        self.set_params(**kwargs)

    @keyword_only
    def set_params(self, input_cols: str = "input",
                   output_cols: str = "output"):
        """
        Setting input and ouput columns
        """
        print(input_cols, output_cols)
        kwargs = self._input_kwargs
        self._set(**kwargs)

    def get_input_cols(self):
        """
        Returns input columns
        """
        return self.getOrDefault(self.input_cols)

    def get_output_cols(self):
        """
        Returns output columns
        """
        return self.getOrDefault(self.output_cols)

    def _transform(self, dataset: DataFrame):
        input_cols = self.get_input_cols().split(',')
        output_cols = self.get_output_cols().split(',')
        assert len(input_cols) == 1, "Expected one input column: address."
        assert len(output_cols) == 1, "Expected one output column: city."

        # define the UDF for extracting city from address
        extract_city_udf = F.udf(lambda address: address.
                                 split(",")[-1].strip(),
                                 StringType())

        dataset = dataset.withColumn(output_cols[0],
                                     extract_city_udf(dataset[input_cols[0]]))
        dataset = dataset.drop(input_cols[0])

        return dataset


# In[17]:


ecef = EcefCoordinatesTransformer(input_cols="longitude,latitude",
                                  output_cols="x,y")
boolean_to_int = MultiBooleanToIntTransformer(input_cols="under_construction,\
rera,ready_to_move,resale",
                                              output_cols="under_construction,\
rera,ready_to_move,resale")
address = AddressTransformer(input_cols="address", output_cols="city")

indexer_bhk_or_rk = StringIndexer(inputCol="bhk_or_rk",
                                  outputCol="indexed_bhk_or_rk")
indexer_city = StringIndexer(inputCol="city", outputCol="indexed_city")
indexer_posted_by = StringIndexer(inputCol="posted_by",
                                  outputCol="indexed_posted_by")

one_hot_bhk_or_rk = OneHotEncoder(inputCol="indexed_bhk_or_rk",
                                  outputCol="bhk_or_rk_enc")
one_hot_city = OneHotEncoder(inputCol="indexed_city", outputCol="city_enc")
one_hot_posted_by = OneHotEncoder(inputCol="indexed_posted_by",
                                  outputCol="posted_by_enc")

assembler = VectorAssembler(inputCols=["under_construction", "rera", "bhk_no",
                                       "square_ft", "ready_to_move", "resale",
                                       "x", "y", "bhk_or_rk_enc", "city_enc",
                                       "posted_by_enc"], outputCol="features")

pipeline = Pipeline(stages=[ecef, boolean_to_int, address, indexer_bhk_or_rk,
                            indexer_city, indexer_posted_by, one_hot_bhk_or_rk,
                            one_hot_city, one_hot_posted_by, assembler])
model = pipeline.fit(df)
df = model.transform(df)


# In[18]:


df.show()


# In[19]:


df = df.select(["features", "price_in_lacs"])
df = df.withColumnRenamed("price_in_lacs", "label")
df.show()


# In[20]:


(train_data, test_data) = df.randomSplit([0.8, 0.2], seed=121)


def run(command):
    """
    Function for running commands in cmd
    """
    return os.popen(command).read()


train_data.select("features", "label")\
        .coalesce(1)\
        .write\
        .mode("overwrite")\
        .format("json")\
        .save("project/data/train")

# run it from root directory of the repository
run("hdfs dfs -cat project/data/train/*.json > data/train.json")

test_data.select("features", "label")\
        .coalesce(1)\
        .write\
        .mode("overwrite")\
        .format("json")\
        .save("project/data/test")

# run it from root directory of the repository
run("hdfs dfs -cat project/data/test/*.json > data/test.json")


# # Model 1

# In[21]:


# linear regression

lr = LinearRegression()
model_lr = lr.fit(train_data)

predictions_lr = model_lr.transform(test_data)
predictions_lr.show()


# In[22]:

# evaluate the performance of the model
evaluator = RegressionEvaluator(labelCol="label", predictionCol="prediction",
                                metricName="rmse")
rmse_lr = evaluator.evaluate(predictions_lr)
r2_lr = evaluator.evaluate(predictions_lr, {evaluator.metricName: "r2"})
print(f"RMSE: {rmse_lr}")
print(f"R2: {r2_lr}")


# In[23]:


grid = ParamGridBuilder()
grid = grid.addGrid(
                    model_lr.aggregationDepth, [2, 3, 4])\
                    .addGrid(model_lr.regParam,
                             np.logspace(1e-3, 1e-1, num=3))\
                    .build()

cv = CrossValidator(estimator=lr,
                    estimatorParamMaps=grid,
                    evaluator=evaluator,
                    parallelism=5,
                    numFolds=3)

cvModel = cv.fit(train_data)
bestModel = cvModel.bestModel
print(bestModel)


# In[24]:

model_lr_best = bestModel
pprint(model_lr_best.extractParamMap())


# In[25]:


model_lr_best.write().overwrite().save("project/models/model_lr_best")

# Run it from root directory of the repository
run("hdfs dfs -get project/models/model_lr_best models/model_lr_best")


# In[26]:


model_lr_best_predictions = model_lr_best.transform(test_data)
model_lr_best_predictions.show()

model_lr_best_predictions.select("label", "prediction")\
        .repartition(1)\
        .write\
        .mode("overwrite")\
        .format("csv")\
        .option("sep", ",")\
        .option("header", "true")\
        .save("project/output/model_lr_best_predictions.csv")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/model_lr_best_predictions.csv/*.csv > \
output/model_lr_best_predictions.csv")


# In[27]:


# evaluate the performance of the model
rmse_lr_best = evaluator.evaluate(model_lr_best_predictions)
r2_lr_best = evaluator.evaluate(model_lr_best_predictions,
                                {evaluator.metricName: "r2"})
print(f"RMSE: {rmse_lr_best}")
print(f"R2: {r2_lr_best}")


# # Model 2

# In[28]:


# linear regression

dt = DecisionTreeRegressor()
model_dt = dt.fit(train_data)

predictions_dt = model_dt.transform(test_data)
predictions_dt.show()


# In[29]:

# evaluate the performance of the model
rmse_dt = evaluator.evaluate(predictions_dt)
r2_dt = evaluator.evaluate(predictions_dt, {evaluator.metricName: "r2"})
print(f"RMSE: {rmse_dt}")
print(f"R2: {r2_dt}")


# In[31]:

grid = ParamGridBuilder()\
        .addGrid(dt.maxDepth, [3, 5, 7])\
        .addGrid(dt.minInstancesPerNode, [1, 2, 3])\
        .build()

cv = CrossValidator(estimator=dt,
                    estimatorParamMaps=grid,
                    evaluator=evaluator,
                    parallelism=5,
                    numFolds=3)

cvModel = cv.fit(train_data)
bestModel = cvModel.bestModel
print(bestModel)


# In[ ]:


model_dt_best = bestModel
pprint(model_dt_best.extractParamMap())


# In[ ]:


model_dt_best.write().overwrite().save("project/models/model_dt_best")

# Run it from root directory of the repository
run("hdfs dfs -get project/models/model_dt_best models/model_dt_best")


# In[ ]:


model_dt_best_predictions = model_dt_best.transform(test_data)
model_dt_best_predictions.show()

model_dt_best_predictions.select("label", "prediction")\
        .repartition(1)\
        .write\
        .mode("overwrite")\
        .format("csv")\
        .option("sep", ",")\
        .option("header", "true")\
        .save("project/output/model_dt_best_predictions.csv")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/model_dt_best_predictions.csv/*.csv > \
output/model_dt_best_predictions.csv")


# evaluate the performance of the model
rmse_dt_best = evaluator.evaluate(model_dt_best_predictions)
r2_dt_best = evaluator.evaluate(model_dt_best_predictions,
                                {evaluator.metricName: "r2"})
print(f"RMSE: {rmse_dt_best}")
print(f"R2: {r2_dt_best}")


# # Compare

# create data frame to report performance of the models
models = [[str(model_lr_best), rmse_lr_best, r2_lr_best],
          [str(model_dt_best), rmse_dt_best, r2_dt_best]]

df = spark.createDataFrame(models, ["model", "RMSE", "R2"])
df.show(truncate=False)

# save it to HDFS
df.repartition(1)\
        .write\
        .mode("overwrite")\
        .format("csv")\
        .option("sep", ",")\
        .option("header", "true")\
        .save("project/output/evaluation.csv")

# Run it from root directory of the repository
run("hdfs dfs -cat project/output/evaluation.csv/*.csv > \
output/evaluation.csv")
