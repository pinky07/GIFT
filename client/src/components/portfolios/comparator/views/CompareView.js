import React from 'react';
import CompareViewSuccess from "./viewComponents/CompareViewSuccess";
import CompareWithCriticalError from "./viewComponents/CompareWithCriticalError";
import LoadingCompareView from "./viewComponents/LoadingCompareView";

const CompareView = ({viewModel}) => {
  const {errorMessage} = viewModel;

  if (errorMessage)
    return (<CompareWithCriticalError errorMessage={errorMessage}/>);
  else {
    const {portfolioName} = viewModel.comparison;
    if (portfolioName) {
      return (<CompareViewSuccess viewModel={viewModel}/>);
    }
    else {
      return (<LoadingCompareView/>);
    }
  }
}

export default CompareView;

