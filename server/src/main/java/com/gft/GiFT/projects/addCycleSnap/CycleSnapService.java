package com.gft.GiFT.projects.addCycleSnap;

import java.text.ParseException;

public interface CycleSnapService {

    String findProjectNameById(int projectId);

    CycleSnap createCycleSnap(CycleSnap cycleSnap) throws ParseException;
}