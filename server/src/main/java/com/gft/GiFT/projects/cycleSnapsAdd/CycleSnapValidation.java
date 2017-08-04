package com.gft.GiFT.projects.cycleSnapsAdd;

import com.gft.GiFT.entities.CycleSnap;
import com.gft.GiFT.formatters.DateFormatter;
import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

public class CycleSnapValidation {

    public static void validate(CycleSnap newCycleSnap, Set<CycleSnap> existingCycleSnaps) throws ParseException {

        if (newCycleSnap.getStartDate().isEmpty()) {
            throw new IllegalArgumentException("Start Date is required.");
        }
        if (newCycleSnap.getEndDate().isEmpty()) {
            throw new IllegalArgumentException("End Date is required.");
        }

        DateTime startDateTime = new DateTime(DateFormatter.convertDateStringToDate(newCycleSnap.getStartDate()));
        DateTime endDateTime = new DateTime(DateFormatter.convertDateStringToDate(newCycleSnap.getEndDate()));
        Date startDate = DateFormatter.convertDateStringToDate(newCycleSnap.getStartDate());
        Date endDate = DateFormatter.convertDateStringToDate(newCycleSnap.getEndDate());

        if (newCycleSnap.getCycleSnapName().isEmpty()) {
            throw new IllegalArgumentException("Cycle name is required.");
        }
        if (newCycleSnap.getCycleSnapName().length() > 200) {
            throw new IllegalArgumentException("Cycle Snap Name can not be greater than 200 characters.");
        }
        if (newCycleSnap.getStartDate().isEmpty()) {
            throw new IllegalArgumentException("Start Date is required.");
        }
        if (newCycleSnap.getEndDate().isEmpty()) {
            throw new IllegalArgumentException("End Date is required.");
        }
        if (!startDate.before(endDate)) {
            throw new IllegalArgumentException("Start Date should precede End Date.");
        }
        if (newCycleSnap.getTargetedPoints() < 0) {
            throw new IllegalArgumentException("Min number for Targeted Points is 0.");
        }
        if (newCycleSnap.getTargetedPoints() > 10000) {
            throw new IllegalArgumentException("Max number for Targeted Points is 10,000.");
        }
        if (newCycleSnap.getAchievedPoints() < 0) {
            throw new IllegalArgumentException("Min number for Achieved Points is 0.");
        }
        if (newCycleSnap.getAchievedPoints() > 10000) {
            throw new IllegalArgumentException("Max number for Achieved Points is 10,000.");
        }

        //Cycle dates shouldn't overlap
        Interval newInterval = new Interval(startDateTime, endDateTime);

        for (CycleSnap existingCycle : existingCycleSnaps) {
            DateTime cycleStartDate = new DateTime(DateFormatter.convertDateStringToDate(existingCycle.getStartDate()));
            DateTime cycleEndDate = new DateTime(DateFormatter.convertDateStringToDate(existingCycle.getEndDate()));

            Interval existingInterval = new Interval(cycleStartDate, cycleEndDate);

            if (newInterval.overlaps(existingInterval)) {
                throw new IllegalArgumentException("The new cycle dates overlap with an existing cycle.");
            }
        }
    }
}
