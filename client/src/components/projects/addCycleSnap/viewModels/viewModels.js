const viewModels = {
    getInitial(props, formCallbacks) {
        return {
            projectId: props.projectId,
            projectName: props.projectName,
            cycleSnapName: '',
            startDate: '',
            endDate: '',
            targetedPoints: '0',
            achievedPoints: '0',
            isMoodAvailable: true,
            mood: '0',
            errors: {},
            formCallbacks: formCallbacks
        };
    },

    getMoodAverage(isMoodAvailable, mood) {
      let newMood
      if(isMoodAvailable) {
        newMood= mood
      } else {
        newMood= '0'
      }
      return {
        isMoodAvailable: isMoodAvailable,
        mood: newMood
      };
    }
}

export default viewModels;