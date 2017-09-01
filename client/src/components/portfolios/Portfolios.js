import React from 'react';

import Card from 'grommet/components/Card';
import Box from 'grommet/components/Box';
import Hero from 'grommet/components/Hero';
import Anchor from 'grommet/components/Anchor';
import Table from 'grommet/components/Table';
import TableHeader from 'grommet/components/TableHeader';
import TableRow from 'grommet/components/TableRow';
import Heading from 'grommet/components/Heading';
import Section from 'grommet/components/Section';


const Portfolios = () =>
  (
    <Box>
        <Heading>Portfolios</Heading>

        <Table>
          <TableHeader labels={['Name', 'Actions']} sortIndex={0} />
          <tbody>
            <TableRow>
              <td>
                Portfolio #1 (Actual data from Phoenix)
            </td>
              <td>
                <Anchor id="view-projects-link-1" className="no-link-color" path={"/portfolios/1/comparison"}>Compare projects</Anchor>
              </td>
            </TableRow>
            <TableRow>
              <td>
                Portfolio #2 (Actual data from A-Team)
            </td>
              <td>
                <Anchor id="view-projects-link-2" className="no-link-color" path={"/portfolios/2/comparison"}>Compare projects</Anchor>
              </td>
            </TableRow>
            <TableRow>
              <td>
                Portfolio #3 (Actual data from Operating Metrics)
            </td>
              <td>
                <Anchor id="view-projects-link-3" className="no-link-color" path={"/portfolios/3/comparison"}>Compare projects</Anchor>
              </td>
            </TableRow>
            <TableRow>
              <td>
                Portfolio #4 (Test data for Project comparison and Dashboard)
            </td>
              <td>
                <Anchor id="view-projects-link-4" className="no-link-color" path={"/portfolios/4/comparison"}>Compare projects</Anchor>
              </td>
            </TableRow>

            <TableRow>
              <td>
                Portfolio #5 (Portfolio with no projects)
              </td>
              <td>
                <Anchor id="view-projects-link-5" className="no-link-color" path={"/portfolios/5/comparison"}>Compare projects</Anchor>
              </td>
            </TableRow>
          </tbody>
        </Table>
    </Box>
  );

export default Portfolios;