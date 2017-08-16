const validations = {
    validate(points) {
        let error = undefined;

        if (isNaN(points)) 
            error = 'Achieved points are required';
        else {
            if (points < 0)
                error = 'Achieved points min is 0';
            if (points > 10000)
                error = 'Achieved points max is 10,000';
        }

        return error;
    }
}

export default validations;