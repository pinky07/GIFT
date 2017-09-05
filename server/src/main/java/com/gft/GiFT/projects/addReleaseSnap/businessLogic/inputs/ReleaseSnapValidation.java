package com.gft.GiFT.projects.addReleaseSnap.businessLogic.inputs;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReleaseSnapValidation {
    public static void validate(ReleaseSnap releaseSnap) {
        if (releaseSnap.getProjectId()<=0) {
            throw new IllegalArgumentException("ProjectId is required");
        }

        String name = releaseSnap.getReleaseName();
        if (name == null ||name.isEmpty()) {
            throw new IllegalArgumentException("Release name is required");
        }

        if (name.length() > 200) {
            throw new IllegalArgumentException("Release name can not be greater than 200 characters");
        }
        if (releaseSnap.getReleaseDate().isEmpty()) {
            throw new IllegalArgumentException("Release Date is required");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name with whitespaces is not valid");
        }

    }
    public  static boolean isValidDate(ReleaseSnap releaseSnap)  {
        DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        df2.format(releaseSnap.getReleaseDate());
        return true;
    }

}
