import dateValidations from '../date/validations';

const validations = {
    validate(startDate) {
        let error;

        if (!startDate)
            error = 'Start date is required';
        else 
            if (!dateValidations.isValid(startDate))
                error = 'Start date should be a valid one';
            else
                error = undefined;

        return error;
    }
}

export default validations;