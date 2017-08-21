const addCycleSnapRequest = {
  get(viewModel) {
    return {
      projectId: viewModel.projectId,
      cycleSnapName: viewModel.cycleSnapName,
      startDate: viewModel.startDate,
      endDate: viewModel.endDate,
      targetedPoints: viewModel.targetedPoints,
      achievedPoints: viewModel.achievedPoints,
      isMoodAvailable: viewModel.isMoodAvailable,
      moodAverage: viewModel.mood
    }
  }
}

export default addCycleSnapRequest;