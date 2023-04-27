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

public class signupActivity extends AppCompatActivity {

    EditText enterName, enterEmail, enterContact, enterPassword;

    MyDBHelper db;
    Button signupButton;

    TextView login_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        login_txt = findViewById(R.id.login_btntxt);
        login_txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), loginActivity.class);
                startActivity(i);
                finish();
            }
        });


        db = new MyDBHelper(signupActivity.this);
        enterName = findViewById(R.id.enterName);
        enterEmail = findViewById(R.id.enterEmail);
        enterContact = findViewById(R.id.enterContact);
        enterPassword = findViewById(R.id.enterPassword);
        signupButton = findViewById(R.id.signupbutton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name = enterName.getText().toString();
                String user_email = enterEmail.getText().toString();
                String user_contact = enterContact.getText().toString();
                String user_password = enterPassword.getText().toString();

                if(TextUtils.isEmpty(user_name) || TextUtils.isEmpty(user_email) || TextUtils.isEmpty(user_contact) || TextUtils.isEmpty(user_password)){
                    Toast.makeText(signupActivity.this, "All fields required !", Toast.LENGTH_SHORT).show();
                }else{
                    Boolean checkemail = db.checkEmail(user_email);
                    if(checkemail == false){
                        Boolean insert = db.insertData(user_name,user_email,user_contact, user_password);
                        if(insert == true){
                            Cursor res = db.fetchname(user_email);
                            res.moveToFirst();
                            String email_name = res.getString(0);
                            String email_id = res.getString(1);
                            SharedPreferences pref = getSharedPreferences("login",MODE_PRIVATE);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putBoolean("flag",true);
                            editor.putString("NAME",email_name);
                            editor.putString("EMAIL",email_id);
                            editor.apply();
                            Toast.makeText(signupActivity.this,"Sign up Successfull !", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(signupActivity.this, HomeActivity.class);
                            startActivity(intent);
                            finish();
                        }else {
                            Toast.makeText(signupActivity.this, "Sign up Failed !", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(signupActivity.this, "Email already exists !", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}