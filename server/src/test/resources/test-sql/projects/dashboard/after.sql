SET SQL_SAFE_UPDATES = 0;

DELETE FROM t_cycle_snap WHERE cycle_snap_name = 'Sprint Test';

DELETE FROM t_project WHERE project_id = 99999;

COMMIT;

SET SQL_SAFE_UPDATES = 1;
