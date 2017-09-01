import validations from './validations';

describe('Date validations should validate', () => {
  it('Valid date', () => {
    let actual = validations.isValid('2016-11-21');
    let expected = true;

     expect(actual).toEqual(expected);
  });

  it('Not a valid day', () => {
    let actual = validations.isValid('2016-12-32');
    let expected = false;

     expect(actual).toEqual(expected);
  });

  it('A number', () => {
    let actual = validations.isValid(2016-12-32);
    let expected = false;

     expect(actual).toEqual(expected);
  });

  it('Not a date', () => {
    let actual = validations.isValid('NotADate');
    let expected = false;

     expect(actual).toEqual(expected);
  });

  it('Not a date in the expected format (YYYY-MM-DD)', () => {
    let actual = validations.isValid('17-11-11');
    let expected = false;

     expect(actual).toEqual(expected);
  });
});