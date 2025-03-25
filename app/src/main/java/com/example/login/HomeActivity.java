package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private TextView txtUsername, txtEmail;
    private Button btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Inisialisasi Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Hubungkan dengan elemen di XML
        txtUsername = findViewById(R.id.txtUsername);
        txtEmail = findViewById(R.id.txtEmail);
        btnProfile = findViewById(R.id.btnProfile);

        // Ambil data pengguna saat ini dari Firebase
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            String userId = user.getUid(); // Ambil UID pengguna dari Firebase
            String email = (user.getEmail() != null) ? user.getEmail() : "Tidak Ada Email";

            // Tampilkan di TextView
            txtUsername.setText("User ID: " + userId);
            txtEmail.setText(email);
        } else {
            // Jika user belum login
            txtUsername.setText("Pengguna Tidak Login");
            txtEmail.setText("Tidak ada email");
        }

        // Klik tombol profil untuk membuka ProfileActivity
        btnProfile.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            intent.putExtra("USERNAME", txtUsername.getText().toString());
            intent.putExtra("EMAIL", txtEmail.getText().toString());
            startActivity(intent);
        });
    }
}
