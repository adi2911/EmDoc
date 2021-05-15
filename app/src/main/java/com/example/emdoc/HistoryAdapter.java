package com.example.emdoc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder> {
    ArrayList<History> history;
    Context context;
    public HistoryAdapter(ArrayList<History> history, Context context)
    {
        this.history=history;
        this.context=context;
    }
    @NonNull
    @Override
    public HistoryAdapter.HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HistoryViewHolder(LayoutInflater.from(context).inflate(R.layout.historycardview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.HistoryViewHolder bookingViewHolder, int i) {
        bookingViewHolder.patname.setText(history.get(i).getPname());
        bookingViewHolder.patemail.setText(history.get(i).getPemail());

    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder
    {
        TextView patname,patemail;
        public HistoryViewHolder(View itemview)
        {
            super(itemview);
            patname=(TextView)itemview.findViewById(R.id.patname);
            patemail=(TextView)itemview.findViewById(R.id.patemail);

        }

    }

}


