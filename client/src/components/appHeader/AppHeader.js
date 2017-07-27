import React from 'react';
import Header  from 'grommet/components/Header';
import Title  from 'grommet/components/Title';
import Box  from 'grommet/components/Box';
import Menu  from 'grommet/components/Menu';
import Anchor  from 'grommet/components/Anchor';
import Link from 'react-router';

const AppHeader = () =>
  (
    <Header colorIndex='neutral-1' pad='small'>
      <Title>
        <Anchor path={"/"}>
          GIFT
        </Anchor>
      </Title>
      <Box pad="small" separator='left' />
      <Box flex={true}
           direction='row'
           responsive={false}>
        <Menu direction='row' colorIndex='neutral-1' >
          <Anchor  path={"/projects/1"}>
            Projects
          </Anchor>
          <Anchor href='#'>
            Configuration
          </Anchor>
        </Menu>
      </Box>
    </Header>
  );


export default AppHeader;