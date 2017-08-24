const validations = {
    validate(points) {
        let error = undefined;

        if (isNaN(points))
            error = 'Targeted points are required';
        else {
            if (points < 0)
                error = 'Targeted points min is 0';
            if (points > 10000)
                error = 'Targeted points max is 10,000';
        }

        return error;
    }
}

export default validations;