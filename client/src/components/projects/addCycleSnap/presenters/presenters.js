import nameValidations from './validations/name/validations';
import startDateValidations from './validations/startDate/validations';
import endDateValidations from './validations/endDate/validations';
import targetedPointsValidations from './validations/targetedPoints/validations';
import achievedPointsValidations from './validations/achievedPoints/validations';
import moodValidations from './validations/mood/validations';
import wasteDaysValidations from './validations/wasteDays/validations';
import teamCapacityValidations from './validations/teamCapacity/validations';
import fieldsValidation from './validations/fields/validation';

import addCycleSnapRequest from './requests/addCycleSnapRequest';

const presenters = {
  getInitial(props, formCallbacks) {
    return {
      projectId: props.projectId,
      projectName: props.projectName,
      cycleSnapName: '',
      startDate: '',
      endDate: '',
      targetedPoints: '0',
      achievedPoints: '0',
      isMoodAvailable: true,
      mood: '0',
      isWasteAvailable: true,
      teamCapacity: 0,
      wasteDays: '0',
      errors: {},
      formCallbacks: formCallbacks
    };
  },

  getOnMoodIsAvailableChange(event, currentViewModel) {
    const isMoodAvailable = event.target.checked;
    let {errors} = currentViewModel;

    errors.mood = undefined;

    return {
      isMoodAvailable: isMoodAvailable,
      mood: '0',
      errors: errors
    };
  },

  getOnWasteIsAvailableChange(event, currentViewModel) {
    // Get state
    const isWasteAvailable = event.target.checked;
    let {errors} = currentViewModel;

    errors.teamCapacity = undefined;
    errors.wasteDays = undefined;

    return {
      isWasteAvailable: isWasteAvailable,
      teamCapacity: '0',
      wasteDays: '0',
      errors: errors
    };
  },

  getOnNameChange(event, currentViewModel) {
    // Get state
    const newValue = event.target.value;
    let {errors} = currentViewModel;

    const isNotEmpty = newValue.trim();

    if (isNotEmpty)
      errors.name = nameValidations.validate(newValue);
    else
      errors.name = nameValidations.validate('');

    return {
      errors: errors,
      cycleSnapName: newValue
    };
  },

  getOnStartDateChange(newValue, currentViewModel) {
    // Get state
    let {errors} = currentViewModel;

    // Validate
    errors.startDate = startDateValidations.validate(newValue);

    return {errors: errors, startDate: newValue};
  },

  getOnEndDateChange(newValue, currentViewModel) {
    // Get state
    let {errors} = currentViewModel;
    let {startDate} = currentViewModel;

    // Validate
    errors.endDate = endDateValidations.validate(startDate, newValue);

    return {errors: errors, endDate: newValue};
  },

  getOnTargetedPointsChange(event, currentViewModel) {
    // Get state
    let newValue = event.target.valueAsNumber;
    let {errors} = currentViewModel;

    // Validate
    errors.targetedPoints = targetedPointsValidations.validate(newValue);

    return {errors: errors, targetedPoints: newValue};

  },

  getOnAchievedPointsChange(event, currentViewModel) {
    // Get state
    let newValue = event.target.valueAsNumber;
    let {errors} = currentViewModel;

    // Validate
    errors.achievedPoints = achievedPointsValidations.validate(newValue);

    return {errors: errors, achievedPoints: newValue};
  },

  getOnMoodChange(event, currentViewModel) {
    // Get state
    let newValue = event.target.valueAsNumber;
    let {errors} = currentViewModel;
    const {isMoodAvailable} = currentViewModel

    //Validate
    let withTwoDecimals = Math.round(newValue * 100) / 100;
    errors.mood = moodValidations.validate(isMoodAvailable, withTwoDecimals)

    return {errors: errors, mood: withTwoDecimals};
  },

  getOnTeamCapacityChange(event, currentViewModel) {
    // Get state
    let newTeamCapacity = event.target.valueAsNumber;
    let {errors} = currentViewModel;
    const {isWasteAvailable} = currentViewModel;

    //Validate
    const withTwoDecimals = Math.round(newTeamCapacity * 100) / 100;
    errors.teamCapacity = teamCapacityValidations.validate(isWasteAvailable, withTwoDecimals)

    return {errors: errors, teamCapacity: withTwoDecimals};
  },

  getOnWasteDaysChange(event, currentViewModel) {
    // Get state
    const newWasteDays = event.target.valueAsNumber;
    let {errors} = currentViewModel;
    const {isWasteAvailable} = currentViewModel;
    const {teamCapacity} = currentViewModel;

    //Validate
    const withTwoDecimals = Math.round(newWasteDays * 100) / 100;
    errors.wasteDays = wasteDaysValidations.validate(isWasteAvailable, teamCapacity, withTwoDecimals);

    return {errors: errors, wasteDays: withTwoDecimals};

  },

  processSubmit(currentViewModel, updateViewModel, submitRequest) {
    let errors = fieldsValidation.validate(currentViewModel);
    let hasNoErrors = !fieldsValidation.hasErrors(errors);

    if (hasNoErrors) {
      const request = addCycleSnapRequest.get(currentViewModel);
      submitRequest(request);
    }
    else {
      const newViewModel = {errors: errors}
      updateViewModel(newViewModel);
    }
  }
}

export default presenters;