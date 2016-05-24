package io.github.schef.xmlbible;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.github.schef.xmlbible.Book.Book;
import io.github.schef.xmlbible.Book.Chapter;

/**
 * Created by schef on 5/24/16.
 */

public class ChapterAdapter extends ArrayAdapter<Chapter> {

    Context context;
    int layoutResourceId;
    List<Chapter> data = null;

    public ChapterAdapter(Context context, int layoutResourceId, List<Chapter> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        WeatherHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new WeatherHolder();
            holder.txtNum = (TextView)row.findViewById(R.id.txtNum);
            holder.txtVerse = (TextView)row.findViewById(R.id.txtVerse);

            row.setTag(holder);
        }
        else
        {
            holder = (WeatherHolder)row.getTag();
        }

        Chapter weather = data.get(position);
        holder.txtNum.setText(weather.toString());
        String str = weather.getVerses().get(0).toString();
        if(str.length() > 40) {
            str = str.substring(0, 40);
        }
        holder.txtVerse.setText(":1 - " + str + "...");

        return row;
    }

    static class WeatherHolder
    {
        TextView txtVerse;
        TextView txtNum;
    }
}
