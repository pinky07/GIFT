import React from 'react';
import Table from 'grommet/components/Table';
import TableHeader from 'grommet/components/TableHeader';

import CycleSnapsRow from './CycleSnapsRow';

const CycleSnapsTable = ({cycleSnaps}) => {
    const formattedCycleSnaps = cycleSnaps.map(
      (cycle, index) => <CycleSnapsRow cycle={cycle} index={index}/>
    );

    const labels = ['Name', 'Start Date', 'End Date', 'Achieved / Targeted Points', 'TAC', 'Current Release', 'Release Date', 'Related Incidents', 'Days Since Last Release', 'Team Capacity', 'Waste Days', 'Waste Percentage'];

    return (<Table>
              <TableHeader labels={labels} sortIndex={2} sortAscending={false} />
              <tbody>
                {formattedCycleSnaps}
              </tbody>
            </Table>
        );
    }
    
export default CycleSnapsTable;