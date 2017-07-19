import * as types from './types';
import projectService from '../services/projectService';

export const loadProjects = (portfolioId) => {
  return (dispatch) => {
    projectService.loadProjects(portfolioId)
      .then((response) => {
        if (response.data) {
          dispatch({ type: types.LOAD_PROJECTS_SUCCESS, projects: response.data });
        }
      })
      .catch((error) => {
        dispatch({ type: types.LOAD_PROJECTS_FAIL, error });
      });
  };
};