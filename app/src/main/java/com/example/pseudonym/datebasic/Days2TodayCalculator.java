package com.example.pseudonym.datebasic;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by pseudonym on 2016/5/18.
 */
public class Days2TodayCalculator {

    public Days2TodayCalculator(){
    }

    public static String getString(String startDate){
        return getDays(startDate);
    }

    private static String getDays(String strStartDate){
        DateTime today = new DateTime();

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime startDate = formatter.parseDateTime(strStartDate);

        Duration duration = new Duration(startDate, today);
        long days = duration.getStandardDays() + 1;

        return Long.toString(days);
    }
}
