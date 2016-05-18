package com.example.pseudonym.datebasic;

/**
 * Created by pseudonym on 2016/5/18.
 */
public class Memo {
    private String memoName_;
    private String memoDate_;

    public Memo(String name, String date){
        memoName_ = name;
        memoDate_ = date;
    }

    public String getName()  {
        return memoName_;
    }

    public String getDate(){
        return memoDate_;
    }

}
