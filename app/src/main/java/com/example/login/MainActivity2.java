package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {
    Button btnSignUp;
    TextInputEditText usernameSignUp, passwordSignUp, nimPengguna, emailPengguna;
    FirebaseAuth mAuth;  // Firebase Authentication

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Inisialisasi UI
        btnSignUp = findViewById(R.id.btnSignUp);
        usernameSignUp = findViewById(R.id.usernameSignUp);
        emailPengguna = findViewById(R.id.emailPengguna);
        passwordSignUp = findViewById(R.id.passwordSignUp);
        nimPengguna = findViewById(R.id.nimPengguna);

        btnSignUp.setOnClickListener(view -> registerUser());
    }

    private void registerUser() {
        String username = usernameSignUp.getText().toString().trim();
        String email = emailPengguna.getText().toString().trim();
        String password = passwordSignUp.getText().toString().trim();
        String NIM = nimPengguna.getText().toString().trim();

        // Validasi input
        if (TextUtils.isEmpty(username)) {
            usernameSignUp.setError("Masukkan username!");
            usernameSignUp.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            emailPengguna.setError("Masukkan email!");
            emailPengguna.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(password) || password.length() < 6) {
            passwordSignUp.setError("Password minimal 6 karakter!");
            passwordSignUp.requestFocus();
            return;
        }
        if (TextUtils.isEmpty(NIM)) {
            nimPengguna.setError("Masukkan NIM!");
            nimPengguna.requestFocus();
            return;
        }

        // Firebase Authentication untuk registrasi
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            user.sendEmailVerification(); // Kirim email verifikasi (opsional)
                        }
                        Toast.makeText(MainActivity2.this, "Registrasi Berhasil!", Toast.LENGTH_SHORT).show();

                        // Pindah ke halaman login setelah sukses
                        startActivity(new Intent(MainActivity2.this, MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(MainActivity2.this, "Registrasi Gagal: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
