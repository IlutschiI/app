package com.wickenhauser.lukas.refreshactivity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.ColorRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Lukas on 1/31/2015.
 */
public class SupplierungsAdapter extends ArrayAdapter<Supplierung> {

    public enum RowType {
        LIST_ITEM, HEADER_ITEM
    }

    Activity context;
    List<Supplierung> list;
    public SupplierungsAdapter(Activity context, int resource, List<Supplierung> objects) {
        super(context, resource, objects);
        this.context=context;
        this.list=objects;
    }

    @Override
    public int getItemViewType(int position) {
        if(position ==4){
            return RowType.HEADER_ITEM.ordinal();
        }

        return RowType.LIST_ITEM.ordinal();
    }
    @Override
    public int getViewTypeCount() {
        return RowType.values().length;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row;
        if(position!=4) {
            row = inflater.inflate(R.layout.listview_column_supplierplan, null);
            Supplierung s = list.get(position);

            TextView abwLehrer = (TextView) row.findViewById(R.id.tv_teacher2);
            TextView verLehrer = (TextView) row.findViewById(R.id.tv_teacher1);
            TextView lessonTyp1 = (TextView) row.findViewById(R.id.tv_lessonTyp1);
            TextView lessonTyp2 = (TextView) row.findViewById(R.id.tv_lessonTyp2);
            TextView suppType = (TextView) row.findViewById(R.id.tv_supp_type);
            TextView lesson = (TextView) row.findViewById(R.id.tv_lesson);

            abwLehrer.setText(s.getAbwLehrer());
            verLehrer.setText(s.getVerLehrer());
            lessonTyp2.setText("(" + s.getFach1() + ")");
            lessonTyp1.setText("(" + s.getFach2() + ")");
            suppType.setText(s.getSuppTyp());
            lesson.setText(String.valueOf(s.getLesson()));
        }
        else
        {
            row=inflater.inflate(android.R.layout.simple_list_item_1,null);
            TextView tv = (TextView)row.findViewById(android.R.id.text1);
            row.setBackgroundDrawable(new ColorDrawable(Color.rgb(66, 165, 245)));
            tv.setText("Neuer Tag");
            tv.setTextColor(Color.WHITE);

        }


        return row;
    }

}
