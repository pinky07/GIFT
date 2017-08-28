import React from 'react';

import presenters from './presenters/presenters';
import axios from 'axios';
import constants from '../../constants';
import ComparatorView from "./views/ComparatorView";

export default class ComparatorController extends React.Component {
  constructor(props) {
    super(props);

    this.state = presenters.getInitial(props);
  }

  componentDidMount() {
    this.loadComparator();
  }

  loadComparator() {
    const {portfolioId} = this.state

    const onSuccess = presenters.getOnSuccessLoadingComparator;
    const onError = undefined;

    this.load(portfolioId, onSuccess, onError).then(newViewModel => this.setState(newViewModel));
  }

  load(id, onSuccess, onError) {
    return axios.get(`${constants.API}/portfolios/${id}/comparator`)
      .then((response) => onSuccess(response))
      //.catch((error) => onError(error));
  }

  render() {
    return (<ComparatorView viewModel={this.state}/>)
  }
}