package com.wickenhauser.lukas.refreshactivity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class Stundenplan3 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stundenplan3);
        LayoutInflater inflater=this.getLayoutInflater();


        TableRow header=(TableRow)findViewById(R.id.tage);
        View mon=inflater.inflate(R.layout.tagitem3,null);
        ((TextView)mon.findViewById(R.id.tv_day)).setText("MONTAG");
        View die=inflater.inflate(R.layout.tagitem3,null);
        ((TextView)die.findViewById(R.id.tv_day)).setText("DIENSTAG");
        View mit=inflater.inflate(R.layout.tagitem3,null);
        ((TextView)mit.findViewById(R.id.tv_day)).setText("MITTWOCH");
        View don=inflater.inflate(R.layout.tagitem3,null);
        ((TextView)don.findViewById(R.id.tv_day)).setText("DONNERSTAG");
        View fre=inflater.inflate(R.layout.tagitem3,null);
        ((TextView)fre.findViewById(R.id.tv_day)).setText("FREITAG");
        header.addView(mon);
        header.addView(die);
        header.addView(mit);
        header.addView(don);
        header.addView(fre);


        LinearLayout layout=(LinearLayout)findViewById(R.id.ll_stund);
        TableRow r1=new TableRow(this);
        r1.addView(inflater.inflate(R.layout.stunden_line,null));r1.addView(inflater.inflate(R.layout.stunden_line,null));


        layout.addView(r1);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stundenplan3, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
