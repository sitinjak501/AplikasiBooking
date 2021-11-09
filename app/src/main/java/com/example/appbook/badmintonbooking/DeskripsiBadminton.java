package com.example.appbook.badmintonbooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appbook.R;

public class DeskripsiBadminton extends AppCompatActivity {

    Button BookBadmninton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.deskripsi_badminton);

        BookBadmninton= findViewById(R.id.bookingnowbdm);

        BookBadmninton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(DeskripsiBadminton.this, RequestOrderBadminton.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
