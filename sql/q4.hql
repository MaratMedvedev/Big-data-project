USE team28_projectdb;

DROP TABLE IF EXISTS q4_results;
CREATE EXTERNAL TABLE q4_results(
Resale Boolean,
Mean_price FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q4'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q4_results
SELECT p.resale, AVG(t.price_in_lacs) AS mean_target_price
FROM property_details_part_buck p
JOIN target_price_prediction_fixed t ON p.id = t.property_id
GROUP BY p.resale;

INSERT OVERWRITE DIRECTORY 'project/output/q4' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q4_results;