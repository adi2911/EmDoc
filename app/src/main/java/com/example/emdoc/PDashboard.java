package com.example.emdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PDashboard extends AppCompatActivity {
    ImageView profile,appointment,ambulance,reports,bedbook,history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdashboard);
        profile=(ImageView)findViewById(R.id.profile);
        appointment=(ImageView)findViewById(R.id.appointment);
        ambulance=(ImageView)findViewById(R.id.ambulance);
        reports=(ImageView)findViewById(R.id.reports);
        bedbook=(ImageView)findViewById(R.id.bedbook);
        history=(ImageView)findViewById(R.id.history);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PDashboard.this,Pprofile.class);
                startActivity(i);
            }
        });
        appointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PDashboard.this,HomeP.class);
                startActivity(i);

            }
        });
        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PDashboard.this,Ambulance.class);
                startActivity(i);
            }
        });
        reports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PDashboard.this,Reports.class);
                startActivity(i);

            }
        });
        bedbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PDashboard.this,Bedbooking.class);
                startActivity(i);

            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(PDashboard.this, MedHistory.class);
                startActivity(i);

            }
        });

    }
}
