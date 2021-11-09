package Proses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbook.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class AdapterHistory extends RecyclerView.Adapter<AdapterHistory.MyViewHolder > {

    Context context;
    ArrayList<History> list;


    public AdapterHistory(Context context, ArrayList<History> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.itemhistory,parent,false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {

        History history=list.get(position);

//        holder.lapangan.setText(history.getLapangan());
        holder.tanggalmain.setText(history.getTanggalbermain());
//        holder.jam.setText(history.getJambermain());
        holder.status.setText(history.getStatus());
        holder.nama.setText(history.getNama());
//        holder.harga.setText(history.getHarga());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nama, lapangan, tanggalmain, jam, status, harga;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

//            lapangan = itemView.findViewById(R.id.JenisLapangan);
            tanggalmain = itemView.findViewById(R.id.TanggalTersedia);
//            jam = itemView.findViewById(R.id.JamTersedia);
            status = itemView.findViewById(R.id.Status);
            nama = itemView.findViewById(R.id.namaOrder);
//            harga = itemView.findViewById(R.id.harga);
        }
    }
}
