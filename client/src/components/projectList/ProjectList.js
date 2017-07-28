import React from 'react';
import * as actions from '../../actions';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import PropTypes from 'prop-types';

import Anchor  from 'grommet/components/Anchor';

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
        <ul>
          {this.props.projects.map( project =>
            <li key ={project.id}>
              <Anchor path={`/projects/${project.id}/dashboard`}>
                {project.name} dashboard
              </Anchor>
            </li>)}
        </ul>
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
