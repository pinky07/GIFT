import React from 'react';
import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Status from 'grommet/components/icons/Status';

const DashboardWithCriticalError = ({errorMessage}) =>
    (
        <Box>
            <Heading>Dashboard</Heading>
            <h3><Status value='critical' /> <span>{errorMessage}</span></h3>
        </Box>
    );

export default DashboardWithCriticalError;



