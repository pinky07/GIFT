import React from 'react';
import TableRow from 'grommet/components/TableRow';

const CycleSnapsRow = ({cycle, index}) =>
  <TableRow key={index}>
    <td>{cycle.cycleSnapName}</td>
    <td>{cycle.startDate}</td>
    <td>{cycle.endDate}</td>
    <td>{cycle.achievedPoints} / {cycle.targetedPoints}</td>
    <td>{cycle.tac}</td>
    <td>{cycle.lastReleaseName}</td>
    <td>{cycle.lastReleaseDate}</td>
    <td>{cycle.relatedIncidents}</td>
    <td>{cycle.AccumulatedProductionIncidents}</td>
    <td>{cycle.waste}</td>
    <td>{cycle.daysSinceLastRelease}</td>
  </TableRow>

export default CycleSnapsRow;