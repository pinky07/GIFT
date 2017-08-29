import presenters from '../presenters';

describe('View model when loading the Compare and there was a critical error', () => {

  let viewModel;
  beforeEach(() => {
    let error = { message: 'A critical error' };
    viewModel = presenters.getOnErrorLoadingCompare(error);
  });

  it('should return no data', () => {
    const actual = viewModel.comparison;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('should show the validation error message', () => {
    const actual = viewModel.errorMessage;
    const expected = 'Oops! We got a bit of an issue: A critical error.';

    expect(actual).toEqual(expected);
  });
});