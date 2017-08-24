import presenters from '../presenters';

describe('View model when the given project id is invalid', () => {

  let viewModel
  beforeEach(() => {
    viewModel = presenters.getInvalidProjectError();
  })

  it('should show the correct error message', () => {
    const actual = viewModel.errorMessage;
    const expected = 'We are sorry, but your asked with an invalid project id.';

    expect(actual).toEqual(expected);
  });

  it('should show no add cycle layer', () => {
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