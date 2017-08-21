package com.gft.GiFT.projects.addCycleSnap;

import com.gft.GiFT.entities.CycleSnap;

import java.text.ParseException;

public interface CycleSnapService {

    String findProjectNameById(int projectId);

    CycleSnap createCycleSnap(CycleSnap cycleSnap) throws ParseException;
}