package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class PengaturanActivity extends AppCompatActivity {

    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);

        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(PengaturanActivity.this, "Berhasil logout", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(PengaturanActivity.this, MainActivity.class));
            finish();
        });
    }
}
