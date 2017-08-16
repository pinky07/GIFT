import React from 'react';
import Toast from 'grommet/components/Toast';

import dashboardService from './dashboardService';
import cycleSnapService from '../cycleSnapAdd/cycleSnapService';

import DashboardWithCriticalError from './DashboardWithCriticalError';
import LoadingDashboard from './LoadingDashboard';
import DashboardWithNoCycleSnaps from './DashboardWithNoCycleSnaps';
import DashboardWithCycleSnaps from './DashboardWithCycleSnaps';

import CycleSnapAdd from '../cycleSnapAdd/CycleSnapAdd';

export default class Dashboard extends React.Component {
  constructor(props) {
    super(props);

    this._onRequestAddCycleSnap = this._onRequestAddCycleSnap.bind(this);
    this._onAddCycleSnapCancel = this._onAddCycleSnapCancel.bind(this);
    this._onAddCycleSnapSubmit = this._onAddCycleSnapSubmit.bind(this);
    this._loadDashboard = this._loadDashboard.bind(this);

    this.state = {
      projectId: props.params.id,
      projectName: '',
      cycleSnaps: [],
      errorMessage: '',
      addCycleSnap: false,
      successNotificationOnAdd: undefined,
      failureNotificationOnAdd: undefined
    };
  }

  componentDidMount() {
    this._loadDashboard();
  }

  _loadDashboard() {
    const { projectId } = this.state

    if (isNaN(projectId))
      this.setState({ errorMessage: "Invalid project id" });
    else
      dashboardService.load(projectId).then(newState => this.setState(newState));
  }

  _onRequestAddCycleSnap() {
    this.setState({
      addCycleSnap: true,
      successNotificationOnAdd: undefined,
      failureNotificationOnAdd: undefined
    });
  }

  _onAddCycleSnapCancel() {
    this.setState({
      addCycleSnap: false,
      successNotificationOnAdd: undefined,
      failureNotificationOnAdd: undefined
    });
  }

  _onAddCycleSnapSubmit(newCycleSnap) {
    const { projectId } = this.state
    cycleSnapService.add(newCycleSnap, this._loadDashboard).then(newState => this.setState(newState));
  }

  /* Determines the UI elements that will be shown: 
    - success notification after adding a cycle snap 
    - failure notification when adding a cycle snap 
    - the modal dialog for adding a cycle snap 
  */
  _determineElements(state, dashboardCallbacks) {
    let elements = {
      successNotification: undefined,
      failureNotification: undefined,
      addCycleSnapLayer: undefined
    };

    if (state.successNotificationOnAdd)
      elements.successNotification = (<Toast status='ok'>{state.successNotificationOnAdd}</Toast>);

    if (state.failureNotificationOnAdd)
      elements.failureNotification = (<Toast status='critical'>{state.failureNotificationOnAdd}</Toast>);

    if (state.addCycleSnap)
      elements.addCycleSnapLayer = (<CycleSnapAdd
                                      projectId={state.projectId}
                                      projectName={state.projectName}
                                      onClose={dashboardCallbacks._onAddCycleSnapCancel}
                                      onSubmit={dashboardCallbacks._onAddCycleSnapSubmit} />);

    return elements;
  }

  render() {
    let dashboardCallbacks = {
      _onRequestAddCycleSnap: this._onRequestAddCycleSnap,
      _onAddCycleSnapSubmit: this._onAddCycleSnapSubmit,
      _onAddCycleSnapCancel: this._onAddCycleSnapCancel
    }

    const elements = this._determineElements(this.state, dashboardCallbacks);

    const { projectName } = this.state;
    const { cycleSnaps } = this.state;
    const { errorMessage } = this.state;

    if (errorMessage)
      return (<DashboardWithCriticalError errorMessage={errorMessage} />);
    else
      if (projectName)
        if (cycleSnaps.length > 0)
          return (<DashboardWithCycleSnaps state={this.state} elements={elements} dashboardCallbacks={dashboardCallbacks} />);
        else
          return (<DashboardWithNoCycleSnaps state={this.state} elements={elements} dashboardCallbacks={dashboardCallbacks} />);
      else
        return (<LoadingDashboard />);
  }
}