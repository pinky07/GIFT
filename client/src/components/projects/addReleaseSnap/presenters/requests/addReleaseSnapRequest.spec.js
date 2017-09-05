import addReleaseSnapRequest from './addReleaseSnapRequest';

describe('Add Release Snap request', () => {

  let request
  beforeEach(() => {
    let viewModel = {
      projectId: 999,
      releaseName: 'Exceptional Release',
      releaseDate: '2016-06-08'
    };
    request = addReleaseSnapRequest.get(viewModel);
  })

  it('should contain the project id', () => {
    const actual = request.projectId;
    const expected = 999;

    expect(actual).toEqual(expected);
  });

  it('should contain the release snap name', () => {
    const actual = request.releaseName;
    const expected = 'Exceptional Release';

    expect(actual).toEqual(expected);
  });

  it('should contain the release date', () => {
    const actual = request.releaseDate;
    const expected = '2016-06-08';

    expect(actual).toEqual(expected);
  });
});