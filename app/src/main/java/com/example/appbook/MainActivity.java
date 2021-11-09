package com.example.appbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appbook.badmintonbooking.DeskripsiBadminton;
import com.example.appbook.bookingfutsal.DeskripsiFutsal;
import com.example.appbook.login_daftar.LoginActivity;
import com.example.appbook.login_daftar.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import Proses.StatusPesanan;

public class MainActivity extends AppCompatActivity  {

    private CardView cardfutsal, cardbadminton, cardViewinformasi, cardViewhistory;
    private TextView namaview, nomorhp,  Greeting, Transfer;
    private Button BtnKeluar;
    private String email, password;
    private FirebaseDatabase database;
    private DatabaseReference reference;
    private FirebaseUser User;
    private String userID;
    private static final String USERS = "User";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        cardfutsal = (CardView) findViewById(R.id.cv_futsal);
        cardbadminton = (CardView) findViewById(R.id.cv_badminton);
        cardViewinformasi = (CardView) findViewById(R.id.cv_informasi);
        cardViewhistory=findViewById(R.id.cv_history);
        Transfer= findViewById(R.id.BuktiTransfer);


        User = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("User");
        userID = User.getUid();
        BtnKeluar = (Button) findViewById(R.id.btnkeluar);
        cardfutsal = findViewById(R.id.cv_futsal);

        Transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProsesPembayaran.class));
            }
        });


        cardViewinformasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Informasi.class));
            }
        });
        cardViewhistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StatusPesanan.class));
            }
        });

        cardfutsal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DeskripsiFutsal.class));
            }
        });
        cardbadminton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DeskripsiBadminton.class));
            }
        });


        BtnKeluar.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        });

        final TextView greetingTextView = (TextView) findViewById(R.id.greeting);
        final TextView fullnameTextView = (TextView) findViewById(R.id.usernameprofile);
        final TextView phoneTextView = (TextView) findViewById(R.id.No_hp);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                User userprofile = snapshot.getValue(User.class);

                if (userprofile != null){
                    String fullname = userprofile.Fullname;
                    String nohp = userprofile.Nohp;

                    fullnameTextView.setText("Hai, " + fullname);
                    phoneTextView.setText(nohp);
                }

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {
                Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_LONG).show();

            }
        });


    }
}