import React, { Component } from 'react';
import App  from 'grommet/components/App';
import Box  from 'grommet/components/Box';

import AppHeader from './appHeader/AppHeader';
import AppFooter from './appFooter/AppFooter';

export default class Main extends Component {
  constructor() {
    super();
  }

  render() {
    return (
      <App centered={false}>
        <Box>
        <AppHeader/>
        <Box align="stretch" appCentered={true} colorIndex="light-2" pad="small" flex="grow" full="vertical">
          {this.props.children}
        </Box>
        <AppFooter/>
        </Box>
      </App>
    );
  }
}
