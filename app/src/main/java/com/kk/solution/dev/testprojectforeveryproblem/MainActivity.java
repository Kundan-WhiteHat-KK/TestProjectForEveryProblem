package com.kk.solution.dev.testprojectforeveryproblem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSendToNotify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSendToNotify = (Button)findViewById(R.id.mainButton);

        btnSendToNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendToNotifyAct = new Intent(MainActivity.this,SendToNotificationBanner.class);
                startActivity(sendToNotifyAct);
            }
        });
    }
}
