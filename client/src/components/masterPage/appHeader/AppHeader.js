import React from 'react';
import Anchor from 'grommet/components/Anchor';
import Box from 'grommet/components/Box';
import Header from 'grommet/components/Header';
import Heading from 'grommet/components/Heading';
import Menu from 'grommet/components/Menu';
import Title from 'grommet/components/Title';
import DownIcon from 'grommet/components/icons/base/Down';
import ConfigureIcon from 'grommet/components/icons/base/Configure';

export default function AppHeader (props) {
  return (
    <Header colorIndex="neutral-1" >
      <Box direction="row"
        responsive={false} justify="start" align="center" 
        pad={{horizontal: 'medium'}} flex="grow">
        <Title>
        <Anchor path={"/"}>
          GiFT
        </Anchor>
      </Title>
        <Box pad="small" />
        <Menu label="Menu" icon={<DownIcon />} inline={true} direction="row">
          <Anchor href="#">Portfolios</Anchor>
        </Menu>
        <Box flex="grow" align="end">
          <ConfigureIcon />
        </Box>
      </Box>
    </Header>
  );
};