import React from 'react';
import Box from 'grommet/components/Box';
import CompareHeading from './CompareHeading';
import Status from 'grommet/components/icons/Status';

const CompareWithCriticalError = ({errorMessage}) =>
  (
    <Box>
      <CompareHeading/>
      <h3><Status value='critical'/> <span>{errorMessage}</span></h3>
    </Box>
  );

export default CompareWithCriticalError;



