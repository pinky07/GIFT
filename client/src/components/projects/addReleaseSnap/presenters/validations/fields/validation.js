import nameValidations from '../name/validations';
import newDate from '../releaseDate/validations';

const validation = {
  validate(state) {
    let errors = {};

    const {releaseName} = state;
    errors.name = nameValidations.validate(releaseName);

    const {date} = state;
    errors.date = newDate.validate(date);

    return errors;
  },

  hasErrors(errors) {
    if (errors.name || errors.date) {
      return true;
    }
    else
      return false;
  }
};

export default validation;