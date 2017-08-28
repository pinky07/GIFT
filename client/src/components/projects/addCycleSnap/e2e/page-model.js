import { Selector } from 'testcafe';
import ReactSelector from 'testcafe-react-selectors';

export default class Page {
    constructor() {
        this.nameInput = Selector('#cycleNameInput');
        this.startDateInput = Selector('#cycleStartDate');
        this.endDateInput = Selector('#cycleEndDate');

        this.targetedPointsInput = Selector('#targetedPointsId');
        this.achievedPointsInput = Selector('#achievedPoints');

        this.moodIsAvailableCheckbox = ReactSelector('CheckBox').nth(0);
        this.moodInput = Selector('#moodId');

        this.wasteIsAvailableCheckbox = ReactSelector('CheckBox').nth(1);
        this.teamCapacityInput = Selector('#teamCapacityId');
        this.wasteDaysInput = Selector('#wasteDaysId');

        this.showFormButton = Selector('button').withText('Add Cycle Snap');
        this.submitButton = Selector('button').withText('Add');
        this.closeButton = Selector('button span svg').withAttribute('aria-label', 'Close  Layer');
        this.cancelButton = Selector('button').withText('Cancel');
    }
}