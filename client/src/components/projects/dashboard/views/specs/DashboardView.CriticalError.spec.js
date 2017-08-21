import React from 'react';
import renderer from 'react-test-renderer';

import DashboardView from '../DashboardView';

describe('DashboardView shows critical errors', () => {

    let viewModel;
    let actual;

    it('should render a critical error', () => {
        viewModel = { errorMessage: 'There was a critical error!' }
        actual = renderer.create(<DashboardView viewModel={viewModel} />).toJSON();

        expect(actual).toMatchSnapshot();
    });
});