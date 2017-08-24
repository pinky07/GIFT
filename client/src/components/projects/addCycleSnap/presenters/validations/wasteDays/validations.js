const validations = {
  validate(wasteIsAvailable, teamCapacity, wasteDays) {
    let error = undefined;

    if (wasteIsAvailable) {
      if (isNaN(wasteDays))
        error = 'Waste days is required';
      else {
        if (wasteDays < 0)
          error = 'Waste days min is 0';
        if (!isNaN(teamCapacity)) {
          if (wasteDays > teamCapacity)
            error = "Waste days max is the team's capacity";
        }
      }
    } else {
      error = undefined;
    }

    return error;
  }
}

export default validations;