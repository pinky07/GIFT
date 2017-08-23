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
      moodAverage: viewModel.mood,
      isWasteAvailable: viewModel.isWasteAvailable,
      teamCapacity: viewModel.teamCapacity,
      wasteDays: viewModel.wasteDays
    }
  }
}

export default addCycleSnapRequest;