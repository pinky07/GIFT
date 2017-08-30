import React from 'react';
import renderer from 'react-test-renderer';

import DashboardView from '../DashboardView';

describe('DashboardView when project has one or more cycle snaps', () => {

  let viewModel;
  let actual;

  it('should render dashboard with two cycle snaps', () => {
    viewModel = getViewModelWithTwoCycleSnaps();
    actual = renderer.create(<DashboardView viewModel={viewModel}/>).toJSON();

    expect(actual).toMatchSnapshot();
  });

  function getViewModelWithTwoCycleSnaps() {
    return {
      projectId: '7',
      project: getProjectWithCycleSnaps(),
      dashboardCallbacks: getDashboardCallbacks(),

      errorMessage: '',
      addCycleSnap: false,
      successNotificationOnAdd: undefined,
      failureNotificationOnAdd: undefined
    }
  }

  function getDashboardCallbacks() {
    const onRequestAddCycleSnap = jest.fn();
    const onAddCycleSnapSubmit = jest.fn();
    const onAddCycleSnapCancel = jest.fn();

    return {
      onRequestAddCycleSnap: onRequestAddCycleSnap,
      onAddCycleSnapSubmit: onAddCycleSnapSubmit,
      onAddCycleSnapCancel: onAddCycleSnapCancel
    }
  }

  function getProjectWithCycleSnaps() {
    // Test data from http://localhost:8080/api/v1/projects/7/dashboard
    return {
      "name": "Exceptional Project",
      "cycleSnaps": [{
        "cycleSnapName": "5",
        "startDate": "2017-03-16",
        "endDate": "2017-03-17",
        "targetedPoints": 1,
        "achievedPoints": 2,
        "tac": "200%",
        "relatedIncidents": "7",
        "daysSinceLastRelease": "15",
        "lastReleaseName": "Second Update",
        "lastReleaseDate": "2017-03-02",
        "teamCapacity": 0.0,
        "wasteDays": 0.0,
        "wastePercentage": "No data",
        "mood": "No data"
      }, {
        "cycleSnapName": "Sprint #4",
        "startDate": "2017-03-01",
        "endDate": "2017-03-15",
        "targetedPoints": 100,
        "achievedPoints": 100,
        "tac": "100%",
        "relatedIncidents": "6",
        "daysSinceLastRelease": "13",
        "lastReleaseName": "Second Update",
        "lastReleaseDate": "2017-03-02",
        "teamCapacity": 0.0,
        "wasteDays": 0.0,
        "wastePercentage": "No data",
        "mood": "No data"
      }, {
        "cycleSnapName": "Sprint #3",
        "startDate": "2017-02-18",
        "endDate": "2017-02-28",
        "targetedPoints": 70,
        "achievedPoints": 68,
        "tac": "97%",
        "relatedIncidents": "6",
        "daysSinceLastRelease": "21",
        "lastReleaseName": "First Version",
        "lastReleaseDate": "2017-02-07",
        "teamCapacity": 99.0,
        "wasteDays": 0.0,
        "wastePercentage": "0.0%",
        "mood": "2.50"
      }, {
        "cycleSnapName": "Sprint #2",
        "startDate": "2017-02-01",
        "endDate": "2017-02-14",
        "targetedPoints": 60,
        "achievedPoints": 55,
        "tac": "91%",
        "relatedIncidents": "5",
        "daysSinceLastRelease": "7",
        "lastReleaseName": "First Version",
        "lastReleaseDate": "2017-02-07",
        "teamCapacity": 99.0,
        "wasteDays": 5.67,
        "wastePercentage": "5.7%",
        "mood": "3.00"
      }, {
        "cycleSnapName": "Sprint #1",
        "startDate": "2017-01-25",
        "endDate": "2017-01-30",
        "targetedPoints": 0,
        "achievedPoints": 0,
        "tac": "No Data",
        "relatedIncidents": "No releases yet",
        "daysSinceLastRelease": "5",
        "lastReleaseName": "No releases yet",
        "lastReleaseDate": "No releases yet",
        "teamCapacity": 100.0,
        "wasteDays": 5.0,
        "wastePercentage": "5.0%",
        "mood": "3.00"
      }]
    };
  }
});