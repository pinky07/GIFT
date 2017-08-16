import React from 'react';
import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Spinning from 'grommet/components/icons/Spinning';

const LoadingDashboard = () =>
    (
        <Box>
            <Heading>Dashboard</Heading>
            <h3><Spinning /> Loading... </h3>
        </Box>
    );

export default LoadingDashboard;

