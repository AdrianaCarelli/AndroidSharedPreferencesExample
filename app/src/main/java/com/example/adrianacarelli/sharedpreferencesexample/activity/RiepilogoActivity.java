package com.example.adrianacarelli.sharedpreferencesexample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.adrianacarelli.sharedpreferencesexample.R;
import com.example.adrianacarelli.sharedpreferencesexample.object.SharedPreferencesUtils;

public class RiepilogoActivity extends AppCompatActivity {

    private TextView mTextNome, mTextCognome, mTextEmail, mTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riepilogo);

        mTextNome = (TextView)findViewById(R.id.textNome);
        mTextCognome = (TextView)findViewById(R.id.textCognome);
        mTextEmail = (TextView) findViewById(R.id.textEmail);
        mTextPhone  = (TextView) findViewById(R.id.textPhone);

        mTextNome.setText(SharedPreferencesUtils.getNome());
        mTextCognome.setText(SharedPreferencesUtils.getCognome());
        mTextEmail.setText(SharedPreferencesUtils.getEmail());
        mTextPhone.setText(SharedPreferencesUtils.getPhone());
    }
}
