import React from 'react';

export default class Projects extends React.Component {
  constructor() {
    super();
    this.listItems = [];
  }

  loadProjects() {
    fetch('http://localhost:8080/api/v1/projects/portfolio/1')
      .then((resp) => resp.json())
      .then((data) => {
        this.listItems = data.map((project) => {
          return <li>`${project.name}, status: ${project.projectStatus}`  </li>
        });
      })
      .catch(() => {
      });
  }

  componentDidMount() {
    this.loadProjects();
  }

  render() {
    return (
      <div>
        <ul>{this.listItems}</ul>
      </div>
    );
  }
}
