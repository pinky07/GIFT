import presenters from '../presenters';

describe('View model when there is a validation error adding a cycle snap', () => {

  let viewModelForValidationError
  beforeEach(() => {
    let validationError = { response: { data: { message: 'Points are required' } } };
    viewModelForValidationError = presenters.getOnErrorAddingACycleSnap(validationError);
  })

  it('If there was a validation error, it should show a failure notification', () => {
    const actual = viewModelForValidationError.failureNotificationOnAdd;
    const expected = 'Sorry, there was a validation error: Points are required.';

    expect(actual).toEqual(expected);
  });

  it('If there was a validation error, it should hide the add cycle layer', () => {
    const actual = viewModelForValidationError.addCycleSnap;
    const expected = false;

    expect(actual).toEqual(expected);
  });

  it('should show the correct success message', () => {
    const actual = viewModelForValidationError.successNotificationOnAdd;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('If there was a validation error, it should show a failure notification', () => {
    const actual = viewModelForValidationError.failureNotificationOnAdd;
    const expected = 'Sorry, there was a validation error: Points are required.';

    expect(actual).toEqual(expected);
  });

});