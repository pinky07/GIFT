import React from 'react';
import * as actions from './actions';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import PropTypes from 'prop-types';

import Box from 'grommet/components/Box';
import Heading from 'grommet/components/Heading';
import Anchor from 'grommet/components/Anchor';
import Table from 'grommet/components/Table';
import TableHeader from 'grommet/components/TableHeader';
import TableRow from 'grommet/components/TableRow';

export class ProjectList extends React.Component {

  componentDidMount() {
    let portfolioId = this.props.params.id;
    this.props.loadProjects(portfolioId);
  }

  render() {
    return (<Box>
        <Heading>Portfolio #{this.props.params.id}: Projects list</Heading>

        <Table>
          <TableHeader labels={['Name', 'DashboardController']} />
          <tbody>
            {this.props.projects.map((project, i) =>
              <TableRow key={project.id}>
                <td>{project.name}</td>
                <td><Anchor id={`dashboard-link-${i}`} path={`/projects/${project.id}/dashboard`}>
                  Dashboard
              </Anchor></td>
              </TableRow>)}
          </tbody>
        </Table>
      </Box>);
  }
}

ProjectList.propTypes = {
  loadProjects: PropTypes.func.isRequired
};

const mapStateToProps = state => {
  return {
    projects: state.projects
  };
};

const mapDispatchToProps = dispatch => {
  return {
    loadProjects: bindActionCreators(actions.loadProjects, dispatch)
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(ProjectList);
`                                   `