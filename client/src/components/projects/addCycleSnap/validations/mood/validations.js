const validations = {
    validate(isMoodAvailable, mood) {
        let error = undefined;

        if (isMoodAvailable) {
          if (isNaN(mood))
            error = 'Mood average is required';
          else {
            if (mood < 1)
              error = 'Mood average min is 1';
            if (mood > 3)
              error = 'Mood average max is 3';
          }
        } else {
          error = undefined;
        }

        return error;
    }
}

export default validations;