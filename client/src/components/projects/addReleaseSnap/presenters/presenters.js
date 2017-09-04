import addReleaseSnapRequest from './requests/addReleaseSnapRequest';
import fieldsValidation from './validations/fields/validation';
import nameValidations from './validations/name/validations';
import releaseDateValidations from './validations/releaseDate/validations';

const presenters = {
  getInitial(props, formCallbacks) {
    return {
      projectId: props.projectId,
      projectName: props.projectName,
      releaseName: '',
      releaseDate: '',
      errors: {},
      formCallbacks: formCallbacks
    };
  },

  processSubmit(currentViewModel, updateViewModel, submitRequest) {
    let errors = fieldsValidation.validate(currentViewModel);
    let hasNoErrors = !fieldsValidation.hasErrors(errors);

    if (hasNoErrors) {
      const request = addReleaseSnapRequest.get(currentViewModel);
      submitRequest(request);
    }
    else {
      const newViewModel = {errors: errors}
      updateViewModel(newViewModel);
    }
  },

  getOnNameChange(event, currentViewModel) {
    // Get state
    const newValue = event.target.value;
    let {errors} = currentViewModel;

    const isNotEmpty = newValue.trim();

    if (isNotEmpty)
      errors.releaseName = nameValidations.validate(newValue);
    else
      errors.releaseName = nameValidations.validate('');

    return {
      errors: errors,
      releaseName: newValue
    };
  },

  getOnDateChange(newValue, currentViewModel) {
    // Get state
    let {errors} = currentViewModel;

    // Validate
    errors.releaseDate = releaseDateValidations.validate(newValue);

    return {errors: errors, releaseDate: newValue};
  }
};

export default presenters;