package net.openwebinars.liststring;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by miguelcampos on 22/1/16.
 */
public class StudentAdapter extends ArrayAdapter<Student> {
    Context context;
    List<Student> lista;
    int layoutItem;


    public StudentAdapter(Context context, int resource, List<Student> objects) {
        super(context, resource, objects);
        this.layoutItem = resource;
        this.context = context;
        this.lista = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // GEt the data from the current student that we're drawing
        Student currentStudent = lista.get(position);
        String sex = currentStudent.getSex();
        String name = currentStudent.getName();
        int age = currentStudent.getAge();

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(layoutItem, parent, false);

        // Get a reference to the elements of the layout
        ImageView icon = (ImageView) v.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
        TextView textViewAge = (TextView) v.findViewById(R.id.textViewAge);
        RelativeLayout relativeLayout = (RelativeLayout)v.findViewById(R.id.layoutItemStudent);


        textViewName.setText(name);
        textViewAge.setText(String.valueOf(age));
        if(sex.equals("male")) {
            icon.setImageResource(R.drawable.ic_male);
        } else {
            icon.setImageResource(R.drawable.ic_female);
        }

        return v;
    }
}
