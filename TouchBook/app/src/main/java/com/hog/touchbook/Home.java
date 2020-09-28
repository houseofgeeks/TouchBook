package com.hog.touchbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Home extends AppCompatActivity {

    private BottomNavigationView nav;
    private String uid;
    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        uid=getIntent().getExtras().getString("uid");
        System.out.println(uid);
        getSupportActionBar().hide();
        nav = findViewById(R.id.nav);
        nav.setOnNavigationItemSelectedListener(navigate);
        Button save = (findViewById(R.id.button));
        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                save_user();
            }
        });
        downloadJSON("http://progwithme.dx.am/touchbook/get.php?uid="+uid);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigate = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    switch(id)
                    {
                        case 2131230877:
                            Home.this.finish();
                            System.exit(0);
                        case 2131230830:
                            System.out.println("Contact");
                            Bundle dataBundle = new Bundle();
                            dataBundle.putInt("id", 2);
                            Intent intent = new Intent(getApplicationContext(), Account.class);
                            intent.putExtras(dataBundle);
                            intent.putExtra("uid", uid);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            break;
                    }
                    //System.out.println(id);
                    finish();
                    return true;
                }
            };

    private void downloadJSON(final String urlWebService)
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
                    EditText name = (EditText) (findViewById(R.id.editTextTextPersonName));
                    EditText batch = (EditText) (findViewById(R.id.editTextTextPersonName2));
                    EditText email = (EditText) (findViewById(R.id.editTextTextPersonName3));
                    EditText phone = (EditText) (findViewById(R.id.editTextTextPersonName4));
                    EditText company = (EditText) (findViewById(R.id.editTextTextPersonName5));

                    System.out.println(s);
                    Scanner sc = new Scanner(s);
                    String tmp = sc.next().replace("$", " ");
                    name.setText(tmp);
                    tmp = sc.next().replace("$", " ");
                    phone.setText(tmp);
                    tmp = sc.next().replace("$", " ");
                    batch.setText(tmp);
                    tmp = sc.next().replace("$", " ");
                    company.setText(tmp);
                    tmp = sc.next().replace("$", " ");
                    email.setText(tmp);
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                try {
                    final String urlWebServiceM = urlWebService.replace(" ", "$");
                    URL url = new URL(urlWebServiceM);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    System.out.println(con.toString());
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

    void save_user()
    {
        EditText name = (EditText) (findViewById(R.id.editTextTextPersonName));
        EditText batch = (EditText) (findViewById(R.id.editTextTextPersonName2));
        EditText email = (EditText) (findViewById(R.id.editTextTextPersonName3));
        EditText phone = (EditText) (findViewById(R.id.editTextTextPersonName4));
        EditText company = (EditText) (findViewById(R.id.editTextTextPersonName5));
        downloadJSON("http://progwithme.dx.am/touchbook/save.php?name="+name.getText()+"&batch="+batch.getText()+"&email="+email.getText()+"&phone="+phone.getText()+"&company="+company.getText()+"&uid="+uid);
    }

}