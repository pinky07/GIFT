INSERT INTO t_project(project_id, project_name, portfolio_id, release_pattern_id, cycle_type_id, project_status)
VALUES (99999, 'Project Test', 2, 1, 2, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id)
VALUES ('Sprint Test', '2017-05-22', '2017-06-18', 136, 70, 99999);

COMMIT;