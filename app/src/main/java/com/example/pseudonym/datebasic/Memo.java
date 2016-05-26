package com.example.pseudonym.datebasic;

import android.graphics.drawable.Drawable;

/**
 * Created by pseudonym on 2016/5/18.
 */
public class Memo {
    private Drawable image_;
    private String hint_;
    private String bigDayDate_;
    private long days_;

    public Memo(String hint, String bigDayDate, Drawable image, long day){
        hint_ = hint;
        bigDayDate_ = bigDayDate;
        image_ = image;
        days_ = day;
    }

    public Memo(String name, Drawable image){
        hint_ = name;
        image_ = image;
        days_ = 0;
    }

    public String getText()  {
        return hint_;
    }

    public String getBigDayDate(){return bigDayDate_;}

    public Drawable getImage(){
        return image_;
    }

    public long getDays(){return days_;}

}
