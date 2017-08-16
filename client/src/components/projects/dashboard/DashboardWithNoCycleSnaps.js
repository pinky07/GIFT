import React from 'react';
import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Status from 'grommet/components/icons/Status';
import Footer from 'grommet/components/Heading';
import Button from 'grommet/components/Button';

const DashboardWithNoCycleSnaps = ({state, elements, dashboardCallbacks}) =>
    (
        <Box>
            <Heading>Dashboard: {state.projectName}</Heading>
            <h3>
                <Status value='unknown' /> 
                <span>This project has no cycle snaps.</span>
            </h3>
            <Footer>
                 <Button 
                    label='Add Cycle Snap'
                    onClick={dashboardCallbacks._onRequestAddCycleSnap} 
                    onSubmit={dashboardCallbacks._onAddCycleSnapSubmit} 
                    primary={true}/> 
            </Footer>
            {elements.addCycleSnapLayer}
            {elements.successNotification}
            {elements.failureNotification}
        </Box>);

export default DashboardWithNoCycleSnaps;