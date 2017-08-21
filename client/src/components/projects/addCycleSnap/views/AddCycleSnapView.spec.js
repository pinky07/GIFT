import React from 'react';
import renderer from 'react-test-renderer';

import AddCycleSnapView from './AddCycleSnapView';

describe('AddCycleSnapView', () => {

    let actual;

    it('should render the correct data values and validation errors', () => {
        let viewModel = getViewModelWithErrors();
        actual = renderer.create(<AddCycleSnapView viewModel={viewModel} />).toJSON();

        expect(actual).toMatchSnapshot();
    });

    function getViewModelWithErrors() {
        return {
            projectId: '7',
            projectName: 'Exceptional Project',
            cycleSnapName: '1',
            startDate: '2017-01-02',
            endDate: '2017-01-15',
            targetedPoints: '8',
            achievedPoints: '13',
            errors: {
                name: 'error name',
                startDate: 'error startDate',
                endDate: 'error endDate',
                targetedPoints: 'error targetedPoints',
                achievedPoints: 'error achievedPoints'
            },
            formCallbacks: {
                onNameChange: jest.fn(),
                onStartDateChange: jest.fn(),
                onEndDateChange: jest.fn(),
                onTargetedPointsChange: jest.fn(),
                onAchievedPointsChange: jest.fn(),
                onClick: jest.fn(),
                onClose: jest.fn()
            }
        };
    }
});