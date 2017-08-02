import React from 'react';
import * as actions from '../../actions';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import PropTypes from 'prop-types';

import Anchor from 'grommet/components/Anchor';
import Table from 'grommet/components/Table';
import TableHeader from 'grommet/components/TableHeader';
import TableRow from 'grommet/components/TableRow';

import constants from '../../services/constants';

export class ProjectList extends React.Component {

  componentDidMount() {
    let portfolioId = this.props.params.id;
    this.props.loadProjects(portfolioId);
  }

  render() {
    return (
      <div>
        <h1>Portfolio #{this.props.params.id}: Projects list</h1>

        <Table>
          <TableHeader labels={['Name', 'Dashboard']} />
          <tbody>
            {this.props.projects.map(project =>
              <TableRow key={project.id}>
                <td>{project.name}</td>
                <td><Anchor path={`/projects/${project.id}/dashboard`}>
                  Dashboard
              </Anchor></td>
              </TableRow>)}
          </tbody>
        </Table>
      </div>
    );
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
