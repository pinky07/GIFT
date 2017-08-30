SET SQL_SAFE_UPDATES = 0;

DELETE FROM t_release_snap WHERE project_id = 12345;

DELETE FROM t_cycle_snap WHERE project_id = 12345;

DELETE FROM t_incidents_report WHERE project_id = 12345;

DELETE FROM t_project WHERE project_id = 12345;
DELETE FROM t_project WHERE project_id = 12346;

DELETE FROM t_portfolio WHERE portfolio_id = 12345;

COMMIT;

SET SQL_SAFE_UPDATES = 1;
