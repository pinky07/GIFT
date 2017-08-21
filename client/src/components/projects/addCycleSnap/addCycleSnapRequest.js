const addCycleSnapRequest = {
  get(viewModel) {
    return {
      projectId: viewModel.projectId,
      cycleSnapName: viewModel.cycleSnapName,
      startDate: viewModel.startDate,
      endDate: viewModel.endDate,
      targetedPoints: viewModel.targetedPoints,
      achievedPoints: viewModel.achievedPoints
    }
  }
}

export default addCycleSnapRequest;