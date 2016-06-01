package io.github.schef.xmlbible.ShowBooks;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import io.github.schef.xmlbible.Library.Book;
import io.github.schef.xmlbible.Library.Chapter;
import io.github.schef.xmlbible.R;

/**
 * Created by schef on 5/24/16.
 */

public class BookAdapter extends ArrayAdapter<Chapter> {

    Context context;
    int layoutResourceId;
    List<Chapter> data = null;

    public BookAdapter(Context context, int layoutResourceId, List<Chapter> data) {
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
            holder.txtBible = (TextView)row.findViewById(R.id.txtBible);

            row.setTag(holder);
        }
        else
        {
            holder = (WeatherHolder)row.getTag();
        }

        Chapter weather = data.get(position);
        String str = weather.toString();
        if(str.length() > 40) {
            str = str.substring(0, 40);
        }
        holder.txtBible.setText(str);

        return row;
    }

    static class WeatherHolder
    {
        TextView txtBible;
    }
}
