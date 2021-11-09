package com.example.appbook.badmintonbooking;

import com.example.appbook.bookingfutsal.OrderFutsal;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class BookBadminton {

    private DatabaseReference databaseReference;


    public BookBadminton(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(OrderBadminton.class.getSimpleName());
    }
    public Task<Void> add (OrderBadminton badminton){
        return databaseReference.push().setValue(badminton);
    }
    public Task<Void> update(String key, HashMap<String, Object> hashMap){

        return databaseReference.child(key).updateChildren(hashMap);
    }


}
