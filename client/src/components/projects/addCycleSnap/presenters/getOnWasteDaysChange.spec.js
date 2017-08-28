import presenters from './presenters';

describe('presenters.getOnWasteDaysChange', () => {

  let event
  let currentViewModel
  let viewModel
  beforeEach(() => {
    event = {target: {valueAsNumber: 2.349}};

    currentViewModel = {
      errors: {wasteDays: undefined},
      wasteDays: undefined,
      teamCapacity: 100.45,
      isWasteAvailable: true
    };
  });

  it('Should set the new rounded two decimal value', () => {
    viewModel = presenters.getOnWasteDaysChange(event, currentViewModel);
    const actual = viewModel.wasteDays;
    const expected = 2.35;

    expect(actual).toEqual(expected);
  });

  it('Should set validation result when valid', () => {
    viewModel = presenters.getOnWasteDaysChange(event, currentViewModel);
    const actual = viewModel.errors.wasteDays;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Should set validation result when invalid', () => {
    event.target.valueAsNumber = -1;
    viewModel = presenters.getOnWasteDaysChange(event, currentViewModel);
    const actual = viewModel.errors.wasteDays;
    const expected = 'Waste days min is 0';

    expect(actual).toEqual(expected);
  });

  it('Should set validation result when new value is NaN', () => {
    event.target.valueAsNumber = NaN;
    viewModel = presenters.getOnWasteDaysChange(event, currentViewModel);
    const actual = viewModel.errors.wasteDays;
    const expected = 'Waste days is required';

    expect(actual).toEqual(expected);
  });
});