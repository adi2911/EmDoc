package com.example.emdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Specialization extends AppCompatActivity {
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c11,c12,c13,c14,c16,c17,c18,c19,c21,c22,c23,c24,c26,c27,c28,c29,c31,c32,c33,c34;
    Button submit;
    FirebaseDatabase database;
    DatabaseReference reff;
    String spec="";
Fields f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.specialization);
        database = FirebaseDatabase.getInstance();
        reff = database.getReference("Fields");
        c1=(CheckBox)findViewById(R.id.checkBox1);
        c2=(CheckBox)findViewById(R.id.checkBox2);
        c3=(CheckBox)findViewById(R.id.checkBox3);
        c4=(CheckBox)findViewById(R.id.checkBox4);
        c5=(CheckBox)findViewById(R.id.checkBox5);
        c6=(CheckBox)findViewById(R.id.checkBox6);
        c7=(CheckBox)findViewById(R.id.checkBox7);
        c8=(CheckBox)findViewById(R.id.checkBox8);
        c9=(CheckBox)findViewById(R.id.checkBox9);
        c11=(CheckBox)findViewById(R.id.checkBox11);
        c12=(CheckBox)findViewById(R.id.checkBox12);
        c13=(CheckBox)findViewById(R.id.checkBox13);
        c14=(CheckBox)findViewById(R.id.checkBox14);
        c16=(CheckBox)findViewById(R.id.checkBox16);
        c17=(CheckBox)findViewById(R.id.checkBox17);
        c18=(CheckBox)findViewById(R.id.checkBox18);
        c19=(CheckBox)findViewById(R.id.checkBox19);
        c21=(CheckBox)findViewById(R.id.checkBox21);
        c22=(CheckBox)findViewById(R.id.checkBox22);
        c23=(CheckBox)findViewById(R.id.checkBox23);
        c24=(CheckBox)findViewById(R.id.checkBox24);
        c26=(CheckBox)findViewById(R.id.checkBox26);
        c27=(CheckBox)findViewById(R.id.checkBox27);
        c28=(CheckBox)findViewById(R.id.checkBox28);
        c29=(CheckBox)findViewById(R.id.checkBox29);
        c31=(CheckBox)findViewById(R.id.checkBox31);
        c32=(CheckBox)findViewById(R.id.checkBox32);
        c33=(CheckBox)findViewById(R.id.checkBox33);
        c34=(CheckBox)findViewById(R.id.checkBox34);
        submit=(Button)findViewById(R.id.submit);
        System.out.print("email="+ SignupD.demail);
        f=new Fields();

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(Specialization.this, "Please enter required fields", Toast.LENGTH_SHORT).show();

                if(c1.isChecked())
                {
                   spec="cardiologists";
                    System.out.print("checked c1");
                }
                else if(c2.isChecked())
                {
                    spec="cr_surgeons";
                }
                else if(c3.isChecked())
                {
                    spec="alergists";
                }
                else if(c4.isChecked()) {
                    spec = "anesthologists";
                }
                else if(c6.isChecked())
                {
                    spec="dermatologists";
                }
                else if(c7.isChecked())
                {
                    spec="endocrinologists";
                }

                else if(c8.isChecked())
                {
                    spec="fphysician";
                }
                else if(c9.isChecked())
                {
                    spec="gastroenterologists";
                }
                else if(c11.isChecked())
                {
                    spec="hematologists";
                }
                else if(c12.isChecked())
                {
                    spec="internists";
                }
                else if(c13.isChecked()) {
                    spec = "geneticists";
                }
               else if(c14.isChecked())
                {
                    spec="nephrologists";
                }
                else if(c16.isChecked())
                {
                    spec="neurologists";

                }
                else if(c17.isChecked())
                {
                    spec="gynecologists";

                }
                else if(c18.isChecked())
                {
                    spec="oncologists";
                }
                else if(c19.isChecked())
                {
                    spec="opthalmologists";
                }
                else if(c21.isChecked()) {
                    spec = "osteopaths";
                }
                else if(c22.isChecked()) {
                    spec = "otolaryngoloists";
                }
                else if(c23.isChecked()) {
                    spec = "pathologist";
                }
                else if(c24.isChecked())
                {
                    spec="pediatricians";
                }
                else if(c26.isChecked())
                {
                    spec="physiatrists";
                }
                else if(c27.isChecked()) {
                    spec = "p_surgeons";
                }
                else if(c28.isChecked()) {
                    spec = "podiatrists";
                }
                else if(c29.isChecked())
                {
                    spec="plumonologists";
                }
                else if(c32.isChecked())
                {
                    spec="rheumatologists";
                }
                else if(c33.isChecked()) {
                    spec = "urologists";
                }
                else if(c34.isChecked()) {
                    spec = "g_surgeon";
                }
                if(spec!=null) {
                    f.setSpec(spec);
                }
                f.setEmail(SignupD.demail);
                reff.push().setValue(f);
                Toast.makeText(Specialization.this, "Data Inserted Succesfully", Toast.LENGTH_LONG).show();
                Intent i=new Intent(Specialization.this,Login.class);
                startActivity(i);
                finish();
            }
        });
    }
}
