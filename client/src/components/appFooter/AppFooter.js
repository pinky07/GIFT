import React from 'react';
import Footer  from 'grommet/components/Footer';
import Box  from 'grommet/components/Box';
import Paragraph  from 'grommet/components/Paragraph';

const AppFooter = () =>
  (
    <Footer justify='between' float={true} fixed={true} pad="small">
      <Box direction='row'
           align='end'
           pad={{"between": "medium"}}>
        <Paragraph align='end'>
          © 2017 GFT Labs
        </Paragraph>
      </Box>
    </Footer>
  );

export default AppFooter;