package net.openwebinars.optionsmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Load a layout
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Load a Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    // Control click on the Options Menu Items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.option_settings:
                Toast.makeText(this,"Settings clicked",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_exit:
                Toast.makeText(this,"Exit clicked",Toast.LENGTH_SHORT).show();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
