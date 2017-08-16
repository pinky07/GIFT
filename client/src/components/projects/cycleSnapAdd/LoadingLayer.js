import React from 'react';
import Layer from 'grommet/components/Footer';
import Box from 'grommet/components/Box';
import Spinning from 'grommet/components/icons/Spinning';

const LoadingLayer = () =>
    (
        <Layer align='center'>
            <Box pad={{ vertical: 'large', horizontal: 'small' }}>
                <h3><Spinning /> Loading... </h3>
            </Box>
        </Layer>
    );

export default LoadingLayer;

