import viewModels from './viewModels';

describe('getNewWasteInfo', () => {

  let errors
  beforeEach(() => {
    errors = { teamCapacity: 'Waste is invalid', wasteDays: 'Waste days is invalid' };
  })
  
  it('it should set team capacity to 0', () => {
    const viewModel = viewModels.getNewWasteInfo(true, errors);
    const actual = viewModel.teamCapacity;
    const expected = '0';

    expect(actual).toEqual(expected);
  });

  it('it should set team capacity to 0', () => {
    const viewModel = viewModels.getNewWasteInfo(true, errors);
    const actual = viewModel.wasteDays;
    const expected = '0';

    expect(actual).toEqual(expected);
  });

  it('it should return the same isWasteAvailable', () => {
    const viewModel = viewModels.getNewWasteInfo(true, errors);
    const actual = viewModel.isWasteAvailable;
    const expected = true;

    expect(actual).toEqual(expected);
  });

  it('it should return the same isWasteAvailable even when false', () => {
    const viewModel = viewModels.getNewWasteInfo(false, errors);
    const actual = viewModel.isWasteAvailable;
    const expected = false;

    expect(actual).toEqual(expected);
  });

  it('it should clean the team capacity error message', () => {
    const viewModel = viewModels.getNewWasteInfo(true, errors);
    const actual = viewModel.errors.teamCapacity;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('it should clean the waste days error message', () => {
    const viewModel = viewModels.getNewWasteInfo(true, errors);
    const actual = viewModel.errors.wasteDays;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

 
});