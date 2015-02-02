package com.wickenhauser.lukas.refreshactivity;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Lukas on 2/1/2015.
 */
public class StundenplanHeaderAdapter extends ArrayAdapter<Stunden> {
    private LinkedList<Stunden> list;
    private Activity c;
    int res;
    public StundenplanHeaderAdapter(Activity context, int resource, LinkedList<Stunden> objects) {
        super(context, resource, objects);
        c=context;
        res=resource;
        list=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = c.getLayoutInflater();
        View row=inflater.inflate(R.layout.stunden_item,null);
        TextView lehrer=(TextView)row.findViewById(R.id.tv_Lehrer);
        TextView raum=(TextView)row.findViewById(R.id.tv_Raum);
        TextView fach=(TextView)row.findViewById(R.id.tv_Fach);

                fach.setText(list.get(position).getFach());
                fach.setTextColor(Color.WHITE);
                row.setBackgroundDrawable(new ColorDrawable(Color.rgb(33, 150, 243)));




        return row;
    }
}
