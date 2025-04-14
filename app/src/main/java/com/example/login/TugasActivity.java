package com.example.login;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TugasActivity extends AppCompatActivity {

    private EditText edtTugas, edtTenggat;
    private Button btnSimpanTugas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugas);

        edtTugas = findViewById(R.id.edtTugas);
        edtTenggat = findViewById(R.id.edtTenggat);
        btnSimpanTugas = findViewById(R.id.btnSimpanTugas);

        // Menambahkan listener untuk edtTenggat (EditText Tanggal Tenggat)
        edtTenggat.setOnClickListener(view -> {
            // Mendapatkan tanggal sekarang
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

            // Membuka DatePickerDialog
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    TugasActivity.this,
                    (view1, year1, monthOfYear, dayOfMonth1) -> {
                        // Menampilkan tanggal yang dipilih di edtTenggat
                        edtTenggat.setText(dayOfMonth1 + "/" + (monthOfYear + 1) + "/" + year1);
                    },
                    year, month, dayOfMonth
            );
            datePickerDialog.show();
        });

        // Simpan tugas
        btnSimpanTugas.setOnClickListener(view -> {
            String tugas = edtTugas.getText().toString();
            String tenggat = edtTenggat.getText().toString();

            if (!tugas.isEmpty() && !tenggat.isEmpty()) {
                // Menampilkan Toast sebagai contoh penyimpanan
                Toast.makeText(TugasActivity.this, "Tugas berhasil disimpan", Toast.LENGTH_SHORT).show();
                edtTugas.setText(""); // Kosongkan input tugas
                edtTenggat.setText(""); // Kosongkan input tenggat
            } else {
                Toast.makeText(TugasActivity.this, "Pastikan semua data terisi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
