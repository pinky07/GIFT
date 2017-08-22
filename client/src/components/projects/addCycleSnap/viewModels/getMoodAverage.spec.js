import viewModels from './viewModels';

describe('Mood Average view model', () => {

  it('should set 0 to Mood Average if the Mood is not available', () => {
    const viewModel = viewModels.getMoodAverage(false, '2.56');
    const actual = viewModel.mood;
    const expected = '0';

    expect(actual).toEqual(expected);
  });

  it('should return the isMoodAvailable as it was sent', () => {
    const viewModel = viewModels.getMoodAverage(true, '2.56');
    const actual = viewModel.isMoodAvailable;
    const expected = true;

    expect(actual).toEqual(expected);
  });

  it('should return the Mood Average if the Mood is available', () => {
    const viewModel = viewModels.getMoodAverage(true, '2.56');
    const actual = viewModel.mood;
    const expected = '2.56';

    expect(actual).toEqual(expected);
  });
});