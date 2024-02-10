package com.example.myapplicationnew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login,reset;
    EditText username,password;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button) findViewById(R.id.login_btn);
        reset = (Button)findViewById(R.id.reset_btn);
        username =(EditText) findViewById(R.id.username_input);
        password = (EditText)findViewById(R.id.password_input);
        login.setEnabled(false);
        reset.setEnabled(false);

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (username.getText().toString().trim().equals("") || password.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Username and Password are Required", Toast.LENGTH_LONG).show();
                } else if (username.getText().toString().trim().equals("Smit_45") && password.getText().toString().equals("smit45")) {
                    // Start the SecondActivity and pass the username as an extra
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                    intent.putExtra("Username", username.getText().toString());
                    startActivity(intent);

                } else {
                    Toast.makeText(getApplicationContext(), "Username and Password are Invalid", Toast.LENGTH_LONG).show();
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Reset text fields
                username.getText().clear();
                password.getText().clear();
            }
        });

        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(username.getText().toString().equals(" ")) {
                        username.setBackgroundColor(Color.parseColor("#FF0000"));
                    }else {
                        if(username.getText().toString().equals("Smit_45")) {
                            username.setBackgroundColor(Color.parseColor("#00FF00"));
                            Toast.makeText(MainActivity.this, "green", Toast.LENGTH_SHORT).show();
                        }else {
                            username.setBackgroundColor(Color.parseColor("#FF0000"));
                        }
                    }
                }
            }
        });

        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    if(password.getText().toString().equals(" ")) {
                        password.setBackgroundColor(Color.parseColor("#FF0000"));
                    }else {
                        if(password.getText().toString().equals("smit45")) {
                            password.setBackgroundColor(Color.parseColor("#00FF00"));
                        }else {
                            password.setBackgroundColor(Color.parseColor("#FF0000"));
                        }
                    }

                }
                /*else
                {
                    password.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }*/
            }
        });


        TextWatcher loginWacther = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(username.getText().toString().equals("Smit_45") && password.getText().toString().equals("smit45")){
                    login.setEnabled(true);
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    login.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        username.addTextChangedListener(loginWacther);
        password.addTextChangedListener(loginWacther);
        reset.addTextChangedListener(loginWacther);

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(username.getText().toString().equals("Smit_45") && password.getText().toString().equals("smit45")){
                    login.setEnabled(true);
                    Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    login.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}