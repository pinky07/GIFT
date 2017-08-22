import React from 'react';

import Heading from 'grommet/components/Heading';
import Form from 'grommet/components/Form';
import FormFields from 'grommet/components/FormFields';
import FormField from 'grommet/components/FormField';
import TextInput from 'grommet/components/TextInput';
import Box from 'grommet/components/Box';
import Footer from 'grommet/components/Footer';
import Button from 'grommet/components/Button';
import NumberInput from 'grommet/components/NumberInput';
import DateTime from 'grommet/components/DateTime';
import Layer from 'grommet/components/Layer';
import CheckBox from 'grommet/components/CheckBox';

const AddCycleSnapView = ({ viewModel }) => {
  const { errors } = viewModel;
  const { formCallbacks } = viewModel;
  const { projectName } = viewModel;
  const { cycleSnapName } = viewModel;
  const { startDate } = viewModel;
  const { endDate } = viewModel;
  const { targetedPoints } = viewModel;
  const { achievedPoints } = viewModel;
  const { isMoodAvailable} = viewModel;
  const { mood } = viewModel;

  return <Layer align='center' closer={true} onClose={formCallbacks.onClose}>
    <Box pad={{ vertical: 'large', horizontal: 'small' }}>

      <Heading>Add cycle snap</Heading>
      <h2>Project: {projectName}</h2>

      <Form compact={false}>
        <FormFields>
          <fieldset>
            <FormField label='Cycle name or id' htmlFor="cycleNameInput" error={errors.name}>
              <TextInput id='cycleNameInput' onDOMChange={formCallbacks.onNameChange} value={cycleSnapName} />
            </FormField>

            <FormField label='Start Date' htmlFor="cycleStartDate" error={errors.startDate}>
              <DateTime id='cycleStartDate' format='YYYY-MM-DD' value={startDate} onChange={formCallbacks.onStartDateChange} />
            </FormField>

            <FormField label='End Date' htmlFor="cycleEndDate" error={errors.endDate}>
              <DateTime id='cycleEndDate' format='YYYY-MM-DD' value={endDate} onChange={formCallbacks.onEndDateChange} />
            </FormField>

            <FormField label='Targeted points' htmlFor='targetedPointsId' error={errors.targetedPoints}>
              <NumberInput id='targetedPointsId' step={1} value={targetedPoints} min={0} onChange={formCallbacks.onTargetedPointsChange} />
            </FormField>

            <FormField label='Achieved points' htmlFor='achievedPointsId' error={errors.achievedPoints}>
              <NumberInput id='achievedPoints' step={1} value={achievedPoints} min={0} onChange={formCallbacks.onAchievedPointsChange} />
            </FormField>

            <FormField>
              <CheckBox label='Is Mood Available?'
                        reverse={true}
                        toggle={true}
                        disabled={false}
                        value={isMoodAvailable}
                        onChange={formCallbacks.onIsMoodAvailableChange}/>
            </FormField>

            <FormField label='Mood' htmlFor='moodId' error={errors.mood}>
              <NumberInput id='mood' step={0.01} min={1} max={3} value={mood} onChange={formCallbacks.onMoodChange} />
            </FormField>

          </fieldset>
        </FormFields>

        <Footer pad={{ "vertical": "medium" }}>
          <Box>
            <Button label='Add' type='submit' primary={true} onClick={formCallbacks.onClick} />
          </Box>
          <Box pad={{ horizontal: 'small' }}>
            <Button label='Cancel' secondary={true} onClick={formCallbacks.onClose} />
          </Box>
        </Footer>
      </Form>
    </Box>
  </Layer>
}

export default AddCycleSnapView;