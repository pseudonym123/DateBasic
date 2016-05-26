package com.example.pseudonym.datebasic;

import android.graphics.drawable.Drawable;

/**
 * Created by pseudonym on 2016/5/18.
 */
public class Memo {
    private Drawable image_;
    private String text_;
    private long days_;

    public Memo(String name, Drawable image, long day){
        text_ = name;
        image_ = image;
        days_ = day;
    }

    public Memo(String name, Drawable image){
        text_ = name;
        image_ = image;
        days_ = 0;
    }

    public String getText()  {
        return text_;
    }

    public Drawable getImage(){
        return image_;
    }

    public long getDays(){return days_;}

}
