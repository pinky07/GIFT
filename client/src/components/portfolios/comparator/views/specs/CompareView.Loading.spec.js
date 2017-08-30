import React from 'react';
import renderer from 'react-test-renderer';
import CompareView from '../CompareView';

describe('CompareView shows the loading view', () => {

  let viewModel;
  let actual;

  it('should render the loading view', () => {
    viewModel = { comparison: { portfolioName: '' } };
    actual = renderer.create(<CompareView viewModel={viewModel} />).toJSON();

    expect(actual).toMatchSnapshot();
  });
});