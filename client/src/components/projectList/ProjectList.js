import React from 'react';
import * as actions from '../../actions';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import PropTypes from 'prop-types';

export class ProjectList extends React.Component {

  componentDidMount() {
    let portfolioId = 1;
    this.props.loadProjects(portfolioId);
  }

  render() {
    return (
      <div>
        <h1>Projects list</h1>
        <ul>
          {this.props.projects.map((project) =>
             <li key ={project.id}>{project.name}</li>
          )}
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
