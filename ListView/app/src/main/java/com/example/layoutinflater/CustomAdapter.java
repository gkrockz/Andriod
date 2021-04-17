package com.example.layoutinflater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String[] title, subtitle;
    int[] images;

    CustomAdapter(Context context, String[] title, int[] images, String[] subtitle)
    {
        this.context=context;
        this.title=title;
        this.images=images;
        this.subtitle=subtitle;

    }
    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return title[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v=inflater.inflate(R.layout.custom_layout,null);

        ImageView image=v.findViewById(R.id.image);
        TextView titles=v.findViewById(R.id.title);
        TextView subtitles=v.findViewById(R.id.subtitle);

        // setting the values for the resources fetched
        image.setImageResource(images[position]);
        titles.setText(title[position]);
        subtitles.setText(subtitle[position]);

        return v;
    }
}