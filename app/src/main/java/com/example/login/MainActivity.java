package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText username, password;
    CheckBox ingatSaya;
    Button btnLogin;
    TextView lupaPassword, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        ingatSaya = findViewById(R.id.ingatSaya);
        btnLogin = findViewById(R.id.btnLogin);
        lupaPassword = findViewById(R.id.lupaPassword);
        signUp = findViewById(R.id.signUp);

        if (getIntent().getBooleanExtra("EXTRA_REGISTER_SUCCESS", false)) {
            Toast.makeText(MainActivity.this, "Registrasi Sukses! Silakan login.", Toast.LENGTH_SHORT).show();
        }

        btnLogin.setOnClickListener(view -> {
            String user = username.getText().toString().trim();
            String pass = password.getText().toString().trim();

            if (user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(MainActivity.this, "Nama pengguna dan password harus diisi!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Login Berhasil!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        lupaPassword.setOnClickListener(view ->
                Toast.makeText(MainActivity.this, "Fitur lupa password belum tersedia!", Toast.LENGTH_SHORT).show()
        );

        signUp.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}
