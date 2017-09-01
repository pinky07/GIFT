import React from 'react';
import Table from 'grommet/components/Table';
import TableHeader from 'grommet/components/TableHeader';

import CompareRow from './CompareRow';

const CompareTable = ({viewModel}) => {
  const { lastSnaps } = viewModel.comparison;

  const formattedComparison = lastSnaps.map (
    (lastSnap, index) => <CompareRow key={index} lastSnap={lastSnap} index={index}/>
  );

  const labels = ['Project', 'TAC', 'Days Without Release', 'Incidents', 'Waste', 'Mood'];

  return (<Table responsive={false}>
      <TableHeader labels={labels}/>
      <tbody>
      {formattedComparison}
      </tbody>
    </Table>
  );
}

export default CompareTable;