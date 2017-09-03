package com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs;

import java.util.Date;
import java.util.List;

public abstract class AbstractInputs {
    // This algorithm has two kinds of inputs:

    // 1. User inputs: concrete information given by the user
    public CycleSnap newCycleSnap;

    // 2. External dependencies: information that should be retrieved from
    // databases, external services, dates, time, random
    // Each retrieval is represented by an abstract method
    // This leads to an algorithm that is independent from tools and frameworks
    public abstract Date getCurrentDate();
    public abstract List<CycleSnap> getExistingCycles(int projectId);
    public abstract void save(CycleSnap newCycleSnap);
}
