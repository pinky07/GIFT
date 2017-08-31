import React from 'react';
import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import CompareTable from './CompareTable'

const CompareWithProjects = ({ viewModel }) => {
  const { portfolioName } = viewModel.comparison;

  return (<Box>
      <Heading>Compare Projects for Portfolio: {portfolioName}</Heading>
      <CompareTable viewModel={viewModel} />
    </Box>
  );
}
export default CompareWithProjects;