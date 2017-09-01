import addReleaseSnapRequest from './requests/addReleaseSnapRequest';
import fieldsValidation from './validations/fields/validation';


const presenters = {
  getInitial(props, formCallbacks) {
    return {
      projectId: props.projectId,
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
      //submitRequest(request);
    }
    else {
      const newViewModel = {errors: errors}
      //updateViewModel(newViewModel);
    }
  }
};