import Page from './page-model';
import constants from '../../../constants'

fixture`Using the comparison dashboard`
  .page`${constants.Website}/portfolios/4/comparison`;

const page = new Page();

test('The comparison is available. It also means the API is available.', async t => {
  await t
    .expect(page.comparison.exists).ok();
});