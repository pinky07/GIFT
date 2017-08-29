import presenters from '../presenters';

describe('View model when loading the Compare and data was not found', () => {

  let viewModel
  beforeEach(() => {
    let response = {
      data: undefined
    };
    viewModel = presenters.getOnSuccessLoadingComparison(response);
  })

  it('No Success Loading when response data is empty', () => {
    const actual = viewModel;
    const expected = {
      comparison: undefined,
      errorMessage: 'No information was found'
    };

    expect(actual).toEqual(expected);
  });
});