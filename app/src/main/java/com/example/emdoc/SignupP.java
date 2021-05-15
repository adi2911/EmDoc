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

public class SignupP extends AppCompatActivity {
EditText name,email,pass,repass,dob,address,phoneno,des,empid;
Button register;
Patients patient;
String pemail;
    DatabaseReference reff,reff1,reff2;
    FirebaseDatabase database;
    Boolean copy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.psignup);
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);
        repass=(EditText)findViewById(R.id.repassword);
        dob=(EditText)findViewById(R.id.dob);
        address=(EditText)findViewById(R.id.address);
        phoneno=(EditText)findViewById(R.id.phoneno);
        des=(EditText)findViewById(R.id.designation);
        empid=(EditText)findViewById(R.id.empid);
        register=(Button)findViewById(R.id.button);
        patient=new Patients();
        database = FirebaseDatabase.getInstance();
        reff = database.getReference().child("Patients");

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pname=name.getText().toString().trim();
                 pemail=email.getText().toString().trim();
                String ppass=pass.getText().toString().trim();
                String prepass=repass.getText().toString().trim();
                String pdob=dob.getText().toString().trim();
                String paddress=address.getText().toString().trim();
                String pphoneno=phoneno.getText().toString().trim();
                String pdes=des.getText().toString().trim();
                String pempid=empid.getText().toString().trim();
                if(pname.equals("")&&pemail.equals("")&&ppass.equals("")&&prepass.equals("")&&paddress.equals("")&&pphoneno.equals("")&&pdes.equals("")&&pempid.equals("")&&pdob.equals(""))
                {
                    Toast.makeText(SignupP.this,"please enter the fields",Toast.LENGTH_LONG).show();
                }
                else if(pname.equals(""))
                {
                    Toast.makeText(SignupP.this,"please enter the name field",Toast.LENGTH_LONG).show();
                    name.requestFocus();

                }
                else if(pemail.equals("")|| !Patterns.EMAIL_ADDRESS.matcher(pemail).matches())
                {
                    email.setError("Enter valid email address");


                }
                else if(ppass.equals("")|| ppass.length() > 10)
                {
                    pass.setError("The password should contain 1-10 characters");


                }
                else if(prepass.equals("")|| !ppass.equals(prepass))
                {
                    repass.setError("Re password should be same as password");


                }
                else if(pphoneno.equals("")||!pphoneno.matches("^[6-9]{1}[0-9]{9}$"))
                {
                    phoneno.setError("Enter a valid phone no");
                }

                else if(pdob.equals(""))
                {
                    dob.setError("Enter a valid Date of Birth");

                }
                else if(paddress.equals(""))
                {
                    Toast.makeText(SignupP.this,"please enter the address field",Toast.LENGTH_LONG).show();
                    address.requestFocus();

                }
                else if(pdes.equals(""))
                {
                    Toast.makeText(SignupP.this,"ple/ase enter the designation field",Toast.LENGTH_LONG).show();
                    des.requestFocus();

                }
                else if(pempid.equals("")||!(pempid.length()==10))
                {
                    empid.setError("Enter valid empd id");

                }
/*                else if(copyP())
                {
                    email.setError("Email Already exist");
                    email.setText("");
                }
                else if(copyD())
                {
                    email.setError("Email Already exist");
                    email.setText("");
                }*/

                else {
                    patient.setAddress(paddress);
                    patient.setName(pname);
                    patient.setPass(ppass);
                    patient.setEmail(pemail);
                    patient.setDob(pdob);
                    patient.setPhoneno(pphoneno);
                    patient.setDes(pdes);
                    patient.setEmpid(pempid);
                    reff.push().setValue(patient);
                    Toast.makeText(SignupP.this, "Data Inserted Succesfully", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(SignupP.this, Plogin.class);
                finish();
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
                    if (value.equals(pemail)) {
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
                    if (value.equals(pemail)) {
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
