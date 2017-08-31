import React from 'react';
import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Status from 'grommet/components/icons/Status';

const CompareWithNoProjects = ({viewModel}) => {
  const { portfolioName } = viewModel.comparison;

  return (<Box>
    <Heading>Compare Projects for Portfolio: {portfolioName}</Heading>
    <h3>
      <Status value='unknown' />
      <span>This Portfolio has no projects.</span>
    </h3>
  </Box>);
}

export default CompareWithNoProjects;