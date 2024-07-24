package com.example.mysecondapplication;

import static androidx.constraintlayout.motion.widget.TransitionBuilder.validate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInActivity extends AppCompatActivity {

    private TextView goToForgetPass;

    private EditText email, password;
    private TextView goToSignUp;
    private Button btnSignIn;
    private String emailString,passwordString;
    private final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        goToForgetPass = findViewById(R.id.goToForgetPass);
        email = findViewById(R.id.emailSignIn);
        password = findViewById(R.id.passwordSignIn);
        btnSignIn = findViewById(R.id.btnSignIn);


        goToForgetPass.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this, ForgetPasswordActivity.class));
        });

        goToSignUp = findViewById(R.id.goTosignUp);
        goToSignUp.setOnClickListener(v -> {
            startActivity(new Intent(SignInActivity.this, SignUpActivity.class));
        });

        btnSignIn.setOnClickListener(v -> {
            if (validate()){
                Toast.makeText(this, "Done !", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private boolean validate(){
        boolean res = false ;
        emailString = email.getText().toString().trim();
        passwordString = password.getText().toString().trim();

        if (!isValidPattern(emailString, EMAIL_PATTERN)) {
            email.setError("Email invalide !!");

        } else if (passwordString.length()<8) {
            password.setError("password doit contenir au moins 8 caractères");
            
        }else
            res = true ;

        return res;
    }

    private boolean isValidPattern(String mot, String patternn) {
        Pattern pattern = Pattern.compile(patternn);
        Matcher matcher = pattern.matcher(mot);
        return matcher.matches();
    }
}