import Page from './page-model';
import constants from '../../../constants'

fixture`Using the Add cycle snap form through the project dashboard`
  .page`${constants.Website}/projects/1/dashboard`;


test('The Add Cycle Snap form is shown', async t => {
  const page = new Page();

  await t
    .click(page.showFormButton);

  // If the button is present, that means the form was shown correctly
  await t
    .click(page.submitButton);
});

test('Every field accepts valid values. Mood and waste are not available.', async t => {
  const page = new Page();

  await t
    .click(page.showFormButton);
  await t
    .typeText(page.nameInput, ' Sprint 1 ')
    .expect(page.nameInput.value).eql(' Sprint 1 ');
  await t
    .typeText(page.startDateInput, '2017-08-12')
    .expect(page.startDateInput.value).eql('2017-08-12');
  await t
    .typeText(page.endDateInput, '2017-08-13')
    .expect(page.endDateInput.value).eql('2017-08-13');
  await t
    .typeText(page.targetedPointsInput, '10', {replace: true})
    .expect(page.targetedPointsInput.value).eql('10');
  await t
    .typeText(page.achievedPointsInput, '11')
    .expect(page.achievedPointsInput.value).eql('011');
  await t
    .click(page.moodIsAvailableCheckbox)
    .click(page.wasteIsAvailableCheckbox)
    .click(page.submitButton)

  // After submission, the form should disappear,
  // and if the API is available, the Add Cycle Snap button is shown.
  // if not, a critical error page will be shown, and this test will fail`

  await t
    .click(page.showFormButton);
});

test('Each button works as intended (cancel, close, submit)', async t => {
  const page = new Page();

  await t
    .click(page.showFormButton)
    .click(page.cancelButton)
  await t
    .click(page.showFormButton)
    .click(page.closeButton);
  await t
    .click(page.showFormButton)
    .click(page.submitButton);

  // Form should not disappear and we should be able to click Cancel
  await t
    .click(page.cancelButton)
});

test('Every field accepts valid values. Mood and waste info are available', async t => {
  const page = new Page();

  await t
    .click(page.showFormButton);
  await t
    .typeText(page.nameInput, ' Sprint 1 ')
    .expect(page.nameInput.value).eql(' Sprint 1 ');
  await t
    .typeText(page.startDateInput, '2017-08-12')
    .expect(page.startDateInput.value).eql('2017-08-12');
  await t
    .typeText(page.endDateInput, '2017-08-13')
    .expect(page.endDateInput.value).eql('2017-08-13');
  await t
    .typeText(page.targetedPointsInput, '10', {replace: true})
    .expect(page.targetedPointsInput.value).eql('10');
  await t
    .typeText(page.achievedPointsInput, '11', {replace: true})
    .expect(page.achievedPointsInput.value).eql('11');
  await t
    .typeText(page.moodInput, '2.34', {replace: true})
    .expect(page.moodInput.value).eql('2.34');
  await t
    .typeText(page.teamCapacityInput, '119.12', {replace: true})
    .expect(page.teamCapacityInput.value).eql('119.12');
  await t
    .typeText(page.wasteDaysInput, '5.32', {replace: true})
    .expect(page.wasteDaysInput.value).eql('5.32');
  await t
    .click(page.submitButton)

  // Form should disappear so that we can click the Add Cycle Snap button again
  await t
    .click(page.showFormButton);
});