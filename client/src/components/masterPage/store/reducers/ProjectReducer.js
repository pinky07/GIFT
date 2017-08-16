import * as types from './types';

const INITIAL_STATE = {
  projects: []
};

export default ( state = INITIAL_STATE, action ) => {
  switch (action.type) {
    case types.LOAD_PROJECTS_SUCCESS:
      return action.projects;
    case types.GET_PROJECT_DASHBOARD_SUCCESS:
      return action.projectDashboard;
    default:
      return state;
  }
}