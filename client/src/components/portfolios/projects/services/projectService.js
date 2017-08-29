import axios from 'axios';
import constants from '../../../constants';

const projectService = {
  loadProjects(portfolioId) {
    return axios.get(`${constants.getApi()}/projects/portfolio/${portfolioId}`);
  }
}

export default projectService;