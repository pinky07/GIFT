import presenters from '../presenters';

describe('View model when loading the dashboard and data was found', () => {

  let viewModel
  beforeEach(() => {
    let response = { data: {name:'name', cycleSnaps: []} };
    viewModel = presenters.getOnSuccessLoadingDashboard(response);
  })

  it('should return the data', () => {
    const actual = viewModel.project;
    const expected = {name:'name', cycleSnaps: []};

    expect(actual).toEqual(expected);
  });

  it('should show no error message', () => {
    const actual = viewModel.errorMessage;
    const expected = '';

    expect(actual).toEqual(expected);
  });
});