import presenters from '../presenters';

describe('View model when there is a critical error adding a cycle snap', () => {

  let viewModel
  beforeEach(() => {
    let criticalError = { message: 'Network Error' };
    viewModel = presenters.getOnErrorAddingACycleSnap(criticalError);
  })

  it('should show critical error message', () => {
    const actual = viewModel.errorMessage;
    const expected = 'Oops! We got a bit of an issue: Network Error.';

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