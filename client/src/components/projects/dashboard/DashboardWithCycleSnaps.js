import React from 'react';
import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Footer from 'grommet/components/Footer';
import Button from 'grommet/components/Button';
import CycleSnapsTable from './CycleSnapsTable'

const DashboardWithCycleSnaps = ({state, elements, dashboardCallbacks}) => {

    return (<Box>
            <Heading>Dashboard: {state.projectName}</Heading>
            <Footer>
              <Button 
                    label='Add Cycle Snap'
                    onClick={dashboardCallbacks._onRequestAddCycleSnap} 
                    onSubmit={dashboardCallbacks._onAddCycleSnapSubmit} 
                    primary={true}/> 
            </Footer>

            <CycleSnapsTable cycleSnaps={state.cycleSnaps}/>
            
            {elements.addCycleSnapLayer}
            {elements.successNotification}
            {elements.failureNotification}
          </Box>
        );
    }
export default DashboardWithCycleSnaps;