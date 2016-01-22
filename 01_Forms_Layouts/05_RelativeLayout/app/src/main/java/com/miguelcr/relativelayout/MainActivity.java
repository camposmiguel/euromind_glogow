package com.miguelcr.relativelayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText email, password;
    Button btnLogin;
    boolean userAcceptsConditions = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the reference to the Form Elements
        email = (EditText)findViewById(R.id.editTextEmail);
        password = (EditText)findViewById(R.id.editTextPassword);
        btnLogin = (Button)findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"Message...",Toast.LENGTH_SHORT).show();


        String userEmail = email.getText().toString();
        String userPass = password.getText().toString();

        if(userEmail.equals("hi@goglow.pl") && userPass.equals("1234") && userAcceptsConditions) {
            // If login is ok and user accepts conditions
            Intent i = new Intent(this, UserActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this,"Wrong login",Toast.LENGTH_SHORT).show();
        }


    }

    public void onRadioButtonClicked(View view) {
        switch(view.getId()) {
            case R.id.radio_yes:
                userAcceptsConditions = true;
                break;
            case R.id.radio_no:
                userAcceptsConditions = false;
        }

    }
}
