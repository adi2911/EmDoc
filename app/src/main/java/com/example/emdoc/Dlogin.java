package com.example.emdoc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Dlogin extends AppCompatActivity {
    EditText demail,dpass;
    Button login;
    DatabaseReference reff;
    String email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dlogin);
        demail=(EditText)findViewById(R.id.demail);
        dpass=(EditText)findViewById(R.id.dpass);
        login=(Button)findViewById(R.id.logind);
        reff= FirebaseDatabase.getInstance().getReference().child("Doctors");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final String demail1=demail.getText().toString().trim();
                final String dpass1=dpass.getText().toString().trim();
                System.out.println("email"+demail1);

                if (demail1.equals("") || dpass1.equals("")) {
                    Toast.makeText(Dlogin.this, "Please enter required fields", Toast.LENGTH_SHORT).show();
                    System.out.println("I ran");
                } else {
                    reff.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                        {
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                                email = dataSnapshot1.child("email").getValue(String.class);
                                pass = dataSnapshot1.child("pass").getValue(String.class);
                                if (email.equals(demail1) && pass.equals(dpass1)) {
                                    Toast.makeText(Dlogin.this, "You are logged in sucessfully", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Dlogin.this, DDashboard.class);
                                    Dprofile.demail1=demail1;
                                        startActivity(intent);
                                        finish();

                                    }
                                else
                                {
                                    Toast.makeText(Dlogin.this, "You are logged in sucessfully", Toast.LENGTH_SHORT).show();

                                }


                                }
                            }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


    }

                       }
            });

    }}
