package com.wickenhauser.lukas.refreshactivity;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;


public class Stundenplan2 extends ActionBarActivity {

    LinearLayout tag;
    LinearLayout stunden;
    private LinkedList<View> views;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        views=new LinkedList<>();
        setContentView(R.layout.activity_stundenplan2);
        LayoutInflater inflater=this.getLayoutInflater();

        tag=(LinearLayout)findViewById(R.id.layoutTage);
        stunden=(LinearLayout)findViewById(R.id.layoutStunden);

        final TextView t;

        View tage=inflater.inflate(R.layout.tagitem,null);
        t=((TextView)tage.findViewById(R.id.tv_mon));
        t.setText("MONTAG");
        ((TextView)tage.findViewById(R.id.tv_dien)).setText("Dienstag");
        ((TextView)tage.findViewById(R.id.tv_mint)).setText("Mittwoch");
        ((TextView)tage.findViewById(R.id.tv_donn)).setText("Donnerstag");
        ((TextView)tage.findViewById(R.id.tv_frei)).setText("Freitag");
       // Toast.makeText(this,String.valueOf(t.getWidth()),Toast.LENGTH_LONG).show();
        tag.addView(tage,0);

        View stunde;

     //   ((TextView)stunden.findViewById(R.id.tv_mon)).setText("Montag");
     //   ((TextView)stunden.findViewById(R.id.tv_dien)).setText("Dienstag");
     //   ((TextView)stunden.findViewById(R.id.tv_mint)).setText("Mittwoch");
     //   ((TextView)stunden.findViewById(R.id.tv_donn)).setText("Donnerstag");
     //   ((TextView)stunden.findViewById(R.id.tv_frei)).setText("Freitag");
        for (int i =0;i<15;i++) {
            stunde=inflater.inflate(R.layout.stunden_line,null);
            views.add(stunde);
            stunden.addView(stunde, i);
        }
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Toast.makeText(getBaseContext(),String.valueOf(t.getWidth()),Toast.LENGTH_LONG).show();
                findGreatesLength();
            }
        },500);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_stundenplan2, menu);
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

    public void findGreatesLength(){
        int width=tag.getChildAt(0).getWidth();
        for (View acc : views)
        {
            if(((TextView)acc.findViewById(R.id.tv_monFach)).getWidth()>width)
                width=((TextView)acc.findViewById(R.id.tv_monFach)).getWidth();
            if(((TextView)acc.findViewById(R.id.tv_monLehrer)).getWidth()+((TextView)acc.findViewById(R.id.tv_monRaum)).getWidth()>width)
                width=((TextView)acc.findViewById(R.id.tv_monLehrer)).getWidth()+((TextView)acc.findViewById(R.id.tv_monRaum)).getWidth();


            if(((TextView)acc.findViewById(R.id.tv_dieFach)).getWidth()>width)
                width=((TextView)acc.findViewById(R.id.tv_dieFach)).getWidth();
            if(((TextView)acc.findViewById(R.id.tv_dieLehrer)).getWidth()+((TextView)acc.findViewById(R.id.tv_dieRaum)).getWidth()>width)
                width=((TextView)acc.findViewById(R.id.tv_dieLehrer)).getWidth()+((TextView)acc.findViewById(R.id.tv_dieRaum)).getWidth();


            if(((TextView)acc.findViewById(R.id.tv_mitFach)).getWidth()>width)
                width=((TextView)acc.findViewById(R.id.tv_mitFach)).getWidth();
            if(((TextView)acc.findViewById(R.id.tv_mitLehrer)).getWidth()+((TextView)acc.findViewById(R.id.tv_mitRaum)).getWidth()>width)
                width=((TextView)acc.findViewById(R.id.tv_mitLehrer)).getWidth()+((TextView)acc.findViewById(R.id.tv_mitRaum)).getWidth();


            if(((TextView)acc.findViewById(R.id.tv_donFach)).getWidth()>width)
                width=((TextView)acc.findViewById(R.id.tv_donFach)).getWidth();
            if(((TextView)acc.findViewById(R.id.tv_donLehrer)).getWidth()+((TextView)acc.findViewById(R.id.tv_donRaum)).getWidth()>width)
                width=((TextView)acc.findViewById(R.id.tv_donLehrer)).getWidth()+((TextView)acc.findViewById(R.id.tv_donRaum)).getWidth();


            if(((TextView)acc.findViewById(R.id.tv_freiFach)).getWidth()>width)
                width=((TextView)acc.findViewById(R.id.tv_freiFach)).getWidth();
            if(((TextView)acc.findViewById(R.id.tv_monLehrer)).getWidth()+((TextView)acc.findViewById(R.id.tv_freiRaum)).getWidth()>width)
                width=((TextView)acc.findViewById(R.id.tv_monLehrer)).getWidth()+((TextView)acc.findViewById(R.id.tv_freiRaum)).getWidth();

        }

        for (View acc : views)
        {
            acc.setMinimumWidth(width);
        }
        for(int i =0;i<tag.getChildCount();i++)
        {
            tag.getChildAt(i).setMinimumWidth(width);
        }
    }
}
