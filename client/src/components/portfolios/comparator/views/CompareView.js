import React from 'react';
import Box from 'grommet/components/Box';
import CompareWithProjects from "./viewComponents/CompareWithProjects";


const CompareView = ({ viewModel }) => {
  return (
    <Box>
      <CompareWithProjects viewModel={viewModel} />
    </Box>
  );
}

export default CompareView;

