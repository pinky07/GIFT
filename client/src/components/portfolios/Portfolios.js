import React from 'react';

import Box from 'grommet/components/Box';
import Anchor from 'grommet/components/Anchor';
import Table from 'grommet/components/Table';
import TableHeader from 'grommet/components/TableHeader';
import TableRow from 'grommet/components/TableRow';


const Portfolios = () =>
  (
    <Box>
      <h1>Portfolios</h1>

      <Table>
        <TableHeader labels={['Name', 'Actions']} sortIndex={0} />
        <tbody>
          <TableRow>
            <td>
              Portfolio #11
            </td>
            <td>
              <Anchor id="view-projects-link-1" className="no-link-color" path={"/projects/1"}>View projects</Anchor>
            </td>
          </TableRow>
          <TableRow>
            <td>
              Portfolio #2
            </td>
            <td>
              <Anchor id="view-projects-link-2" className="no-link-color" path={"/projects/2"}>View projects</Anchor>
            </td>
          </TableRow>
          <TableRow>
            <td>
              Portfolio #3
            </td>
            <td>
              <Anchor id="view-projects-link-3" className="no-link-color" path={"/projects/3"}>View projects</Anchor>
            </td>
          </TableRow>
          <TableRow>
            <td>
              Portfolio #4
            </td>
            <td>
              <Anchor id="view-projects-link-4" className="no-link-color" path={"/projects/4"}>View projects</Anchor>
            </td>
          </TableRow>
        </tbody>
      </Table>
    </Box>
  );

export default Portfolios;