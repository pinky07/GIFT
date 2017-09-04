import React from 'react';
import axios from 'axios';

import presenters from "./presenters/presenters";
import DashboardView from './views/DashboardView';
import dashboardService from './dashboardService';
import cycleSnapService from '../addCycleSnap/cycleSnapService';
import releaseSnapService from '../addReleaseSnap/releaseSnapService';

export default class DashboardController extends React.Component {
  constructor(props) {
    super(props);

    this.onRequestAddCycleSnap = this.onRequestAddCycleSnap.bind(this);
    this.onAddCycleSnapSubmit = this.onAddCycleSnapSubmit.bind(this);
    this.loadDashboard = this.loadDashboard.bind(this);
    this.onSuccessAddingCycleSnap = this.onSuccessAddingCycleSnap.bind(this);
    this.onRequestAddReleaseSnap = this.onRequestAddReleaseSnap.bind(this);
    this.onSuccessAddingReleaseSnap = this.onSuccessAddingReleaseSnap.bind(this);
    this.onFormCancel = this.onFormCancel.bind(this);
    this.onAddReleaseSnapSubmit = this.onAddReleaseSnapSubmit.bind(this);

    const dashboardCallbacks = {
      onRequestAddCycleSnap: this.onRequestAddCycleSnap,
      onAddCycleSnapSubmit: this.onAddCycleSnapSubmit,
      onRequestAddReleaseSnap: this.onRequestAddReleaseSnap,
      onSuccessAddingReleaseSnap: this.onSuccessAddingReleaseSnap,
      onAddReleaseSnapSubmit: this.onAddReleaseSnapSubmit,
      onClose: this.onFormCancel
    }

    this.state = presenters.getInitial(props, dashboardCallbacks);
  }

  componentDidMount() {
    this.loadDashboard();
  }

  loadDashboard() {
    const {projectId} = this.state

    if (isNaN(projectId) || this.isInteger(projectId)) {
      const newViewModel = presenters.getInvalidProjectError();
      this.setState(newViewModel);
    }
    else {
      const onSuccess = presenters.getOnSuccessLoadingDashboard;
      const onError = presenters.getOnErrorLoadingDashboard;
      const axiosGet = axios.get;

      dashboardService
        .load(axiosGet, projectId, onSuccess, onError)
        .then(newViewModel => this.setState(newViewModel));
    }
  }

  isInteger(projectId) {
    return projectId % 1 != 0;
  }

  onRequestAddCycleSnap() {
    const newViewModel = presenters.getShowAddCycleSnapForm();
    this.setState(newViewModel);
  }

  onRequestAddReleaseSnap() {
    const newViewModel = presenters.getShowAddReleaseSnapForm();
    this.setState(newViewModel);
  }

  onFormCancel() {
    const newViewModel = presenters.getForClosingForms();
    this.setState(newViewModel);
  }

  onAddCycleSnapSubmit(newCycleSnap) {
    const onSuccess = this.onSuccessAddingCycleSnap;
    const onError = presenters.getOnErrorAddingACycleSnap;
    const post = axios.post;

    cycleSnapService.add(newCycleSnap, post, onSuccess, onError).then(newViewModel => this.setState(newViewModel));
  }

  onAddReleaseSnapSubmit(newReleaseSnap) {
    const onSuccess = this.onSuccessAddingReleaseSnap;
    const onError = presenters.getOnErrorAddingAReleaseSnap;
    const post = axios.post;

    releaseSnapService.add(newReleaseSnap, post, onSuccess, onError).then(newViewModel => this.setState(newViewModel));
  }


  onSuccessAddingCycleSnap(response) {
    this.loadDashboard();

    return presenters.getSuccessOnAddingACycleSnap();
  }

  onSuccessAddingReleaseSnap(response) {
    this.loadDashboard();

    return presenters.getSuccessOnAddingAReleaseSnap();
  }

  render() {
    const viewModel = this.state;

    return (<DashboardView viewModel={viewModel}/>)
  }
}