package com.miguelcr.navigationdrawer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    String email, password;
    JSONArray response = new JSONArray();
    EditText userEmail, userPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = (EditText)findViewById(R.id.editTextEmail);
        userPass = (EditText)findViewById(R.id.editTextPassword);
        btnLogin = (Button) findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String currentEmail = userEmail.getText().toString();
        String currentPass = userPass.getText().toString();

        if(!currentEmail.isEmpty() && !currentPass.isEmpty()) {
            new LoginTask().execute(currentEmail,currentPass);
        }
    }

    private class LoginTask extends AsyncTask<String, Void, String> {
        protected String doInBackground(String... credentials) {

            email = credentials[0];
            password = credentials[1];

            return "";
        }

        // We've removed onProgressUpdate method (so receive Void in the
        // second param of the AsyncTask)


        protected void onPostExecute(String result) {

        }
    }

    private void sendRegistrationIdToBackend() {
        URL url = null;
        HttpURLConnection urlConnection = null;

        String registro = "http://rest.miguelcr.com/underground/login?email=" +email+"&password="+ password;

        try {
            url = new URL(registro);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            urlConnection = (HttpURLConnection) url.openConnection();

            int responseCode = urlConnection.getResponseCode();

            if(responseCode == HttpURLConnection.HTTP_OK){
                String responseString = readStream(urlConnection.getInputStream());
                Log.v("CatalogClient", responseString);
                try {
                    response = new JSONArray(responseString);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }else{
                Log.v("CatalogClient", "Response code:"+ responseCode);
            }
        } catch (IOException e) {
            Log.v("CatalogClient", "Error conexión");
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }

    }

    private String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuffer response = new StringBuffer();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return response.toString();
    }

}
