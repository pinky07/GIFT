import React from 'react';
import axios from 'axios';

import presenters from "./presenters/presenters";
import DashboardView from './views/DashboardView';
import dashboardService from './dashboardService';
import cycleSnapService from '../addCycleSnap/cycleSnapService';

export default class Dashboard extends React.Component {
  constructor(props) {
    super(props);

    this.onRequestAddCycleSnap = this.onRequestAddCycleSnap.bind(this);
    this.onAddCycleSnapCancel = this.onAddCycleSnapCancel.bind(this);
    this.onAddCycleSnapSubmit = this.onAddCycleSnapSubmit.bind(this);
    this.loadDashboard = this.loadDashboard.bind(this);
    this.onSuccessAddingCycleSnap = this.onSuccessAddingCycleSnap.bind(this);

    const dashboardCallbacks = {
      onRequestAddCycleSnap: this.onRequestAddCycleSnap,
      onAddCycleSnapSubmit: this.onAddCycleSnapSubmit,
      onAddCycleSnapCancel: this.onAddCycleSnapCancel
    }

    this.state = presenters.getInitial(props, dashboardCallbacks);
  }

  componentDidMount() {
    this.loadDashboard();
  }

  loadDashboard() {
    const {projectId} = this.state

    if (isNaN(projectId)) {
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

  onRequestAddCycleSnap() {
    const newViewModel = presenters.getShowAddCycleSnapForm();
    this.setState(newViewModel);
  }

  onAddCycleSnapCancel() {
    const newViewModel = presenters.getForClosingTheAddCycleSnapForm();
    this.setState(newViewModel);
  }

  onAddCycleSnapSubmit(newCycleSnap) {
    const onSuccess = this.onSuccessAddingCycleSnap;
    const onError = presenters.getOnErrorAddingACycleSnap;
    const post = axios.post;

    cycleSnapService.add(newCycleSnap, post, onSuccess, onError).then(newViewModel => this.setState(newViewModel));
  }

  onSuccessAddingCycleSnap(response) {
    this.loadDashboard();

    return presenters.getSuccessOnAddingACycleSnap();
  }

  render() {
    const viewModel = this.state;

    return (<DashboardView viewModel={viewModel}/>)
  }
}