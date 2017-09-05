import validation from './validation';

describe('Validation for all fields should validate', () => {

  let state
  beforeEach(() => {
    state = {
      releaseName: '1',
      releaseDate: '2016-11-15'
    };
  })

  it('Valid scenario', () => {
    let actual = validation.validate(state);
    let expected = {"releaseName": undefined, "releaseDate": undefined};

    expect(actual).toEqual(expected);
  });

  it('Name is not valid', () => {
    state.releaseName = '';
    let errors = validation.validate(state);
    let actual = errors.releaseName;

    expect(actual).toBeTruthy();
  });

  it('Release date is not valid', () => {
    state.releaseDate = '';
    let errors = validation.validate(state);
    let actual = errors.releaseDate;

    expect(actual).toBeTruthy();
  });
});