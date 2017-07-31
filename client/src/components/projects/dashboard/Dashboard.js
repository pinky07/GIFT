import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import PropTypes from 'prop-types';

import axios from 'axios';

import constants from '../../../services/constants';

import Anchor from 'grommet/components/Anchor';
import Box from 'grommet/components/Box';
import Table from 'grommet/components/Table';
import TableHeader from 'grommet/components/TableHeader';
import TableRow from 'grommet/components/TableRow';
import Status from 'grommet/components/icons/Status';

export default class Dashboard extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      projectId: props.params.id,
      name: '',
      cycleSnaps: [],
      errorMessage: ''
    };
  }

  componentDidMount() {
    this.LoadDashboard(this.state.projectId);
  }

  LoadDashboard(projectId) {
    if (isNaN(projectId)) {
      this.setState({ errorMessage: "Invalid project id" });
    }
    else {

      debugger;
      axios.get(`${constants.API}/projects/${projectId}/dashboard`).then((response) => {
        if (response.data) {
          this.setState({ name: response.data.name, cycleSnaps: response.data.cycleSnaps });
        }
      }).catch((error) => {
        this.setState({ errorMessage: error.response.data.message });
      });

    }
  }

  render() {
    const errorMessage = this.state.errorMessage;
    const projectName = this.state.name;

    const cycleSnaps = this.state.cycleSnaps.map((cycle, i) => <TableRow key={i}>
      <td>{cycle.cycleSnapName}</td>
      <td>{cycle.startDate}</td>
      <td>{cycle.endDate}</td>
      <td>{cycle.achievedPoints} / {cycle.targetedPoints}</td>
      <td>{cycle.tac}</td>
    </TableRow>
    );

    if (errorMessage) {
      return <div id="layout-content" className="layout-content-wrapper">
        <h1>Dashboard</h1>
        <h3><Status value='critical' /> <span>{errorMessage}</span></h3>
      </div>
    }
    else {

      if (cycleSnaps.length > 0) {
        return <div id="layout-content" className="layout-content-wrapper">
          <h1>Dashboard: {projectName}</h1>

          <p><Anchor path={`/projects/${this.state.projectId}/cyclesnaps/add`}>
                  Add cycle snap
              </Anchor></p>
                        <Table>
            <TableHeader labels={['Name', 'Start Date', 'End Date', 'Achieved / Targeted points', 'TAC']} sortIndex={2} sortAscending={false} />
            <tbody>
              {cycleSnaps}
            </tbody>
          </Table>
        </div>
      }
      else {
        return <div id="layout-content" className="layout-content-wrapper">
          <h1>Dashboard: {projectName}</h1>
          <h3><Status value='unknown' /> <span>This project has no cycle snaps.</span></h3>
          
        </div>
      }
    }
  }
}