import React from 'react';
import ShallowRenderer from 'react-test-renderer/shallow';

import AddReleaseSnapView from './AddReleaseSnapView';

describe('AddReleaseSnapView', () => {

    it('should render the correct data values and validation errors', () => {
        const viewModel = getViewModelWithErrors();
        const renderer = ShallowRenderer.createRenderer();
        const actual = renderer.render(<AddReleaseSnapView viewModel={viewModel} />);

        expect(actual).toMatchSnapshot();
    });

    function getViewModelWithErrors() {
        return {
            projectName: 'Exceptional Project',
            releaseName: 'Version 4',
            releaseDate: '2017-01-02',
            errors: {
                releaseName: 'error releaseName',
                releaseDate: 'error startDate'
            },
            formCallbacks: {
                onNameChange: jest.fn(),
                onDateChange: jest.fn(),
                onClick: jest.fn(),
                onClose: jest.fn()
            }
        };
    }
});