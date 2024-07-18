package com.example.mysecondapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ForgetPasswordActivity extends AppCompatActivity {

    private Button goToSignIn ;
    private EditText email;
    private Button btnForgPass;
    private String emailString;
    private final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forget_password);

        goToSignIn = findViewById(R.id.goTosignIn);
        email = findViewById(R.id.emailForgPass);
        btnForgPass = findViewById(R.id.btnForgPass);


        goToSignIn.setOnClickListener(v -> {
            startActivity(new Intent(ForgetPasswordActivity.this,SignInActivity.class));
        });

        btnForgPass.setOnClickListener(v->{
            if (validate()){
                Toast.makeText(this, "Done !", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private boolean validate(){
        boolean res = false;
        emailString = email.getText().toString().trim();
        if(!isValidPattern(emailString, EMAIL_PATTERN)) {
            email.setError("Email invalide !!");

        }else
            res = true;
        return res;
    }
    private boolean isValidPattern(String mot, String patternn) {
        Pattern pattern = Pattern.compile(patternn);
        Matcher matcher = pattern.matcher(mot);
        return matcher.matches();
    }
}