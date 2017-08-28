import React from 'react';
import Table from 'grommet/components/Table';
import TableHeader from 'grommet/components/TableHeader';

import ComparatorRow from './ComparatorRow';

const ComparatorTable = ({viewModel}) => {
  const { lastSnaps } = viewModel.comparator;

  const formattedComparator = lastSnaps.map (
    (lastSnap, index) => <ComparatorRow key={index} lastSnap={lastSnap} index={index}/>
  );

  const labels = ['Project', 'TAC', 'Days without release', 'Incidents', 'Waste', 'Mood'];

  return (<Table>
      <TableHeader labels={labels}/>
      <tbody>
      {formattedComparator}
      </tbody>
    </Table>
  );
}

export default ComparatorTable;