COPY property_details (id, posted_by, under_construction, rera, bhk_no, bhk_or_rk, square_ft, ready_to_move, resale, address, longitude, latitude) FROM STDIN WITH CSV HEADER DELIMITER ',' QUOTE '''' NULL AS 'null';
COPY target_price_prediction (property_id, price_in_lacs) FROM STDIN WITH CSV HEADER DELIMITER ',' QUOTE '''' NULL AS 'null';
