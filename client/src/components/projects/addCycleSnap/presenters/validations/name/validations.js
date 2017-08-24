const validations = {
    validate(name) {
        let error;

        if (!name) {
            error = 'Name is required';
        }
        else {
            const trimmedName = name.trim();
            if (!trimmedName) {
                error = 'Name is required';
            }
            else {
                if (trimmedName.length > 200)
                    error = 'Name has a max of 200 characters';
                else
                    error = undefined;
            }
        }
        return error;
    }
}

export default validations;