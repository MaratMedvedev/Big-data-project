#!/bin/bash

# Dataset downloading
curl -L -o dataset.zip "https://drive.google.com/uc?export=download&id=1xU9_RQUEuvE8l5xPGNVNDfTmXV9jCt2B"
unzip dataset.zip
rm dataset.zip
mv train.csv dataset.csv
mv dataset.csv data

# Dataset preprocessing
python3 scripts/preprocess_dataset.py
rm data/dataset.csv
