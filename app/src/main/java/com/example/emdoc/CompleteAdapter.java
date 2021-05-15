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

public class CompleteAdapter extends RecyclerView.Adapter<CompleteAdapter.CompleteViewHolder> {
    ArrayList<History> history;
    Context context;
    public CompleteAdapter(ArrayList<History> history, Context context)
    {
        this.history=history;
        this.context=context;
    }
    @NonNull
    @Override
    public CompleteAdapter.CompleteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new CompleteViewHolder(LayoutInflater.from(context).inflate(R.layout.completecardview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CompleteAdapter.CompleteViewHolder viewHolder, int i) {
        viewHolder.docname.setText(history.get(i).getDname());
        viewHolder.docemail.setText(history.get(i).getDemail());
        viewHolder.docphoneno.setText(history.get(i).getDphone());

    }

    @Override
    public int getItemCount() {
        return history.size();
    }

    public class CompleteViewHolder extends RecyclerView.ViewHolder
    {
        Button report;
        TextView docname,docphoneno,docemail;
        public CompleteViewHolder(View itemview)
        {
            super(itemview);
            docname=(TextView)itemview.findViewById(R.id.docname);
            docemail=(TextView)itemview.findViewById(R.id.docemail);
            docphoneno=(TextView)itemview.findViewById(R.id.docphoneno);
            report=(Button)itemview.findViewById(R.id.report);
            report.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Reported Succesfully", Toast.LENGTH_LONG).show();

                }
            });
        }

    }

}


