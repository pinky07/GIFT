const viewModels = {

    // Initial state indicates that only the Loading View will be shown
    getInitial(props, dashboardCallbacks) {
        return {
            projectId: props.params.id,
            project: {
                name: undefined,
                cycleSnaps: []
            },
            dashboardCallbacks: dashboardCallbacks,
            errorMessage: '',
            addCycleSnap: false,
            addReleaseSnap: false,
            successNotificationOnAdd: undefined,
            failureNotificationOnAdd: undefined
        }
    },

    getInvalidProjectError() {
        return {
            errorMessage: "We are sorry, but your asked with an invalid project id.",
            addCycleSnap: false,
            addReleaseSnap: false,
            successNotificationOnAdd: undefined,
            failureNotificationOnAdd: undefined
        };
    },

    getShowAddCycleSnapForm() {
        return {
            errorMessage: '',
            addCycleSnap: true,
            addReleaseSnap: false,
            successNotificationOnAdd: undefined,
            failureNotificationOnAdd: undefined
        }
    },

    getShowAddReleaseSnapForm() {
      return {
        errorMessage: '',
        addCycleSnap: false,
        addReleaseSnap: true,
        successNotificationOnAdd: undefined,
        failureNotificationOnAdd: undefined
      }
    },

    getForClosingForms() {
      return {
        errorMessage: '',
        addReleaseSnap: false,
        addCycleSnap: false,
        successNotificationOnAdd: undefined,
        failureNotificationOnAdd: undefined
      }
    },

    getSuccessOnAddingACycleSnap() {
        return {
            errorMessage: '',
            addReleaseSnap: false,
            addCycleSnap: false,
            successNotificationOnAdd: 'Success! You just added a new cycle snap.',
            failureNotificationOnAdd: undefined
        }
    },

    getSuccessOnAddingAReleaseSnap() {
      return {
        errorMessage: '',
        addReleaseSnap: false,
        addCycleSnap: false,
        successNotificationOnAdd: 'Success! You just added a new release snap.',
        failureNotificationOnAdd: undefined
      }
    },

    getOnErrorAddingACycleSnap(error) {
        if (error.response) {
            // There was a validation error.
            return {
                errorMessage: '',
                successNotificationOnAdd: undefined,
                failureNotificationOnAdd: 'Sorry, there was a validation error: ' + error.response.data.message + '.',
                addReleaseSnap: false,
                addCycleSnap: false
            }
        }
        else {
            // There was a critical error.
            return {
                errorMessage: `Oops! We got a bit of an issue: ${error.message}.`,
                successNotificationOnAdd: undefined,
                failureNotificationOnAdd: undefined,
                addReleaseSnap: false,
                addCycleSnap: false
            }
        }
    },

    getOnErrorAddingAReleaseSnap(error) {
      if (error.response) {
        // There was a validation error.
        return {
          errorMessage: '',
          successNotificationOnAdd: undefined,
          failureNotificationOnAdd: 'Sorry, there was a validation error: ' + error.response.data.message + '.',
          addReleaseSnap: false,
          addCycleSnap: false
        }
      }
      else {
        // There was a critical error.
        return {
          errorMessage: `Oops! We got a bit of an issue: ${error.message}.`,
          successNotificationOnAdd: undefined,
          failureNotificationOnAdd: undefined,
          addReleaseSnap: false,
          addCycleSnap: false
        }
      }
    },

    getOnSuccessLoadingDashboard(response) {
        if (response.data)
            return {
                project: response.data,
                errorMessage: '',
            };
        else
            return {
                project: undefined,
                errorMessage: 'No information was found',
            };
    },

    getOnErrorLoadingDashboard(error) {
        if (error.response) {
            // There was a validation error.
            return {
                project: undefined,
                errorMessage: 'Please check: ' + error.response.data.message + '.',
                successNotificationOnAdd: undefined,
                failureNotificationOnAdd: undefined,
                addReleaseSnap: false,
                addCycleSnap: false
            };
        }
        else {
            // There was a critical error.
            return {
                project: undefined,
                errorMessage: 'Oops! We got a bit of an issue: ' + error.message + '.',
                successNotificationOnAdd: undefined,
                failureNotificationOnAdd: undefined,
                addReleaseSnap: false,
                addCycleSnap: false
            };
        }
    }
}

export default viewModels;