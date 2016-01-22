package com.miguelcr.addtrainer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int randomOne, randomTwo;
    TextView randomOperation;
    int correctSolution;
    EditText userSolution;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        userSolution = (EditText)findViewById(R.id.solution);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userNumber = Integer.valueOf(userSolution.getText().toString());
                if(correctSolution==userNumber) {
                    Snackbar.make(view, "Correct", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    randomOperation.setText("Good!!!!");
                    userSolution.setVisibility(View.INVISIBLE);
                } else {
                    Snackbar.make(view, "Incorrect, try again", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
         });

        randomOperation = (TextView)findViewById(R.id.textViewOperation);
        generateRandomNumbers();
    }

    private void generateRandomNumbers() {
        randomOne = 0 + (int)(Math.random() * 100);
        randomTwo = 0 + (int)(Math.random() * 100);

        correctSolution = randomOne + randomTwo;

        // set TextView with the random numbers
        randomOperation.setText(randomOne+" + "+randomTwo+" = ?");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
