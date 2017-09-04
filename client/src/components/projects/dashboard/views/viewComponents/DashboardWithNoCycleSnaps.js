import React from 'react';
import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Status from 'grommet/components/icons/Status';
import Footer from 'grommet/components/Heading';
import Button from 'grommet/components/Button';

const DashboardWithNoCycleSnaps = ({viewModel, elements}) => {
  const {dashboardCallbacks} = viewModel;

  return (<Box>
    <Heading>Dashboard: {viewModel.project.name}</Heading>
    <h3>
      <Status value='unknown'/>
      <span>This project has no cycle snaps.</span>
    </h3>
    <Footer>
      <Box direction='row'
           pad={{"between": "medium"}}>
        <Button
          label='Add Cycle Snap'
          onClick={dashboardCallbacks.onRequestAddCycleSnap}
          onSubmit={dashboardCallbacks.onAddCycleSnapSubmit}
          primary={true}/>

        <Button
          label='Add Release Snap'
          onClick={dashboardCallbacks.onRequestAddReleaseSnap}
          onSubmit={dashboardCallbacks.onAddReleaseSnapSubmit}
          primary={true}/>
      </Box>
    </Footer>
    {elements.addCycleSnapLayer}
    {elements.addReleaseSnapLayer}
    {elements.successNotification}
    {elements.failureNotification}
  </Box>);
}

export default DashboardWithNoCycleSnaps;