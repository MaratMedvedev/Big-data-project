import psycopg2 as psql
from pprint import pprint
import os

with open(os.path.join("secrets", ".psql.pass"), "r") as file:
    password = file.read().rstrip()

conn_string = f"host=hadoop-04.uni.innopolis.ru port=5432 user=team28 dbname=team28_projectdb password={password}"

with psql.connect(conn_string) as conn:
    cur = conn.cursor()
    with open(os.path.join("sql", "create_tables.sql")) as file:
        content = file.read()
        cur.execute(content)
    conn.commit()

    with open(os.path.join("sql", "import_data.sql")) as file:
        commands = file.readlines()
        with open(os.path.join("data", "property_details_with_id.csv"), "r") as property_details:
            cur.copy_expert(commands[0], property_details)
        with open(os.path.join("data", "target_price_prediction_with_id.csv"), "r") as target_price:
            cur.copy_expert(commands[1], target_price)

    conn.commit()

    pprint(conn)
    cur = conn.cursor()
    with open(os.path.join("sql", "test_database.sql")) as file:
        commands = file.readlines()
        for command in commands:
            cur.execute(command)
            pprint(cur.fetchall())