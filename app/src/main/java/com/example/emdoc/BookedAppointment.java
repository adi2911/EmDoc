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

public class BookedAppointment extends AppCompatActivity {

    DatabaseReference reff;
    RecyclerView recyclerView;
    ArrayList<Bookings> bookings;
    BookedAdapter adapter;
    String pemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.booked_appointment);
        recyclerView=(RecyclerView)findViewById(R.id.bookedrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookings=new ArrayList<Bookings>();
        reff= FirebaseDatabase.getInstance().getReference("Bookings");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    pemail=dataSnapshot1.child("pemail").getValue(String.class);
                    if(pemail.equals(Pprofile.pemail1)) {
                        Bookings book = dataSnapshot1.getValue(Bookings.class);
                        bookings.add(book);
                    }
                }
                adapter=new BookedAdapter(bookings,BookedAppointment.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(BookedAppointment.this,"Something is wrong",Toast.LENGTH_LONG);
            }
        });

    }
}
