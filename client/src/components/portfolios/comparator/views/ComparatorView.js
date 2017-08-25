import React from 'react';
import Box from 'grommet/components/Box';
import {Heading} from "grommet";

const ComparatorView = ({ viewModel }) => {
  const { portfolioName } = viewModel;

  return(<Box>
    <Heading>Project Comparator</Heading>
    <h2>Portfolio: {portfolioName}</h2>

    </Box>
  );
}

export default ComparatorView;