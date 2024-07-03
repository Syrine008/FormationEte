package com.example.mysecondapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignInActivity extends AppCompatActivity {

    private TextView goToForgetPass ;
    private Button goToSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        goToForgetPass = findViewById(R.id.goToForgetPass);
        goToForgetPass.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this,ForgetPasswordActivity.class));
        });

        goToSignUp = findViewById(R.id.goTosignUp);
        goToSignUp.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this,SignUpActivity.class));
        });

    }
}