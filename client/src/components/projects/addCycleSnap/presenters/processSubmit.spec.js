import presenters from './presenters';

describe('presenters.processSubmit', () => {

  let currentViewModel
  let updateViewModelCallBack
  let submitRequestCallBack
  beforeEach(() => {
    currentViewModel = {
      projectId: 999,
      cycleSnapName: 'Exceptional',
      startDate: '2017-01-01',
      endDate: '2017-12-31',
      targetedPoints: '18',
      achievedPoints: '19',
      isMoodAvailable: true,
      mood: 3,
      isWasteAvailable: true,
      teamCapacity: 100.01,
      wasteDays: 5.89,
    };
    updateViewModelCallBack = jest.fn();
    submitRequestCallBack = jest.fn();
  })

  it('should submit the request', () => {
    presenters.processSubmit(currentViewModel, updateViewModelCallBack, submitRequestCallBack);

    expect(submitRequestCallBack).toBeCalled();
  });

  it('should submit the correct request', () => {
    presenters.processSubmit(currentViewModel, updateViewModelCallBack, submitRequestCallBack);

    const expected = {
      "achievedPoints": "19",
      "cycleSnapName": "Exceptional",
      "endDate": "2017-12-31",
      "isMoodAvailable": true,
      "isWasteAvailable": true,
      "moodAverage": 3,
      "projectId": 999,
      "startDate": "2017-01-01",
      "targetedPoints": "18",
      "teamCapacity": 100.01,
      "wasteDays": 5.89};

    expect(submitRequestCallBack).toBeCalledWith(expected);
  });
});