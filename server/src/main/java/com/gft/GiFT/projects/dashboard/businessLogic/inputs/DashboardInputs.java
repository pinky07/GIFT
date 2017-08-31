package com.gft.GiFT.projects.dashboard.businessLogic.inputs;

import lombok.Data;
import java.util.Date;

@Data
public class DashboardInputs {
    private Project project;
    private int projectId;
    private Date currentDate;

    public boolean projectDoesNotExist() {
        return project == null;
    }
}