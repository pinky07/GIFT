import presenters from './presenters';

describe('presenters.getInitial', () => {

  let viewModel
  beforeEach(() => {
    let props = {
      params:
        {id: 1}
    };
    viewModel = presenters.getInitial(props);
  })

  it('should contain the portfolio id', () => {
    const actual = viewModel.portfolioId;
    const expected = 1;

    expect(actual).toEqual(expected);
  });

  it('should contain an empty compare', () => {
    const actual = viewModel.comparison;
    const expected = {
      portfolioName: undefined,
      lastSnaps: []
    };

    expect(actual).toEqual(expected);
  });

});