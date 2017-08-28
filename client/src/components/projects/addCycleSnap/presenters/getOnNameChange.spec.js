import presenters from './presenters';

describe('presenters.getOnNameChange', () => {

  let eventWithEmptyValue
  let eventWithValidValue
  let currentViewModel

  beforeEach(() => {
    eventWithEmptyValue = {target: {value: '          '}};
    eventWithValidValue = {target: {value: ' Sprint 1 '}};

    currentViewModel = {
      errors: {name: undefined},
      cycleSnapName: undefined
    };
  })

  it('Should set the new value', () => {
    const viewModel = presenters.getOnNameChange(eventWithValidValue, currentViewModel);
    const actual = viewModel.cycleSnapName;
    const expected = ' Sprint 1 ';

    expect(actual).toEqual(expected);
  });

  it('Should clear error when valid', () => {
    const viewModel = presenters.getOnNameChange(eventWithValidValue, currentViewModel);
    const actual = viewModel.errors.name;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Should set error when trimmed value is empty', () => {
    const viewModel = presenters.getOnNameChange(eventWithEmptyValue, currentViewModel);
    const actual = viewModel.errors.name;
    const expected = 'Name is required';

    expect(actual).toEqual(expected);
  });
});