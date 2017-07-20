import React from 'react';
import Header  from 'grommet/components/Header';
import Title  from 'grommet/components/Title';
import Box  from 'grommet/components/Box';
import Menu  from 'grommet/components/Menu';
import Anchor  from 'grommet/components/Anchor';

const AppHeader = () =>
  (
    <Header>
      <Title>
        GIFT
      </Title>
      <Box flex={true}
           direction='row'
           responsive={false}>

        <Menu direction='row'>
          <Anchor path={"/"}>
            Home
          </Anchor>
          <Anchor href='#'>
            Configuration
          </Anchor>
          <Anchor  path={"/projects"}>
            Projects
          </Anchor>
        </Menu>
      </Box>
    </Header>
  );


export default AppHeader;