import React from 'react';
import renderer from 'react-test-renderer';

import DashboardView from '../DashboardView';

describe('DashboardView shows the loading view', () => {

    let viewModel;
    let actual;

    it('should render the loading view', () => {
        viewModel = { project: { name: '' } };
        actual = renderer.create(<DashboardView viewModel={viewModel} />).toJSON();

        expect(actual).toMatchSnapshot();
    });
});