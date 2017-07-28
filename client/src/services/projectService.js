import axios from 'axios';
import constants from './constants';

const projectService = {
  loadProjects(portfolioId) {
    return axios.get(`${constants.API}/projects/portfolio/${portfolioId}`);
  }
}

export default projectService;