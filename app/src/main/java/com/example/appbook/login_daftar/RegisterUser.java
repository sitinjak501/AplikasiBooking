package com.example.appbook.login_daftar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appbook.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmail, etUsername, txpassowrd, etPhone;
    private FloatingActionButton registerUser;
    private FirebaseAuth mAuth;
    private Button BtnLoginUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        registerUser = findViewById(R.id.fab_register);
        registerUser.setOnClickListener(this);

        BtnLoginUser=findViewById(R.id.btnLogininten);

        etEmail = (EditText) findViewById(R.id.et_email);
        txpassowrd = (EditText) findViewById(R.id.inputpass);
        etPhone = (EditText) findViewById(R.id.phonenumb);
        etUsername = (EditText) findViewById(R.id.et_username);



        BtnLoginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterUser.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.btnLogininten:
//                startActivity(new Intent(RegisterUser.this, LoginActivity.class));
//                break;

            case R.id.fab_register:
                register();
                break;
        }

    }

    private void register() {

        String email = etEmail.getText().toString().trim();
        String password = txpassowrd.getText().toString().trim();
        String fullname = etUsername.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();

        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError("Please provide valid email !");
            etEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            txpassowrd.setError("Password is required");
            txpassowrd.requestFocus();
            return;
        }
        if (password.length() < 6) {
            txpassowrd.setError("Min password length should be 6 character");
            txpassowrd.requestFocus();
            return;
        }
        if (phone.isEmpty()) {
            etPhone.setError("Phone is requires");
            etPhone.requestFocus();
            return;
        }
        if (fullname.isEmpty()) {
            etUsername.setError("Fullname is required");
            etUsername.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            User user = new User(fullname, email, password, phone);
                            FirebaseDatabase.getInstance().getReference("User")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(RegisterUser.this, "Silahkan Login Kembali",
                                                Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(RegisterUser.this, LoginActivity.class));

                                    } else {
                                        // If sign in fails, display a message to the User.
                                        Toast.makeText(RegisterUser.this, "Failed to register! Try again !", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } else {
                            // If sign in fails, display a message to the User.
                            Toast.makeText(RegisterUser.this, "Failed to register", Toast.LENGTH_SHORT).show();


                        }
                    }
                });
    }
}


