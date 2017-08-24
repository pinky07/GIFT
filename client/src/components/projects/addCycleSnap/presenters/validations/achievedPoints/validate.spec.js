import validations from './validations';

describe('Achieved Points Validations should validate', () => {
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

  it('Achieved points are required', () => {
    let actual = validations.validate(undefined);
    let expected = 'Achieved points are required';

    expect(actual).toBe(expected);
  });

  it('Achieved points min is 0', () => {
    let actual = validations.validate(-1);
    let expected = 'Achieved points min is 0';

    expect(actual).toEqual(expected);
  });

  it('Achieved points max is 10,000', () => {
    let actual = validations.validate(10001);
    let expected = 'Achieved points max is 10,000';

    expect(actual).toEqual(expected);
  });
});