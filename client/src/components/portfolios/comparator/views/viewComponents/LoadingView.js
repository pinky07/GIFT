import React from 'react';
import Box from 'grommet/components/Box';
import Spinning from 'grommet/components/icons/Spinning';
import CompareHeading from './CompareHeading';

const LoadingView = () =>
  (
    <Box>
      <CompareHeading/>
      <h3><Spinning /> Loading... </h3>
    </Box>
  );

export default LoadingView;

