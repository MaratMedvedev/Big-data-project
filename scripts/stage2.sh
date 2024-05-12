#!/bin/bash
hdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put -f output/*.avsc project/warehouse/avsc

# Create initial Hive tables
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team28 -p 6MBLFOY0lG3MNJTd -f sql/db.hql > output/hive_results.txt 2> /dev/null

# Make external, partitioned, bucketing table for property_details table with fixed column datatypes
# and bucketing table for target_price_prediction table with fixed datatypes
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team28 -p 6MBLFOY0lG3MNJTd -f sql/make_partitions.hql > output/hive_results2.txt 2> /dev/null

# EDA
# Insight 1:
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team28 -p 6MBLFOY0lG3MNJTd -f sql/q1.hql 2> /dev/null
echo "Under_construction,Mean_price" > output/q1.csv # Add a header to the output file
hdfs dfs -cat project/output/q1/* >> output/q1.csv

# Insight 2:
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team28 -p 6MBLFOY0lG3MNJTd -f sql/q2.hql 2> /dev/null
echo "RERA,Mean_price" > output/q2.csv # Add a header to the output file
hdfs dfs -cat project/output/q2/* >> output/q2.csv

# Insight 3:
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team28 -p 6MBLFOY0lG3MNJTd -f sql/q3.hql 2> /dev/null
echo "BHK_NO,Mean_price" > output/q3.csv # Add a header to the output file
hdfs dfs -cat project/output/q3/* >> output/q3.csv

# Insight 4:
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team28 -p 6MBLFOY0lG3MNJTd -f sql/q4.hql 2> /dev/null
echo "Resale,Mean_price" > output/q4.csv # Add a header to the output file
hdfs dfs -cat project/output/q4/* >> output/q4.csv

# Insight 5:
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team28 -p 6MBLFOY0lG3MNJTd -f sql/q5.hql 2> /dev/null
echo "RERA,UNDER_CONSTRUCTION,RESALE,N,MEAN_PRICE" > output/q5.csv # Add a header to the output file
hdfs dfs -cat project/output/q5/* >> output/q5.csv