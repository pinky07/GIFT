import React, { Component } from 'react';
import App  from 'grommet/components/App';
import Box  from 'grommet/components/Box';
import Section  from 'grommet/components/Section';

import AppHeader from './appHeader/AppHeader';
import AppFooter from './appFooter/AppFooter';

export default class Main extends Component {
  constructor() {
    super();
  }

  render() {
    return (
      <App centered={false}>
        <Box align="stretch" flex="grow" >
        <AppHeader/>
          <Box pad={{horizontal: 'medium', vertical: 'medium'}}>
          {this.props.children}
        </Box>
        </Box>
      </App>
    );
  }
}
