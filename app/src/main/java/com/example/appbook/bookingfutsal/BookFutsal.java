package com.example.appbook.bookingfutsal;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class BookFutsal {

    private DatabaseReference databaseReference;

    public BookFutsal(){

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(OrderFutsal.class.getSimpleName());
    }
    public Task<Void> add (OrderFutsal futsal){
        return databaseReference.push().setValue(futsal);
    }
    public Task<Void> update(String key, HashMap<String, Object>hashMap){

        return databaseReference.child(key).updateChildren(hashMap);
    }


}
