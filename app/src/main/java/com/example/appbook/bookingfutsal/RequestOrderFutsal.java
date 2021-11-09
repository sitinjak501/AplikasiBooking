package com.example.appbook.bookingfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appbook.R;

import java.util.Calendar;

public class RequestOrderFutsal extends AppCompatActivity {

    DatePickerDialog.OnDateSetListener setListener;
    Button Orderlapangan, BtnBatalFutsal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.orderfutsal);

        final EditText NamaPemesan = findViewById(R.id.namapemesan);
        final EditText NomorPonsel = findViewById(R.id.nomorhp);
        final EditText TanggalBermain = findViewById(R.id.tanggalbermain);
        final EditText JamBermain = findViewById(R.id.jambermain);
        final EditText Email = findViewById(R.id.emailpesan);
        final EditText Durasi = findViewById(R.id.lamabermain);
        final TextView Lapangan = findViewById(R.id.JenisLapangan);


        BookFutsal dao = new BookFutsal();

        Orderlapangan = findViewById(R.id.btnorder);
        BtnBatalFutsal = findViewById(R.id.btnbatalfutsal);

        BtnBatalFutsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RequestOrderFutsal.this, DeskripsiFutsal.class);
                startActivity(intent);
            }
        });


        Orderlapangan.setOnClickListener(v-> {

            OrderFutsal futsal = new OrderFutsal(NamaPemesan.getText().toString(), NomorPonsel.getText().toString(),
                    TanggalBermain.getText().toString(), JamBermain.getText().toString(),Durasi.getText().toString(), Email.getText().toString(), Lapangan.getText().toString());
            dao.add(futsal).addOnSuccessListener(suc -> {
                Toast.makeText(this, "Berhasil Disimpan", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
            });
//            HashMap<String, Object> hashMap = new HashMap<>();
//            hashMap.put("Nama", NamaPemesan.getText().toString());
//            hashMap.put("NomorHp", NomorPonsel.getText().toString());
//            hashMap.put("TanggalBermain", TanggalBermain.getText().toString());
//            hashMap.put("JamBermain", JamBermain.getText().toString());
//            dao.update("lap",hashMap).addOnSuccessListener(suc->{
//                Toast.makeText(this, "Berhasil Diupdate", Toast.LENGTH_SHORT).show();
//            }).addOnFailureListener(er->{
//                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
//            });
//
//
        });

            Calendar calendar = Calendar.getInstance();
            final int year = calendar.get(Calendar.YEAR);
            final int month = calendar.get(Calendar.MONTH);
            final int day = calendar.get(Calendar.DAY_OF_MONTH);

            TanggalBermain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(
                            RequestOrderFutsal.this, android.R.style.Theme_Holo_Dialog_MinWidth, setListener, year, month, day);
                    datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    datePickerDialog.show();
                }
            });

            setListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month = month + 1;
                    String date = dayOfMonth + "/" + month + "/" + year;
                    TanggalBermain.setText(date);
                }
            };

    }
}

