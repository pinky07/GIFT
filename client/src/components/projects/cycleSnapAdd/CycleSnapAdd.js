import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import PropTypes from 'prop-types';

import axios from 'axios';

import constants from '../../../services/constants';

import Form from 'grommet/components/Form';
import FormField from 'grommet/components/FormField';
import TextInput from 'grommet/components/TextInput';
import Box from 'grommet/components/Box';
import Status from 'grommet/components/icons/Status';
import Footer from 'grommet/components/Footer';
import Button from 'grommet/components/Button';
import NumberInput from 'grommet/components/NumberInput';
import DateTime from 'grommet/components/DateTime';

export default class CycleSnapAdd extends React.Component {
  constructor(props) {
    super(props);

    this._onSubmit = this._onSubmit.bind(this);

    this.state = {
      successMessage: false,
      errorMessageOnSubmit: '',
      isLoadingTheFirstTime: true,
      projectId: props.params.id,
      projectName: '',
      cycleSnapName: '',
      cycleSnapStartDate: '',
      cycleSnapEndDate: '',
      targetedPoints: 0,
      achievedPoints: 0,
      errorMessage: '',
      noErrors: true,
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
        isLoadingTheFirstTime: false
      });
    }
    else {
      axios.get(`${constants.API}/projects/${projectId}/name`).then((response) => {
        if (response.data) {
          this.setState({
            projectName: response.data,
            isLoadingTheFirstTime: false
          });
          // this.setState({ projectName: 'MyProject' });
        }
      }).catch((error) => {
        this.setState({
          errorMessage: error.response.data.message,
          isLoadingTheFirstTime: false
        });
      });
    }
  }

  isValidDate(text) {
    let aDate = new Date(text + "T00:00");

    if (Object.prototype.toString.call(aDate) === "[object Date]") {
      // it is a date
      if (isNaN(aDate.getTime())) {  // d.valueOf() could also work
        // date is not valid
        return false;
      }
      else {
        // date is valid
        return true;
      }
    }
    else {
      // not a date
      return false;
    }
  }

  _changeCycleName(index) {
    return (event) => {
      let newValue = event.target.value;
      this.setState({ cycleSnapName: newValue });
    };
  }

  _changeStartDate(index) {
    return (newDate) => {
      this.setState({ cycleSnapStartDate: newDate });
    }
  }

  _changeEndDate(index) {
    return (newDate) => {
      this.setState({ cycleSnapEndDate: newDate });
    }
  }

  _changeTargetedPoints(index) {
    return (event) => {
      let value = event.target.value;
      value = parseInt(value, 10);
      this.setState({ targetedPoints: value });
    };
  }

  _changeAchievedPoints(index) {
    return (event) => {
      let value = event.target.value;
      value = parseInt(value, 10);
      this.setState({ achievedPoints: value });
    };
  }

  startPrecedesEndDate(startDate, endDate) {
    return new Date(endDate) > new Date(startDate); // true if endDate is later
  }

  validateFields() {

    let errors = {};
    let noErrors = true;

    const { cycleSnapName } = this.state;
    if (!cycleSnapName) {
      errors.cycleSnapName = 'Name is required';
      noErrors = false;
    }
    else {
      if (cycleSnapName.length > 200) {
        errors.cycleSnapName = 'Name has a max of 200 characters';
        noErrors = false;
      }
    }

    const { cycleSnapStartDate } = this.state;
    if (!cycleSnapStartDate) {
      errors.cycleSnapStartDate = 'Start date is required';
      noErrors = false;
    }
    else {
      if (!this.isValidDate(cycleSnapStartDate)) {
        errors.cycleSnapStartDate = 'Start date should be a valid one';
        noErrors = false;
      }
    }

    const { cycleSnapEndDate } = this.state;
    if (!cycleSnapEndDate) {
      errors.cycleSnapEndDate = 'End date is required';
      noErrors = false;
    }
    else {
      if (!this.isValidDate(cycleSnapEndDate)) {
        errors.cycleSnapEndDate = 'End date should be a valid one';
        noErrors = false;
      }
    }

    if (this.isValidDate(cycleSnapStartDate) && this.isValidDate(cycleSnapEndDate)) {
      if (!this.startPrecedesEndDate(cycleSnapStartDate, cycleSnapEndDate)) {
        errors.cycleSnapEndDate = 'End date should happen after the start date';
        noErrors = false;
      }
    }

    const { targetedPoints } = this.state;
    if (!targetedPoints) {
      errors.targetedPoints = 'Targeted points is required';
      noErrors = false;
    }
    else {
      if (targetedPoints > 10000) {
        errors.targetedPoints = 'Targeted points max is 10,000';
        noErrors = false;
      }
    }

    const { achievedPoints } = this.state;
    if (!achievedPoints) {
      errors.achievedPoints = 'Achieved points is required';
      noErrors = false;
    }
    else {
      if (achievedPoints > 10000) {
        errors.achievedPoints = 'Achieved points max is 10,000';
        noErrors = false;
      }
    }

    this.setState({ noErrors: noErrors, errors: errors });

    return noErrors;
  }

  _onSubmit(event) {
    event.preventDefault();

    let noErrors = this.validateFields();

    if (noErrors) {
      axios.post(`${constants.API}/projects/cyclesnaps`, {
        projectId: this.state.projectId,
        cycleSnapName: this.state.cycleSnapName,
        startDate: this.state.cycleSnapStartDate,
        endDate: this.state.cycleSnapEndDate,
        targetedPoints: this.state.targetedPoints,
        achievedPoints: this.state.achievedPoints
      })
        .then(function (response) {
          this.setState({
            successMessage: true
          });
        })
        .catch(function (error) {
          console.log('error:' + error);
          this.setState({
            successMessage: false,
            errorMessageOnSubmit: error
          });
        });
    }
  }


  render() {
    const { successMessage } = this.state;

    const { errorMessage } = this.state;
    const { projectName } = this.state;
    const { isLoadingTheFirstTime } = this.state;

    if (isLoadingTheFirstTime) {
      return <div>
        <h1>Add Cycle Snap</h1>
        <h3>Loading...</h3>
      </div>
    }
    else {

      if (errorMessage) {
        return <div>
          <h1>Add Cycle Snap</h1>
          <h3><Status value='critical' /> <span>{errorMessage}</span></h3>
        </div>
      }
      else {

        if (projectName) {

          // if (successMessage) {
          //   let notificationOnSubmitBox = <Notification message='Success! You just added a new cycle snap.' status='ok' size='small' />
          // }
          // else {
          //   if (errorMessageOnSubmit) {
          //     let notificationOnSubmitBox = <Notification message={`Oops! ' + ${error}`} status='critical' size='small' />
          //   }
          // }

          const { targetedPoints } = this.state;
          const { achievedPoints } = this.state;
          const { cycleSnapStartDate } = this.state;
          const { cycleSnapEndDate } = this.state;
          const { noErrors } = this.state;
          const { errors } = this.state;

          return <div id="layout-content" className="layout-content-wrapper">
            <h1>Cycle Snap</h1>
            <h2>Project: {projectName}</h2>

            <Form compact={false}>
              <FormField label='Cycle name or id' htmlFor="cycleNameInput" error={errors.cycleSnapName}>
                <TextInput id='cycleNameInput' onDOMChange={this._changeCycleName()} />
              </FormField>
              <FormField label='Start Date' htmlFor="cycleStartDate" error={errors.cycleSnapStartDate}>
                <DateTime id='cycleStartDate' format='YYYY-MM-DD' value={cycleSnapStartDate} onChange={this._changeStartDate()} />
              </FormField>
              <FormField label='End Date' htmlFor="cycleEndDate" error={errors.cycleSnapEndDate}>
                <DateTime id='cycleEndDate' format='YYYY-MM-DD' value={cycleSnapEndDate} onChange={this._changeEndDate()} />
              </FormField>
              <FormField label='Targeted points' htmlFor='targetedPointsId' error={errors.targetedPoints}>
                <NumberInput id='targetedPointsId' step={1} value={targetedPoints} min={0} onChange={this._changeTargetedPoints()} />
              </FormField>
              <FormField label='Achieved points' htmlFor='achievedPointsId' error={errors.achievedPoints}>
                <NumberInput id='achievedPoints' step={1} value={achievedPoints} min={0} onChange={this._changeAchievedPoints()} />
              </FormField>

              <Footer pad={{ "vertical": "medium" }}>
                <Button label='Add' type='submit' primary={true} onClick={this._onSubmit} />
              </Footer>

              {/* {notificationOnSubmitBox} */}
            </Form>
          </div>
        }
        else {
          return <div id="layout-content" className="layout-content-wrapper">
            <h1>Add Cycle Snap for project Id #{projectName}</h1>
            <h3><Status value='unknown' /> <span>We are sorry, but this project does not exist.</span></h3>
          </div>
        }
      }
    }
  }
}