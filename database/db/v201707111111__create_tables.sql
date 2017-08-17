CREATE TABLE t_project (
  project_id         INT         NOT NULL AUTO_INCREMENT,
  project_name       VARCHAR(45) NOT NULL,
  portfolio_id       INT         NULL,
  release_pattern_id INT         NOT NULL,
  cycle_type_id      INT         NULL,
  project_status     INT         NULL,
  PRIMARY KEY (project_id)
);

CREATE TABLE t_cycle_snap (
  cycle_snap_id   INT          NOT NULL AUTO_INCREMENT,
  cycle_snap_name VARCHAR(200) NOT NULL,
  start_date      DATE         NOT NULL,
  end_date        DATE         NOT NULL,
  targeted_points INT          NOT NULL,
  achieved_points INT          NOT NULL,
  project_id      INT          NOT NULL,
  team_capacity   DOUBLE           NUll default 0,
  waste_days      DOUBLE           NULL default 0,
  is_waste_available BOOLEAN NOT NULL default 0,
  isMoodAvailabel BOOLEAN NOT NULL default 0,
   moodAvearge      DOUBLE           NULL default 0,
  CONSTRAINT pk_cycle_snap_id PRIMARY KEY (cycle_snap_id),
  CONSTRAINT fk_project_id_cycle FOREIGN KEY (project_id) REFERENCES t_project (project_id)
);

CREATE TABLE t_release_snap (
  release_id   INT  NOT NULL AUTO_INCREMENT,
  release_date DATE NOT NULL,
  name VARCHAR(200) NOT NULL,
  project_id   INT  NOT NULL,
  CONSTRAINT pk_release_id PRIMARY KEY (release_id),
  CONSTRAINT fk_project_id_release FOREIGN KEY (project_id) REFERENCES t_project (project_id)
);

CREATE TABLE t_incidents_report (
  report_id       INT  NOT NULL AUTO_INCREMENT,
  report_date     DATE NOT NULL,
  total_incidents INT  NOT NULL,
  project_id      INT  NOT NULL,
  CONSTRAINT pk_report_id PRIMARY KEY (report_id),
  CONSTRAINT fk_project_id_report FOREIGN KEY (project_id) REFERENCES t_project (project_id)
);