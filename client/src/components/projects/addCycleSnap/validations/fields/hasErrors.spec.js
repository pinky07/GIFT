import validation from './validation';

describe('How to know if there is any error in the fields', () => {

  let errors
  beforeEach(() => {
    errors = {
      "achievedPoints": undefined,
      "endDate": undefined,
      "name": undefined,
      "startDate": undefined,
      "targetedPoints": undefined
    };
  })

  it('No errors', () => {
    let actual = validation.hasErrors(errors);
    let expected = false;

    expect(actual).toEqual(expected);
  });

  it('Error in the name', () => {
    errors.name = "Error";
    let actual = validation.hasErrors(errors);
    let expected = true;

    expect(actual).toEqual(expected);
  });

  it('Error in the start date', () => {
    errors.startDate = "Error";
    let actual = validation.hasErrors(errors);
    let expected = true;

    expect(actual).toEqual(expected);
  });

  it('Error in the end date', () => {
    errors.endDate = "Error";
    let actual = validation.hasErrors(errors);
    let expected = true;

    expect(actual).toEqual(expected);
  });

  it('Error in the targeted points', () => {
    errors.targetedPoints = "Error";
    let actual = validation.hasErrors(errors);
    let expected = true;

    expect(actual).toEqual(expected);
  });

  it('Error in the achieved points', () => {
    errors.achievedPoints = "Error";
    let actual = validation.hasErrors(errors);
    let expected = true;

    expect(actual).toEqual(expected);
  });
});