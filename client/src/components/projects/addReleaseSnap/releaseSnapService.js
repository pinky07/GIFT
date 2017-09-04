import constants from '../../constants';

const releaseSnapService = {
  add(newReleaseSnap, post, onSuccess, onError) {
    return post(`${constants.getApi()}/projects/releases`, newReleaseSnap)
      .then((response) => onSuccess(response))
      .catch((error) => onError(error));
  }
}

export default releaseSnapService;