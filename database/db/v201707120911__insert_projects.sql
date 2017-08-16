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

INSERT INTO t_project(project_name, portfolio_id, release_pattern_id, cycle_type_id, project_status)
VALUES ('Exceptional Project', 4, 1, 2, 1);


-- Test Data for t_cycle_snap
INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('50', '2016-04-18', '2016-05-06', 76, 58, 1,162,3,TRUE);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('51', '2016-05-09', '2016-05-30', 87, 45, 1,135,3,True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('52', '2016-05-31', '2016-06-20', 76, 70, 1,135,3,True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('53', '2016-06-20', '2016-07-11', 88, 79, 1,135,4,True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('54', '2016-07-11', '2016-08-01', 84, 73, 1,135,2,True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('55', '2016-08-01', '2016-08-22', 67, 67, 1,135,1,True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('56', '2016-08-22', '2016-09-12', 71, 65, 1,135,5,True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('57', '2016-09-12', '2016-10-03', 64, 57, 1,135,4,True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('58', '2016-10-3', '2016-10-24', 62, 56, 1,135,3,True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('59', '2016-10-24', '2016-11-14', 60, 54, 1,135,3,True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('Sprint 84', '2017-05-22', '2017-06-18', 136, 70, 3,735,0,False);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('Sprint #20', '2017-03-05', '2017-05-17', 29, 24, 6,20,0,False);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('Sprint #21', '2017-05-17', '2017-06-01', 33, 28, 6,20,0,False);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('Sprint #22', '2017-05-31', '2017-06-13', 44, 40, 6,20,0,False);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('Sprint #1', '2017-01-25', '2017-01-30', 0, 0, 7, 100, 5, True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('Sprint #2', '2017-02-01', '2017-02-14', 60, 55, 7, 99, 5.67, True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('Sprint #3', '2017-02-18', '2017-02-28', 70, 68, 7, 99, 0, True);

INSERT INTO t_cycle_snap(cycle_snap_name, start_date, end_date, targeted_points, achieved_points, project_id,team_capacity,waste_days,is_waste_available)
VALUES ('Sprint #4', '2017-03-01', '2017-03-15', 100, 100, 7, 0, 0, False);


-- Test Data for t_release_snap
INSERT INTO t_release_snap(release_date, name,project_id )
VALUES ('2016-03-10','2017.03.00', 1);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2016-03-27','2017.03.01', 1);

INSERT INTO t_release_snap(release_date, name,project_id )
VALUES ('2016-03-31','2017.03.02', 1);

INSERT INTO t_release_snap(release_date, name,project_id )
VALUES ('2016-04-24','No releases yet', 1);

INSERT INTO t_release_snap(release_date, name,project_id )
VALUES ('2016-04-03','2017.03.03', 1);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2016-04-10','2017.03.04', 1);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2016-05-1','2017.03.05', 1);

INSERT INTO t_release_snap(release_date, name,project_id )
VALUES ('2016-03-27','2017.05.00',1);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2016-05-31','2017.05.01',1);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2016-06-01','2017.05.02', 1);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2016-06-08','2017.05.03', 1);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2016-05-30','5', 6);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2016-06-13','2', 6);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2016-06-29','3', 6);

INSERT INTO t_release_snap(release_date, name,project_id )
VALUES ('2016-05-25','81', 3);

INSERT INTO t_release_snap(release_date, name,project_id )
VALUES ('2017-02-07','First Version', 7);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2017-03-02','Second Update', 7);

INSERT INTO t_release_snap(release_date, name,project_id )
VALUES ('2017-02-07','First Version', 7);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2017-03-02','Second Update', 7);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2017-04-02','Third Update', 7);

INSERT INTO t_release_snap(release_date,name, project_id )
VALUES ('2017-04-02','Third Update', 7);

--Test Data for t_incidents_report
INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-06-13', 1, 6);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-02-07', 2, 7);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-02-09', 3, 7);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-02-21', 1, 7);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-03-02', 4, 7);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-03-02', 1, 7);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-03-14', 1, 7);

INSERT INTO t_incidents_report(report_date, total_incidents, project_id)
VALUES ('2017-03-16', 1, 7);