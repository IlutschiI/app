package com.wickenhauser.lukas.refreshactivity;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class NotificationService extends IntentService {


    public NotificationService() {
        super("NotificationService");
    }
    int c = Color.YELLOW;

    @Override
    protected void onHandleIntent(Intent intent) {
        registerReceiver(receiver,new IntentFilter(MainActivity.BROADCAST_COLOR));
        registerReceiver(receiveNewNotification,new IntentFilter(MainActivity.BROADCAST_Notif));
        sendNotification();
        while(true){}
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            c=intent.getIntExtra("color",0);
        }
    };
    BroadcastReceiver receiveNewNotification = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            sendNotification();
        }
    };
    public void sendNotification(){
        Intent i = new Intent(getBaseContext(), MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(getBaseContext(), 0, i, 0);

        NotificationManager manager=(NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);


        NotificationCompat.Builder b = new NotificationCompat.Builder(getBaseContext())
                .setContentTitle("Sie haben eine neue Supplierung!!!")
                .setContentText("")
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .setLights(c, 1000, 500)
                .setVibrate(new long[]{1000,350,1000})
                .setPriority(Notification.PRIORITY_HIGH)
                ;
        Notification n2 = new NotificationCompat.BigTextStyle(b).bigText("1.D Entfall \n" +
                "2.AM Entfall\n" +
                "3.AM Entfall\n" +
                "4.BSP Entfall\n" +
                "5.BSP Entfall").build();
        n2.defaults=NotificationCompat.PRIORITY_HIGH;
        manager.notify(0,n2);
    }

}
