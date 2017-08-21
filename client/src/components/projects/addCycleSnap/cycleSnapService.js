import axios from 'axios';
import constants from '../../constants';

const cycleSnapService = {
  add(newCycleSnap, onSuccess, onError) {
    return axios.post(`${constants.API}/projects/cyclesnaps`, newCycleSnap)
      .then((response) => onSuccess(response))
      .catch((error) => onError(error));
  }
}

export default cycleSnapService;