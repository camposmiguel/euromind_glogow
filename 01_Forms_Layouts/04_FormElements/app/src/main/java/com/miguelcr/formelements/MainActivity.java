package com.miguelcr.formelements;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkboxClicked(View view)
    {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        if(checked) {
            Toast.makeText(this,"Checkbox checked",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"Checkbox Unchecked",Toast.LENGTH_SHORT).show();
        }

    }
}
