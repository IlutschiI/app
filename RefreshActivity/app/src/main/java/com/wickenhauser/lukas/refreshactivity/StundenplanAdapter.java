package com.wickenhauser.lukas.refreshactivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.zip.Inflater;

/**
 * Created by Lukas on 2/1/2015.
 */
public class StundenplanAdapter extends ArrayAdapter<Stunden> {
    private LinkedList<Stunden> list;
    private Activity c;
    int res;
    public StundenplanAdapter(Activity context, int resource, LinkedList<Stunden> objects) {
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

                if(list.get(position).getFach()!="---") {
                    fach.setText(list.get(position).getFach());
                    raum.setText(list.get(position).getRaum());
                    lehrer.setText(list.get(position).getLehrer());
                    row.setBackgroundDrawable(new ColorDrawable(Color.rgb(187, 222, 251)));
                }
                else
                {
                    row.setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                }




        return row;
    }
}
