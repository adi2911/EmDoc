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

public class PendingAppointment extends AppCompatActivity {
    DatabaseReference reff;
    RecyclerView recyclerView;
    ArrayList<Bookings> bookings;
    BookingAdapter adapter;
    String demail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_appointment);
        recyclerView=(RecyclerView)findViewById(R.id.pendingrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bookings=new ArrayList<Bookings>();
        reff= FirebaseDatabase.getInstance().getReference("Bookings");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                    demail=dataSnapshot1.child("demail").getValue(String.class);
                    System.out.println(("demail="+demail+","+Dprofile.demail1));
                    if(demail.equals(Dprofile.demail1)) {
                        Bookings book = dataSnapshot1.getValue(Bookings.class);
                        System.out.println("booking="+book);
                        bookings.add(book);
                        System.out.println("bookings="+bookings);
                    }
                }
                adapter=new BookingAdapter(bookings,PendingAppointment.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(PendingAppointment.this,"Something is wrong",Toast.LENGTH_LONG);
            }
        });

    }
}
