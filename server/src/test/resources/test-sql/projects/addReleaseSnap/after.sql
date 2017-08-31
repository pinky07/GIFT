SET SQL_SAFE_UPDATES = 0;

DELETE FROM t_release_snap WHERE project_id = 123456;

DELETE FROM t_project WHERE project_id = 123456;

DELETE FROM t_portfolio WHERE portfolio_id = 12345;

COMMIT;

SET SQL_SAFE_UPDATES = 1;