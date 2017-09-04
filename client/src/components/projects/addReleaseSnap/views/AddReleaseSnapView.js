import React from 'react';

import Heading from 'grommet/components/Heading';
import Form from 'grommet/components/Form';
import FormFields from 'grommet/components/FormFields';
import FormField from 'grommet/components/FormField';
import TextInput from 'grommet/components/TextInput';
import Box from 'grommet/components/Box';
import Footer from 'grommet/components/Footer';
import Button from 'grommet/components/Button';
import DateTime from 'grommet/components/DateTime';
import Layer from 'grommet/components/Layer';

const AddReleaseSnapView = ({viewModel}) => {
  const {errors} = viewModel;
  const {formCallbacks} = viewModel;
  const {projectName} = viewModel;
  const {releaseName} = viewModel;
  const {releaseDate} = viewModel;

  return (
    <Layer align='center' closer={true} onClose={formCallbacks.onClose}>

      <Box pad={{vertical: 'large', horizontal: 'small'}}>

        <Heading>Add a release snap</Heading>
        <h2>Project: {projectName}</h2>

        <Form compact={false}>
          <FormFields>
            <fieldset>

              <FormField label='Release name or id' htmlFor="releaseNameInput" error={errors.releaseName}>
                <TextInput id='releaseNameInput' onDOMChange={formCallbacks.onNameChange} value={releaseName}/>
              </FormField>

              <FormField label='Date' htmlFor="releaseDate" error={errors.releaseDate}>
                <DateTime id='releaseDate' format='YYYY-MM-DD' value={releaseDate}
                          onChange={formCallbacks.onDateChange}/>
              </FormField>

            </fieldset>
          </FormFields>

          <Footer pad={{"vertical": "medium"}}>
            <Box>
              <Button label='Add' type='submit' primary={true} onClick={formCallbacks.onClick}/>
            </Box>
            <Box pad={{horizontal: 'small'}}>
              <Button label='Cancel' secondary={true} onClick={formCallbacks.onClose}/>
            </Box>
          </Footer>
        </Form>
      </Box>
    </Layer>
  );
};

export default AddReleaseSnapView;