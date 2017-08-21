import startDateValidations from '../startDate/validations';
import endDateValidations from '../endDate/validations';
import targetedPointsValidations from '../targetedPoints/validations';
import achievedPointsValidations from '../achievedPoints/validations';
import nameValidations from '../name/validations';

const validation = {
  validate(state) {
    let errors = {};

    const { cycleSnapName } = state;
    errors.name = nameValidations.validate(cycleSnapName);

    const { startDate } = state;
    errors.startDate = startDateValidations.validate(startDate);

    const { endDate } = state;
    errors.endDate = endDateValidations.validate(startDate, endDate);

    const { targetedPoints } = state;
    errors.targetedPoints = targetedPointsValidations.validate(targetedPoints);

    const { achievedPoints } = state;
    errors.achievedPoints = achievedPointsValidations.validate(achievedPoints);

    return errors;
  },

  hasErrors(errors) {
    if (errors.name ||
      errors.startDate ||
      errors.endDate ||
      errors.achievedPoints ||
      errors.targetedPoints) {
      return true;
    }
    else
      return false;
  }
}

export default validation;