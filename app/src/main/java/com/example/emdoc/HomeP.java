package com.example.emdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeP extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_p);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button7);
        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9);
        b10=(Button)findViewById(R.id.button10);
        b11=(Button)findViewById(R.id.button11);
        b12=(Button)findViewById(R.id.button12);
        b13=(Button)findViewById(R.id.button13);
        b14=(Button)findViewById(R.id.button14);
        b15=(Button)findViewById(R.id.button15);
        b16=(Button)findViewById(R.id.button16);
        b17=(Button)findViewById(R.id.button17);
        b18=(Button)findViewById(R.id.button18);
        b19=(Button)findViewById(R.id.button19);
        b20=(Button)findViewById(R.id.button20);
        b21=(Button)findViewById(R.id.button21);
        b22=(Button)findViewById(R.id.button22);
        b23=(Button)findViewById(R.id.button23);
        b24=(Button)findViewById(R.id.button24);
        b25=(Button)findViewById(R.id.button25);
        b26=(Button)findViewById(R.id.button26);
        b27=(Button)findViewById(R.id.button27);
        b28=(Button)findViewById(R.id.button28);
        b29=(Button)findViewById(R.id.button29);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="cardiologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
            startActivity(i);
            }
        });b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="cr_surgeons";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   Appointment.spec="alergists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec = "anesthologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="dermatologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="endocrinologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="fphysician";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="gastroenterologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="hematologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="internists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec = "geneticists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="nephrologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="neurologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="gynecologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="oncologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="opthalmologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec = "osteopaths";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec = "otolaryngoloists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec = "pathologist";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="pediatricians";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="physiatrists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec = "p_surgeons";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec = "podiatrists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="plumonologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="rheumatologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec = "urologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec = "g_surgeon";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="radiologists";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Appointment.spec="colon/rectal surgeons";
                Intent i=new Intent(HomeP.this,Appointment.class);
                startActivity(i);

            }
        });
    }
}
