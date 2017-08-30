import React from 'react';
import renderer from 'react-test-renderer';
import CompareView from '../CompareView';

describe('CompareView shows critical errors', () => {

  let viewModel;
  let actual;

  it('should render a critical error', () => {
    viewModel = { errorMessage: 'There was a critical error!' }
    actual = renderer.create(<CompareView viewModel={viewModel} />).toJSON();

    expect(actual).toMatchSnapshot();
  });

});