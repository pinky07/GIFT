INSERT INTO t_portfolio(portfolio_id, portfolio_name)
VALUES (12345, 'Amazing projects');

INSERT INTO t_project(project_id, project_name, portfolio_id)
VALUES (12345, 'Exceptional Project', 12345);

INSERT INTO t_project(project_id, project_name, portfolio_id)
VALUES (12346, 'Appraisal tool', 12345);

-- Test Data for t_cycle_snap
INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available,is_mood_available,mood_average)
VALUES ('Sprint #1', '2017-01-25', '2017-01-30', 0, 0, 12345, 100, 5, True,TRUE,3.00);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available,is_mood_available,mood_average)
VALUES ('Sprint #2', '2017-02-01', '2017-02-14', 60, 55, 12345, 99, 5.67, True,TRUE,3.00);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available,is_mood_available,mood_average)
VALUES ('Sprint #3', '2017-02-18', '2017-02-28', 70, 68, 12345, 99, 0, True,TRUE,2.50);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available,is_mood_available,mood_average)
VALUES ('Sprint #4', '2017-03-01', '2017-03-15', 100, 100, 12345, 0, 0, False,false,0);

-- Test Data for t_release_snap
INSERT INTO t_release_snap(release_date, name,project_id )
VALUES ('2017-02-07','First Version', 12345);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2017-03-02','Second Update', 12345);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2017-04-02','Third Update', 12345);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2017-04-02','Third Update', 12345);

--Test Data for t_incidents_report
INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-02-07', 2, 12345);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-02-09', 3, 12345);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-02-21', 1, 12345);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-03-02', 4, 12345);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-03-02', 1, 12345);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-03-14', 1, 12345);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-03-16', 1, 12345);

COMMIT;