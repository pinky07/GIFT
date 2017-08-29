const presenters = {
  getInitial(props) {
    return {
      portfolioId: props.params.id,
      comparison: {
        portfolioName: undefined,
        lastSnaps: []
      },
      errorMessage: ''
    }
  },

  getOnSuccessLoadingComparison(response) {
    if (response.data)
      return {
        comparison: response.data,
        errorMessage: ''
      };
    else
      return {
        comparison: undefined,
        errorMessage: 'No information was found'
      };
  },

  getInvalidPortfolioIdError() {
    return {
      comparison: undefined,
      errorMessage: "We are sorry, but your asked with an invalid portfolio id."
    };
  },

  getOnErrorLoadingCompare(error) {
    if (error.response) {
      // There was a validation error.
      return {
        comparison: undefined,
        errorMessage: 'Please check: ' + error.response.data.message + '.'
      };
    }
    else {
      // There was a critical error.
      return {
        comparison: undefined,
        errorMessage: 'Oops! We got a bit of an issue: ' + error.message + '.',
      };
    }
  }

}

export default presenters;
