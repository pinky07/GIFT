import React from 'react';

import presenters from './presenters/presenters';
import axios from 'axios';
import constants from '../../constants';
import CompareView from "./views/CompareView";

export default class CompareController extends React.Component {
  constructor(props) {
    super(props);

    this.state = presenters.getInitial(props);
  }

  componentDidMount() {
    this.loadCompare();
  }

  loadCompare() {
    const {portfolioId} = this.state

    const onSuccess = presenters.getOnSuccessLoadingComparison;
    const onError = undefined;

    this.load(portfolioId, onSuccess, onError).then(newViewModel => this.setState(newViewModel));
  }

  load(id, onSuccess, onError) {
    return axios.get(`${constants.API}/portfolios/${id}/comparator`)
      .then((response) => onSuccess(response))
      //.catch((error) => onError(error));
  }

  render() {
    return (<CompareView viewModel={this.state}/>)
  }
}