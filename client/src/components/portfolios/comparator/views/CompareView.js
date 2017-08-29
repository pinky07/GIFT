import React from 'react';
import CompareWithProjects from "./viewComponents/CompareWithProjects";
import CompareWithCriticalError from "./viewComponents/CompareWithCriticalError";
import CompareWithNoProjects from "./viewComponents/CompareWithNoProjects";
import LoadingCompareView from "./viewComponents/LoadingCompareView";


const CompareView = ({viewModel}) => {
  const {errorMessage} = viewModel;

  if (errorMessage)
    return (<CompareWithCriticalError errorMessage={errorMessage}/>);
  else {
    const {portfolioName} = viewModel.comparison;
    if (portfolioName) {
      const {lastSnaps} = viewModel.comparison;
      if (lastSnaps.length > 0) {
        return (<CompareWithProjects viewModel={viewModel}/>);
      }
      else {
        return (<CompareWithNoProjects viewModel={viewModel}/>);
      }
    }
    else {
      return (<LoadingCompareView/>);
    }
  }
}

export default CompareView;

