package com.example.appbook;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbook.bookingfutsal.RequestOrderFutsal;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AdapterBooking extends RecyclerView.Adapter<AdapterBooking.MyViewHolder> implements View.OnClickListener {

    Context context;
    ArrayList<Booking> list;

    public AdapterBooking(Context context, ArrayList<Booking> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public void onClick(View v) {

    }

    @NonNull
    @NotNull
    @Override
    public AdapterBooking.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemlapangan, parent, false);
        v.setOnClickListener(this);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AdapterBooking.MyViewHolder holder, int position) {

        Booking book = list.get(position);

        holder.fullname.setText(book.getNama());
        holder.emailorder.setText(book.getEmail());
        holder.nomorhp.setText(book.getNomorponsel());
        holder.tanggalbermain.setText(book.getTanggalbermain());
        holder.jambermain.setText(book.getJambermain());
        holder.durasibermain.setText(book.getLamabermain());


        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, RequestOrderFutsal.class);
            intent.putExtra("email", list.get(position));
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView fullname, emailorder, nomorhp, tanggalbermain, jambermain, durasibermain, lapangan;


        public MyViewHolder(@NonNull View itemview) {
            super(itemview);
            fullname = itemView.findViewById(R.id.namaOrder);
            tanggalbermain = itemView.findViewById(R.id.TanggalTersedia);
//            jambermain = itemView.findViewById(R.id.JamTersedia);
            lapangan = itemView.findViewById(R.id.JenisLapangan);
        }
    }
}
