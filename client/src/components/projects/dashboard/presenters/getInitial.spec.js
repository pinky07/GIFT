import presenters from './presenters';

describe('presenters.getInitial', () => {

  let dashboardCallbacks
  let viewModel

  beforeEach(() => {
    let props = { params: { id: 999 } };
    dashboardCallbacks = {};
    viewModel = presenters.getInitial(props, dashboardCallbacks);
  })

  it('should contain the project id', () => {
    const actual = viewModel.projectId;
    const expected = 999;

    expect(actual).toEqual(expected);
  });

  it('should contain an empty project', () => {
    const actual = viewModel.project;
    const expected = { name: undefined, cycleSnaps: [] };

    expect(actual).toEqual(expected);
  });

  it('should contain given callbacks', () => {
    const actual = viewModel.dashboardCallbacks;
    const expected = dashboardCallbacks

    expect(actual).toEqual(expected);
  });

  it('should show no error message', () => {
    const actual = viewModel.errorMessage;
    const expected = '';

    expect(actual).toEqual(expected);
  });

  it('should show no add cycle layer', () => {
    const actual = viewModel.addCycleSnap;
    const expected = false;

    expect(actual).toEqual(expected);
  });

  it('should show no success notification on add', () => {
    const actual = viewModel.successNotificationOnAdd;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });

  it('should show no failure notification on add', () => {
    const actual = viewModel.failureNotificationOnAdd;
    const expected = undefined;

    expect(actual).toEqual(expected);
  });
});