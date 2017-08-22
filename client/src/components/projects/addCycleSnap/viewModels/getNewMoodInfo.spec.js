import viewModels from './viewModels';

describe('getNewMoodInfo', () => {

  let errors
  beforeEach(() => {
    errors = { mood: 'Mood is invalid' };
  })
  
  it('If the Mood data is not available, it should set mood to 0', () => {
    const viewModel = viewModels.getNewMoodInfo(false, '2.56', errors);
    const actual = viewModel.mood;
    const expected = '0';

    expect(actual).toEqual(expected);
  });

  it('If the Mood data is not available, it should return the same isMoodAvailable', () => {
    const viewModel = viewModels.getNewMoodInfo(false, '2.56', errors);
    const actual = viewModel.isMoodAvailable;
    const expected = false;

    expect(actual).toEqual(expected);
  });

  it('If the Mood data is not available, it should clean the mood error message', () => {
    const viewModel = viewModels.getNewMoodInfo(false, '2.56', errors);
    const actual = viewModel.errors.mood;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('If the Mood data is available, it should return the isMoodAvailable as it was sent', () => {
    const viewModel = viewModels.getNewMoodInfo(true, '2.56', errors);
    const actual = viewModel.isMoodAvailable;
    const expected = true;

    expect(actual).toEqual(expected);
  });

  it('If the Mood data is available, it should return the same Mood', () => {
    const viewModel = viewModels.getNewMoodInfo(true, '2.56', errors);
    const actual = viewModel.mood;
    const expected = '2.56';

    expect(actual).toEqual(expected);
  });

  it('If the Mood data is available, it should return no error message for the mood', () => {
    const viewModel = viewModels.getNewMoodInfo(true, '2.56', errors);
    const actual = viewModel.errors.mood;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });
});