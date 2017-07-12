CREATE TABLE t_project (
  project_id INT NOT NULL AUTO_INCREMENT,
  project_name VARCHAR(45) NOT NULL,
  portfolio_id INT NULL,
  release_pattern_id INT NOT NULL,
  cycle_type_id INT NULL,
  project_status INT NULL,
  PRIMARY KEY (project_id)
);