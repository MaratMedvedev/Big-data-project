#!/bin/bash
hdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put -f output/*.avsc project/warehouse/avsc

# Create initial Hive tables
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team28 -p 6MBLFOY0lG3MNJTd -f sql/db.hql > output/hive_results.txt 2> /dev/null

# Make external, partitioned, bucketing table for property_details table with fixed column datatypes
# and bucketing table for target_price_prediction table with fixed datatypes
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team28 -p 6MBLFOY0lG3MNJTd -f sql/make_partitions.hql > output/hive_results2.txt 2> /dev/null
