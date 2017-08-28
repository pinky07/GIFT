import React from 'react';
import Box from 'grommet/components/Box';
import ComparatorWithProjects from "./viewComponents/ComparatorWithProjects";


const ComparatorView = ({ viewModel }) => {
  return (
    <Box>
      <ComparatorWithProjects viewModel={viewModel} />
    </Box>
  );
}

export default ComparatorView;

