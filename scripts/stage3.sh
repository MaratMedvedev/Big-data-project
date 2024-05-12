#!/bin/bash

spark-submit --master yarn scripts/model.py 2> /dev/null
sleep 5
if [ -d "scripts/.ipynb_checkpoints" ]; then rm -r scripts/.ipynb_checkpoints; fi