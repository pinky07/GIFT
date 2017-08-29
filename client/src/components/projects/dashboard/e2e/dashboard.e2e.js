import Page from './page-model';
import constants from '../../../constants'

fixture`Using the project dashboard`
  .page`${constants.Website}/projects/1/dashboard`;

const page = new Page();

test('The project dashboard is available. It also means the API is available.', async t => {
  await t
    .click(page.showFormButton);
});
