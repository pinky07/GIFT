import presenters from './presenters';

describe('presenters.getOnAchievedPointsChange', () => {

  let viewModel
  beforeEach(() => {
    const eventWithInvalidValue = {target: {valueAsNumber: -1}};

    const currentViewModel = {
      errors: {achievedPoints: undefined},
      achievedPoints: '0'
    };
    viewModel = presenters.getOnAchievedPointsChange(eventWithInvalidValue, currentViewModel);

  })

  it('Should set the new value', () => {
    const actual = viewModel.achievedPoints;
    const expected = -1;

    expect(actual).toEqual(expected);
  });

  it('Should set validation result', () => {
    const actual = viewModel.errors.achievedPoints;
    const expected = 'Achieved points min is 0';

    expect(actual).toEqual(expected);
  });
});