import validations from './validations';

describe('Waste days validations should validate', () => {
  it('Valid Scenario', () => {
    let actual = validations.validate(true, 100, 5);
    let expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Two Decimals for waste days are allowed', () => {
    let actual = validations.validate(true, 100.00, 2.59);
    let expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Waste days is not required if Waste data is not available', () => {
    let actual = validations.validate(false, 100, undefined);
    let expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('Waste days is required if waste data is available', () => {
    let actual = validations.validate(true, 100, undefined);
    let expected = 'Waste days is required';

    expect(actual).toEqual(expected);
  });

  it('Waste days min is 0', () => {
    let actual = validations.validate(true, 100, -0.01);
    let expected = 'Waste days min is 0';

    expect(actual).toEqual(expected);
  });

  it('Waste days of 0 is valid', () => {
    let actual = validations.validate(true, 100, 0);
    let expected = undefined;

    expect(actual).toEqual(expected);
  });

  it("Waste days max is the team's capacity", () => {
    let actual = validations.validate(true, 100, 100.01);
    let expected = "Waste days max is the team's capacity";

    expect(actual).toBe(expected);
  });

  it("Waste days equal to the team's capacity is valid", () => {
    let actual = validations.validate(true, 100, 100);
    let expected = undefined;

     expect(actual).toBe(expected);
  });
});