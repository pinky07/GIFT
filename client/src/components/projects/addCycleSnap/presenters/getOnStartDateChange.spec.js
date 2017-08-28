import presenters from './presenters';

describe('presenters.getOnStartDateChange', () => {

  let viewModel
  beforeEach(() => {
    const currentViewModel = {
      errors: {startDate: undefined},
      startDate: undefined
    };
    viewModel = presenters.getOnStartDateChange(' ', currentViewModel);

  })

  it('Should set the new value', () => {
    const actual = viewModel.startDate;
    const expected = ' ';

    expect(actual).toEqual(expected);
  });

  it('Should set error when new value is invalid', () => {
    const actual = viewModel.errors.startDate;
    const expected = 'Start date should be a valid one';

    expect(actual).toEqual(expected);
  });
});