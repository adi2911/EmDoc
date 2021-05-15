package com.example.emdoc;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class CompletedAppointment extends AppCompatActivity {
    DatabaseReference reff;
    RecyclerView recyclerView;
    ArrayList<History> history;
    CompleteAdapter adapter;
    String pemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.completed_appointment);
        recyclerView=(RecyclerView)findViewById(R.id.completerecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        history=new ArrayList<History>();
        reff= FirebaseDatabase.getInstance().getReference("History");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    pemail=dataSnapshot1.child("pemail").getValue(String.class);
                    if(pemail.equals(Pprofile.pemail1)) {
                        History h = dataSnapshot1.getValue(History.class);
                        history.add(h);
                        }
                }
                adapter=new CompleteAdapter(history,CompletedAppointment.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(CompletedAppointment.this,"Something is wrong",Toast.LENGTH_LONG);
            }
        });


    }
}
