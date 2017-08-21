import validations from './validations';

describe('Targeted points validations should validate', () => {
  it('Valid scenario', () => {
    let actual = validations.validate(8);
    let expected = undefined;

     expect(actual).toEqual(expected);
  });

  it('Zero points are allowed', () => {
    let actual = validations.validate(0);
    let expected = undefined;

     expect(actual).toEqual(expected);
  });

    it('Targeted points are required', () => {
    let actual = validations.validate(undefined);
    let expected = 'Targeted points are required';

     expect(actual).toBe(expected);
  });

  it('Targeted points min is 0', () => {
    let actual = validations.validate(-1);
    let expected = 'Targeted points min is 0';

     expect(actual).toEqual(expected);
  });

  it('Targeted points max is 10,000', () => {
    let actual = validations.validate(10001);
    let expected = 'Targeted points max is 10,000';

     expect(actual).toEqual(expected);
  });
});