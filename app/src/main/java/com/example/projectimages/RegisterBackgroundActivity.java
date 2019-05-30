package com.example.projectimages;

    import android.app.AlertDialog;
    import android.content.Context;
    import android.content.Intent;
    import android.os.AsyncTask;
    import android.util.Log;
    import android.view.View;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.net.HttpURLConnection;
    import java.net.URL;

public class RegisterBackgroundActivity extends AsyncTask<String,String,String>{

    Context context;
    AlertDialog alertDialog;
    RegisterBackgroundActivity (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... strings) {

            try {
                String user_name = strings[0];
                String password = strings[1];
                String email = strings[2];

                String login_url = "http://79.168.22.42/register.php/?username=" + user_name + "&password=" + password+"&email="+email;

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
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        Log.w("Executed", result);

        if (result.equals("Cant access the data") || result.equals("User already exists")) {
            alertDialog.setMessage(result);
            alertDialog.show();
        } else if(result.equals("User registered successfully")){
            alertDialog.setMessage(result);
            alertDialog.show();
            Intent intent = new Intent(context.getApplicationContext(), LoginActivity.class);
            context.startActivity(intent);
        }
        super.onPostExecute(result);

    }
}
