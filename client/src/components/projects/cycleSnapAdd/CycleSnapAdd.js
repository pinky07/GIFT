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
      projectId: props.params.id,
      projectName: '',
      cycleSnapName: '',
      cycleSnapStartDate: '',
      cycleSnapEndDate: '',
      targetedPoints: 0,
      achievedPoints: 0,
      errorMessage: '',
      errors: {}
    };
  }

  componentDidMount() {
    this.LoadProjectInformation(this.state.projectId);
  }

  LoadProjectInformation(projectId) {
    if (isNaN(projectId)) {
      this.setState({ errorMessage: "Invalid project id" });
    }
    else {
      axios.get(`${constants.API}/projects/${projectId}/name`).then((response) => {
        if (response.data) {
          this.setState({ projectName: response.data });
          // this.setState({ projectName: 'MyProject' });
        }
      }).catch((error) => {
        this.setState({ errorMessage: error.response.data.message });
      });
    }
  }

  _changeCycleName(index) {
    return (event) => {
      let value = event.target.value;
      this.setState({ cycleSnapName: value });
    };
  }

  _changeStartDate(index) {
    return (newDate) => {
      this.setState({ cycleSnapStartDate: newDate });
    };
  }

  _changeEndDate(index) {
    return (newDate) => {
      this.setState({ cycleSnapEndDate: newDate });
    };
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

  _onSubmit(event) {
    console.log('submitting');
    event.preventDefault();

    axios.post('/projects/cyclesnaps', {
      projectId: this.state.projectId,
      cycleSnapName: this.state.cycleSnapName,
      cycleSnapStartDate: this.state.cycleSnapStartDate,
      cycleSnapEndDate: this.state.cycleSnapEndDate,
      targetedPoints: this.state.targetedPoints,
      achievedPoints: this.state.achievedPoints
    })
      .then(function (response) {
        console.log('response: ' + response);
      })
      .catch(function (error) {
        console.log('error:' + error);
      });
    console.log(' after submitting');


    // TODO Validations
    /*     const { cycleSnapName } = this.state;
        const { cycleSnapStartDate } = this.state;
        let errors = {};
        let noErrors = true;
    
        if (!cycleSnapName) {
          errors.cycleSnapName = 'required';
          noErrors = false;
        }
    
        if (!cycleSnapStartDate) {
          errors.cycleSnapStartDate = 'required';
          noErrors = false;
        }
    
        if (noErrors) {
          // post: https://github.com/grommet/grommet-ferret/blob/master/src/js/components/settings/AccountEdit.js
          alert('submit!');
        } else {
          this.setState({ errors: errors });
        } */
  }


  render() {
    const errorMessage = this.state.errorMessage;
    const projectName = this.state.projectName;
    const startDate = this.state.startDate;

    if (errorMessage) {
      return <div id="layout-content" className="layout-content-wrapper">
        <h1>Add Cycle Snap</h1>
        <h3><Status value='critical' /> <span>{errorMessage}</span></h3>
      </div>
    }
    else {

      if (projectName) {
        const { targetedPoints } = this.state;
        const { achievedPoints } = this.state;
        const { cycleSnapStartDate } = this.state;
        const { cycleSnapEndDate } = this.state;
        const { errors } = this.state;

        return <div id="layout-content" className="layout-content-wrapper">
          <h1>Cycle Snap</h1>
          <h2>Project: {projectName}</h2>

          <Form compact={false}>
            <FormField label='Cycle name or id' htmlFor="cycleNameInput" error={errors.cycleSnapName}>
              <TextInput id='cycleNameInput' onDOMChange={this._changeCycleName()} />
            </FormField>
            <FormField label='Start Date' htmlFor="cycleStartDate" error={errors.cycleSnapStartDate}>
              <DateTime id='cycleStartDate' format='M/D/YYYY' value={cycleSnapStartDate} onChange={this._changeStartDate()} />
            </FormField>
            <FormField label='End Date' htmlFor="cycleEndDate">
              <DateTime id='cycleEndDate' format='M/D/YYYY' value={cycleSnapEndDate} onChange={this._changeEndDate()} />
            </FormField>
            <FormField label='Targeted points' htmlFor='targetedPointsId'>
              <NumberInput id='targetedPointsId' step={1} value={targetedPoints} min={0} onChange={this._changeTargetedPoints()} />
            </FormField>
            <FormField label='Achieved points' htmlFor='achievedPointsId'>
              <NumberInput id='achievedPoints' step={1} value={achievedPoints} min={0} onChange={this._changeAchievedPoints()} />
            </FormField>

            <Footer pad={{ "vertical": "medium" }}>
              <Button label='Add'
                type='submit'
                primary={true}
                onClick={this._onSubmit} />
            </Footer>
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