import axios from 'axios';
import constants from '../../constants';

const dashboardService = {
  load(projectId, onSuccess, onError) {
    return axios.get(`${constants.API}/projects/${projectId}/dashboard`)
      .then((response) => onSuccess(response))
      .catch((error) => onError(error));
  }
}
export default dashboardService;