package com.kedaiit.dev.jadwalin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<UpcomingItem> {
    private List<UpcomingItem> upcomingItemList;

    private Context context;

    public ListViewAdapter(List<UpcomingItem> upcomingItemList, Context context) {
        super(context, R.layout.list_item_upcoming, upcomingItemList);
        this.upcomingItemList = upcomingItemList;
        this.context = context;
    }

    @Override
    public View getView(final int idEvent, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.list_item_upcoming, null, true);

        TextView textViewidEvent = listViewItem.findViewById(R.id.tv_idEvent);
        TextView textViewsstrEvent = listViewItem.findViewById(R.id.tv_strEvent);
        TextView textViewdateEvent = listViewItem.findViewById(R.id.tv_dateEvent);



        UpcomingItem upcomingItem = upcomingItemList.get(idEvent);

        textViewidEvent.setText(upcomingItem.getidEvent());
        textViewsstrEvent.setText(upcomingItem.getstrEvent());
        textViewdateEvent.setText(upcomingItem.getdateEvent());



        return listViewItem;
    }
}
