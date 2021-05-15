package com.example.emdoc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Pprofile extends AppCompatActivity {
    public static String pemail1,pname;
    Button chgpass,updinfo,logout;
    TextView name,email,phone,add,dob,des,id;
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pprofile);
        name = (TextView) findViewById(R.id.uname);
        email = (TextView) findViewById(R.id.uemail);
        phone = (TextView) findViewById(R.id.phone);
        add = (TextView) findViewById(R.id.addr);
        id = (TextView) findViewById(R.id.pid);
        des = (TextView) findViewById(R.id.des);
        dob = (TextView) findViewById(R.id.dob);
        chgpass=(Button)findViewById(R.id.changepass);
        updinfo=(Button)findViewById(R.id.updateinfo);
        logout=(Button)findViewById(R.id.plogout);
        reff = FirebaseDatabase.getInstance().getReference().child("Patients");
        System.out.println("Pname pprofile="+pname);


        // Read from the database
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i=0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String pemail =dataSnapshot1.child("email").getValue(String.class);
                    if(pemail.equals(pemail1))
                    {
                        Toast.makeText(Pprofile.this, "Its working true", Toast.LENGTH_SHORT).show();
                        name.setText(dataSnapshot1.child("name").getValue(String.class));
                        phone.setText(dataSnapshot1.child("phoneno").getValue(String.class));
                        dob.setText(dataSnapshot1.child("dob").getValue(String.class));
                        des.setText(dataSnapshot1.child("des").getValue(String.class));
                        id.setText(dataSnapshot1.child("empid").getValue(String.class));
                        add.setText(dataSnapshot1.child("address").getValue(String.class));
                        email.setText(pemail);

                    }
                    }
                 if(i==0)
                {
                    Toast.makeText(Pprofile.this, "Sorry Its not working", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });
    logout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(Pprofile.this,"logged out successfuly",Toast.LENGTH_LONG);
            Intent i=new Intent(Pprofile.this,Login.class);
            finish();
            startActivity(i);
        }
    });
    }


}
