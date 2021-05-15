package com.example.emdoc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class BookedAdapter extends RecyclerView.Adapter<BookedAdapter.BookedViewHolder> {
    ArrayList<Bookings> bookings;
    Context context;
    public BookedAdapter(ArrayList<Bookings> bookings, Context context)
    {
        this.bookings=bookings;
        this.context=context;
    }
    @NonNull
    @Override
    public BookedAdapter.BookedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BookedViewHolder(LayoutInflater.from(context).inflate(R.layout.bookedcardview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BookedAdapter.BookedViewHolder bookedViewHolder, int i) {
        bookedViewHolder.docn.setText(bookings.get(i).getDname());
        bookedViewHolder.doce.setText(bookings.get(i).getDemail());
        bookedViewHolder.docp.setText(bookings.get(i).getDphone());

    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }

    public class BookedViewHolder extends RecyclerView.ViewHolder
    {
        DatabaseReference reff;
        FirebaseDatabase database;
        TextView docp,docn,doce;
        public BookedViewHolder(View itemview)
        {
            super(itemview);
            docn=(TextView)itemview.findViewById(R.id.docn);
            doce=(TextView)itemview.findViewById(R.id.doce);
            docp=(TextView)itemview.findViewById(R.id.docp);
        }

    }

}


