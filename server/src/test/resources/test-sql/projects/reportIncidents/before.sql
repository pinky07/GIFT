INSERT INTO t_portfolio(portfolio_id, portfolio_name)
VALUES (12345, 'Amazing projects');

INSERT INTO t_project(project_id, project_name, portfolio_id)
VALUES (123456, 'Exceptional Project', 12345);

COMMIT;