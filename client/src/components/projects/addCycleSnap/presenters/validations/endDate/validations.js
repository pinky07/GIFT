import dateValidations from '../date/validations';

const endDatevalidations = {
    validate(startDate, endDate) {
        let error = undefined;

        if (!endDate)
            error = 'End date is required';
        else
            if (!dateValidations.isValid(endDate))
                error = 'End date should be a valid one';

        if (dateValidations.isValid(startDate) && dateValidations.isValid(endDate))
            if (!this.startPrecedesEndDate(startDate, endDate))
                error = 'End date should happen after the start date';

        return error;
    },

    startPrecedesEndDate(startDate, endDate) {
        return new Date(endDate) > new Date(startDate); // true if endDate is later
    }
}

export default endDatevalidations;