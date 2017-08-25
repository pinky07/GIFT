package com.gft.GiFT.portfolios.comparator.businessLogic;

import com.gft.GiFT.portfolios.comparator.businessLogic.inputs.*;
import com.gft.GiFT.portfolios.comparator.businessLogic.response.LastSnapDTO;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LastSnapListCreation {
    public static List<LastSnapDTO> getList(Set<Project> projects) {
        List<LastSnapDTO> snaps = new LinkedList<>();

        for(Project project : projects){
            CycleSnap last = project.getLastSnap();
            String name = project.getName();

            LastSnapDTO lastSnapDTO = LastSnapCreation.getLastSnap(name, last);

            snaps.add(lastSnapDTO);
        }

        return snaps;
    }
}