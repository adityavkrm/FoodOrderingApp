package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    TextView sign_up_txt;

    EditText emailInput , passwordInput;
    Button loginButton;
    MyDBHelper db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        sign_up_txt = findViewById(R.id.sign_up_btntxt);
        sign_up_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signupActivity.class);
                startActivity(intent);
                finish();
            }
        });


        db = new MyDBHelper(loginActivity.this);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        loginButton = findViewById(R.id.loginbutton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailInput.getText().toString();
                String password = passwordInput.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(loginActivity.this, "All fields required !", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkemailpassword =  db.checkEmailPassword(email,password);

                    if(checkemailpassword == true) {
                        Toast.makeText(loginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        Cursor res = db.fetchname(email);
                        res.moveToFirst();
                            String email_name = res.getString(0);
                            String email_id = res.getString(1);

                        Intent intent = new Intent(loginActivity.this, HomeActivity.class);
                        SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putBoolean("flag",true);
                        editor.putString("NAME",email_name);
                        editor.putString("EMAIL",email_id);
                        editor.apply();
                        startActivity(intent);
                        finish();

                    }else{
                        Toast.makeText(loginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });






    }
}