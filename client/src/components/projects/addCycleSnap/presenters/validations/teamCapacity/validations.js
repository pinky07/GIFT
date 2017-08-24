const validations = {
  validate(wasteIsAvailable, teamCapacity) {
    let error = undefined;

    if (wasteIsAvailable) {
      if (isNaN(teamCapacity))
        error = 'Team capacity is required';
      else {
        if (teamCapacity < 1)
          error = 'Team capacity min is 1';
        if (teamCapacity > 10000)
          error = 'Team capacity max is 10,000';
      }
    } else {
      error = undefined;
    }

    return error;
  }
}

export default validations;