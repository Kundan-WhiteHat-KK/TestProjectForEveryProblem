package com.kk.solution.dev.testprojectforeveryproblem;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class SendToNotificationBanner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_to_notification_banner);
    }

    public void displayNotification(View view)  {

        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        final int notify_id = 1;
        final NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("Download Status...");
        builder.setContentText("Download in Progress..");

        new Thread(new Runnable() {
            @Override
            public void run() {
                int icr;

                for (icr = 0; icr<=100;icr+=5)  {

                    builder.setProgress(100,icr,false);
                    notificationManager.notify(notify_id,builder.build());

                    try {
                        Thread.sleep(2*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                builder.setProgress(0,0,false);
                builder.setContentText("Download Completed...");
                notificationManager.notify(notify_id,builder.build());
            }
        }).start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}