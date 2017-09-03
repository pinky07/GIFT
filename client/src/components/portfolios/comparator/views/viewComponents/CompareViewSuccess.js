import React from 'react';
import CompareWithProjects from './CompareWithProjects';
import CompareWithNoProjects from './CompareWithNoProjects';

const CompareViewSuccess = ({viewModel}) => {
  const {lastSnaps} = viewModel.comparison;
  if (lastSnaps.length > 0) {
    return (<CompareWithProjects viewModel={viewModel}/>);
  }
  else {
    return (<CompareWithNoProjects viewModel={viewModel}/>);
  }
}

export default CompareViewSuccess;