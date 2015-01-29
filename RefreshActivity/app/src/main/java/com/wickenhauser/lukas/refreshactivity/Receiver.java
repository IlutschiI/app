package com.wickenhauser.lukas.refreshactivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Lukas on 1/29/2015.
 */
public class Receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i =new Intent(context, NotificationService.class);
        context.startService(i);
    }
}
