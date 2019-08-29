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
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button daftar, masuk;
    EditText edt_email, edt_sandi;
    private FirebaseAuth mAuth;
    String email;
    String sandi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        daftar = (Button) findViewById(R.id.btndaftar);
        masuk = (Button) findViewById(R.id.btnmasuk);
        edt_email = (EditText) findViewById(R.id.edt_Login_Login);
        edt_sandi = (EditText) findViewById(R.id.edt_sandi_login);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null){
            startActivity(new Intent(Login.this, Home.class));
            finish();
        }
        daftar.setOnClickListener(this);
        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }

    private void login() {
        email = edt_email.getText().toString();
        sandi = edt_sandi.getText().toString();
        if (TextUtils.isEmpty(email)){
            Toast.makeText(getApplicationContext(), "Masukkan Email", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(sandi)){
            Toast.makeText(getApplicationContext(), "Masukkan Sandi", Toast.LENGTH_SHORT).show();
        }
        mAuth.signInWithEmailAndPassword(email, sandi).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(Login.this, Formulir.class));
                    finish();
                }else {
                    Toast.makeText(Login.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    @Override
    public void onClick(View i) {
        if (i == daftar){
            Intent registrasi = new Intent(getApplicationContext(), Registrasi.class);
            startActivity(registrasi);
        }
    }
}
