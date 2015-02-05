package com.wickenhauser.lukas.refreshactivity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;


public class Stundenplan extends ActionBarActivity {
    GridView g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stundenplan);


        LinkedList<Stunden> list = new LinkedList<>();
        LinkedList<Stunden> header = new LinkedList<>();

        header.add(new Stunden("MONTAG","",""));
        header.add(new Stunden("DIENSTAG","",""));
        header.add(new Stunden("MITTWOCH","",""));
        header.add(new Stunden("DONNERSTAG","",""));
        header.add(new Stunden("FREITAG","",""));

        //1
        list.add(new Stunden("DBI","Holzer","151"));
        list.add(new Stunden("E","Prieler","151"));
        list.add(new Stunden("DBI","Holzer","151"));
        list.add(new Stunden("AM","Reichinger","151"));
        list.add(new Stunden("DBI","Holzer","151"));

        //2
        list.add(new Stunden("RK","Brenn","151"));
        list.add(new Stunden("SEP","Hartl","151"));
        list.add(new Stunden("GS","Keplinger","151"));
        list.add(new Stunden("D","Keplinger","151"));
        list.add(new Stunden("DBI","Holzer","151"));

        //3
        list.add(new Stunden("GW/AM","Täubel/Reichinger","151"));
        list.add(new Stunden("SEP","Hartl","151"));
        list.add(new Stunden("E","Prieler","151"));
        list.add(new Stunden("D","Keplinger","151"));
        list.add(new Stunden("PROO","Bucek","151"));

        //4
        list.add(new Stunden("GW/AM","Täubel/Reichinger","151"));
        list.add(new Stunden("SYP","TStütz","151"));
        list.add(new Stunden("BOBW","Traunmüller","151"));
        list.add(new Stunden("NVS","Lackinger","151"));
        list.add(new Stunden("PROO","Bucek","151"));

        //5
        list.add(new Stunden("BSPK","Kerschner","151"));
        list.add(new Stunden("---","---","---"));
        list.add(new Stunden("---","---","---"));
        list.add(new Stunden("NVS","Lackinger","151"));
        list.add(new Stunden("RK","Brenn","151"));

        //6
        list.add(new Stunden("BSPK","Kerschner","151"));
        list.add(new Stunden("SYP","Stütz/Bucek","151"));
        list.add(new Stunden("NWGP","Ruckerbauer","151"));
        list.add(new Stunden("---","---","---"));
        list.add(new Stunden("---","---","---"));

        //7
        list.add(new Stunden("---","---","---"));
        list.add(new Stunden("SYP","Stütz/Bucek","151"));
        list.add(new Stunden("NWGC","Schweiger","151"));
        list.add(new Stunden("NVS","Simon","151"));
        list.add(new Stunden("PROO","BUCEK","151"));

        //8
        list.add(new Stunden("---","---","---"));
        list.add(new Stunden("SYP","Stütz/Bucek","151"));
        list.add(new Stunden("RWBW","Weginger","151"));
        list.add(new Stunden("NVS","Simon","151"));
        list.add(new Stunden("PROO","Bucek","151"));

        //9
        list.add(new Stunden("---","---","---"));
        list.add(new Stunden("E1K","Willmann","151"));
        list.add(new Stunden("BSPM","Gross","151"));
        list.add(new Stunden("REBW","Krückel","151"));
        list.add(new Stunden("PROO","Bucek","151"));

        //10
        list.add(new Stunden("---","---","---"));
        list.add(new Stunden("E1K","Willmann","151"));
        list.add(new Stunden("BSPM","Gross","151"));
        list.add(new Stunden("REBW","Krückel","151"));
        list.add(new Stunden("---","---","---"));






        ((GridView)findViewById(R.id.gvHeader)).setAdapter(new StundenplanHeaderAdapter(this,1,header));

        g=(GridView)findViewById(R.id.gridView);
       // g.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new String[]{"Montag", "Dienstag","Mittwoch","Donnerstag","Freitag","bla","bla","bla","bla","bla","bla","bla","bla","bla","bla","bla","bla"}));
        g.setAdapter(new StundenplanAdapter(this, 0 , list));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.manu_stundenplan, menu);
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
            //Toast.makeText(this,String.valueOf(((TextView) findViewById(R.id.textView6)).getWidth()),Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
