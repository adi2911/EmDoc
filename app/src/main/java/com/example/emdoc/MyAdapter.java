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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        ArrayList<Doctors> docInfos;
        Context context;
        public MyAdapter(ArrayList<Doctors> docInfos, Context context)
        {
            this.docInfos=docInfos;
            this.context=context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
           return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,viewGroup,false));
                   }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
            myViewHolder.dcname.setText(docInfos.get(i).getName());
            myViewHolder.dname=docInfos.get(i).getName();
            myViewHolder.dcemail.setText(docInfos.get(i).getEmail());
            myViewHolder.demail=docInfos.get(i).getEmail();
            myViewHolder.dcspec.setText(docInfos.get(i).getDes());
            myViewHolder.dcphoneno.setText(docInfos.get(i).getPhoneno());
            myViewHolder.dphoneno=docInfos.get(i).getPhoneno();
            myViewHolder.dcdeg.setText(docInfos.get(i).getDegree());
            myViewHolder.dctime.setText(docInfos.get(i).getTimefrom()+"-"+docInfos.get(i).getTimeto());
        }

        @Override
        public int getItemCount() {
            return docInfos.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder
        {
            Button book;
            DatabaseReference reff;
            FirebaseDatabase database; Bookings b;
            String demail,dphoneno,dname;
            TextView dcname,dcemail,dcphoneno,dctime,dcdeg,dcspec;
            public MyViewHolder(View itemview)
            {
                super(itemview);
                dcname=(TextView)itemview.findViewById(R.id.dcname);
                dcemail=(TextView)itemview.findViewById(R.id.dcemail);
                dcphoneno=(TextView)itemview.findViewById(R.id.dcphone);
                dctime=(TextView)itemview.findViewById(R.id.dctime);
                dcdeg=(TextView)itemview.findViewById(R.id.dcdeg);
                dcspec=(TextView)itemview.findViewById(R.id.dcdes);
                book=(Button)itemview.findViewById(R.id.bookapp);
                book.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context, "Appointment Booked Successfully", Toast.LENGTH_SHORT).show();
                        database = FirebaseDatabase.getInstance();
                        reff = database.getReference().child("Bookings");
                        b=new Bookings();
                        b.setDemail(demail);
                        b.setDname(dname);
                        b.setDphone(dphoneno);
                        b.setPemail(Pprofile.pemail1);
                        b.setPname(Pprofile.pname);
                        reff.push().setValue(b);
                        Intent i=new Intent(context, PDashboard.class);
                        context.startActivity(i);
                    }
                });
            }

        }

    }


