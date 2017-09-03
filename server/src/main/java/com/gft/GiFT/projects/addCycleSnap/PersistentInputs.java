package com.gft.GiFT.projects.addCycleSnap;

import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.AbstractInputs;
import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.CycleSnap;
import com.gft.GiFT.projects.addCycleSnap.dataAccess.CycleSnapRepository;

import java.util.Date;
import java.util.List;

public class PersistentInputs extends AbstractInputs {
    private final CycleSnapRepository repository;

    PersistentInputs(CycleSnapRepository repository) {
        // Initialize every external dependency here
        // (i.e. database repositories or external data sources)
        this.repository = repository;
    }

    // Each implementation method should be one simple line of code
    // No cycles, decisions or conversions are allowed here,
    // because this class will not be unit tested.
    @Override
    public Date getCurrentDate() {
        return new Date();
    }

    @Override
    public List<CycleSnap> getExistingCycles(int projectId) {
        return repository.findByProjectId(projectId);
    }

    @Override
    public void save(CycleSnap newCycleSnap) {
        repository.save(newCycleSnap);
    }
}