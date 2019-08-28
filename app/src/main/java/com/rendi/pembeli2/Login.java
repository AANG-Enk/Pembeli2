package com.rendi.pembeli2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button daftar = (Button) findViewById(R.id.btndaftar);

        daftar.setOnClickListener(this);

    }

    @Override
    public void onClick(View i) {
        if (i == daftar){
            Intent registrasi = new Intent(getApplicationContext(), Registrasi.class);
            startActivity(registrasi);
        }
    }
}
