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
          return <li>{project.name}</li>
        });
      })
      .catch(() => {
      });
  }

  componentDidMount() {
    this.loadProjects();
  }

  render() {
    const list = [{"id":1,"name":"GiFT","portfolioId":1,"releasePatternId":2,"cycleTypeId":1,"projectStatus":2},{"id":2,"name":"Big Ball","portfolioId":1,"releasePatternId":1,"cycleTypeId":2,"projectStatus":1}];
    debugger;
    return (
      <div>
        <ul>
          {list.map(function(item, index){
            return <li key={ index }>{item.name}</li>;
          })}
        </ul>
      </div>
    );
  }
}
