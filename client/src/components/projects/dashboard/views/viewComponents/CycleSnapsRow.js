import React from 'react';
import TableRow from 'grommet/components/TableRow';

const CycleSnapsRow = ({cycle, index}) =>
  <TableRow key={cycle.cycleSnapName}>
    <td key='name'>{cycle.cycleSnapName}</td>
    <td key='startDate'>{cycle.startDate}</td>
    <td key='endDate'>{cycle.endDate}</td>
    <td key='points'>{cycle.achievedPoints} / {cycle.targetedPoints}</td>
    <td key='tac'>{cycle.tac}</td>
    <td key='lastReleaseName'>{cycle.lastReleaseName}</td>
    <td key='lastReleaseDate'>{cycle.lastReleaseDate}</td>
    <td key='relatedIncidents'>{cycle.relatedIncidents}</td>
    <td key='daysSinceLastRelease'>{cycle.daysSinceLastRelease}</td>
    <td key='teamCapacity'>{cycle.teamCapacity}</td>
    <td key='wasteDays'>{cycle.wasteDays}</td>
    <td key='wastePercentage'>{cycle.wastePercentage}</td>
    <td key='mood'>{cycle.mood}</td>
  </TableRow>

export default CycleSnapsRow;