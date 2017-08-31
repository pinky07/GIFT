import dateValidations from '../date/validations';

const validations = {
  validate(releaseDate) {
    let error;

    if (!releaseDate)
      error = 'Date is required';
    else
    if (!dateValidations.isValid(releaseDate))
      error = 'Date should be a valid one';
    else
      error = undefined;

    return error;
  }
}

export default validations;