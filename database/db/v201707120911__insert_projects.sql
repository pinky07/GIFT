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
VALUES ('50', '4/18/2016', '5/6/2016', 76, 58, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('51', '5/9/2016', '5/30/2016', 87, 45, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('52', '5/31/2016', '6/20/2016', 76, 70, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('53', '6/20/2016', '7/11/2016', 88, 79, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('54', '7/11/2016', '8/1/2016', 84, 73, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('55', '8/1/2016', '8/22/2016', 67, 67, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('56', '8/22/2016', '9/12/2016', 71, 65, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('57', '9/12/2016', '10/3/2016', 64, 57, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('58', '10/3/2016', '10/24/2016', 62, 56, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('59', '10/24/2016', '11/14/2016', 60, 54, 1);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('Sprint 84', '5/22/2017', '6/18/2017', 136, 70, 3);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('Sprint #20', '5/3/2017', '5/17/2017', 29, 24, 6);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('Sprint #21', '5/17/2017', '6/1/2017', 33, 28, 6);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('Sprint #22', '5/31/2017', '6/13/2017', 44, 40, 6);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, points_achieved, project_id)
VALUES ('Sprint #23', '6/14/2017', '6/29/2017', 26, 26, 6);