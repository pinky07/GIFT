import React from 'react';
import Box from 'grommet/components/Box';
import Spinning from 'grommet/components/icons/Spinning';
import CompareHeading from './CompareHeading';

const LoadingCompareView = () =>
  (
    <Box>
      <CompareHeading/>
      <h3><Spinning /> Loading... </h3>
    </Box>
  );

export default LoadingCompareView;

