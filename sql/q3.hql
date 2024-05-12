USE team28_projectdb;

DROP TABLE IF EXISTS q3_results;
CREATE EXTERNAL TABLE q3_results(
BHK_NO int,
Mean_price FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q3'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q3_results
SELECT p.bhk_no, AVG(t.price_in_lacs) AS mean_target_price
FROM property_details_part_buck p
JOIN target_price_prediction_fixed t ON p.id = t.property_id
GROUP BY p.bhk_no; 

INSERT OVERWRITE DIRECTORY 'project/output/q3' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q3_results;