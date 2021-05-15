package com.example.emdoc;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.BookingViewHolder> {
    ArrayList<Bookings> bookings;
    Context context;
    public BookingAdapter(ArrayList<Bookings> bookings, Context context)
    {
        this.bookings=bookings;
        System.out.println("bookingsadp="+bookings);
        this.context=context;
    }
    @NonNull
    @Override
    public BookingAdapter.BookingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BookingViewHolder(LayoutInflater.from(context).inflate(R.layout.bookingcardview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookingAdapter.BookingViewHolder bookingViewHolder, int i) {
        bookingViewHolder.patientn.setText(bookings.get(i).getPname());
        bookingViewHolder.patiente.setText(bookings.get(i).getPemail());
        bookingViewHolder.pname=bookings.get(i).getPname();
        bookingViewHolder.pemail=bookings.get(i).getPemail();
        bookingViewHolder.dname=bookings.get(i).getDname();
        bookingViewHolder.demail=bookings.get(i).getDemail();
        bookingViewHolder.dphone=bookings.get(i).getDphone();

    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public class BookingViewHolder extends RecyclerView.ViewHolder
    {
        Button completed;
        DatabaseReference reff,reff1;
        History h;
        FirebaseDatabase database;// Bookings b;
        String demail,dname,dphone,pname,pemail,pemailr,demailr;
        TextView patientn,patiente;
        public BookingViewHolder(View itemview)
        {
            super(itemview);
            patientn=(TextView)itemview.findViewById(R.id.patientn);
            patiente=(TextView)itemview.findViewById(R.id.patiente);
            completed=(Button)itemview.findViewById(R.id.completedapp);
            database = FirebaseDatabase.getInstance();
            reff = database.getReference().child("History");
            reff1=database.getReference("Bookings");
            h=new History();
            completed.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    h.setDemail(demail);
                    h.setDphone(dphone);
                    h.setDname(dname);
                    h.setPemail(pemail);
                    h.setPname(pname);
                    reff.push().setValue(h);
                    reff1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                                pemailr=dataSnapshot1.child("pemail").getValue(String.class);
                                demailr=dataSnapshot1.child("demail").getValue(String.class);
                                if(pemail.equals(pemailr)&&demail.equals(demailr)) {
                                     dataSnapshot1.getRef().removeValue();
                                }
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    Toast.makeText(context, "Appointment Completed Succesfully", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(context,DDashboard.class);
                    context.startActivity(i);




                }
            });

                }

    }

}


