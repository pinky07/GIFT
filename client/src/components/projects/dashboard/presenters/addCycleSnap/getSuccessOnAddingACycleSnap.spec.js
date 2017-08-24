import presenters from '../presenters';

describe('View model after adding a cycle snap', () => {

  let viewModel
  beforeEach(() => {
    viewModel = presenters.getSuccessOnAddingACycleSnap();
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

  it('should show the correct success message', () => {
    const actual = viewModel.successNotificationOnAdd;
    const expected = 'Success! You just added a new cycle snap.';

    expect(actual).toEqual(expected);
  });

  it('should show no failure notification on add', () => {
    const actual = viewModel.failureNotificationOnAdd;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });
});