import presenters from './presenters';

describe('presenters.getOnTargetedPointsChange', () => {

  let viewModel
  beforeEach(() => {
    const eventWithInvalidValue = {target: {valueAsNumber: -1}};

    const currentViewModel = {
      errors: {targetedPoints: undefined},
      targetedPoints: '0'
    };
    viewModel = presenters.getOnTargetedPointsChange(eventWithInvalidValue, currentViewModel);

  })

  it('Should set the new value', () => {
    const actual = viewModel.targetedPoints;
    const expected = -1;

    expect(actual).toEqual(expected);
  });

  it('Should set validation result', () => {
    const actual = viewModel.errors.targetedPoints;
    const expected = 'Targeted points min is 0';

    expect(actual).toEqual(expected);
  });
});