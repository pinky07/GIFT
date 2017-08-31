const addReleaseSnapRequest = {
  get(viewModel) {
    return {
      projectId: viewModel.projectId,
      releaseSnapName: viewModel.releaseSnapName,
      releaseName: viewModel.releaseName
    }
  }
}

export default addReleaseSnapRequest;