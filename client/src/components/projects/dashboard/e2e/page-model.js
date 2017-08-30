import { Selector } from 'testcafe';

export default class Page {
    constructor() {
      this.showFormButton = Selector('button').withText('Add Cycle Snap');
    }
}