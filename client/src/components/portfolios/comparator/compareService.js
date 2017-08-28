import constants from '../../constants';

const compareService = {
  load(getComparedProjects, id, onSuccess, onError) {
    return getComparedProjects(`${constants.API}/portfolios/${id}/comparator`)
      .then((response) => onSuccess(response))
      .catch((error) => onError(error));
  }
}

export default compareService;