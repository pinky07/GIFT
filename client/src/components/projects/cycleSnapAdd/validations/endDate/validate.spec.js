import validations from './validations';

describe('End date validations should validate', () => {
  it('Valid end date', () => {
    let actual = validations.validate('2016-11-15', '2016-11-21');
    let expected = undefined;

     expect(actual).toEqual(expected);
  });

  it('End date is required', () => {
    let actual = validations.validate('2016-11-15', '');
    let expected = 'End date is required';

     expect(actual).toEqual(expected);
  });

  it('End date should happen after the start date', () => {
    let actual = validations.validate('2016-11-15', '2016-11-14');
    let expected = 'End date should happen after the start date';

     expect(actual).toEqual(expected);
  });

  it('End date should be a valid one', () => {
    let actual = validations.validate('2016-11-15', '2016-1x-21');
    let expected = 'End date should be a valid one';

     expect(actual).toEqual(expected);
  });
});