import React from 'react';
import Box from 'grommet/components/Box';
import DashboardHeading from './DashboardHeading';
import Status from 'grommet/components/icons/Status';

const DashboardWithCriticalError = ({errorMessage}) =>
    (
        <Box>
            <DashboardHeading/>
            <h3><Status value='critical' /> <span>{errorMessage}</span></h3>
        </Box>
    );

export default DashboardWithCriticalError;



