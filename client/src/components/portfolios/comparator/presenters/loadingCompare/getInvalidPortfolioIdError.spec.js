import presenters from '../presenters';

describe('View model when the given portfolio id is invalid', () => {

  let viewModel;
  beforeEach(() => {
    viewModel = presenters.getInvalidPortfolioIdError();
  });

  it('should show no compare object', () => {
    const actual = viewModel.comparison;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('should show the correct error message', () => {
    const actual = viewModel.errorMessage;
    const expected = 'We are sorry, but your asked with an invalid portfolio id.';

    expect(actual).toEqual(expected);
  });
});