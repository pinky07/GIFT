import presenters from './presenters';

describe('presenters.getOnMoodIsAvailableChange', () => {

    let viewModel
    beforeEach(() => {
        const event = { target: { checked: true } };
        const currentViewModel = {
            errors: { mood: 'Mood is invalid' },
            mood: '2.56',
            isMoodAvailable: true
        };
        viewModel = presenters.getOnMoodIsAvailableChange(event, currentViewModel);
    })

    it('It should set mood to 0', () => {
        const actual = viewModel.mood;
        const expected = '0';

        expect(actual).toEqual(expected);
    });

    it('It should return the same isMoodAvailable', () => {
        const actual = viewModel.isMoodAvailable;
        const expected = true;

        expect(actual).toEqual(expected);
    });

    it('It should clean the mood error message', () => {
        const actual = viewModel.errors.mood;
        const expected = undefined;

        expect(actual).toEqual(expected);
    });
});