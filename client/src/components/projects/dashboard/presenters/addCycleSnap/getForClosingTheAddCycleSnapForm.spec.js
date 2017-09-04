import presenters from '../presenters';

describe('View model when closing the Add Cycle Snap Form', () => {

  let viewModel
  beforeEach(() => {
    viewModel = presenters.getForClosingForms();
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

  it('should show no success notification on add', () => {
    const actual = viewModel.successNotificationOnAdd;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('should show no failure notification on add', () => {
    const actual = viewModel.failureNotificationOnAdd;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });
});