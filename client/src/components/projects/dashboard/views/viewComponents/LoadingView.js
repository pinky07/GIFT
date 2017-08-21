import React from 'react';
import Box from 'grommet/components/Box';
import Spinning from 'grommet/components/icons/Spinning';
import DashboardHeading from './DashboardHeading';

const LoadingView = () =>
    (
        <Box>
            <DashboardHeading/>
            <h3><Spinning /> Loading... </h3>
        </Box>
    );

export default LoadingView;

