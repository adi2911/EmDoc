
package com.example.emdoc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button plogin,dlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        plogin=(Button)findViewById(R.id.plogin);
        dlogin=(Button)findViewById(R.id.dlogin);
        plogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,Plogin.class);
                startActivity(i);
            }
        });
        dlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,Dlogin.class);
                startActivity(i);

            }
        });
    }
}
