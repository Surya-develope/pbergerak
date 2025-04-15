package com.example.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class KeuanganActivity extends AppCompatActivity {

    private EditText edtPendapatan, edtPengeluaran;
    private Button btnSimpanKeuangan;
    private TextView txtTotalKeuangan;
    private float totalKeuangan = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keuangan);

        edtPendapatan = findViewById(R.id.edtPendapatan);
        edtPengeluaran = findViewById(R.id.edtPengeluaran);
        btnSimpanKeuangan = findViewById(R.id.btnSimpanKeuangan);
        txtTotalKeuangan = findViewById(R.id.txtTotalKeuangan);

        btnSimpanKeuangan.setOnClickListener(view -> {
            float pendapatan = Float.parseFloat(edtPendapatan.getText().toString());
            float pengeluaran = Float.parseFloat(edtPengeluaran.getText().toString());
            totalKeuangan = pendapatan - pengeluaran;
            txtTotalKeuangan.setText("Total: " + totalKeuangan);
        });
    }
}
