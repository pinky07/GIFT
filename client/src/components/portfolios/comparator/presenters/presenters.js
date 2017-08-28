const presenters = {
  getInitial(props) {
    return {
      portfolioId: props.params.id,
      comparator: {
        portfolioName: undefined,
        lastSnaps: []
      }
    };
  },

  getOnSuccessLoadingComparison(response) {
    return {
      comparator: response.data
    };
  }
}

export default presenters;
