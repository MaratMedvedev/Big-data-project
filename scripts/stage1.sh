# !/bin/bash
python3 scripts/build_projectdb.py

if $(hdfs dfs -test -d project/warehouse/property_details) ; then $(hdfs dfs -rm -r project/warehouse/property_details); fi
if $(hdfs dfs -test -d project/warehouse/target_price_prediction) ; then $(hdfs dfs -rm -r project/warehouse/target_price_prediction); fi

sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team28_projectdb --username team28 \
--password 6MBLFOY0lG3MNJTd --compression-codec=snappy --compress --as-avrodatafile --warehouse-dir=project/warehouse \
--m 1

mv property_details.java output
mv property_details.avsc output
mv target_price_prediction.avsc output
mv target_price_prediction.java output
