-- Test Data for t_project
INSERT INTO t_project(project_name, portfolio_id, release_pattern_id, cycle_type_id, project_status)
VALUES ('Phoenix', 1, 2, 1, 2);

INSERT INTO t_project(project_name, portfolio_id, release_pattern_id, cycle_type_id, project_status)
VALUES ('BAAM', 1, 1, 2, 1);

INSERT INTO t_project(project_name, portfolio_id, release_pattern_id, cycle_type_id, project_status)
VALUES ('A-Team', 2, 1, 2, 1);

INSERT INTO t_project(project_name, portfolio_id, release_pattern_id, cycle_type_id, project_status)
VALUES ('Bootcamp', 2, 1, 2, 1);

INSERT INTO t_project(project_name, portfolio_id, release_pattern_id, cycle_type_id, project_status)
VALUES ('PW', 3, 1, 2, 1);

INSERT INTO t_project(project_name, portfolio_id, release_pattern_id, cycle_type_id, project_status)
VALUES ('Operation metrics', 3, 1, 2, 1);


-- Test Data for t_cycle_snap
INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('50', '2016-04-18', '2016-05-06', 76, 58, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('51', '2016-05-09', '2016-05-30', 87, 45, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('52', '2016-05-31', '2016-06-20', 76, 70, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('53', '2016-06-20', '2016-07-11', 88, 79, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('54', '2016-07-11', '2016-08-01', 84, 73, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('55', '2016-08-01', '2016-08-22', 67, 67, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('56', '2016-08-22', '2016-09-12', 71, 65, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('57', '2016-09-12', '2016-10-03', 64, 57, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('58', '2016-10-3', '2016-10-24', 62, 56, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('59', '2016-10-24', '2016-11-14', 60, 54, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('Sprint 84', '2017-05-22', '2017-06-18', 136, 70, 3);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('Sprint #20', '2017-03-05', '2017-05-17', 29, 24, 6);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('Sprint #21', '2017-05-17', '2017-06-01', 33, 28, 6);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('Sprint #22', '2017-05-31', '2017-06-13', 44, 40, 6);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('Sprint #23', '2017-06-14', '2017-06-29', 26, 26, 6);