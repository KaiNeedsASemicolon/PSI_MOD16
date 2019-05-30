package com.example.projectimages;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginBackgroundActivity extends AsyncTask<String,String,String> {
    Context context;
    AlertDialog alertDialog;

    LoginBackgroundActivity(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            String user_name = strings[0];
            String password = strings[1];

            String login_url = "http://79.168.22.42/login.php/?username=" + user_name + "&password=" + password;

            URL url = new URL(login_url);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
            return bf.readLine();

        } catch (Exception e) {
            Log.w("Caught", e);
            return "Can't access the data";
        }
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        Log.w("Caught", result);
        if (result.equals("Cant access the data")) {
            alertDialog.setMessage(result);
            alertDialog.show();
        }
        else if (result.equals("Cant find the user")) {
            alertDialog.setMessage(result);
            alertDialog.show();

        } else {

            LoginActivity.userID = Integer.parseInt(result);
            Intent intent = new Intent(context.getApplicationContext(), HomePageActivity.class);
            context.startActivity(intent);
        }

        super.onPostExecute(result);
    }
}
