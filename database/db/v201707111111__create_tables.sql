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
  cycle_snap_name VARCHAR(200) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  targeted_points INT NOT NULL,
  achieved_points INT NOT NULL,
  project_id INT NOT NULL,
  CONSTRAINT pk_cycle_snap_id PRIMARY KEY (cycle_snap_id),
  CONSTRAINT fk_project_id_cycle FOREIGN KEY (project_id) REFERENCES t_project (project_id)
);

CREATE TABLE t_release_snap (
  release_id INT  AUTO_INCREMENT  NOT NULL,
  release_date DATE NOT NULL,
  project_id INT NOT NULL,
    CONSTRAINT pk_release_id PRIMARY KEY (release_id),
   CONSTRAINT project_id
   FOREIGN KEY (project_id)
   REFERENCES t_project (project_id)
);