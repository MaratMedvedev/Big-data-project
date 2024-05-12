"""
Script to build project database
"""

import os
import psycopg2 as psql

PASSWORD = "6MBLFOY0lG3MNJTd"

CONN_STRING = (
    "host=hadoop-04.uni.innopolis.ru "
    "port=5432 "
    "user=team28 "
    "dbname=team28_projectdb "
    "password=" + PASSWORD
)

with psql.connect(CONN_STRING) as conn:
    cur = conn.cursor()
    with open(
        os.path.join("sql", "create_tables_for_ml_res.sql"), encoding="utf-8"
    ) as file:
        content = file.read()
        cur.execute(content)
    conn.commit()

    with open(
        os.path.join("sql", "import_ml_res_data.sql"), encoding="utf-8"
    ) as file:
        commands = file.readlines()
        with open(
            os.path.join("output", "evaluation.csv"),
            "r",
            encoding="utf-8",
        ) as mdl_cmp:
            cur.copy_expert(commands[0], mdl_cmp)
        with open(
            os.path.join("output", "model_dt_best_predictions.csv"),
            "r",
            encoding="utf-8",
        ) as dt_preds:
            cur.copy_expert(commands[1], dt_preds)
        with open(
            os.path.join("output", "model_lr_best_predictions.csv"),
            "r",
            encoding="utf-8",
        ) as lr_preds:
            cur.copy_expert(commands[2], lr_preds)

    conn.commit()
    