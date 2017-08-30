import Page from './page-model';
import constants from '../../../constants'

fixture`Using the project dashboard`
  .page`${constants.Website}/projects/1/dashboard`;


test('The project dashboard is available. It also means the API is available.', async t => {
  const page = new Page();

  await t
    .expect(page.addCycleSnapButtonExists).ok();
});
