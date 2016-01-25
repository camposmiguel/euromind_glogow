package net.openwebinars.liststring;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView)findViewById(R.id.listView);
        students = new ArrayList<Student>();

        students.add(new Student("male","Piotr",18));
        students.add(new Student("male","Rafal",18));
        students.add(new Student("male","Oskar",17));
        students.add(new Student("male","Marcin",18));
        students.add(new Student("male","Jakub",18));
        students.add(new Student("female","Ada",18));
        students.add(new Student("male","Dawid",18));
        students.add(new Student("male","Norbert",18));
        students.add(new Student("male","Kacper",18));
        students.add(new Student("male","Marcin II",17));
        students.add(new Student("male","Krzysztof",18));
        students.add(new Student("male","Bartek",18));
        students.add(new Student("male","Marcin III",18));
        students.add(new Student("male","Dawid II",18));
        students.add(new Student("male", "Patryk", 18));
        students.add(new Student("male", "Piotr II", 18));

        StudentAdapter adapter = new StudentAdapter(this,R.layout.item_list_student,students);

        lista.setAdapter(adapter);

        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Student: "+students.get(position).getName(),Toast.LENGTH_LONG).show();

        view.animate().rotationX(360).setDuration(2000);
    }
}
