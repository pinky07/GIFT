import React from 'react';
import Table from 'grommet/components/Table';
import TableHeader from 'grommet/components/TableHeader';

import CycleSnapsRow from './CycleSnapsRow';

const CycleSnapsTable = ({viewModel}) => {
    const {cycleSnaps} = viewModel.project;
  
    const formattedCycleSnaps = cycleSnaps.map(
      (cycle, index) => <CycleSnapsRow key={index} cycle={cycle} index={index}/>
    );

    const labels = ['Name', 'Start Date', 'End Date', 'Achieved / Targeted Points', 'TAC', 'Current Release', 'Release Date', 'Related Incidents', 'Days Without Release', 'Team Capacity', 'Waste Days', 'Waste Percentage', 'Mood Average'];

    return (<Table responsive={false}>
              <TableHeader labels={labels} sortIndex={2} sortAscending={true} />
              <tbody>
                {formattedCycleSnaps}
              </tbody>
            </Table>
        );
    }
    
export default CycleSnapsTable;