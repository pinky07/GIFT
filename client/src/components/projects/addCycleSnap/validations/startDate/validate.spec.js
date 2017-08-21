import validations from './validations';

describe('Start date validations should validate', () => {
  it('Valid start date', () => {
    let actual = validations.validate('2016-11-15');
    let expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Start date is required', () => {
    let actual = validations.validate('');
    let expected = 'Start date is required';

    expect(actual).toEqual(expected);
  });

  it('Start date should be a valid one', () => {
    let actual = validations.validate('2016-1x-15');
    let expected = 'Start date should be a valid one';

    expect(actual).toEqual(expected);
  });
});