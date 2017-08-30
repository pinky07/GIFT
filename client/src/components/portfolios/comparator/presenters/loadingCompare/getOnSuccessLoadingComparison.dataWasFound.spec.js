import presenters from '../presenters';

describe('View model when loading the Compare and data was found', () => {

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

  it('should return the data for the compare', () => {
    const actual = viewModel;
    const expected = {
      comparison: {
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
      },
      errorMessage: ''
    };

    expect(actual).toEqual(expected);
  }) ;
});