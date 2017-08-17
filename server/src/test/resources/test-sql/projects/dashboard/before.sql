-- Test data for integration test "Should get dashboard by project Id"
INSERT INTO t_project(project_id, project_name, portfolio_id, release_pattern_id, cycle_type_id, project_status)
VALUES (99999, 'Project Test', 2, 1, 2, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id)
VALUES ('Sprint Test', '2017-05-22', '2017-06-18', 136, 70, 99999);

-- Test data for integration test
INSERT INTO t_project(project_id, project_name, portfolio_id, release_pattern_id, cycle_type_id, project_status)
VALUES (12345, 'New Project Test', 2, 1, 2, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id, team_capacity, waste_days, is_waste_available, is_mood_available, mood_average)
VALUES ('New Sprint Test', '2017-02-01', '2017-02-14', 76, 58, 12345, 100, 5, TRUE, TRUE, 3.00);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id, team_capacity, waste_days, is_waste_available, is_mood_available, mood_average)
VALUES ('Sprint Test 2', '2017-03-02', '2017-03-15', 87, 45, 12345, 99, 5.67, TRUE, TRUE, 2.50);

INSERT INTO t_release_snap(release_date, name, project_id )
VALUES ('2017-02-07', 'First version', 12345);

INSERT INTO t_release_snap(release_date, name, project_id )
VALUES ('2017-03-02', 'Second update', 12345);

COMMIT;