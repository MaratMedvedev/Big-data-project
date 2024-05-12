COPY models_comparison (model, RMSE, R2) FROM STDIN WITH CSV HEADER DELIMITER ',' QUOTE '"' NULL AS 'null';
COPY best_dt_prediction_samples (label, prediction) FROM STDIN WITH CSV HEADER DELIMITER ',' QUOTE '''' NULL AS 'null';
COPY best_lr_prediction_samples (label, prediction) FROM STDIN WITH CSV HEADER DELIMITER ',' QUOTE '''' NULL AS 'null';
