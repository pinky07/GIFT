import axios from 'axios';
import constants from '../../constants';

const dashboardService = {
  load(projectId) {
    return axios.get(`${constants.API}/projects/${projectId}/dashboard`).then((response) => {
      if (response.data) {
        return {
          projectName: response.data.name,
          cycleSnaps: response.data.cycleSnaps,
          addCycleSnap: false
        };
      }
      else
        return { errorMessage: 'No information was found' };
    }).catch((error) => {
      if (error.response) {
        // There was a validation error.
        return {
          errorMessage: 'Please check: ' + error.response.data.message + '.',
          addCycleSnap: false
        };
      }
      else {
        // There was a critical error.
        return {
          errorMessage: 'Oops! We got a bit of an issue: ' + error.message + '.',
          addCycleSnap: false
        };
      }
    }
      );
  }
}
export default dashboardService;