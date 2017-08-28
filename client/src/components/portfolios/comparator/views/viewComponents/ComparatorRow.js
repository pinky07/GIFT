import React from 'react';
import TableRow from 'grommet/components/TableRow';

const ComparatorRow = ({lastSnap, index}) =>
  <TableRow key={lastSnap.projectName}>
    <td key='projectName'>{lastSnap.projectName}</td>
    <td key='tac'>{lastSnap.tac}</td>
    <td key='daysWithoutRelease'>{lastSnap.daysWithoutRelease}</td>
    <td key='incidents'>{lastSnap.relatedIncidents}</td>
    <td key='waste'>{lastSnap.waste}</td>
    <td key='mood'>{lastSnap.mood}</td>
  </TableRow>

export default ComparatorRow;