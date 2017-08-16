import axios from 'axios';
import constants from '../../constants';

const cycleSnapService = {
  add(newCycleSnap, updateDashboard) {
    return axios.post(`${constants.API}/projects/cyclesnaps`, newCycleSnap)
      .then((response) => {
        updateDashboard();
        return { successNotificationOnAdd: 'Success! You just added a new cycle snap.' }
      })
      .catch((error) => {
        if (error.response) {
          // There was a validation error.
          return {
            failureNotificationOnAdd: 'Sorry, there was a validation error: ' + error.response.data.message + '.',
            addCycleSnap: false
          }
        }
        else {
          // There was a critical error.
          return {
            failureNotificationOnAdd: 'Oops! We got a bit of an issue: ' + error.message + '.',
            addCycleSnap: false
          }
        }
      });
  }
}

export default cycleSnapService;