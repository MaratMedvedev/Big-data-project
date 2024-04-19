DROP DATABASE IF EXISTS team28_projectdb CASCADE;

CREATE DATABASE team28_projectdb LOCATION "project/hive/warehouse";
USE team28_projectdb;

-- Create tables

-- property_details table
CREATE EXTERNAL TABLE property_details STORED AS AVRO LOCATION 'project/warehouse/property_details' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/property_details.avsc');

-- target_price_prediction table
CREATE EXTERNAL TABLE target_price_prediction STORED AS AVRO LOCATION 'project/warehouse/target_price_prediction' TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/target_price_prediction.avsc');

--Test database
DESCRIBE property_details;
SELECT * FROM property_details LIMIT 5;

DESCRIBE target_price_prediction;
SELECT * FROM target_price_prediction LIMIT 5;
