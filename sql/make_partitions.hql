SET hive.exec.dynamic.partition = true; 
SET hive.exec.dynamic.partition.mode = nonstrict; 

USE team28_projectdb;

-- Create new external table partitioned by poster and bucketed by area(also to fix column datatypes)
drop table if exists property_details_part_buck;
CREATE EXTERNAL TABLE property_details_part_buck(
    id int,
    under_construction boolean,
    rera boolean,
    bhk_no int,
    bhk_or_rk varchar(50),
    square_ft decimal(20,10),
    ready_to_move boolean,
    resale boolean,
    address varchar(255),
    longitude decimal(19,10),
    latitude decimal(19,10)
)
    PARTITIONED BY (posted_by varchar(50))
    CLUSTERED BY (square_ft) into 7 buckets
    STORED AS AVRO LOCATION 'project/hive/warehouse/property_details_part_buck'
    TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

-- Insert data from unpartitioned table
INSERT INTO property_details_part_buck
PARTITION (posted_by)
SELECT id, under_construction, rera, bhk_no, bhk_or_rk, square_ft, ready_to_move, resale,address, longitude, latitude, posted_by FROM property_details;

-- Check accessibility
DESCRIBE property_details_part_buck;
SELECT * FROM property_details_part_buck WHERE posted_by="Builder" AND square_ft<300 limit 10;

-- Delete old unpartitoned table
DROP TABLE IF EXISTS property_details;

-- Create new table for target_price_prediction to fix column datatype
drop table if exists target_price_prediction_fixed;
CREATE EXTERNAL TABLE target_price_prediction_fixed(
   property_id int,
   price_in_lacs decimal(10,1)
)
    CLUSTERED BY (property_id) into 7 buckets
    STORED AS AVRO LOCATION 'project/hive/warehouse/target_price_prediction_fixed'
    TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

-- Insert data from old table
INSERT INTO target_price_prediction_fixed
SELECT * FROM target_price_prediction;

-- Check accessibility
DESCRIBE target_price_prediction_fixed;
SELECT * FROM target_price_prediction_fixed WHERE property_id>100 limit 10;

-- Delete old table
DROP TABLE IF EXISTS target_price_prediction;
