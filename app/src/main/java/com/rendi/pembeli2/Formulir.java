package com.rendi.pembeli2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import model.User;

public class Formulir extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private FirebaseUser user;
    private DatabaseReference reference;
    private User mUser = new User();
    EditText edt_nama, edt_umur, edt_alamat, edt_kelamin;
    Button save;
    String Nama, Umur, Alamat, Kelamin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulir);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        user = mAuth.getCurrentUser();
        reference = database.getReference();

        save = (Button) findViewById(R.id.btn_save);
        edt_alamat = (EditText) findViewById(R.id.edt_alamat_form);
        edt_kelamin = (EditText) findViewById(R.id.edt_kelamin_form);
        edt_nama = (EditText) findViewById(R.id.edt_nama_form);
        edt_umur = (EditText) findViewById(R.id.edt_umur_form);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IsiData();
            }
        });
    }

    private void IsiData() {
        Alamat = edt_alamat.getText().toString();
        Kelamin = edt_kelamin.getText().toString();
        Nama = edt_nama.getText().toString();
        Umur = edt_umur.getText().toString();
        mUser.setAlamat(Alamat);
        mUser.setKelamin(Kelamin);
        mUser.setNama(Nama);
        mUser.setUmur(Umur);
        if (TextUtils.isEmpty(Alamat)){
            Toast.makeText(getApplicationContext(), "Masukkan Alamat", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(Kelamin)){
            Toast.makeText(getApplicationContext(), "Masukkan Kelamin", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(Nama)){
            Toast.makeText(getApplicationContext(), "Masukkan Nama", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(Umur)){
            Toast.makeText(getApplicationContext(), "Masukkan Umur", Toast.LENGTH_SHORT).show();
        }

        reference.child(user.getUid()).setValue(new User(Alamat, Kelamin, Nama, Umur)).addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                edt_alamat.setText(" ");
                edt_kelamin.setText(" ");
                edt_nama.setText(" ");
                edt_umur.setText(" ");
            }
        });
    }
}
