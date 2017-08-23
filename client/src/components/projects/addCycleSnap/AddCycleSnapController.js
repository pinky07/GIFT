import React from 'react';
import PropTypes from 'prop-types';

import nameValidations from './validations/name/validations';
import startDateValidations from './validations/startDate/validations';
import endDateValidations from './validations/endDate/validations';
import targetedPointsValidations from './validations/targetedPoints/validations';
import achievedPointsValidations from './validations/achievedPoints/validations';
import moodValidations from './validations/mood/validations';
import wasteDaysValidations from './validations/wasteDays/validations';
import teamCapacityValidations from './validations/teamCapacity/validations';
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
      onIsWasteAvailableChange: this.changeIsWasteAvailable(),
      onTeamCapacityChange: this.changeTeamCapacity(),
      onWasteDaysChange: this.changeWasteDays(),
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
      const newViewModel = { errors: errors, cycleSnapName: newValue };

      // Set new state
      this.setState(newViewModel);
    };
  }

  changeStartDate(index) {
    return (newValue) => {
      // Get state
      let { errors } = this.state;

      // Validate
      errors.startDate = startDateValidations.validate(newValue);
      const newViewModel = { errors: errors, startDate: newValue };

      // Set new state
      this.setState(newViewModel);
    }
  }

  changeEndDate(index) {
    return (newValue) => {
      // Get state
      let { errors } = this.state;
      let { startDate } = this.state;

      // Validate
      errors.endDate = endDateValidations.validate(startDate, newValue);
      const newViewModel = { errors: errors, endDate: newValue };

      // Set new state
      this.setState(newViewModel);
    }
  }

  changeTargetedPoints(index) {
    return (event) => {
      // Get state
      let newValue = event.target.value;
      let { errors } = this.state;

      // Validate
      newValue = parseInt(newValue);
      errors.targetedPoints = targetedPointsValidations.validate(newValue);
      const newViewModel = { errors: errors, targetedPoints: newValue };

      // Set new state
      this.setState(newViewModel);
    };
  }

  changeAchievedPoints(index) {
    return (event) => {
      // Get state
      let newValue = event.target.valueAsNumber;
      let { errors } = this.state;

      // Validate
      newValue = parseInt(newValue);
      errors.achievedPoints = achievedPointsValidations.validate(newValue);
      const newViewModel = { errors: errors, achievedPoints: newValue };

      // Set new state
      this.setState(newViewModel);
    };
  }

  changeIsMoodAvailable() {
    return (event) => {
      // Get state
      const newIsMoodAvailable = event.target.checked;
      const { mood } = this.state
      let { errors } = this.state;

      //Validate
      const newViewModel = viewModels.getNewMoodInfo(newIsMoodAvailable, mood, errors);

      // Set new state
      this.setState(newViewModel);
    };
  }

  changeMood() {
    return (event) => {
      // Get state
      let newValue = event.target.valueAsNumber;
      let { errors } = this.state;
      const { isMoodAvailable } = this.state

      //Validate
      let withTwoDecimals = Math.round(newValue * 100) / 100;
      errors.mood = moodValidations.validate(isMoodAvailable, withTwoDecimals)
      const newViewModel = { errors: errors, mood: withTwoDecimals };

      // Set new state
      this.setState(newViewModel);

    };
  }

  changeIsWasteAvailable() {
    return (event) => {
      // Get state
      const newIsWasteAvailable = event.target.checked;
      let { errors } = this.state;

      //Validate
      const newViewModel = viewModels.getNewWasteInfo(newIsWasteAvailable, errors);

      // Set new state
      this.setState(newViewModel);
    };
  }

  changeTeamCapacity() {
    return (event) => {
      // Get state
      let newTeamCapacity = event.target.valueAsNumber;
      let { errors } = this.state;
      const { isWasteAvailable } = this.state

      //Validate
      const withTwoDecimals = Math.round(newTeamCapacity * 100) / 100;
      errors.teamCapacity = teamCapacityValidations.validate(isWasteAvailable, withTwoDecimals)
      const newViewModel = { errors: errors, teamCapacity: withTwoDecimals };

      // Set new state
      this.setState(newViewModel);
    }
  }

  changeWasteDays() {
    return (event) => {
      // Get state
      const newWasteDays = event.target.valueAsNumber;
      let { errors } = this.state;
      const { isWasteAvailable } = this.state
      const { teamCapacity } = this.state

      //Validate
      const withTwoDecimals = Math.round(newWasteDays * 100) / 100;
      errors.wasteDays = wasteDaysValidations.validate(isWasteAvailable, teamCapacity, withTwoDecimals)
      const newViewModel = { errors: errors, wasteDays: withTwoDecimals };

      // Set new state
      this.setState(newViewModel);
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