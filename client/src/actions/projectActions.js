import * as types from './types';

const URL = 'http://localhost:8080/api/v1/projects/portfolio/1';

export const loadProjects = () => {
  return (dispatch) => {
    fetch(URL)
    .then((resp) => resp.json())
    .then((projects) => {
      if (projects) {
        dispatch({ type: types.LOAD_PROJECTS_SUCCESS, projects });
      }
    })
    .catch((error) => {
      dispatch({ type: types.LOAD_PROJECTS_FAIL, error });
    });
  };
};