# !/bin/bash
python3 scripts/build_projectdb.py 2> /dev/null

if $(hdfs dfs -test -d project/warehouse/property_details) ; then $(hdfs dfs -rm -r project/warehouse/property_details); fi
if $(hdfs dfs -test -d project/warehouse/target_price_prediction) ; then $(hdfs dfs -rm -r project/warehouse/target_price_prediction); fi

sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team28_projectdb --username team28 \
--password 6MBLFOY0lG3MNJTd --compression-codec=snappy --compress --as-avrodatafile --warehouse-dir=project/warehouse \
--m 1 2> /dev/null

mv property_details.java output
mv property_details.avsc output
mv target_price_prediction.avsc output
mv target_price_prediction.java output

if [ -f "models_comparison.avsc" ]; then rm models_comparison.avsc; fi
if [ -f "models_comparison.java" ]; then rm models_comparison.java; fi

if [ -f "best_dt_prediction_samples.avsc" ]; then rm best_dt_prediction_samples.avsc; fi
if [ -f "best_dt_prediction_samples.java" ]; then rm best_dt_prediction_samples.java; fi

if [ -f "best_lr_prediction_samples.avsc" ]; then rm best_lr_prediction_samples.avsc; fi
if [ -f "best_lr_prediction_samples.java" ]; then rm best_lr_prediction_samples.java; fi
