package com.gft.GiFT.projects.dashboard.businessLogic;

import com.gft.GiFT.formatters.DateFormatter;

import java.text.ParseException;
import com.gft.GiFT.projects.dashboard.dataAccess.ReleaseSnap;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class LastReleaseOperations {

    public static LastReleaseInfo getLastRelease(String cycleSnapEndDate,
                                                 List<ReleaseSnap> releases) throws ParseException {
        LastReleaseInfo lastRelease = new LastReleaseInfo();
        Date cycleEndDate = DateFormatter.convertDateStringToDate(cycleSnapEndDate);
        TreeSet<ReleaseSnap> releaseDateComparison = new TreeSet<ReleaseSnap>(new LatestReleaseDateComparator());


        if(releases.isEmpty()) {
            lastRelease.setLastReleaseDate("No releases yet");
            lastRelease.setLastReleaseName("No releases yet");
        }
        else{

            // Create the sorted list
            for(ReleaseSnap release:releases){
                releaseDateComparison.add(release);
            }

            // Get the latest release
            ReleaseSnap pointInTime = new ReleaseSnap();
            pointInTime.setReleaseDate(cycleSnapEndDate);
            ReleaseSnap lastReleaseSnap = releaseDateComparison.floor(pointInTime);

            // Format the returned info
            lastRelease.setLastReleaseDate(lastReleaseSnap.getReleaseDate());
            lastRelease.setLastReleaseName(lastReleaseSnap.getReleaseName());
        }

        return lastRelease;
    }
}

