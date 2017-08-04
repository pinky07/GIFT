import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import PropTypes from 'prop-types';

import constants from '../../../services/constants';

import axios from 'axios';

import Form from 'grommet/components/Form';
import FormFields from 'grommet/components/FormFields';
import FormField from 'grommet/components/FormField';
import TextInput from 'grommet/components/TextInput';
import Box from 'grommet/components/Box';
import Status from 'grommet/components/icons/Status';
import Footer from 'grommet/components/Footer';
import Button from 'grommet/components/Button';
import NumberInput from 'grommet/components/NumberInput';
import DateTime from 'grommet/components/DateTime';
import Layer from 'grommet/components/Layer';
import Toast from 'grommet/components/Toast';
import Spinning from 'grommet/components/icons/Spinning';

export default class CycleSnapAdd extends React.Component {
  constructor(props) {
    super(props);

    this._onSubmit = this._onSubmit.bind(this);
    this._validateFields = this._validateFields.bind(this);

    this.state = {
      projectId: props.projectId,
      projectName: '',
      name: '',
      startDate: '',
      endDate: '',
      targetedPoints: '0',
      achievedPoints: '0',
      errorMessage: undefined,
      errors: {}
    };
  }

  componentDidMount() {
    this.LoadProjectInformation(this.state.projectId);
  }

  LoadProjectInformation(projectId) {
    if (isNaN(projectId)) {
      this.setState({
        errorMessage: "Invalid project id",
      });
    }
    else {
      axios.get(`${constants.API}/projects/${projectId}/name`).then((response) => {
        if (response.data) {
          this.setState({ projectName: response.data });
        }
      }).catch((error) => {
        this.setState({
          errorMessage: error.message,
        });
      });
    }
  }

  isValidDate(text) {
    let aDate = new Date(text + "T18:00");

    if (Object.prototype.toString.call(aDate) === "[object Date]") {
      // it is a date
      if (isNaN(aDate.getTime())) {  // d.valueOf() could also work
        // date is not valid
        return false;
      }
      else {
        // date is valid
        let dateReg = /^\d{4}\-\d{2}\-\d{2}$/;
        if (dateReg.test(text)) {
          return true;
        }
        else {
          return false;
        }
      }
    }
    else {
      // not a date
      return false;
    }
  }

