import presenters from './presenters';

describe('presenters.getOnMoodChange', () => {

  let event
  let currentViewModel
  let viewModel
  beforeEach(() => {
    event = {target: {valueAsNumber: 2.349}};

    currentViewModel = {
      errors: {mood: undefined},
      mood: undefined,
      isMoodAvailable: true
    };
  });

  it('Should set the new rounded two decimal value', () => {
    viewModel = presenters.getOnMoodChange(event, currentViewModel);
    const actual = viewModel.mood;
    const expected = 2.35;

    expect(actual).toEqual(expected);
  });

  it('Should set validation result when valid', () => {
    viewModel = presenters.getOnMoodChange(event, currentViewModel);
    const actual = viewModel.errors.mood;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Should set validation result when invalid', () => {
    event.target.valueAsNumber = -1;
    viewModel = presenters.getOnMoodChange(event, currentViewModel);
    const actual = viewModel.errors.mood;
    const expected = 'Mood average min is 1';

    expect(actual).toEqual(expected);
  });

  it('Should set validation result when new value is NaN', () => {
    event.target.valueAsNumber = NaN;
    viewModel = presenters.getOnMoodChange(event, currentViewModel);
    const actual = viewModel.errors.mood;
    const expected = 'Mood average is required';

    expect(actual).toEqual(expected);
  });
});