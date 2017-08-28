import React from 'react';
import PropTypes from 'prop-types';

import presenters from './presenters/presenters';
import AddCycleSnapView from './views/AddCycleSnapView';

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

    this.state = presenters.getInitial(props, formCallbacks);
  }

  changeName(index) {
    return (event) => {
      const newViewModel = presenters.getOnNameChange(event, this.state);
      this.setState(newViewModel);
    };
  }

  changeStartDate(index) {
    return (newValue) => {
      const newViewModel = presenters.getOnStartDateChange(newValue, this.state)
      this.setState(newViewModel);
    }
  }

  changeEndDate(index) {
    return (newValue) => {
      const newViewModel = presenters.getOnEndDateChange(newValue, this.state);
      this.setState(newViewModel);
    }
  }

  changeTargetedPoints(index) {
    return (event) => {
      const newViewModel = presenters.getOnTargetedPointsChange(event, this.state)
      this.setState(newViewModel);
    };
  }

  changeAchievedPoints(index) {
    return (event) => {
      const newViewModel = presenters.getOnAchievedPointsChange(event, this.state);
      this.setState(newViewModel);
    };
  }

  changeIsMoodAvailable() {
    return (event) => {
      const newViewModel = presenters.getOnMoodIsAvailableChange(event, this.state);
      this.setState(newViewModel);
    };
  }

  changeMood() {
    return (event) => {
      const newViewModel = presenters.getOnMoodChange(event, this.state);
      this.setState(newViewModel);
    };
  }

  changeIsWasteAvailable() {
    return (event) => {
      const newViewModel = presenters.getOnWasteIsAvailableChange(event, this.state);
      this.setState(newViewModel);
    };
  }

  changeTeamCapacity() {
    return (event) => {
      const newViewModel = presenters.getOnTeamCapacityChange(event, this.state);
      this.setState(newViewModel);
    }
  }

  changeWasteDays() {
    return (event) => {
      const newViewModel = presenters.getOnWasteDaysChange(event, this.state);
      this.setState(newViewModel);
    };
  }

  onSubmit(event) {
    event.preventDefault();

    const updateViewModel = (newViewModel) => this.setState(newViewModel);
    const submitRequest = this.props.onSubmit;
    let currentViewModel = this.state;

    presenters.processSubmit(currentViewModel, updateViewModel, submitRequest);
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