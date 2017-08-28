import presenters from './presenters';

describe('presenters.getOnTeamCapacityChange', () => {

  let event
  let currentViewModel
  let viewModel
  beforeEach(() => {
    event = {target: {valueAsNumber: 2.349}};

    currentViewModel = {
      errors: {teamCapacity: undefined},
      teamCapacity: undefined,
      isWasteAvailable: true
    };
  });

  it('Should set the new rounded two decimal value', () => {
    viewModel = presenters.getOnTeamCapacityChange(event, currentViewModel);
    const actual = viewModel.teamCapacity;
    const expected = 2.35;

    expect(actual).toEqual(expected);
  });

  it('Should set validation result when valid', () => {
    viewModel = presenters.getOnTeamCapacityChange(event, currentViewModel);
    const actual = viewModel.errors.teamCapacity;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Should set validation result when invalid', () => {
    event.target.valueAsNumber = '';
    viewModel = presenters.getOnTeamCapacityChange(event, currentViewModel);
    const actual = viewModel.errors.teamCapacity;
    const expected = 'Team capacity min is 1';

    expect(actual).toEqual(expected);
  });
});