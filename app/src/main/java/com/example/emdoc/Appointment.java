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

public class Appointment extends AppCompatActivity {
    DatabaseReference reff;
    RecyclerView recyclerView;
    ArrayList<Doctors> docInfos;
    public static String spec;

MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);
        recyclerView=(RecyclerView)findViewById(R.id.myrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        docInfos=new ArrayList<Doctors>();
        reff= FirebaseDatabase.getInstance().getReference().child("Doctors");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    Doctors doc=dataSnapshot1.getValue(Doctors.class);
                    docInfos.add(doc);
                    System.out.println("Docs="+docInfos);

            }
                adapter=new MyAdapter(docInfos,Appointment.this);
                recyclerView.setAdapter(adapter);

        }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Appointment.this,"Something is wrong",Toast.LENGTH_LONG);
            }
        });
    }
}
