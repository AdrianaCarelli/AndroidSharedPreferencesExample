package com.example.adrianacarelli.sharedpreferencesexample.activity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.adrianacarelli.sharedpreferencesexample.R;
import com.example.adrianacarelli.sharedpreferencesexample.object.SharedPreferencesUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditTextNome;
    private EditText mEditTextCognome;
    private EditText mEditTextEmail;
    private EditText mEditTextPhone;
    private Button mButtonRegistrati;
    private Button mButtonCancella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditTextNome = (EditText)findViewById(R.id.editTextNome);
        mEditTextCognome = (EditText)findViewById(R.id.editTextCognome);
        mEditTextEmail = (EditText)findViewById(R.id.editTextEmail);
        mEditTextPhone = (EditText)findViewById(R.id.editTextTelefono);
        mButtonRegistrati = (Button)findViewById(R.id.buttonRegistrati);
        mButtonCancella = (Button)findViewById(R.id.buttonCancella);

        mButtonRegistrati.setOnClickListener(this);
        mButtonCancella.setOnClickListener(this);

        if(SharedPreferencesUtils.getNome().equalsIgnoreCase("")&& SharedPreferencesUtils.getCognome().equalsIgnoreCase("")
                && SharedPreferencesUtils.getEmail().equalsIgnoreCase("")&& SharedPreferencesUtils.getPhone().equalsIgnoreCase("")){
            mButtonRegistrati.setText(getResources().getString(R.string.registrati));
        }else{
            mButtonRegistrati.setText(getResources().getString(R.string.entra));
            mEditTextNome.setText(SharedPreferencesUtils.getNome());
            mEditTextCognome.setText(SharedPreferencesUtils.getCognome());
            mEditTextEmail.setText(SharedPreferencesUtils.getEmail());
            mEditTextPhone.setText(SharedPreferencesUtils.getPhone());
        }
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.buttonRegistrati:

                checkEditText();

                break;
            case R.id.buttonCancella:

                cancelData();
                break;
        }


    }

    private  void checkEditText(){

        String nome = mEditTextNome.getText().toString();
        String cognome = mEditTextCognome.getText().toString();
        String email = mEditTextEmail.getText().toString();
        String phone = mEditTextPhone.getText().toString();

        if(!nome.isEmpty()&& !cognome.isEmpty() && !email.isEmpty()&& !phone.isEmpty()){
            //start Activity

            SharedPreferencesUtils.setNome(nome);
            SharedPreferencesUtils.setCognome(cognome);
            SharedPreferencesUtils.setEmail(email);
            SharedPreferencesUtils.setPhone(phone);

            Intent intent = new Intent(this, RiepilogoActivity.class);
            intent.putExtra("key", ""); //Optional parameters
            this.startActivity(intent);

        }else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("ATTENZIONE");
            builder.setMessage("Devi compliare tutti i campi!");
            builder.setPositiveButton("OK", null);

            builder.show();
        }
    }

    private void cancelData(){

        mEditTextNome.setText("");
        mEditTextCognome.setText("");
        mEditTextEmail.setText("");
        mEditTextPhone.setText("");
    }
}
