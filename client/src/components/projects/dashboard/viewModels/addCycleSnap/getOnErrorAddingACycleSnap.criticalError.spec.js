import viewModels from '../viewModels';

describe('View model when there is a critical error adding a cycle snap', () => {

  let viewModel
  beforeEach(() => {
    let criticalError = { message: 'Network Error' };
    viewModel = viewModels.getOnErrorAddingACycleSnap(criticalError);
  })

  it('should show no error message', () => {
    const actual = viewModel.errorMessage;
    const expected = '';

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

  it('should show a failure notification', () => {
    const actual = viewModel.failureNotificationOnAdd;
    const expected = 'Oops! We got a bit of an issue: Network Error.';

    expect(actual).toEqual(expected);
  });
});