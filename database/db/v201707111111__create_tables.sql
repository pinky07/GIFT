CREATE TABLE t_project (
  project_id INT NOT NULL AUTO_INCREMENT,
  project_name VARCHAR(45) NOT NULL,
  portfolio_id INT NULL,
  release_pattern_id INT NOT NULL,
  cycle_type_id INT NULL,
  project_status INT NULL,
  PRIMARY KEY (project_id)
);

CREATE TABLE t_cycle_snap (
  cycle_snap_id INT NOT NULL AUTO_INCREMENT,
  cycle_snap_name VARCHAR(200),
  start_date DATETIME NULL,
  end_date DATETIME NULL,
  targeted_points INT NULL,
  points_achieved INT NULL,
  project_id INT NULL,
  CONSTRAINT pk_cycle_snap_id PRIMARY KEY (cycle_snap_id),
  CONSTRAINT fk_project_id_cycle FOREIGN KEY (project_id) REFERENCES t_project (project_id)
);