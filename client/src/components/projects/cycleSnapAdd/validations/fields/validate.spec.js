import validation from './validation';

describe('Validation for all fields should validate', () => {

  let state
  beforeEach(() => {
    state = {
      cycleSnapName: '1',
      startDate: '2016-11-15',
      endDate: '2016-11-21',
      targetedPoints: '8',
      achievedPoints: '8'
    };
  })

  it('Valid scenario', () => {
    let actual = validation.validate(state);
    let expected = {"achievedPoints": undefined, "endDate": undefined, "name": undefined, "startDate": undefined, "targetedPoints": undefined};

    expect(actual).toEqual(expected);
  });

  it('Name is not valid', () => {
    state.cycleSnapName = '';
    let errors = validation.validate(state);
    let actual = errors.name;

    expect(actual).toBeTruthy();
  });

  it('Start date is not valid', () => {
    state.startDate = '';
    let errors = validation.validate(state);
    let actual = errors.startDate;

    expect(actual).toBeTruthy();
  });

  it('End date is not valid', () => {
    state.endDate = '';
    let errors = validation.validate(state);
    let actual = errors.endDate;

    expect(actual).toBeTruthy();
  });

  it('Targeted points are not valid', () => {
    state.targetedPoints = 10001;
    let errors = validation.validate(state);
    let actual = errors.targetedPoints;

    expect(actual).toBeTruthy();
  });

  it('Achieved points are not valid', () => {
    state.achievedPoints = 10001;
    let errors = validation.validate(state);
    let actual = errors.achievedPoints;

    expect(actual).toBeTruthy();
  });
});