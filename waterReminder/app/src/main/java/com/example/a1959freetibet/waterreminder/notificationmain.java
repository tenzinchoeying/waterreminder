package com.example.a1959freetibet.waterreminder;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/*In androidManifest you need to have this line below.
 *<receiver android:name="com.example.akeat.finalnotifications.NotificationPublisher"/>
 *Also in the modular level gradle file put this line VVV
 *implementation "com.android.support:support-compat:27.1.1"
 */
/*I made the notifications come from a menu because I followed a tutorial
 * but you ill go ahead and comment the important parts that actually make the notification.
 * That way its as easy as possible for whoever is combining code.
 */


/*
 * if youre going to use the menu to test it out, you have to make sure that you create
 * menu in the res folder. to do that,  right click on res. make a new resource directory and
 * change the value to menu. then put the main.xml  into menu on res. ill also include the photo
 * i used for the little water droplet on the notification.
 * */

public class notificationmain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        scheduleNotification(getNotification("Put the amount of time here ->, could be a variable or whatever"), 1000);
    }


    //this sets up the intent for the notification
    //as well as the pending intent so we can schedule it for some time in the future
    //you should pretty much be able to just copy paste these into the rest of the code and just call
    //liune 61 whenever a user puts in how often they want to be reminded.
    private void scheduleNotification(Notification notification, int delay){
        Intent notifIntent = new Intent(this, NotificationPublisher.class);
        notifIntent.putExtra(NotificationPublisher.NOTIFICATION_ID,1);
        notifIntent.putExtra(NotificationPublisher.NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,notifIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        long futureInMillis = SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    /*
     * this is also a needed component to actually build the notification
     * */
    private Notification getNotification(String content){
        final Intent emptyIntent = new Intent(this, NotificationPublisher.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, emptyIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.water)
                .setContentTitle("Drink some water")
                .setContentText("drink. some. water.")
                .setContentIntent(pendingIntent);
        return mBuilder.build();
    }
}
