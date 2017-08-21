import React from 'react';
import PropTypes from 'prop-types';

import startDateValidations from './validations/startDate/validations';
import endDateValidations from './validations/endDate/validations';
import targetedPointsValidations from './validations/targetedPoints/validations';
import achievedPointsValidations from './validations/achievedPoints/validations';
import moodValidations from './validations/mood/validations';
import nameValidations from './validations/name/validations';
import fieldsValidation from './validations/fields/validation';

import viewModels from './viewModels/viewModels';

import AddCycleSnapView from './views/AddCycleSnapView';
import addCycleSnapRequest from './addCycleSnapRequest';

export default class AddCycleSnapController extends React.Component {
  constructor(props) {
    super(props);

    this.onSubmit = this.onSubmit.bind(this);

    const formCallbacks = {
      onNameChange: this.changeName(),
      onStartDateChange: this.changeStartDate(),
      onEndDateChange: this.changeEndDate(),
      onTargetedPointsChange: this.changeTargetedPoints(),
      onAchievedPointsChange: this.changeAchievedPoints(),
      onIsMoodAvailableChange: this.changeIsMoodAvailable(),
      onMoodChange: this.changeMood(),
      onClick: this.onSubmit,
      onClose: this.props.onClose
    }

    this.state = viewModels.getInitial(props, formCallbacks);
  }

  changeName(index) {
    return (event) => {
      // Get state
      let newValue = event.target.value;
      let { errors } = this.state;

      // Validate
      errors.name = nameValidations.validate(newValue);

      // Set new state
      this.setState({
        errors: errors, cycleSnapName: newValue
      });
    };
  }

  changeStartDate(index) {
    return (newValue) => {
      // Get state
      let { errors } = this.state;

      // Validate
      errors.startDate = startDateValidations.validate(newValue);

      // Set new state
      this.setState({
        errors: errors, startDate: newValue
      });
    }
  }

  changeEndDate(index) {
    return (newValue) => {
      // Get state
      let { errors } = this.state;
      let { startDate } = this.state;

      // Validate
      errors.endDate = endDateValidations.validate(startDate, newValue);

      // Set new state
      this.setState({
        errors: errors, endDate: newValue
      });
    }
  }

  changeTargetedPoints(index) {
    return (event) => {
      // Get state
      let newValue = event.target.value;
      let { errors } = this.state;

      newValue = parseInt(newValue);
      // Validate
      errors.targetedPoints = targetedPointsValidations.validate(newValue);

      // Set new state
      this.setState({
        errors: errors, targetedPoints: newValue
      });
    };
  }

  changeAchievedPoints(index) {
    return (event) => {
      // Get state
      let newValue = event.target.value;
      let { errors } = this.state;
      newValue = parseInt(newValue);

      // Validate
      errors.achievedPoints = achievedPointsValidations.validate(newValue);

      // Set new state
      this.setState({
        errors: errors, achievedPoints: newValue
      });
    };
  }

  changeIsMoodAvailable() {

  }

  changeMood() {
    return (event) => {
      let newValue = event.target.value;
      let { errors } = this.state;

      newValue = parseFloat(newValue);
      newValue = Math.floor(newValue*100)/100;

      //Validate
      errors.mood = moodValidations.validate(newValue)

      // Set new state
      this.setState({
        errors: errors, mood: newValue
      });
    };
  }

  onSubmit(event) {
    event.preventDefault();

    let errors = fieldsValidation.validate(this.state);
    let hasNoErrors = !fieldsValidation.hasErrors(errors);

    if (hasNoErrors) {
      const request = addCycleSnapRequest.get(this.state);
      this.props.onSubmit(request);
    }
    else
      this.setState({ errors: errors });
  }

  render() {
    return (<AddCycleSnapView viewModel={this.state} />)
  }
}

AddCycleSnapController.PropTypes = {
  onClose: PropTypes.func.isRequired,
  onSubmit: PropTypes.func.isRequired,
  projectId: PropTypes.number,
  projectName: PropTypes.string
}