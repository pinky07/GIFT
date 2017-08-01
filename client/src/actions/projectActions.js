import * as types from './types';
import projectService from '../services/projectService';

export const loadProjects = portfolioId => {
  return dispatch => {
    return projectService.loadProjects(portfolioId).then( response => {
      if (response.data) {
          dispatch({ type: types.LOAD_PROJECTS_SUCCESS, projects: response.data });
        }
      }).catch((error) => {
        dispatch({ type: types.LOAD_PROJECTS_FAIL, error });
      });
  };
};

export const loadDashboard = projectId => {
  return dispatch => {
    return projectService.getProjectDashboard(projectId).then( response => {
        if (response.data) {
          debugger;
          dispatch({ type: types.GET_PROJECT_DASHBOARD_SUCCESS, projectDashboard: response.data });
        }
      }).catch((error) => {
        dispatch({ type: types.GET_PROJECT_DASHBOARD_FAIL, error });
      });
  };
};