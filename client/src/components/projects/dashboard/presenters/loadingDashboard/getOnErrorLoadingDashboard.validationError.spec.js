import presenters from '../presenters';

describe('View model when loading the dashboard and there was a validation error', () => {

  let viewModel
  beforeEach(() => {
    let error = { response: { data: { message: 'A validation error' } } };
    viewModel = presenters.getOnErrorLoadingDashboard(error);
  })

  it('should return no data', () => {
    const actual = viewModel.project;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('should show the validation error message', () => {
    const actual = viewModel.errorMessage;
    const expected = 'Please check: A validation error.';

    expect(actual).toEqual(expected);
  });

  it('should hide the add cycle layer', () => {
    const actual = viewModel.addCycleSnap;
    const expected = false;

    expect(actual).toEqual(expected);
  });

  it('should show no success notification', () => {
    const actual = viewModel.successNotificationOnAdd;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('should show no failure notification', () => {
    const actual = viewModel.failureNotificationOnAdd;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });
});