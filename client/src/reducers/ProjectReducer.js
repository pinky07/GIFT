import * as types from '../actions/types';

const INITIAL_STATE = {
  projects: []
};

export default ( state = INITIAL_STATE, action ) => {
  switch (action.type) {
    case types.LOAD_PROJECTS_SUCCESS:
      return action.projects;
    default:
      return state;
  }
}