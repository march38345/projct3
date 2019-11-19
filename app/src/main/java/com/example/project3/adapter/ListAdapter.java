package com.example.project3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project3.db.Game;
import com.example.project3.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {
    private List<Game> gameList = new ArrayList<>();

    private Context context;
    public ListAdapter(Context context, List<Game> gameList){
        this.context=context;
        this.gameList = gameList;

    }

    @Override
    public int getCount() {
        if(gameList == null){
            return 0;
        }
        return gameList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item,parent,false);
        ImageView image = (ImageView) view.findViewById(R.id.imageview);
        TextView name = (TextView) view.findViewById(R.id.name);
        TextView price = (TextView) view.findViewById(R.id.price);

        image.setImageResource(gameList.get(position).getPicid());
        name.setText(gameList.get(position).getName());
        price.setText(gameList.get(position).getPrice());
        return view;
    }
}
