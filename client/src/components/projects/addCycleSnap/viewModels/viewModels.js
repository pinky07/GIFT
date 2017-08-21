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
            isMoodAvailable: false,
            mood: '',
            errors: {},
            formCallbacks: formCallbacks
        };
    }
}

export default viewModels;