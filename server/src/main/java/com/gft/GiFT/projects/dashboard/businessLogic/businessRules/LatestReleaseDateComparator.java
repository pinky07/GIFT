package com.gft.GiFT.projects.dashboard.businessLogic.businessRules;
import com.gft.GiFT.projects.dashboard.dataAccess.ReleaseSnap;
import java.util.Comparator;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class LatestReleaseDateComparator implements Comparator <ReleaseSnap> {
    @Override
    public int compare(ReleaseSnap e1, ReleaseSnap e2) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date releaseDateFirst = null;
        Date releaseDateSecond= null;
        try {
             releaseDateFirst = format.parse(e1.getReleaseDate());
             releaseDateSecond = format.parse(e2.getReleaseDate());

        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return releaseDateFirst.compareTo(releaseDateSecond);
    }
}
