import presenters from '../presenters';

describe('View model when loading the dashboard and data was not found', () => {

  let viewModel
  beforeEach(() => {
    let response = { data: undefined };
    viewModel = presenters.getOnSuccessLoadingDashboard(response);
  })

  it('should return no project data', () => {
    const actual = viewModel.project;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('should show an error message', () => {
    const actual = viewModel.errorMessage;
    const expected = 'No information was found';

    expect(actual).toEqual(expected);
  });
});