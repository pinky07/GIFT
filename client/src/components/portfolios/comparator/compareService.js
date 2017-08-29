import constants from '../../constants';

const compareService = {
  load(getComparedProjects, id, onSuccess, onError) {
    return getComparedProjects(`${constants.getApi()}/portfolios/${id}/comparison`)
      .then((response) => onSuccess(response))
      .catch((error) => onError(error));
  }
}

export default compareService;