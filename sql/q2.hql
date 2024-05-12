USE team28_projectdb;

DROP TABLE IF EXISTS q2_results;
CREATE EXTERNAL TABLE q2_results(
RERA Boolean,
Mean_price FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q2'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q2_results
SELECT p.rera, AVG(t.price_in_lacs) AS mean_target_price
FROM property_details_part_buck p
JOIN target_price_prediction_fixed t ON p.id = t.property_id
GROUP BY p.rera;

INSERT OVERWRITE DIRECTORY 'project/output/q2' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q2_results;