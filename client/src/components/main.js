import React, { Component } from 'react';
import App  from 'grommet/components/App';
import Header  from 'grommet/components/Header';
import Footer  from 'grommet/components/Footer';
import Title  from 'grommet/components/Title';
import Box  from 'grommet/components/Box';
import Search  from 'grommet/components/Search';
import Menu  from 'grommet/components/Menu';
import Anchor  from 'grommet/components/Anchor';
import Actions  from 'grommet/components/icons/base/Actions';
import Paragraph  from 'grommet/components/Paragraph';

import ProjectList from './projectList/ProjectList';

export default class Main extends Component {
  constructor() {
    super();
  }

  render() {
    return (
      <App centered={false}>
        <Header>
          <Title>
            GIFT
          </Title>
          <Box flex={true}
               justify='end'
               direction='row'
               responsive={false}>
            <Search inline={true}
                    fill={true}
                    size='medium'
                    placeHolder='Search'
                    dropAlign={{"right": "right"}} />
            <Menu icon={<Actions />}
                  dropAlign={{"right": "right"}}>
              <Anchor href='#'
                      className='active'>
                Login
              </Anchor>
              <Anchor href='#'>
                Configuration
              </Anchor>
              <Anchor href='#'>
                Projects
              </Anchor>
            </Menu>
          </Box>
        </Header>
        <Box align="stretch" appCentered={true} colorIndex="light-2" pad="small" flex="grow" full="vertical">
          <ProjectList />
        </Box>
        <Footer justify='between' float={true} fixed={true} pad="small">
          <Title>
            GIFT App
          </Title>
          <Box direction='row'
               align='center'
               pad={{"between": "medium"}}>
            <Paragraph margin='none'>
              © 2017 GFT Labs
            </Paragraph>
            <Menu direction='row'
                  size='small'
                  dropAlign={{"right": "right"}}>
              <Anchor href='#'>
                Support
              </Anchor>
              <Anchor href='#'>
                Contact
              </Anchor>
              <Anchor href='#'>
                About
              </Anchor>
            </Menu>
          </Box>
        </Footer>
      </App>
    );
  }
}
