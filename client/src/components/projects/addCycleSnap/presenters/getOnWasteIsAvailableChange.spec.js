import presenters from './presenters';

describe('presenters.getOnWasteIsAvailableChange', () => {
    let viewModel

    beforeEach(() => {
        const event = { target: {checked: true}};
        const currentViewModel ={ errors: { teamCapacity: 'Waste is invalid', wasteDays: 'Waste days is invalid' }};
        viewModel = presenters.getOnWasteIsAvailableChange(event, currentViewModel);
    })

    it('it should set team capacity to 0', () => {
        const actual = viewModel.teamCapacity;
        const expected = '0';

        expect(actual).toEqual(expected);
    });

      it('it should set team capacity to 0', () => {
        const actual = viewModel.wasteDays;
        const expected = '0';

        expect(actual).toEqual(expected);
      });

      it('it should return the same isWasteAvailable', () => {
        const actual = viewModel.isWasteAvailable;
        const expected = true;

        expect(actual).toEqual(expected);
      });

      it('it should clean the team capacity error message', () => {
        const actual = viewModel.errors.teamCapacity;
        const expected = undefined;

        expect(actual).toEqual(expected);
      });

      it('it should clean the waste days error message', () => {
        const actual = viewModel.errors.wasteDays;
        const expected = undefined;

        expect(actual).toEqual(expected);
      });
});