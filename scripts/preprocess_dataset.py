# preprocess dataset

import csv
import os

with open(os.path.join("data", "dataset.csv"), 'r') as dataset:
    header = dataset.readline().strip()
    data = dataset.readlines()

records = [line.split("\"") for line in data]
property_details_without_id = []
for record in records:
    record = record[0].split(",")[:-1] + ["\"" + str(record[1]).replace(",", "_") + "\""] + record[2].split(",")[1:-1]
    property_details_without_id.append(record)
target_price_prediction_without_id = [record[2].split(",")[-1] for record in records]

with open(os.path.join("data", 'property_details_with_id.csv'), 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(["ID","POSTED_BY","UNDER_CONSTRUCTION","RERA","BHK_NO.","BHK_OR_RK","SQUARE_FT","READY_TO_MOVE","RESALE","ADDRESS","LONGITUDE","LATITUDE"])
    for i in range(len(property_details_without_id)):
        record = str(i) + "," + ",".join(property_details_without_id[i])
        record = record.split(",")
        record[9] = record[9][1:-1]
        writer.writerow(record)

with open(os.path.join("data", 'target_price_prediction_with_id.csv'), 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow(["PROPERTY_ID", "TARGET(PRICE_IN_LACS)"])
    for i in range(len(target_price_prediction_without_id)):
        writer.writerow([i, float(target_price_prediction_without_id[i])])