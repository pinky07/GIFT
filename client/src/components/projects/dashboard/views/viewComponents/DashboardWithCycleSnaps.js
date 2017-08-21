import React from 'react';
import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Footer from 'grommet/components/Footer';
import Button from 'grommet/components/Button';
import CycleSnapsTable from './CycleSnapsTable'

const DashboardWithCycleSnaps = ({ viewModel, elements }) => {
  const { dashboardCallbacks } = viewModel;
  const { name } = viewModel.project;

  return (<Box>
    <Heading>Dashboard: {name}</Heading>
    <Footer>
      <Button
        label='Add Cycle Snap'
        onClick={dashboardCallbacks.onRequestAddCycleSnap}
        onSubmit={dashboardCallbacks.onAddCycleSnapSubmit}
        primary={true} />
    </Footer>

    <CycleSnapsTable viewModel={viewModel} />

    {elements.addCycleSnapLayer}
    {elements.successNotification}
    {elements.failureNotification}
  </Box>
  );
}
export default DashboardWithCycleSnaps;