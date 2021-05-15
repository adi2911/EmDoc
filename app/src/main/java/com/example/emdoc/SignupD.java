package com.example.emdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupD extends AppCompatActivity {
    Button next;
    EditText name,email,pass,repass,degree,address,phoneno,des,timeto,timefrom;
Doctors doc;
static String demail;
    DatabaseReference reff;
    FirebaseDatabase database;
    boolean copy=false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsignup);
        next=(Button)findViewById(R.id.next);
        name=(EditText)findViewById(R.id.dname);
        email=(EditText)findViewById(R.id.demail);
        pass=(EditText)findViewById(R.id.dpassword);
        repass=(EditText)findViewById(R.id.drepassword);
        degree=(EditText)findViewById(R.id.degree);
        address=(EditText)findViewById(R.id.daddress);
        phoneno=(EditText)findViewById(R.id.dphoneno);
        des=(EditText)findViewById(R.id.ddesignation);
        timefrom=(EditText)findViewById(R.id.timingfrom);
        timeto=(EditText)findViewById(R.id.timingto);
        database = FirebaseDatabase.getInstance();
        reff = database.getReference().child("Doctors");
        doc=new Doctors();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String dname = name.getText().toString().trim();
                demail = email.getText().toString().trim();
                final String demail1 = demail;
                final String dpass = pass.getText().toString().trim();
                final String drepass = repass.getText().toString().trim();
                final String deg = degree.getText().toString().trim();
                final String daddress = address.getText().toString().trim();
                final String dphoneno = phoneno.getText().toString().trim();
                final String ddes = des.getText().toString().trim();
                final String from = timefrom.getText().toString().trim();
                final String to = timeto.getText().toString().trim();
                if (dname.equals("") && demail.equals("") && drepass.equals("") && dpass.equals("") && deg.equals("") && daddress.equals("") && dphoneno.equals("") && ddes.equals("") && from.equals("") && to.equals("")) {
                    Toast.makeText(SignupD.this, "please enter the fields", Toast.LENGTH_LONG).show();
                } else if (dname.equals("") || dname.length() > 32) {
                    Toast.makeText(SignupD.this, "please enter the name field", Toast.LENGTH_LONG).show();
                    name.setError("Enter valid name");

                } else if (demail.equals("") || !Patterns.EMAIL_ADDRESS.matcher(demail).matches()) {
                    Toast.makeText(SignupD.this, "please enter the email field", Toast.LENGTH_LONG).show();
                    email.setError("Enter valid email address");

                } else if (dpass.equals("") || dpass.length() > 10) {
                    Toast.makeText(SignupD.this, "please enter the password field", Toast.LENGTH_LONG).show();
                    pass.setError("The password should contain 1-10 characters");

                } else if (drepass.equals("") || !dpass.equals(drepass)) {
                    repass.setError("Re password should be same as password");

                }else if (dphoneno.equals("")||!dphoneno.matches("^[6-9]{1}[0-9]{9}$")) {
                    Toast.makeText(SignupD.this, "please enter the Phone number field", Toast.LENGTH_LONG).show();
                    phoneno.setError("Enter a valid phone no");

                }else if (deg.equals("")) {
                    Toast.makeText(SignupD.this, "please enter the degree field", Toast.LENGTH_LONG).show();
                    degree.setError("Enter valid degree");
                } else if (daddress.equals("")) {
                    Toast.makeText(SignupD.this, "please enter the address field", Toast.LENGTH_LONG).show();
                    address.setError("Enter valid address");
                }
                else if (ddes.equals("")) {
                    Toast.makeText(SignupD.this, "please enter the designation field", Toast.LENGTH_LONG).show();
                    des.setError("Enter valid designation");

                } else if (from.equals("")||!from.matches("^([0-1][0-9]|[2][0-3]):([0-5][0-9])$")) {
                    Toast.makeText(SignupD.this, "please enter the time field", Toast.LENGTH_LONG).show();
                    timefrom.setError("Enter valid Timing");

                } else if (to.equals("")||!to.matches("^([0-1][0-9]|[2][0-3]):([0-5][0-9])$")) {
                    Toast.makeText(SignupD.this, "please enter the time field", Toast.LENGTH_LONG).show();
                    timeto.setError("Enter valid Timing");
                    System.out.print("timeto"+to.toString());
                }
                else {
                    doc.setAddress(daddress);
                    doc.setName(dname);
                    doc.setPass(dpass);doc.setEmail(demail);
                    doc.setDegree(deg);
                                                doc.setPhoneno(dphoneno);
                                                doc.setDes(ddes);
                                                doc.setTimefrom(from);
                                                doc.setTimeto(to);
                                                reff.push().setValue(doc);
                                                Toast.makeText(SignupD.this, "Data Inserted Succesfully", Toast.LENGTH_LONG).show();
                                                Intent i = new Intent(SignupD.this, Specialization.class);
                                                startActivity(i);
                }



                                    }





                });

                }
   /* public boolean copyP()
    { copy=true;
        reff1 = FirebaseDatabase.getInstance().getReference().child("Doctors");
        reff1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String value = dataSnapshot1.child("email").getValue(String.class);
                    if (value.equals(demail)) {
                        copy=false;
                    }

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return copy;
    }
    public boolean copyD()
    {
        copy=true;
        reff2 = FirebaseDatabase.getInstance().getReference().child("Patients");
        reff2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String value = dataSnapshot1.child("email").getValue(String.class);
                    if (value.equals(demail)) {
                        copy=false;
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return copy;
    }*/

}



