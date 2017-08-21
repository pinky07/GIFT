import React from 'react';
import PropTypes from 'prop-types';

import startDateValidations from './validations/startDate/validations';
import endDateValidations from './validations/endDate/validations';
import targetedPointsValidations from './validations/targetedPoints/validations';
import achievedPointsValidations from './validations/achievedPoints/validations';
import nameValidations from './validations/name/validations';
import fieldsValidation from './validations/fields/validation';

import CycleSnapAddForm from './CycleSnapAddForm';

export default class CycleSnapAdd extends React.Component {
  constructor(props) {
    super(props);

    this.onSubmit = this.onSubmit.bind(this);

    this.state = {
      projectId: props.projectId,
      projectName: props.projectName,
      cycleSnapName: '',
      startDate: '',
      endDate: '',
      targetedPoints: '0',
      achievedPoints: '0',
      errorMessage: undefined,
      errors: {},
      formCallbacks: {
          onNameChange: this.changeName(),
          onStartDateChange: this.changeStartDate(),
          onEndDateChange: this.changeEndDate(),
          onTargetedPointsChange: this.changeTargetedPoints(),
          onAchievedPointsChange: this.changeAchievedPoints(),
          onClick: this.onSubmit,
          onClose: this.props.onClose
        }
    };
  }

  changeName(index) {
    return (event) => {
      // Get state
      let newValue = event.target.value;
      let { errors } = this.state;

      // Validate
      errors.name = nameValidations.validate(newValue);

      // Set new state
      this.setState({errors: errors, cycleSnapName: newValue
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
      this.setState({errors: errors, startDate: newValue
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
      this.setState({errors: errors, endDate: newValue
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
      this.setState({errors: errors, targetedPoints: newValue
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
      this.setState({errors: errors, achievedPoints: newValue
      });
    };
  }

  onSubmit(event) {
    event.preventDefault();

    let errors = fieldsValidation.validate(this.state);
    let hasNoErrors = !fieldsValidation.hasErrors(errors);

    if (hasNoErrors)
      this.props.onSubmit({
        projectId: this.state.projectId,
        cycleSnapName: this.state.cycleSnapName,
        startDate: this.state.startDate,
        endDate: this.state.endDate,
        targetedPoints: this.state.targetedPoints,
        achievedPoints: this.state.achievedPoints
      });
    else
      this.setState({ errors: errors });
  }

  render() {
    // const { errorMessage } = this.state;
    // if (errorMessage)
    //   return (<Toast status='critical'>Oops! We got some issues: {errorMessage}</Toast>)
    // else {
      // const { projectName } = this.state;

      // if (projectName)
        return (<CycleSnapAddForm state={this.state}/>)
      // else
        // return (<LoadingLayer />)
    // }
  }
}

CycleSnapAdd.PropTypes = {
  onClose: PropTypes.func.isRequired,
  onSubmit: PropTypes.func.isRequired,
  projectId: PropTypes.number,
  projectName: PropTypes.string
}