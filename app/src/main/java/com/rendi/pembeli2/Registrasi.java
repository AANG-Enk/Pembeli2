package com.rendi.pembeli2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registrasi extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button back, daftar;
    EditText edt_email, edt_sandi;
    String Email, Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        mAuth = FirebaseAuth.getInstance();
        back = (Button) findViewById(R.id.btn_Back_Registrasi);
        daftar = (Button) findViewById(R.id.btn_daftar_Registrasi);
        edt_email = (EditText) findViewById(R.id.edt_email_Registrasi);
        edt_sandi = (EditText) findViewById(R.id.edt_sandi_Registrasi);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registrasi.this, Login.class));
                finish();
            }
        });

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registrasi();
            }
        });
    }

    private void registrasi() {
        Email = edt_email.getText().toString();
        Password = edt_sandi.getText().toString();

        if (TextUtils.isEmpty(Email)){
            Toast.makeText(getApplicationContext(), "MAsukkan Email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(Password)){
            Toast.makeText(getApplicationContext(), "Masukkan Password", Toast.LENGTH_SHORT).show();
        }

        mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(Registrasi.this, Login.class));
                    finish();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Pendaftaran Gagl :"+task.getException(),Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}
