import React from 'react';

export default class Projects extends React.Component {
  constructor() {
    super();
    this.listItems = [];
  }


  componentDidMount() {
        fetch('http://localhost:8080/api/v1/projects/portfolio/1')
          .then((resp) => resp.json())
          .then((data) => {
            if (data) {
              this.listItems = data.map((project) => {
                return <li key ={project.id}>{project.name}</li>;
              });
              this.setState({listItems: this.listItems});
            }
      })
      .catch(() => {
      });
  }

  render() {
    return (
        <ul>
          {this.listItems}
        </ul>
    );
  }
}
