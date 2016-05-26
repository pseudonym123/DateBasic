package com.example.pseudonym.datebasic;

import org.joda.time.DateTime;
import org.joda.time.Duration;

/**
 * Created by pseudonym on 2016/5/18.
 */
public class HundredsDayCalculator extends NextBigDayCalculator {
    private final int HUNDREDS_DAY[] = {100, 500, 1000, 1500, 2000, 2222, 2500, 3000, 3500, 4000, 4500, 5000,
    5500, 6000, 6500, 7000, 7500, 8000, 8500, 9000, 9500, 10000, 12000, 15000, 18000, 20000, 22222, 25000, 30000};

    public HundredsDayCalculator(String type){ super(type); }

    // return the description string
    @Override
    public String getDescription(){
        Duration duration = new Duration(memoDate_, nextBigDate_);
        long days = duration.getStandardDays() + 1;

        return Long.toString(days);
    }

    @Override
    protected void initialize(){
        DateTime today = DateTime.now();

        for(int days : HUNDREDS_DAY){
            DateTime hundredsDay = memoDate_.plusDays(days - 1);
            if(hundredsDay.isEqualNow() || hundredsDay.isAfterNow()){
                nextBigDate_ = hundredsDay;
                break;
            }
        }
    }
}
