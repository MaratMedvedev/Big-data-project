USE team28_projectdb;

DROP TABLE IF EXISTS q1_results;
CREATE EXTERNAL TABLE q1_results(
Under_construction Boolean,
Mean_price FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q1'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q1_results
SELECT p.under_construction, AVG(t.price_in_lacs) AS mean_target_price
FROM property_details_part_buck p
JOIN target_price_prediction_fixed t ON p.id = t.property_id
GROUP BY p.under_construction;

INSERT OVERWRITE DIRECTORY 'project/output/q1' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q1_results;