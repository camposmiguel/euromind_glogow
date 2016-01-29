package com.miguelcr.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextName;
    Button btnSave;
    public static final String USER_PREFS = "USER_PREFS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = (EditText)findViewById(R.id.editTextName);
        btnSave = (Button)findViewById(R.id.buttonSave);

        // Event click on btnSave
        btnSave.setOnClickListener(this);

        // Recover the data if exists, and load
        // into the EdiText
        SharedPreferences settings = getSharedPreferences(USER_PREFS, 0);
        String name = settings.getString("name","");

        editTextName.setText(name);

    }

    @Override
    public void onClick(View v) {
        String userNameText = editTextName.getText().toString();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(USER_PREFS, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("name",userNameText);

        // Complete de edition
        editor.commit();
    }
}
