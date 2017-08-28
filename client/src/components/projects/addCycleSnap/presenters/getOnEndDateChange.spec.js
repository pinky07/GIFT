import presenters from './presenters';

describe('presenters.getOnEndDateChange', () => {

  let viewModel
  beforeEach(() => {
    const currentViewModel = {
      errors: {endDate: undefined},
      endDate: undefined
    };
    viewModel = presenters.getOnEndDateChange(' ', currentViewModel);

  })

  it('Should set the new value', () => {
    const actual = viewModel.endDate;
    const expected = ' ';

    expect(actual).toEqual(expected);
  });

  it('Should set error when new value is invalid', () => {
    const actual = viewModel.errors.endDate;
    const expected = 'End date should be a valid one';

    expect(actual).toEqual(expected);
  });
});