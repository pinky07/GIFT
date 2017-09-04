import nameValidations from '../name/validations';
import newDate from '../releaseDate/validations';

const validation = {
  validate(state) {
    let errors = {};

    const {releaseName} = state;
    errors.releaseName = nameValidations.validate(releaseName);

    const {releaseDate} = state;
    errors.releaseDate = newDate.validate(releaseDate);

    return errors;
  },

  hasErrors(errors) {
    if (errors.releaseName || errors.releaseDate) {
      return true;
    }
    else
      return false;
  }
};

export default validation;