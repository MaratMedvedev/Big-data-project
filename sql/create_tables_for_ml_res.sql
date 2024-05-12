START TRANSACTION;

DROP TABLE IF EXISTS models_comparison;
DROP TABLE IF EXISTS best_dt_prediction_samples;
DROP TABLE IF EXISTS best_lr_prediction_samples;

CREATE TABLE IF NOT EXISTS models_comparison (
    model VARCHAR(250),
    RMSE NUMERIC(20, 10),
    R2 NUMERIC(20, 10)
);
CREATE TABLE IF NOT EXISTS best_dt_prediction_samples (
    label NUMERIC(20, 10),
    prediction NUMERIC(20, 10)
);
CREATE TABLE IF NOT EXISTS best_lr_prediction_samples (
    label NUMERIC(20, 10),
    prediction NUMERIC(20, 10)
);

COMMIT;
