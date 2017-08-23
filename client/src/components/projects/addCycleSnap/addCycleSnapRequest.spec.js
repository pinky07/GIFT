import addCycleSnapRequest from './addCycleSnapRequest';

describe('Add cycle snap request', () => {

  let request
  beforeEach(() => {
    let viewModel = {
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
    request = addCycleSnapRequest.get(viewModel);
  })

  it('should contain the project id', () => {
    const actual = request.projectId;
    const expected = 999;

    expect(actual).toEqual(expected);
  });

  it('should contain the cycle snap name', () => {
    const actual = request.cycleSnapName;
    const expected = 'Exceptional';

    expect(actual).toEqual(expected);
  });

  it('should contain the start date', () => {
    const actual = request.startDate;
    const expected = '2017-01-01';

    expect(actual).toEqual(expected);
  });

  it('should contain the end date', () => {
    const actual = request.endDate;
    const expected = '2017-12-31';

    expect(actual).toEqual(expected);
  });

  it('should contain the targeted points', () => {
    const actual = request.targetedPoints;
    const expected = '18';

    expect(actual).toEqual(expected);
  });

  it('should contain the achieved points', () => {
    const actual = request.achievedPoints;
    const expected = '19';

    expect(actual).toEqual(expected);
  });

  it('should contain the Mood data is available indicator', () => {
    const actual = request.isMoodAvailable;
    const expected = true;

    expect(actual).toEqual(expected);
  });

  it('should contain the Mood Average', () => {
    const actual = request.moodAverage;
    const expected = 3;

    expect(actual).toEqual(expected);
  });

  it('should contain the Waste is available indicator', () => {
    const actual = request.isWasteAvailable;
    const expected = true;

    expect(actual).toEqual(expected);
  });

  it('should contain the Team capacity', () => {
    const actual = request.teamCapacity;
    const expected = 100.01;

    expect(actual).toEqual(expected);
  });

  it('should contain the Waste Days', () => {
    const actual = request.wasteDays;
    const expected = 5.89;

    expect(actual).toEqual(expected);
  });
});