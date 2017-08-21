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
      achievedPoints: '19'
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
});