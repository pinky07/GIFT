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
      isWasteAvailable: true,
      teamCapacity: 0,
      wasteDays: '0',
      errors: {},
      formCallbacks: formCallbacks
    };
  },

  getNewMoodInfo(isMoodAvailable, mood, errors) {
    let newMood;

    errors.mood = undefined;

    if (isMoodAvailable) {
      newMood = mood;
    } else {
      newMood = '0';
    }

    return {
      isMoodAvailable: isMoodAvailable,
      mood: newMood,
      errors: errors
    };
  },

  getNewWasteInfo(isWasteAvailable, errors) {
    errors.teamCapacity = undefined;
    errors.wasteDays = undefined;

    return {
      isWasteAvailable: isWasteAvailable,
      teamCapacity: '0',
      wasteDays: '0',
      errors: errors
    };
  }
}

export default viewModels;