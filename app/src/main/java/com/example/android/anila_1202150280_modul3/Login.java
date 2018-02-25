package com.example.android.anila_1202150280_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private ImageView alogo;
    private EditText ausername;
    private EditText apassword;
    public static final String Extra_Message="resii";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        alogo=(ImageView) findViewById(R.id.login);
        ausername=(EditText) findViewById(R.id.username);
        apassword=(EditText) findViewById(R.id.pass);
    }


    public void Login(View view) {
    String user=ausername.getText().toString();
    String pass=apassword.getText().toString();
    if (user.equals("EAD")&& pass.equals("MOBILE")){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(Extra_Message,user);
        startActivity(intent);
        Toast.makeText(this,"Selamat anda berhasil Login",Toast.LENGTH_LONG).show();
    }else {
        Toast toast=Toast.makeText(this,"Maaf Username atau Password anda salah",Toast.LENGTH_SHORT);
        toast.show();
    }

    }
}
