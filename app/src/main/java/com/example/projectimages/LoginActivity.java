package com.example.projectimages;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    public static int userID = -1;
    private static final String TAG = "LoginActivity";
    private static final int ERROR_DIALOG_REQUEST = 9001;

    private EditText name;
    private EditText password;
    private Button login;
    private TextView countdownText;
    private CountDownTimer countDownTimer;
    private static final long time = 60000;
    private long timeLeft = time;
    private static int tries = 5;
    private TextView userRegistration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        name = findViewById(R.id.etName);
        password  = findViewById(R.id.etPassword);
        login  = findViewById(R.id.btnLogin);
        countdownText  = findViewById(R.id.countdown_text);
        userRegistration = findViewById(R.id.textViewRegister);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(), password.getText().toString()) ;
                name.setText("");
                password.setText("");
            }
        });

        userRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

    }

//-------------------- Login Validation ------------------------------------------------------------


    private void validate(String userName, String userPassword){
        String type = "login";
        LoginBackgroundActivity backgroundWorkerActivity = new LoginBackgroundActivity(this);

        if(backgroundWorkerActivity.execute(userName, userPassword).equals("User found")){

        }
        else{
            tries--;

            if(tries <= 0) {
                startTimer();
                tries = 5;
            }
        }

    }

//--------------------- Countdown Timer ------------------------------------------------------------

    private void startTimer(){
        countDownTimer = new CountDownTimer(timeLeft, 1000){
            @Override
            public void onTick(long timeTillFinished) {
                timeLeft = timeTillFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                login.setEnabled(true);
                countdownText.setVisibility(View.INVISIBLE);
                timeLeft = time;
            }
        }.start();

        login.setEnabled(false);
        countdownText.setVisibility(View.VISIBLE);

    }

    public void updateTimer() {
        int minutes = (int) (timeLeft / 1000) / 60;
        int seconds = (int) (timeLeft / 1000) % 60;

        String timeLeftText = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);

        countdownText.setText(timeLeftText);

    }

}