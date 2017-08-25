import React from 'react';

import presenters from './presenters/presenters';
import ComparatorView from "./views/ComparatorView";

export default class ComparatorController extends React.Component {
  constructor(props) {
    super(props);

    this.state = presenters.getInitial(props);
  }

  render() {
    return (<ComparatorView viewModel={this.state} />)
  }
}