import presenters from '../presenters';

describe('View model when loading the compare and there was a validation error', () => {

  let viewModel
  beforeEach(() => {
    let error = { response: { data: { message: 'A validation error' } } };
    viewModel = presenters.getOnErrorLoadingCompare(error);
  })

  it('should return no data', () => {
    const actual = viewModel.comparison;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('should show the validation error message', () => {
    const actual = viewModel.errorMessage;
    const expected = 'Please check: A validation error.';

    expect(actual).toEqual(expected);
  });
});