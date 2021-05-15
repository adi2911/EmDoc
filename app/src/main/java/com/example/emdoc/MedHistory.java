package com.example.emdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MedHistory extends AppCompatActivity {
Button booked,completed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medhistory);
        booked=(Button)findViewById(R.id.booked);
        completed=(Button)findViewById(R.id.completed);
        booked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MedHistory.this, BookedAppointment.class);
                startActivity(i);
            }
        }); completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MedHistory.this,CompletedAppointment.class);
                startActivity(i);
            }
        });
    }
}
