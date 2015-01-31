package com.wickenhauser.lukas.refreshactivity;


import android.app.ActivityManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;

import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RemoteViews;


public class MainActivity extends ActionBarActivity {

    SwipeRefreshLayout swipeLayout;
    public static  final String BROADCAST_COLOR="com.wickenhauser.lukas.refreshactivity";
    public static  final String BROADCAST_Notif="com.wickenhauser.lukas.refreshactivity.Notify";
    int c=Color.YELLOW;
    int up=1;
    ListView lv;
    Intent i = new Intent(BROADCAST_COLOR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Wenn Service noch nicht läuft wird er gestartet
        if (!isMyServiceRunning())
        {

            Intent i =new Intent(this, NotificationService.class);
            this.startService(i);
        }
      //  startService(new Intent(this, NotificationService.class));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getWindow().setStatusBarColor(getResources().getColor(android.R.color.holo_blue_dark));

                // getSupportActionBar().setBackgroundDrawable(new ColorDrawable(android.R.color.holo_purple));
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_container);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh()
                {
                    swipeLayout.setRefreshing(true);
                    new Handler().postDelayed(new Runnable() {
                        @Override public void run() {
                            swipeLayout.setRefreshing(false);
                          //  ((TextView)findViewById(R.id.lb)).setText("update " + up++);

                            sendBroadcast(new Intent(BROADCAST_Notif));

                           /* else {
                                Notification n = new Notification.BigTextStyle(new Notification.Builder(getBaseContext())
                                        .setContentTitle("New mail from " + "test@gmail.com")
                                        .setContentText("Subject")

                                        .setSmallIcon(R.drawable.ic_launcher)
                                        .setContentIntent(pIntent)
                                        .setAutoCancel(true)
                                        .setLights(c, 1000, 500)
                                        .setPriority(Notification.PRIORITY_HIGH))
                                        .bigText("Dies ist der Subtext und wird erst später sichtbar")
                                        .build();

                                n.defaults = Notification.PRIORITY_HIGH;
                              //  RemoteViews r = new RemoteViews(getPackageName(),android.R.layout.simple_list_item_1);
                              //  r.setTextViewText(R.id.textView, "Dies ist der Subtext und wird erst später sichtbar");
                              //  n.bigContentView=r;
                                manager.notify(0,n);
                            }*/
                            //getWindow().setStatusBarColor(getResources().getColor(android.R.color.holo_purple));

                        }
                    }, 5000);

            }
        });
        swipeLayout.setColorSchemeResources(
                android.R.color.holo_orange_light,
                android.R.color.holo_purple,
                android.R.color.holo_red_light);


        lv=(ListView)findViewById(R.id.lvList);
        String[] array=new String[]{"item1","item2","item3","item4","item5","item6","item7","item8","item9","item10","item11","item12","item13","item14","item15","item16"};
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array));
        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if(firstVisibleItem==0 && visibleItemCount>0 && lv.getChildAt(0).getTop()>=0) {
                    swipeLayout.setEnabled(true);
                    if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                        lv.setScrollX(0);
                    }
                }

                else
                    swipeLayout.setEnabled(false);
            }
        });

    }


    private boolean isMyServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if ("com.wickenhauser.lukas.refreshactivity.NotificationService".equals(service.service.getClassName())) {

                return true;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();

       // getActionBar().setBackgroundDrawable(new ColorDrawable(android.R.color.holo_blue_bright));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent i = new Intent(this, Menu_Settings.class);
            i.putExtra("color", c);
            startActivityForResult(i, 420);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int green;
        int red;
        int blue;
        if(requestCode==420)
        {
            green=data.getIntExtra("green",0);
            red=data.getIntExtra("red",0);
            blue=data.getIntExtra("blue",0);
            c=Color.rgb(red,green,blue);
            i.putExtra("color", c);
            sendBroadcast(i);
        }
    }
}
