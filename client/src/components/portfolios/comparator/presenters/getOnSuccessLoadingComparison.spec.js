import presenters from './presenters';

describe('presenters.getOnSuccessLoadingComparison', () => {

  let viewModel
  beforeEach(() => {
    let response = {
      data: {
        portfolioName: 'Amazing projects',
        lastSnaps: [
          {
            projectName: 'Exceptional project',
            tac: '100%',
            daysWithoutRelease: 13,
            relatedIncidents: 6,
            waste: 'No data',
            mood: 'No data'
          }
        ]
      }
    };
    viewModel = presenters.getOnSuccessLoadingComparison(response);
  })

  it('should contain the portfolio name', () => {
    const actual = viewModel;
    const expected = {
      comparator: {
        portfolioName: 'Amazing projects',
        lastSnaps: [
          {
            projectName: 'Exceptional project',
            tac: '100%',
            daysWithoutRelease: 13,
            relatedIncidents: 6,
            waste: 'No data',
            mood: 'No data'
          }
        ]
      }
    };

    expect(actual).toEqual(expected);
  });
});