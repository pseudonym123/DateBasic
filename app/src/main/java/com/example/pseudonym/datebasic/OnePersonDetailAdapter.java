package com.example.pseudonym.datebasic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by c_pse on 2016/5/26.
 */
public class OnePersonDetailAdapter extends ArrayAdapter<Memo> {
    private int resourceId_;

    public OnePersonDetailAdapter(Context context, int viewResourceId, List<Memo> objs ){
        super(context, viewResourceId, objs);
        resourceId_ = viewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Memo memo = getItem(position);
        View view;
        ViewHolder viewholder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId_,null);
            viewholder = new ViewHolder();
            viewholder.textView_hint_ = (TextView)view.findViewById(R.id.textView_hint);
            viewholder.textView_date_ = (TextView)view.findViewById(R.id.textView_date);
            viewholder.textView_daysleft_ = (TextView)view.findViewById(R.id.textView_daysleft);
            view.setTag(viewholder);
        }else{
            view = convertView;
            viewholder = (ViewHolder) view.getTag();
        }

        viewholder.textView_hint_.setText(memo.getText());
        viewholder.textView_date_.setText(memo.getBigDayDate());
        viewholder.textView_daysleft_.setText(Long.toString(memo.getDays()) + "天");

        return view;
    }

    class ViewHolder {
        TextView textView_date_;
        TextView textView_hint_;
        TextView textView_daysleft_;
    }
}
