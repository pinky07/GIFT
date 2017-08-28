import React from 'react';
import Anchor from 'grommet/components/Anchor';
import TableRow from 'grommet/components/TableRow';

const CompareRow = ({lastSnap, index}) =>
  <TableRow key={lastSnap.projectName}>
    <td><Anchor id={`compare-link-${index}`} path={`/projects/${lastSnap.projectId}/dashboard`}>
      {lastSnap.projectName}
    </Anchor></td>
    <td key='tac'>{lastSnap.tac}</td>
    <td key='daysWithoutRelease'>{lastSnap.daysWithoutRelease}</td>
    <td key='incidents'>{lastSnap.relatedIncidents}</td>
    <td key='waste'>{lastSnap.waste}</td>
    <td key='mood'>{lastSnap.mood}</td>
  </TableRow>

export default CompareRow;