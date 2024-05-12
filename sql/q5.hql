USE team28_projectdb;

DROP TABLE IF EXISTS q5_results;
CREATE EXTERNAL TABLE q5_results(
    RERA Boolean,
    Under_construction Boolean,
    Resale Boolean,
    N int,
    Mean_Price FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q5'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q5_results
SELECT 
    p.rera, 
    p.under_construction,
    p.resale,
    COUNT(*) AS N,
    AVG(t.price_in_lacs) AS Mean_Price
    
FROM 
    property_details_part_buck p
JOIN 
    target_price_prediction_fixed t ON p.id = t.property_id
GROUP BY 
    p.rera, p.under_construction,p.resale
ORDER BY 
    Mean_Price DESC;

INSERT OVERWRITE DIRECTORY 'project/output/q5' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q5_results;
