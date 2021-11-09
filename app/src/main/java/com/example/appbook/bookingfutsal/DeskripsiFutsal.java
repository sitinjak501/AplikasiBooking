package com.example.appbook.bookingfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.appbook.R;

public class DeskripsiFutsal extends AppCompatActivity {

    Button btnforum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_deskripsi_futsal);



        btnforum=findViewById(R.id.bookingnow);
        btnforum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DeskripsiFutsal.this, RequestOrderFutsal.class);
                startActivity(intent);
                finish();
            }
        });
    }
}