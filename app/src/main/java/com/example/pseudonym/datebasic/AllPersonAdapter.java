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
 * Created by pseudonym on 2016/5/17.
 */
public class AllPersonAdapter extends ArrayAdapter<Person> {
    private int resourceId_;

    public AllPersonAdapter(Context context, int viewResourceId, List<Person> objs ){
        super(context, viewResourceId, objs);
        resourceId_ = viewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Person person = getItem(position);
        View view;
        ViewHolder viewholder;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId_,null);
            viewholder = new ViewHolder();
            viewholder.imageView_ = (ImageView)view.findViewById(R.id.imageView_profile);
            viewholder.textView_ = (TextView)view.findViewById(R.id.textView_duration);
            view.setTag(viewholder);
        }else{
            view = convertView;
            viewholder = (ViewHolder) view.getTag();
        }

        viewholder.imageView_.setImageResource(person.getImageId());
        viewholder.textView_.setText(person.getBirthDuration());

        return view;
    }

    class ViewHolder {
        ImageView imageView_;
        TextView textView_;
    }


}
