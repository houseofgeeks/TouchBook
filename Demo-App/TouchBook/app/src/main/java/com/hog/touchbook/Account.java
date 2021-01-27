package com.hog.touchbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Account extends AppCompatActivity {

    private BottomNavigationView nav;
    private String uid;

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        uid=getIntent().getExtras().getString("uid");
        getSupportActionBar().hide();
        nav = findViewById(R.id.nav);
        nav.setOnNavigationItemSelectedListener(navigate);
        downloadJSON("http://progwithme.dx.am/touchbook/fetch.php");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigate = new
            BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int id = item.getItemId();
                    switch(id)
                    {
                        case 2131230877:
                            Account.this.finish();
                            System.exit(0);

                        case 2131230899:
                            System.out.println("Home");
                            Bundle dataBundle = new Bundle();
                            dataBundle.putInt("id", 2);
                            Intent intent = new Intent(getApplicationContext(), Home.class);
                            intent.putExtras(dataBundle);
                            intent.putExtra("uid", uid);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            break;
                    }
                    //System.out.println(id);
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
                    //System.out.println(s);
                    buildGUI(s);
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

    void buildGUI(String s)
    {
        LinearLayout lr=(LinearLayout) (findViewById(R.id.linear));
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(10,10,10,10);

        Scanner sc = new Scanner(s);
        sc.useDelimiter("~");
        //System.out.println(s);
        while(sc.hasNext())
        {
            String token = sc.next();
            //System.out.println(token);

            if(token.compareTo("") != 0)
            {
                Scanner itr = new Scanner(token);
                String name = itr.next().replace("$"," ");
                String batch = itr.next().replace("$"," ");
                String email = itr.next().replace("$"," ");
                String phone = itr.next().replace("$"," ");
                String company = itr.next().replace("$"," ");
                String data = "   NAME: " + name + "\n   BATCH: " + batch + "\n   EMAIL: " + email + "\n   PHONE:" + phone + "\n   COMPANY: " + company + "\n";
                System.out.println(data);
                final TextView text = new TextView(this);
                text.setLayoutParams(params);
                text.setText(data);
                text.setBackgroundColor(Color.parseColor("#e5335c"));
                text.setTextSize(24);
                text.setTextColor(-1);
                text.setPadding(1, 20, 1, 20);
                text.setGravity(Gravity.LEFT);
                text.setClickable(true);

                text.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Clicked", Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                lr.addView(text);
                itr.close();
            }
        }
        sc.close();
    }
}