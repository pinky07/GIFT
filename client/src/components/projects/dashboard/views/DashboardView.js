import React from 'react';
import Toast from 'grommet/components/Toast';

import DashboardWithCriticalError from './viewComponents/DashboardWithCriticalError';
import LoadingView from './viewComponents/LoadingView';
import DashboardWithNoCycleSnaps from './viewComponents/DashboardWithNoCycleSnaps';
import DashboardWithCycleSnaps from './viewComponents/DashboardWithCycleSnaps';

import AddCycleSnapController from '../../addCycleSnap/AddCycleSnapController';
import AddReleaseSnapController from "../../addReleaseSnap/AddReleaseSnapController";

const DashboardView = ({viewModel}) => {
  const {errorMessage} = viewModel;

  if (errorMessage)
    return (<DashboardWithCriticalError errorMessage={errorMessage}/>);
  else {
    const {name} = viewModel.project;
    if (name) {
      const elements = determineElements(viewModel);
      const {cycleSnaps} = viewModel.project;
      if (cycleSnaps.length > 0) {
        return (<DashboardWithCycleSnaps viewModel={viewModel} elements={elements}/>);
      }
      else
        return (<DashboardWithNoCycleSnaps viewModel={viewModel} elements={elements}/>);
    }
    else
      return (<LoadingView/>);
  }
}

/* Determines the UI elements that will be shown: 
  - success notification after adding a cycle snap 
  - failure notification when adding a cycle snap 
  - the modal dialog for adding a cycle snap 
*/
const determineElements = (viewModel) => {
  let elements = {
    successNotification: undefined,
    failureNotification: undefined,
    addCycleSnapLayer: undefined,
    addReleaseSnapLayer: undefined
  };

  const {successNotificationOnAdd} = viewModel;
  if (successNotificationOnAdd)
    elements.successNotification = <Toast status='ok'>{successNotificationOnAdd}</Toast>;

  const {failureNotificationOnAdd} = viewModel;
  if (failureNotificationOnAdd)
    elements.failureNotification = <Toast status='critical'>{failureNotificationOnAdd}</Toast>;

  const {dashboardCallbacks} = viewModel;
  const {addCycleSnap} = viewModel;
  const {addReleaseSnap} = viewModel;

  if (addCycleSnap) {
    elements.addCycleSnapLayer = <AddCycleSnapController
      projectId={viewModel.projectId}
      projectName={viewModel.project.name}
      onClose={dashboardCallbacks.onClose}
      onSubmit={dashboardCallbacks.onAddCycleSnapSubmit}/>;
  }
  if (addReleaseSnap) {
    elements.addReleaseSnapLayer = <AddReleaseSnapController
      projectId={viewModel.projectId}
      projectName={viewModel.project.name}
      onClose={dashboardCallbacks.onClose}
      onSubmit={dashboardCallbacks.onAddReleaseSnapSubmit}/>;
  }

  return elements;
}

export default DashboardView;