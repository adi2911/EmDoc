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

public class Dprofile extends AppCompatActivity {
    public static String demail1;
    Button chgpass,updinfo,logout;
    TextView name,email,phone,add,dspec;
    DatabaseReference reff,reff1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dprofile);
        name = (TextView) findViewById(R.id.duname);
        email = (TextView) findViewById(R.id.duemail);
        phone = (TextView) findViewById(R.id.dphone);
        add = (TextView) findViewById(R.id.daddr);
        dspec = (TextView) findViewById(R.id.dspec);
        chgpass=(Button)findViewById(R.id.changepass);
        updinfo=(Button)findViewById(R.id.updateinfo);
        logout=(Button)findViewById(R.id.plogout);
        reff = FirebaseDatabase.getInstance().getReference().child("Doctors");
        reff1=FirebaseDatabase.getInstance().getReference().child("Fields");

        // Read from the database
        reff1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String demail =dataSnapshot1.child("email").getValue(String.class);
                    if(demail.equals(demail1))
                    {
                        Toast.makeText(Dprofile.this, "Its working true", Toast.LENGTH_SHORT).show();
                        dspec.setText(dataSnapshot1.child("spec").getValue(String.class));

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int i=0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String demail =dataSnapshot1.child("email").getValue(String.class);
                    if(demail.equals(demail1))
                    {
                        name.setText(dataSnapshot1.child("name").getValue(String.class));
                        phone.setText(dataSnapshot1.child("phoneno").getValue(String.class));
                        add.setText(dataSnapshot1.child("address").getValue(String.class));
                        email.setText(demail);
                    }
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
                Toast.makeText(Dprofile.this,"logged out successfuly",Toast.LENGTH_LONG);
                Intent i=new Intent(Dprofile.this,Login.class);
                finish();
                startActivity(i);
            }
        });
    }
}
