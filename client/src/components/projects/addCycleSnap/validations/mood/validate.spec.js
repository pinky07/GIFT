import validations from './validations';

describe('Mood average validations should validate', () => {
  it('Valid Scenario' , () => {
    let actual = validations.validate(3);
    let expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Two Decimals for Mood average are allowed' , () => {
    let actual = validations.validate(1.56);
    let expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Mood average is required if Mood data is available', () => {
    let actual = validations.validate(undefined);
    let expected = 'Mood average is required';

     expect(actual).toEqual(expected);
  });

  it('Mood average min is 1', () => {
    let actual = validations.validate(0.99);
    let expected = 'Mood average min is 1';

     expect(actual).toEqual(expected);
  });

    it('Mood average max is 3', () => {
    let actual = validations.validate(3.01);
    let expected = 'Mood average max is 3';

     expect(actual).toBe(expected);
  });
});