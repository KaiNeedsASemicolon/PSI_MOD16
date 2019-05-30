package com.example.projectimages;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class RegisterActivity extends AppCompatActivity {

    private EditText userName;
    private EditText userPassword;
    private EditText userEmail;
    private Button regButton;
    private TextView userLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userName = findViewById(R.id.etUserName);
        userPassword  = findViewById(R.id.etUserPassword);
        userEmail  = findViewById(R.id.etUserEmail);
        regButton  = findViewById((R.id.btnRegister));
        userLogin  = findViewById(R.id.tvUserLogin);

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(userName.getText().toString(), userPassword.getText().toString(), userEmail.toString());
            }
        });

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    private void validate(String name, String password, String email){

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()){
            Toast.makeText(this, "Field(s) are empty", Toast.LENGTH_SHORT).show();
        }
        else{
            RegisterBackgroundActivity registerBackgroundActivity = new RegisterBackgroundActivity(this);
            registerBackgroundActivity.execute(name, password, email);
        }
    }
}
