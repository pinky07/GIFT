import axios from 'axios';
import constants from '../../constants';

const cycleSnapService = {
  add(newCycleSnap, post, onSuccess, onError) {
    return post(`${constants.getApi()}/projects/cyclesnaps`, newCycleSnap)
      .then((response) => onSuccess(response))
      .catch((error) => onError(error));
  }
}

export default cycleSnapService;