import React from 'react';

import viewModels from "./viewModels/viewModels";
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

    this.state = viewModels.getInitial(props, dashboardCallbacks);
  }

  componentDidMount() {
    this.loadDashboard();
  }

  loadDashboard() {
    const { projectId } = this.state

    if (isNaN(projectId)) {
      const newState = viewModels.getProjectNotFoundError();
      this.setState(newState);
    }
    else {
      const onSuccess = viewModels.getOnSuccessLoadingDashboard;
      const onError = viewModels.getOnErrorLoadingDashboard;

      dashboardService.load(projectId, onSuccess, onError).then(newState => this.setState(newState));
    }
  }

  onRequestAddCycleSnap() {
    const newState = viewModels.getShowAddCycleSnapForm();
    this.setState(newState);
  }

  onAddCycleSnapCancel() {
    const newState = viewModels.getForClosingTheAddCycleSnapForm();
    this.setState(newState);
  }

  onAddCycleSnapSubmit(newCycleSnap) {
    const onSuccess = this.onSuccessAddingCycleSnap;
    const onError = viewModels.getOnErrorAddingACycleSnap;

    cycleSnapService.add(newCycleSnap, onSuccess, onError).then(newState => this.setState(newState));
  }

  onSuccessAddingCycleSnap(response) {
    this.loadDashboard();
    return viewModels.getSuccessOnAddingACycleSnap();
  }

  render() {
    const viewModel = this.state;

    return (<DashboardView viewModel={viewModel} />)
  }
}