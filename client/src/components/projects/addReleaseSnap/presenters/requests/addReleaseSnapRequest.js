const addReleaseSnapRequest = {
  get(viewModel) {
    return {
      projectId: viewModel.projectId,
      releaseName: viewModel.releaseName,
      releaseDate: viewModel.releaseDate
    }
  }
}

export default addReleaseSnapRequest;