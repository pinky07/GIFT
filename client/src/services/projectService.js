import axios from 'axios';
import constants from './constants';

const projectService = {
  loadProjects(portfolioId) {
//    return axios.get(`http://localhost:8080${constants.API}/projects/portfolio/${portfolioId}`);
    return axios.get(`http://criprj:11010${constants.API}/projects/portfolio/${portfolioId}`);
  }
}

export default projectService;