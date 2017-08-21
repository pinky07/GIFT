import validations from './validations';

describe('Name validations should validate', () => {
  it('Valid scenario', () => {
    let actual = validations.validate('1');
    let expected = undefined;

     expect(actual).toEqual(expected);
  });

  it('Name is required', () => {
    let actual = validations.validate('');
    let expected = 'Name is required';

     expect(actual).toEqual(expected);
  });

    it('Name can be any text', () => {
    let actual = validations.validate('Drop 1');
    let expected = undefined;

     expect(actual).toBe(expected);
  });

  it('Name has a max of 200 characters', () => {
    let actual = validations.validate('123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901');
    let expected = 'Name has a max of 200 characters';

     expect(actual).toEqual(expected);
  });
});