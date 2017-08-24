import validation from './validation';

describe('Validation for all fields should validate', () => {

  let state
  beforeEach(() => {
    state = {
      cycleSnapName: '1',
      startDate: '2016-11-15',
      endDate: '2016-11-21',
      targetedPoints: '8',
      achievedPoints: '8',
      isMoodAvailable: true,
      mood: 3,
      isWasteAvailable: true,
      teamCapacity: 100,
      wasteDays: 5    
    };
  })

  it('Valid scenario', () => {
    let actual = validation.validate(state);
    let expected = {"achievedPoints": undefined, "endDate": undefined, "name": undefined, "startDate": undefined, "targetedPoints": undefined, "mood": undefined};

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

  it('Mood Average is not valid', () => {
    state.mood = 3.01;
    state.isMoodAvailable = true;
    let errors = validation.validate(state);
    let actual = errors.mood;

    expect(actual).toBeTruthy();
  });

  it('Team capacity is not valid', () => {
    state.isMoodAvailable = false;
    state.isWasteAvailable = true;
    state.teamCapacity = 10000.01;
    let errors = validation.validate(state);
    let actual = errors.teamCapacity;

    expect(actual).toBeTruthy();
  });

  it('Waste Days is not valid', () => {
    state.isMoodAvailable = false;
    state.isWasteAvailable = true;
    state.wasteDays = -0.01;
    let errors = validation.validate(state);
    let actual = errors.wasteDays;

    expect(actual).toBeTruthy();
  });

});