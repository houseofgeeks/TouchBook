package com.hog.touchbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Button login = (findViewById(R.id.button4));
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                check_user();
            }
        });
        Button register = (findViewById(R.id.button6));
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                register_user();
            }
        });
    }

    private void authenticate(final String urlWebService)
    {

        class DownloadJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try
                {
                    System.out.println((s));
                    String uid=s;
                    if(uid.compareToIgnoreCase("")==0)
                    {
                        Toast.makeText(getApplicationContext(),"User Not Found", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Bundle dataBundle = new Bundle();
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        intent.putExtras(dataBundle);
                        dataBundle.putInt("id", 1);
                        intent.putExtra("uid",uid);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    return null;
                }
            }
        }
        DownloadJSON getJSON = new DownloadJSON();
        getJSON.execute();

    }

    private void register(final String urlWebService)
    {

        class DownloadJSON extends AsyncTask<Void, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }


            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                try
                {
                    System.out.println((s));
                    String uid=s;
                    if(uid.compareToIgnoreCase("")==0)
                    {
                        Toast.makeText(getApplicationContext(),"Registration Failed", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Bundle dataBundle = new Bundle();
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        dataBundle.putInt("id", 1);
                        intent.putExtras(dataBundle);
                        intent.putExtra("uid",uid);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL(urlWebService);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String json;
                    while ((json = bufferedReader.readLine()) != null) {
                        sb.append(json + "\n");
                    }
                    return sb.toString().trim();
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                    return null;
                }
            }
        }
        DownloadJSON getJSON = new DownloadJSON();
        getJSON.execute();

    }


    void register_user()
    {
        EditText user = (EditText) (findViewById(R.id.editText2));
        EditText pass = (EditText) (findViewById(R.id.editTextTextPassword2));

        String userid = user.getText().toString();
        String password = pass.getText().toString();

        if(userid.compareToIgnoreCase("") == 0 || password.compareToIgnoreCase("") == 0)
        {
            Toast.makeText(getApplicationContext(),"Registratio Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            register("http://progwithme.dx.am/touchbook/register.php?userid="+userid+"&password="+password);
        }
    }

    void check_user()
    {
        EditText user = (EditText) (findViewById(R.id.editText2));
        EditText pass = (EditText) (findViewById(R.id.editTextTextPassword2));

        String userid = user.getText().toString();
        String password = pass.getText().toString();

        if(userid.compareToIgnoreCase("") == 0 || password.compareToIgnoreCase("") == 0)
        {
            Toast.makeText(getApplicationContext(),"Login Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            authenticate("http://progwithme.dx.am/touchbook/login.php?userid="+userid+"&password="+password);
        }
    }
}