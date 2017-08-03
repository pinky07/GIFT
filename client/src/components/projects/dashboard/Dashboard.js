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
import Footer from 'grommet/components/Footer';
import Button from 'grommet/components/Button';
import Toast from 'grommet/components/Toast';
import Spinning from 'grommet/components/icons/Spinning';

import CycleSnapAdd from '../cycleSnapAdd/CycleSnapAdd';

export default class Dashboard extends React.Component {
  constructor(props) {
    super(props);

    this._onRequestAddCycleSnap = this._onRequestAddCycleSnap.bind(this);
    this._onAddCycleSnapCancel = this._onAddCycleSnapCancel.bind(this);
    this._onAddCycleSnapSubmit = this._onAddCycleSnapSubmit.bind(this);
    this._loadDashboard = this._loadDashboard.bind(this);

    this.state = {
      projectId: props.params.id,
      name: '',
      cycleSnaps: [],
      errorMessage: '',
      addCycleSnap: false,
      successNotificationOnAdd: undefined,
      failureNotificationOnAdd: undefined
    };
  }

  componentDidMount() {
    this._loadDashboard(this.state.projectId);
  }

  _loadDashboard(projectId) {
    if (isNaN(projectId)) {
      this.setState({ errorMessage: "Invalid project id" });
    }
    else {
      axios.get(`${constants.API}/projects/${projectId}/dashboard`).then((response) => {
        if (response.data) {
          this.setState({
            name: response.data.name,
            cycleSnaps: response.data.cycleSnaps,
            addCycleSnap: false
          });
        }
      }).catch((error) => {
        this.setState({
          errorMessage: error.message,
          addCycleSnap: false
        });
      });
    }
  }

  _onRequestAddCycleSnap() {
    this.setState({
      addCycleSnap: true,
      successNotificationOnAdd: undefined,
      failureNotificationOnAdd: undefined
    });
  }

  _onAddCycleSnapCancel() {
    this.setState({ addCycleSnap: false });
  }

  _onAddCycleSnapSubmit(newCycleSnap) {
    axios.post(`${constants.API}/projects/cyclesnaps`, {
      projectId: this.state.projectId,
      cycleSnapName: newCycleSnap.name,
      startDate: newCycleSnap.startDate,
      endDate: newCycleSnap.endDate,
      targetedPoints: newCycleSnap.targetedPoints,
      achievedPoints: newCycleSnap.achievedPoints
    })
      .then((response) => {
        this._loadDashboard(this.state.projectId)
        this.setState({ successNotificationOnAdd: 'Success! You just added the snap for cycle ' + newCycleSnap.name + '.' })
      })
      .catch((error) => {
        this.setState({ failureNotificationOnAdd: 'Oops! We got a bit of an issue: ' + error.message + '.' })
      });
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

    let successNotification;
    if (this.state.successNotificationOnAdd) {
      successNotification = (<Toast status='ok' onClose={this._onCloseSuccessNotification}>{this.state.successNotificationOnAdd}</Toast>);
    }

    let failureNotification;
    if (this.state.failureNotificationOnAdd) {
      failureNotification = (<Toast status='critical'>{this.state.failureNotificationOnAdd}</Toast>);
    }

    let addCycleSnapLayer;
    if (this.state.addCycleSnap) {
      addCycleSnapLayer = (<CycleSnapAdd projectId={this.state.projectId} onClose={this._onAddCycleSnapCancel} onSubmit={this._onAddCycleSnapSubmit} />);
    }

    if (errorMessage) {
      return <Box>
        <h1>Dashboard</h1>
        <h3><Status value='critical' /> <span>{errorMessage}</span></h3>
      </Box>
    }
    else {

      if (projectName) {

        if (cycleSnaps.length > 0) {
          return <Box>
            <h1>Dashboard: {projectName}</h1>

            <Footer>
              <Button label='Add Cycle Snap' onClick={this._onRequestAddCycleSnap} onSubmit={this._onAddCycleSnapSubmit} primary={true} />
            </Footer>

            <Table>
              <TableHeader labels={['Name', 'Start Date', 'End Date', 'Achieved / Targeted points', 'TAC']} sortIndex={2} sortAscending={false} />
              <tbody>
                {cycleSnaps}
              </tbody>
            </Table>
            {addCycleSnapLayer}
            {successNotification}
            {failureNotification}
          </Box>
        }
        else {
          return <Box>
            <h1>Dashboard: {projectName}</h1>
            <h3><Status value='unknown' /> <span>This project has no cycle snaps.</span></h3>
            <Footer>
              <Button label='Add Cycle Snap' onClick={this._onRequestAddCycleSnap} onSubmit={this._onAddCycleSnapSubmit} primary={true} />
            </Footer>
          </Box>
        }
      }
      else {
        return <Box>
          <h1>Dashboard</h1>
          <h3><Spinning /> Loading... </h3>
        </Box>
      }
    }
  }
}