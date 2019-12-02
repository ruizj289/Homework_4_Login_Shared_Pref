package com.example.homework4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.BatchUpdateException;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;
    private String sharedPrefFile =
            "com.example.android.loginsharedprefs";
    EditText name, email, password;
    Button save, retrieve, clear;
    String mName, mEmail, mPassword;

    @Override
    protected void onPause(){
        super.onPause();
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString("NAME_KEY", name.getText().toString());
        preferencesEditor.putString("EMAIL_KEY", email.getText().toString());
        preferencesEditor.putString("PASS_KEY", password.getText().toString());
        preferencesEditor.commit();
    }
    @Override
    protected void onResume(){
        super.onResume();
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        name.setText(mPreferences.getString("NAME_KEY",null));
        email.setText(mPreferences.getString("EMAIL_KEY", null));
        password.setText(mPreferences.getString("PASS_KEY", null));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        save = (Button) findViewById(R.id.save);
        retrieve = (Button) findViewById(R.id.retrieve);
        clear = (Button) findViewById(R.id.clear);


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save();
            }
        });
        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrieve();
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Clear();
            }
        });

    }

    public void Save(){
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.putString("NAME_KEY", name.getText().toString());
        preferencesEditor.putString("EMAIL_KEY", email.getText().toString());
        preferencesEditor.putString("PASS_KEY", password.getText().toString());
        preferencesEditor.commit();
        Toast.makeText(getApplicationContext(), "Information Saved!", Toast.LENGTH_SHORT).show();

    }
    public void Retrieve(){
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
        name.setText(mPreferences.getString("NAME_KEY",null));
        email.setText(mPreferences.getString("EMAIL_KEY", null));
        password.setText(mPreferences.getString("PASS_KEY", null));


    }
    public void Clear(){
        name.setText("");
        email.setText("");
        password.setText("");

    }

}
