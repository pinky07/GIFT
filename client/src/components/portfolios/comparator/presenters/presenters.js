const presenters = {
  getInitial(props) {
    return {
      portfolioId: props.params.id,
      comparator: {
        portfolioName: undefined,
        lastSnaps: []
      },
      errorMessage: ''
    }
  },

  getOnSuccessLoadingComparison(response) {
    if (response.data)
      return {
        comparator: response.data,
        errorMessage: ''
      };
    else
      return {
        comparator: undefined,
        errorMessage: 'No information was found'
      };
  },

  getInvalidPortfolioIdError() {
    return {
      comparator: undefined,
      errorMessage: "We are sorry, but your asked with an invalid portfolio id."
    };
  },

  getOnErrorLoadingCompare(error) {
    if (error.response) {
      // There was a validation error.
      return {
        comparator: undefined,
        errorMessage: 'Please check: ' + error.response.data.message + '.'
      };
    }
    else {
      // There was a critical error.
      return {
        comparator: undefined,
        errorMessage: 'Oops! We got a bit of an issue: ' + error.message + '.',
      };
    }
  }

}

export default presenters;
