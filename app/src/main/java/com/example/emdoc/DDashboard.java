package com.example.emdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DDashboard extends AppCompatActivity {
    ImageView dprofile,pappointment,ahistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ddashboard);
        dprofile=(ImageView)findViewById(R.id.dprofile);
        pappointment=(ImageView)findViewById(R.id.pappointment);
        ahistory=(ImageView)findViewById(R.id.ahistory);
        dprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DDashboard.this,Dprofile.class);
                startActivity(i);
            }
        });
        pappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DDashboard.this,PendingAppointment.class);
                startActivity(i);

            }
        });
        ahistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DDashboard.this,AppointmentHistory.class);
                startActivity(i);

            }
        });

    }
}
