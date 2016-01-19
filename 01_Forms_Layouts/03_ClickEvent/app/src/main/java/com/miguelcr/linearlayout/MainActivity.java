package com.miguelcr.linearlayout;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView screen;
    int operand1, operand2;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView) findViewById(R.id.textViewScreen);
        screen.setTypeface(Typeface.createFromAsset(getAssets(),"digital_font.ttf"));
    }

    public void writeScreen(View v) {
        int idButton = v.getId();
        String textScreen = screen.getText().toString();

        if (idButton == R.id.button1) {
            screen.setText(textScreen + "1");
        } else if(idButton == R.id.button2) {
            screen.setText(textScreen + "2");
        } else if(idButton == R.id.button3) {
            screen.setText(textScreen + "3");
        } else if(idButton == R.id.buttonAdd) {
            // 1. Save the number that appear in the screen
            if(textScreen=="") {
                operand1 = 0;
            } else {
                operand1 = Integer.valueOf(textScreen);
            }

            // 2. Save the operator
            operator = '+';

            // 3. Clean the screen
            screen.setText("");

        } else if(idButton == R.id.buttonEqual) {
            operand2 = Integer.valueOf(textScreen);

            if(operator=='+') {
                int result = operand1+operand2;
                screen.setText(String.valueOf(result));
            }
        }
    }
}
