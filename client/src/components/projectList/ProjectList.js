import React from 'react';
import * as actions from '../../actions';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import PropTypes from 'prop-types';

export class ProjectList extends React.Component {

  componentDidMount() {
    let portfolioId = this.props.params.id;
    console.log(portfolioId);
    this.props.loadProjects(portfolioId);
  }

  render() {
    return (
      <div>
        <h1>Portfolio #{this.props.params.id}: Projects list</h1>
        <ul>
          {this.props.projects.map( project => <li key ={project.id}>{project.name}</li>)}
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
    portfolioId: state.portfolioId,
    projects: state.projects
  };
};

const mapDispatchToProps = dispatch => {
  return {
    loadProjects: bindActionCreators(actions.loadProjects, dispatch)
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(ProjectList);
