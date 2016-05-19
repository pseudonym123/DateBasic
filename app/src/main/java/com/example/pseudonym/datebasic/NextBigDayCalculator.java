package com.example.pseudonym.datebasic;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by pseudonym on 2016/5/18.
 */
public class NextBigDayCalculator {

    protected DateTime memoDate_;
    protected DateTime nextBigDate_;
    protected final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");

    public NextBigDayCalculator(String date){
        memoDate_ = formatter.parseDateTime(date);
        initialize();
    }

    // return next big day date
    public String getDate(){
        return nextBigDate_.toString(formatter);
    }

    // return the description string
    public String getDescription(){
        return "";
    }

    // return the days to that day
    public long getLeftDays(){
        Duration duration = new Duration(DateTime.now(), nextBigDate_);
        return duration.getStandardDays();
    }

    protected void initialize(){
        // override in subclass
    }
}
