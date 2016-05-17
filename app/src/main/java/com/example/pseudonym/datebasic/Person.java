package com.example.pseudonym.datebasic;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by pseudonym on 2016/5/17.
 */
public class Person {
    private String name_;
    private int imageId_;
    private String birthDay_;

    public Person(String name, String birthday, int id){
        name_ = name;
        birthDay_ = birthday;
        imageId_ = id;
    }

    public int getImageId() {
        return imageId_;
    }

    public String getName() {
        return name_;
    }

    public String getBirthDuration(){
        DateTime today = new DateTime();

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
        DateTime d1 = formatter.parseDateTime(birthDay_);

        Duration duration = new Duration(d1, today);
        long days = duration.getStandardDays();
        String desc = name_ + "生日距今已过" + Long.toString(days) + "天。";
        return desc;
    }
}
