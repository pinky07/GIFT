const addCycleSnapResponse = {
  create({projectId, cycleSnapName, startDate, endDate, targetedPoints, achievedPoints}) {
    return {
      projectId: projectId,
      cycleSnapName: cycleSnapName,
      startDate: startDate,
      endDate: endDate,
      targetedPoints: targetedPoints,
      achievedPoints: achievedPoints
    }
  }
}

export default addCycleSnapResponse;