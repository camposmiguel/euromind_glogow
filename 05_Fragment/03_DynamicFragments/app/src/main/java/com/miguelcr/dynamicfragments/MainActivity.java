package com.miguelcr.dynamicfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    boolean loadFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment fragment = new FirstFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container,fragment).commit();
        loadFirst = false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.changeFragment:

                Fragment f = null;

                if(loadFirst) {
                    f = new FirstFragment();
                    loadFirst = false;
                } else {
                    f = new SecondFragment();
                    loadFirst = true;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container,f).commit();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
