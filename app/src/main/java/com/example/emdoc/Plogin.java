package com.example.emdoc;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Plogin extends AppCompatActivity {
    EditText pemail,ppass;
    Button login;
    public String email,pass;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plogin);
        pemail=(EditText)findViewById(R.id.pemail);
        ppass=(EditText)findViewById(R.id.ppass);
        login=(Button)findViewById(R.id.loginp);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pemail.getText().toString().equals("") || ppass.getText().toString().equals("")) {
                    Toast.makeText(Plogin.this, "Please enter required fields", Toast.LENGTH_SHORT).show();

                } else {
                    reff= FirebaseDatabase.getInstance().getReference().child("Patients");
                    reff.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                        {
                            int i=1;
                            for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()) {
                                email = dataSnapshot1.child("email").getValue(String.class);
                                pass = dataSnapshot1.child("pass").getValue(String.class);
                                if (email.equals(pemail.getText().toString().trim()) && pass.equals(ppass.getText().toString().trim())) {
                                    Toast.makeText(Plogin.this, "You are logged in sucessfully", Toast.LENGTH_SHORT).show();
                                   Pprofile.pemail1=email;
                                   Pprofile.pname= dataSnapshot1.child("name").getValue(String.class);
                                   System.out.println("Pname plogin="+Pprofile.pname);
                                   i=0;
                                    //Pprofile p=new Pprofile();
                                    //p.setUemail(email);
                                    Intent intent = new Intent(Plogin.this, PDashboard.class);
                                    startActivity(intent);


                                }


                            }
                            if(i==1)
                        {
                            Toast.makeText(Plogin.this, "You are not logged in check email or password ", Toast.LENGTH_SHORT).show();

                        }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }

            }
        });
    }
}
