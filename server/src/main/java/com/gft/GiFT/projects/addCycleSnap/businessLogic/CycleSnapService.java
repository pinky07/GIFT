package com.gft.GiFT.projects.addCycleSnap.businessLogic;

import com.gft.GiFT.projects.addCycleSnap.businessLogic.inputs.CycleSnap;

import java.text.ParseException;

public interface CycleSnapService {

    String findProjectNameById(int projectId);

    CycleSnap createCycleSnap(CycleSnap cycleSnap) throws ParseException;
}