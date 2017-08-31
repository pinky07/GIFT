import React from 'react';
import PropTypes from 'prop-types';

import presenters from './presenters/presenters';
import AddReleaseSnapView from './views/AddReleaseSnapView';
import fieldsValidation from './validations/fields/validation';

export default class AddReleaseSnapController extends React.Component {
  constructor(props) {
    super(props);

    this.onSubmit = this.onSubmit.bind(this);

    const formCallbacks = {
      onNameChange: this.changeReleaseName(),
      onDateChange: this.changeDate()
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

  }

  changeDate() {

  }
}