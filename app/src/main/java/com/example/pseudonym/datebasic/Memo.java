package com.example.pseudonym.datebasic;

import android.graphics.drawable.Drawable;

/**
 * Created by pseudonym on 2016/5/18.
 */
public class Memo {
    private Drawable image_;
    private String text_;

    public Memo(String name, Drawable image){
        text_ = name;
        image_ = image;
    }

    public String getText()  {
        return text_;
    }

    public Drawable getImage(){
        return image_;
    }

}
