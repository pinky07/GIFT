import validations from './validations';

describe('Team capacity validations should validate', () => {
  it('Valid Scenario' , () => {
    let actual = validations.validate(true, 100.00);
    let expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Two Decimals for Team capacity are allowed' , () => {
    let actual = validations.validate(true, 95.89);
    let expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Team capacity is not required if Waste data is not available', () => {
    let actual = validations.validate(false, undefined);
    let expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Team capacity is required if Waste data is available', () => {
    let actual = validations.validate(true, undefined);
    let expected = 'Team capacity is required';

     expect(actual).toEqual(expected);
  });

  it('Team capacity min is 1', () => {
    let actual = validations.validate(true, 0.99);
    let expected = 'Team capacity min is 1';

     expect(actual).toEqual(expected);
  });

  it('Team capacity of 1 valid', () => {
    let actual = validations.validate(true, 1);
    let expected = undefined;

     expect(actual).toEqual(expected);
  });

  it('Team capacity max is 10,000', () => {
    let actual = validations.validate(true, 10000.01);
    let expected = 'Team capacity max is 10,000';

     expect(actual).toBe(expected);
  });

  it('Team capacity of 10,000 is valid', () => {
    let actual = validations.validate(true, 10000);
    let expected = undefined;

     expect(actual).toBe(expected);
  });
});