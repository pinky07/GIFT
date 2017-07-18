import React from 'react';
import * as actions from '../../actions';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import PropTypes from 'prop-types';

class ProjectList extends React.Component {

  componentDidMount() {
    this.props.loadProjects();
  }

  render() {
    return (
        <ul>
          {this.props.projects.map((project) => {
            return <li key ={project.id}>{project.name}</li>;
          })}
        </ul>
    );
  }
}

const mapStateToProps = state => {
  return {
    projects: state.projects
  };
};

const mapDispatchToProps = dispatch => {
  return {
    loadProjects: () => dispatch(actions.loadProjects())
    //actions: bindActionCreators( projectActions, dispatch)
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(ProjectList);
