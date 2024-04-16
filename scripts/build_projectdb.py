"""
Script to build project database
"""

from pprint import pprint
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
        os.path.join("sql", "create_tables.sql"), encoding="utf-8"
    ) as file:
        content = file.read()
        cur.execute(content)
    conn.commit()

    with open(
        os.path.join("sql", "import_data.sql"), encoding="utf-8"
    ) as file:
        commands = file.readlines()
        with open(
            os.path.join("data", "property_details_with_id.csv"),
            "r",
            encoding="utf-8",
        ) as property_details:
            cur.copy_expert(commands[0], property_details)
        with open(
            os.path.join("data", "target_price_prediction_with_id.csv"),
            "r",
            encoding="utf-8",
        ) as target_price:
            cur.copy_expert(commands[1], target_price)

    conn.commit()

    pprint(conn)
    cur = conn.cursor()
    with open(
        os.path.join("sql", "test_database.sql"), encoding="utf-8"
    ) as file:
        commands = file.readlines()
        for command in commands:
            cur.execute(command)
            pprint(cur.fetchall())
