import constants from '../../constants';

const dashboardService = {
  load(getProjectDashboardCallback, projectId, onSuccessCallback, onErrorCallback) {
    return getProjectDashboardCallback(`${constants.getApi()}/projects/${projectId}/dashboard`)
      .then((response) => onSuccessCallback(response))
      .catch((error) => onErrorCallback(error));
  }
}
export default dashboardService;