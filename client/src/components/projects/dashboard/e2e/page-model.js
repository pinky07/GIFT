import { Selector } from 'testcafe';
import ReactSelector from 'testcafe-react-selectors';

export default class Page {
    constructor() {
      this.showFormButton = Selector('button').withText('Add Cycle Snap');
    }
}