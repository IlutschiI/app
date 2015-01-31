package com.wickenhauser.lukas.refreshactivity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;


public class Stundenplan extends ActionBarActivity {
    GridView g;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stundenplan);
       // g=(GridView)findViewById(R.id.gridView);
       // g.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new String[]{"Montag", "Dienstag","Mittwoch","Donnerstag","Freitag","bla","bla","bla","bla","bla","bla","bla","bla","bla","bla","bla","bla"}));
        g.setAdapter(new SupplierungsAdapter(this,0,Repository.getInstance().getList()));
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
