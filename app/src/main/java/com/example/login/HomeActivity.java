package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button btnKeuangan, btnMemo, btnTugas;
    private Button navHome, navProfile, navSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home); // Pastikan nama layout sesuai

        mAuth = FirebaseAuth.getInstance();

        // Inisialisasi tombol menu utama
        btnKeuangan = findViewById(R.id.btnKeuangan);
        btnMemo = findViewById(R.id.btnMemo);
        btnTugas = findViewById(R.id.btnTugas);

        // Inisialisasi Navigation Bar
        navHome = findViewById(R.id.navHome);
        navProfile = findViewById(R.id.navProfile);
        navSettings = findViewById(R.id.navSettings);

        // Ambil data pengguna dari Firebase
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null) {
            // Jika tidak ada pengguna yang login
            Toast.makeText(this, "Silakan login terlebih dahulu", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(HomeActivity.this, MainActivity.class));
            finish();
            return;
        }

        // Mengambil data pengguna
        String userID = user.getUid(); // Ambil UID pengguna dari Firebase
        String username = user.getDisplayName() != null ? user.getDisplayName() : "Username tidak tersedia";
        String email = user.getEmail() != null ? user.getEmail() : "Email tidak tersedia";

        // Aksi tombol menu utama
        btnKeuangan.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, KeuanganActivity.class);
            startActivity(intent);
        });

        btnMemo.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, MemoActivity.class);
            startActivity(intent);
        });

        btnTugas.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, TugasActivity.class);
            startActivity(intent);
        });

        // Aksi tombol navigation bar
        navHome.setOnClickListener(view -> {
            // Sudah berada di Home, tidak perlu mengalihkan ke HomeActivity lagi
        });

        navProfile.setOnClickListener(view -> {
            // Mengirim data pengguna ke ProfileActivity
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            intent.putExtra("USER_ID", userID);
            intent.putExtra("USERNAME", username);
            intent.putExtra("EMAIL", email);
            startActivity(intent);
        });

        navSettings.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, PengaturanActivity.class);
            startActivity(intent);
        });
    }
}
