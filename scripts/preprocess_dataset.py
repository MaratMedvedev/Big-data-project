"""
Preprocesses dataset.
"""

import csv
import os

with open(os.path.join("data", "dataset.csv"), 'r', encoding='utf-8') as dataset:
    header = dataset.readline().strip()
    data = dataset.readlines()

records = [line.split("\"") for line in data]
property_details_without_id = []
for record in records:
    ADDRESS = '"' + str(record[1]).replace(",", "_") + '"'
    record = record[0].split(",")[:-1] + [ADDRESS] + record[2].split(",")[1:-1]
    property_details_without_id.append(record)

target_price_prediction_without_id = [r[2].split(",")[-1] for r in records]

with open(os.path.join("data",'property_details_with_id.csv'),
         'w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(["ID", "POSTED_BY", "UNDER_CONSTRUCTION", "RERA", "BHK_NO.",
		     "BHK_OR_RK", "SQUARE_FT", "READY_TO_MOVE", "RESALE",
	             "ADDRESS", "LONGITUDE", "LATITUDE"])
    for i, record in enumerate(property_details_without_id):
        record[9] = record[9][1:-1]
        writer.writerow([i] + record)

with open(os.path.join("data", 'target_price_prediction_with_id.csv'),
     'w', newline='', encoding='utf-8') as file:
    writer = csv.writer(file)
    writer.writerow(["PROPERTY_ID", "TARGET(PRICE_IN_LACS)"])
    for i, price in enumerate(target_price_prediction_without_id):
        writer.writerow([i, float(price)])
