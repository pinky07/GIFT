import React from 'react';
import PropTypes from 'prop-types';

import presenters from './presenters/presenters';
import AddReleaseSnapView from './views/AddReleaseSnapView';

export default class AddReleaseSnapController extends React.Component {
  constructor(props) {
    super(props);

    this.onSubmit = this.onSubmit.bind(this);

    const formCallbacks = {
      onNameChange: this.changeReleaseName(),
      onDateChange: this.changeReleaseDate(),
      onClick: this.onSubmit,
      onClose: this.props.onClose
    }

    this.state = presenters.getInitial(props, formCallbacks)
  }

  onSubmit(event) {
    event.preventDefault();

    const updateViewModel = (newViewModel) => this.setState(newViewModel);
    const submitRequest = this.props.onSubmit;
    let currentViewModel = this.state;

    presenters.processSubmit(currentViewModel, updateViewModel, submitRequest);
  }


  changeReleaseName() {
    return (event) => {
      const newViewModel = presenters.getOnNameChange(event, this.state);
      this.setState(newViewModel);
    };
  }

  changeReleaseDate() {
    return (newValue) => {
      const newViewModel = presenters.getOnDateChange(newValue, this.state)
      this.setState(newViewModel);
    }
  }

  render() {
    return (<AddReleaseSnapView viewModel={this.state} />)
  }
}

AddReleaseSnapController.PropTypes = {
  onClose: PropTypes.func.isRequired,
  onSubmit: PropTypes.func.isRequired,
  projectId: PropTypes.number,
  projectName: PropTypes.string
};