  _haveErrors(errors) {
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

  _changeName(index) {
    return (event) => {
      // Get state
      let newValue = event.target.value;

      // Set new state
      let { errors } = this.state;

      // Validate
      errors.name = this._validateName(newValue);

      this.setState({
        errors: errors,
        name: newValue
      });
    };
  }

  _changeStartDate(index) {
    return (newValue) => {
      // Get state
      let { errors } = this.state;

      // Validate
      errors.startDate = this._validateStartDate(newValue);

      // Set new state
      this.setState({
        errors: errors,
        startDate: newValue
      });
    }
  }

  _changeEndDate(index) {
    return (newValue) => {
      // Get state
      let { errors } = this.state;
      let { startDate } = this.state;

      // Validate
      errors.endDate = this._validateEndDate(startDate, newValue);

      // Set new state
      this.setState({
        errors: errors,
        endDate: newValue
      });
    }
  }

  _changeTargetedPoints(index) {
    return (event) => {
      // Get state
      let newValue = event.target.value;
      let { errors } = this.state;

      newValue = parseInt(newValue);
      // Validate
      errors.targetedPoints = this._validateTargetedPoints(newValue);

      // Set new state
      this.setState({
        errors: errors,
        targetedPoints: newValue
      });
    };
  }

  _changeAchievedPoints(index) {
    return (event) => {
      // Get state
      let newValue = event.target.value;
      let { errors } = this.state;

      newValue = parseInt(newValue);
      // Validate
      errors.achievedPoints = this._validateAchievedPoints(newValue);

      // Set new state
      this.setState({
        errors: errors,
        achievedPoints: newValue
      });
    };
  }

  startPrecedesEndDate(startDate, endDate) {
    return new Date(endDate) > new Date(startDate); // true if endDate is later
  }

  _validateName(name) {
    let error = undefined;

    if (!name) {
      error = 'Name is required';
    }
    else {
      if (name.length > 200) {
        error = 'Name has a max of 200 characters';
      }
    }

    return error;
  }

  _validateStartDate(startDate) {
    let error = undefined;

    if (!startDate) {
      error = 'Start date is required';
    }
    else {
      if (!this.isValidDate(startDate)) {
        error = 'Start date should be a valid one';
      }
    }

    return error;
  }

  _validateEndDate(startDate, endDate) {
    let error = undefined;

    if (!endDate) {
      error = 'End date is required';
    }
    else {
      if (!this.isValidDate(endDate)) {
        error = 'End date should be a valid one';
      }
    }

    if (this.isValidDate(startDate) && this.isValidDate(endDate)) {
      if (!this.startPrecedesEndDate(startDate, endDate)) {
        error = 'End date should happen after the start date';
      }
    }

    return error;
  }

  _validateTargetedPoints(points) {
    let error = undefined;

    if (isNaN(points)) {
      error = 'Targeted points are required';
    }
    else {
        if (points < 0) {
          error = 'Targeted points min is 0';
        }
        if (points > 10000) {
          error = 'Targeted points max is 10,000';
        }
    }

    return error;
  }

  _validateAchievedPoints(points) {
    let error = undefined;

    if (isNaN(points)) {
      error = 'Achieved points are required';
    }
    else {
      if (points < 0) {
        error = 'Targeted points min is 0';
      }

      if (points > 10000) {
        error = 'Achieved points max is 10,000';
      }
    }

    return error;
  }

  _validateFields() {
    let errors = {};

    const { name } = this.state;
    errors.name = this._validateName(name);

    const { startDate } = this.state;
    errors.startDate = this._validateStartDate(startDate);

    const { endDate } = this.state;
    errors.endDate = this._validateEndDate(startDate, endDate);

    const { targetedPoints } = this.state;
    errors.targetedPoints = this._validateTargetedPoints(targetedPoints);

    const { achievedPoints } = this.state;
    errors.achievedPoints = this._validateAchievedPoints(achievedPoints);

    return errors;
  }

  _onSubmit(event) {
    event.preventDefault();

    let errors = this._validateFields();
    let noErrors = !this._haveErrors(errors);

    if (noErrors) {
      this.props.onSubmit({
        name: this.state.name,
        startDate: this.state.startDate,
        endDate: this.state.endDate,
        targetedPoints: this.state.targetedPoints,
        achievedPoints: this.state.achievedPoints
      });
    }
    else {
      this.setState({
        errors: errors,
      });

    }
  }


  render() {
    const { errorMessage } = this.state;
    if (errorMessage) {
      return <Toast status='critical'>Oops! We got some issues: {errorMessage}</Toast>
    }
    else {
      const { projectName } = this.state;

      if (projectName) {
        const { errors } = this.state;

        const { name } = this.state;
        const { startDate } = this.state;
        const { endDate } = this.state;
        const { targetedPoints } = this.state;
        const { achievedPoints } = this.state;

        return <Layer align='center' closer={true} onClose={this.props.onClose}>
          <Box pad={{ vertical: 'large', horizontal: 'small' }}>

            <header>
              <h1>Add cycle snap</h1>
              <h2>Project: {projectName}</h2>
            </header>

            <Form compact={false}>
              <FormFields>
                <fieldset>
                  <FormField label='Cycle name or id' htmlFor="cycleNameInput" error={errors.name}>
                    <TextInput id='cycleNameInput' onDOMChange={this._changeName()} value={name} />
                  </FormField>
                  <FormField label='Start Date' htmlFor="cycleStartDate" error={errors.startDate}>
                    <DateTime id='cycleStartDate' format='YYYY-MM-DD' value={startDate} onChange={this._changeStartDate()} />
                  </FormField>
                  <FormField label='End Date' htmlFor="cycleEndDate" error={errors.endDate}>
                    <DateTime id='cycleEndDate' format='YYYY-MM-DD' value={endDate} onChange={this._changeEndDate()} />
                  </FormField>
                  <FormField label='Targeted points' htmlFor='targetedPointsId' error={errors.targetedPoints}>
                    <NumberInput id='targetedPointsId' step={1} value={targetedPoints} min={0} onChange={this._changeTargetedPoints()} />
                  </FormField>
                  <FormField label='Achieved points' htmlFor='achievedPointsId' error={errors.achievedPoints}>
                    <NumberInput id='achievedPoints' step={1} value={achievedPoints} min={0} onChange={this._changeAchievedPoints()} />
                  </FormField>
                </fieldset>
              </FormFields>

              <Footer pad={{ "vertical": "medium" }}>
                <Box>
                  <Button label='Add' type='submit' primary={true} onClick={this._onSubmit} />
                </Box>
                <Box pad={{ horizontal: 'small' }}>
                  <Button label='Cancel' onClick={this.props.onClose} />
                </Box>

              </Footer>
            </Form>
          </Box>
        </Layer>
      }
      else {
        return <Layer align='center'>
          <Box pad={{ vertical: 'large', horizontal: 'small' }}>
            <h3><Spinning /> Loading... </h3>
          </Box>
        </Layer>
      }
    }
  }
}

CycleSnapAdd.PropTypes = {
  onClose: PropTypes.func.isRequired,
  onSubmit: PropTypes.func.isRequired,
  projectId: PropTypes.number
}