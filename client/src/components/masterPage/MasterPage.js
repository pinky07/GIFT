import React, {Component} from 'react';
import App from 'grommet/components/App';
import Box from 'grommet/components/Box';

import AppHeader from './appHeader/AppHeader';

export default class MasterPage extends Component {
  constructor() {
    super();
  }

  render() {
    return (
      <App centered={false}>
        <Box align="stretch" flex="grow">
          <AppHeader/>
          <Box pad={{horizontal: 'medium', vertical: 'medium'}}>
            {this.props.children}
          </Box>
        </Box>
      </App>
    );
  }
}
