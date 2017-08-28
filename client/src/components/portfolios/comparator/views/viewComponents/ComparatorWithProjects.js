import React from 'react';
import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import ComparatorTable from './ComparatorTable'

const ComparatorWithProjects = ({ viewModel }) => {
  const { portfolioName } = viewModel.comparator;

  return (<Box>
      <Heading>Compare Project for Portfolio: {portfolioName}</Heading>
      <ComparatorTable viewModel={viewModel} />
    </Box>
  );
}
export default ComparatorWithProjects;