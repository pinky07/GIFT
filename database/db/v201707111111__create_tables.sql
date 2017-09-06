CREATE TABLE t_portfolio  (
  portfolio_id       INT  NOT NULL AUTO_INCREMENT,
  portfolio_name VARCHAR(200) NOT NULL,
  PRIMARY KEY (portfolio_id)
);

CREATE TABLE t_project (
  project_id         INT         NOT NULL AUTO_INCREMENT,
  project_name       VARCHAR(45) NOT NULL,
  portfolio_id       INT         NULL,
  PRIMARY KEY (project_id),
  CONSTRAINT fk_portfolio_id FOREIGN KEY (portfolio_id) REFERENCES t_portfolio (portfolio_id)
);

CREATE TABLE t_cycle_snap (
  cycle_snap_id   INT          NOT NULL AUTO_INCREMENT,
  cycle_snap_name VARCHAR(200) NOT NULL,
  start_date      DATE         NOT NULL,
  end_date        DATE         NOT NULL,
  targeted_points INT          NOT NULL,
  achieved_points INT          NOT NULL,
  project_id      INT          NOT NULL,
  team_capacity   DOUBLE       NOT NULL,
  waste_days      DOUBLE       NOT NULL,
  is_waste_available BOOLEAN   NOT NULL,
  is_mood_available BOOLEAN    NOT NULL,
   mood_average      DOUBLE    NOT NULL,
  PRIMARY KEY (cycle_snap_id),
  CONSTRAINT fk_project_id_cycle FOREIGN KEY (project_id) REFERENCES t_project (project_id)
);

CREATE TABLE t_release_snap (
  release_id   INT  NOT NULL AUTO_INCREMENT,
  release_date DATE NOT NULL,
  name VARCHAR(200) NOT NULL,
  project_id   INT  NOT NULL,
  PRIMARY KEY (release_id),
  CONSTRAINT fk_project_id_release FOREIGN KEY (project_id) REFERENCES t_project (project_id)
);

CREATE TABLE t_incidents_report (
  report_id       INT  NOT NULL AUTO_INCREMENT,
  report_date     DATE NOT NULL,
  total_incidents INT  NOT NULL,
  project_id      INT  NOT NULL,
  rationale_issues varchar(2000) NOT NULL,
  PRIMARY KEY (report_id),
  CONSTRAINT fk_project_id_report FOREIGN KEY (project_id) REFERENCES t_project (project_id)
);