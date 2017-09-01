import React from 'react';

import presenters from './presenters/presenters';
import axios from 'axios';
import CompareView from "./views/CompareView";
import compareService from "./compareService";

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

    if (isNaN(portfolioId) || this.isInteger(portfolioId)) {
      const newViewModel = presenters.getInvalidPortfolioIdError();
      this.setState(newViewModel);
    } else {
      const onSuccess = presenters.getOnSuccessLoadingComparison;
      const onError = presenters.getOnErrorLoadingCompare;
      const axiosGet = axios.get;

      compareService.load(axiosGet, portfolioId, onSuccess, onError)
        .then(newViewModel => this.setState(newViewModel));
    }
  }

  isInteger(portfolioId) {
    return portfolioId % 1 != 0;
  }

  render() {
    return (<CompareView viewModel={this.state}/>)
  }
}