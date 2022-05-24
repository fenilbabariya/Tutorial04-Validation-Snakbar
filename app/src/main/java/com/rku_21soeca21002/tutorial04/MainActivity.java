package com.rku_21soeca21002.tutorial04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    TextInputEditText txtUsername,txtPassword;
    View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPasssword);
        btnLogin = findViewById(R.id.btnLogin);
        root = findViewById(R.id.rootLoginLayout);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String valUsername = txtUsername.getText().toString().trim();
                String valPassword = txtPassword.getText().toString();

                if(valUsername.equals("")){
                    Snackbar.make(root,"Username must not be empty", BaseTransientBottomBar.LENGTH_LONG).show();
                    return;
                }

                if(valPassword.equals("")){
                    Snackbar.make(root,"Password must not be empty",BaseTransientBottomBar.LENGTH_LONG).show();
                    return;
                }

                if(valPassword.length() < 6){
                    Snackbar.make(root,"Password must not be less than 6 letter",BaseTransientBottomBar.LENGTH_LONG).show();
                    return;
                }

                if(!Patterns.EMAIL_ADDRESS.matcher(valUsername).matches()){
                    Snackbar.make(root,"Username must be Email Address",BaseTransientBottomBar.LENGTH_LONG).show();
                    return;
                }

                if(valUsername.equals("admin@gmail.com") && valPassword.equals("123456")){
                    startActivity(new Intent(MainActivity.this,Welcome.class));
                    finish();
                }else{
                    Snackbar.make(root,"Invalid Credentials",BaseTransientBottomBar.LENGTH_LONG).show();
                }

            }
        });

    }
}