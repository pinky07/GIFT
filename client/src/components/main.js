import React, { Component } from 'react';
import  App  from 'grommet/components/App';
import  Header  from 'grommet/components/Header';
import  Footer  from 'grommet/components/Footer';
import  Title  from 'grommet/components/Title';

export default class Main extends Component {
  constructor() {
    super();
  }

  render() {
    return (
      <App centered={false}>
        <Header direction="row" justify="between" pad={{horizonal: 'medium'}}>
          <Title>GIFT</Title>
        </Header>
        <Footer primary={true} appCentered={true} direction="column" align="center" pad="small" colorIndex="grey-1">
          <p>GIF App</p>
        </Footer>
      </App>
    );
  }
}
