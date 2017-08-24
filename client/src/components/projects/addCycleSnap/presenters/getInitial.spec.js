import presenters from './presenters';

describe('presenters.getInitial', () => {

  let viewModel
  beforeEach(() => {
    let props = { projectId: 999, projectName: 'Exceptional' };
    let formCallbacks = {};
    viewModel = presenters.getInitial(props, formCallbacks);
  })

  it('should contain the project id', () => {
    const actual = viewModel.projectId;
    const expected = 999;

    expect(actual).toEqual(expected);
  });

  it('should contain the project name', () => {
    const actual = viewModel.projectName;
    const expected = 'Exceptional';

    expect(actual).toEqual(expected);
  });

  it('should contain an empty name', () => {
    const actual = viewModel.cycleSnapName;
    const expected = '';

    expect(actual).toEqual(expected);
  });

  it('should contain an empty start date', () => {
    const actual = viewModel.startDate;
    const expected = '';

    expect(actual).toEqual(expected);
  });

  it('should contain an empty end date', () => {
    const actual = viewModel.endDate;
    const expected = '';

    expect(actual).toEqual(expected);
  });
  
  it('should contain zero targeted points', () => {
    const actual = viewModel.targetedPoints;
    const expected = '0';

    expect(actual).toEqual(expected);
  });
    
  it('should contain zero achieved points', () => {
    const actual = viewModel.achievedPoints;
    const expected = '0';

    expect(actual).toEqual(expected);
  });

  it('should contain zero mood average', () => {
    const actual = viewModel.mood;
    const expected = '0';

    expect(actual).toEqual(expected);
  });

  it('should contain zero team capacity', () => {
    const actual = viewModel.teamCapacity;
    const expected = 0;

    expect(actual).toEqual(expected);
  });

  it('should contain zero waste days', () => {
    const actual = viewModel.wasteDays;
    const expected = '0';

    expect(actual).toEqual(expected);
  });

  it('should contain no errors', () => {
    const actual = viewModel.errors;
    const expected = {};

    expect(actual).toEqual(expected);
  });

  it('should contain given callbacks', () => {
    const actual = viewModel.formCallbacks;
    const expected = {};

    expect(actual).toEqual(expected);
  });
});