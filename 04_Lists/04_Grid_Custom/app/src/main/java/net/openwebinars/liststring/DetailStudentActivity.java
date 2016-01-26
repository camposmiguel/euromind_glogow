package net.openwebinars.liststring;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailStudentActivity extends AppCompatActivity {
    TextView infoUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_student);

        infoUser = (TextView)findViewById(R.id.textViewInfoUser);

        Bundle info = getIntent().getExtras();
        String name = info.getString("studentName");
        int age = info.getInt("studentAge");

        // Set text to TexView with info of user
        infoUser.setText("Name: "+name+", "+"Age: "+age);

    }
}
