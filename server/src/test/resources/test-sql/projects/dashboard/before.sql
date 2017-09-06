INSERT INTO t_portfolio(portfolio_id, portfolio_name)
VALUES (12345, 'Amazing projects');

INSERT INTO t_project(project_id, project_name, portfolio_id)
VALUES (12345, 'Exceptional Project', 12345);

-- Test Data for t_cycle_snap
INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available,is_mood_available,mood_average)
VALUES ('Sprint #3', '2017-02-18', '2017-02-28', 70, 68, 12345, 99, 0, True,TRUE,2.50);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available,is_mood_available,mood_average)
VALUES ('Sprint #4', '2017-03-01', '2017-03-15', 100, 100, 12345, 0, 0, False,false,0);

-- Test Data for t_release_snap
INSERT INTO t_release_snap(release_date, name,project_id )
VALUES ('2017-02-07','First Version', 12345);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2017-03-02','Second Update', 12345);

--Test Data for t_incidents_report
INSERT INTO t_incidents_report(report_date, total_incidents, project_id,rationale_issues)
VALUES ('2017-02-07', 2, 12345,'The release caused issues');

INSERT INTO t_incidents_report(report_date, total_incidents, project_id,rationale_issues)
VALUES ('2017-02-09', 3, 12345,'The release caused issues');

COMMIT;