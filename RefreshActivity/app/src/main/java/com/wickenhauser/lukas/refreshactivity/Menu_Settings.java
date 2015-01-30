package com.wickenhauser.lukas.refreshactivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;


public class Menu_Settings extends ActionBarActivity {

    EditText red;
    EditText blue;
    EditText green;
    LinearLayout color_prev;

    int red_int;
    int blue_int=0;
    int green_int=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_settings);

        red=(EditText)findViewById(R.id.Red);
        blue=(EditText)findViewById(R.id.Blue);
        green=(EditText)findViewById(R.id.Gree);
        color_prev=(LinearLayout) findViewById(R.id.color);

        red.setText(String.valueOf(Color.red(getIntent().getIntExtra("color",0))));
        blue.setText(String.valueOf(Color.blue(getIntent().getIntExtra("color",0))));
        green.setText(String.valueOf(Color.green(getIntent().getIntExtra("color",0))));

        red_int = Integer.parseInt(red.getText().toString());
        blue_int = Integer.parseInt(blue.getText().toString());
        green_int = Integer.parseInt(green.getText().toString());

        updateColor();

        red.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    red_int = Integer.parseInt(s.toString());
                    if(red_int>255){
                        red_int=0;
                        red.setText("");}
                }
                catch(Exception e){}
                updateColor();
            }
        });
        blue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    blue_int = Integer.parseInt(s.toString());
                    if(blue_int>255){
                        blue_int=0;
                        blue.setText("");}
                }
                catch(Exception e){}
                updateColor();
            }
        });
        green.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                try {
                    green_int = Integer.parseInt(s.toString());
                    if (green_int > 255) {
                        green_int = 0;
                        green.setText("");
                    }
                } catch (Exception e) {
                }
                updateColor();
            }
        });
    }

    public void updateColor(){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            // only for gingerbread and newer versions

            color_prev.setBackground(new ColorDrawable(Color.rgb(red_int, green_int, blue_int)));
        }
        else
        color_prev.setBackgroundDrawable(new ColorDrawable(Color.rgb(red_int,green_int,blue_int)));
    }

    public void onSave(View v){

        finish();
    }

    @Override
    public void finish() {
        getIntent().putExtra("red",red_int);
        getIntent().putExtra("blue",blue_int);
        getIntent().putExtra("green",green_int);
        setResult(420,getIntent());
        super.finish();
    }


}
