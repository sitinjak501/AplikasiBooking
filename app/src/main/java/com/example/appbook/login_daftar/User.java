package com.example.appbook.login_daftar;

public class User {

    public String Fullname, Email, Password, Nohp;

    public User(){

    }

    public User(String fullname, String email, String password, String nohp) {
        this.Fullname = fullname;
        this.Email = email;
        this.Nohp = nohp;
        this.Password = password;
    }
}
