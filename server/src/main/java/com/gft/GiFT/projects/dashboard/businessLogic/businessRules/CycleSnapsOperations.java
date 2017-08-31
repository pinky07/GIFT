package com.gft.GiFT.projects.dashboard.businessLogic.businessRules;

import com.gft.GiFT.common.businessLogic.DateFormatter;

import java.text.ParseException;
import java.util.*;

public class CycleSnapsOperations {

    public static Date findTheFirstDate(List<String> datesAsString) throws ParseException {
        TreeSet<Date> tree = new TreeSet<>();
        for (String start: datesAsString) {
            Date newDate = DateFormatter.convertDateStringToDate(start);
            tree.add(newDate);
        }

        return tree.first();
    }

}
