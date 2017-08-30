import React from 'react';
import renderer from 'react-test-renderer';

import CompareView from '../CompareView';

describe('CompareView when portfolio does not have projects', () => {

  let viewModel;
  let actual;

  it('should render compare view with no projects', () => {

    viewModel = {
      portfolioId: '5',
      comparison: getPortfolioWithNoProjects(),
      errorMessage: '',
    };
    actual = renderer.create(<CompareView viewModel={viewModel}/>).toJSON();

    expect(actual).toMatchSnapshot();
  });

  function getPortfolioWithNoProjects() {
    // Test data from http://http://localhost:8080/api/v1/portfolios/5/comparison
    return {"portfolioName": "Portfolio With No Projects", "lastSnaps": []};
  }

});