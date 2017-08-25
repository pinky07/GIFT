const presenters = {
  getInitial(props) {
    return {
      portfolioId: props.params.id,
      portfolioName: undefined
    };
  }
}

export default presenters;
