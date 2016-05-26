package com.example.pseudonym.datebasic;

import android.graphics.drawable.Drawable;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by pseudonym on 2016/5/17.
 */
public class Person {
    private String name_;
    private Drawable image_;

    public Person(String name, Drawable image){
        name_ = name;

        image_ = image;
    }

    public Drawable getImage() {
        return image_;
    }

    public String getName() {
        return name_;
    }
}
