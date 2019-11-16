package com.example.listmakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class AdapterMakanan extends RecyclerView.Adapter<AdapterMakanan.MakananViewHolder> {

    Context context;
    List<Makanan> dataMakanan;

    public AdapterMakanan(Context context, List<Makanan> dataMakanan) {
        this.context = context;
        this.dataMakanan = dataMakanan;
    }
    //contect itu ambil root dari activity

    @NonNull
    @Override
    public MakananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_makanan, parent,false);
        return new MakananViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MakananViewHolder holder, final int position) {
        Makanan makanan = dataMakanan.get(position);

        holder.nama.setText(dataMakanan.get(position).getNama());
        Glide.with(context).load(dataMakanan.get(position).getPhoto()).into(holder.gambar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(context,DeatilMakananActivity.class);
                intent.putExtra("nama", dataMakanan.get(position).getNama());
                intent.putExtra("detail", dataMakanan.get(position).getDetail());
                intent.putExtra("gambar", dataMakanan.get(position).getPhoto());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataMakanan.size();
    }

    //itemcount untuk nampilin data yang akan ditampilkan

    //itemview itu dari view dan di ambil dari konstrukture makananviewholder @nonnull

    public class MakananViewHolder extends RecyclerView.ViewHolder {

        //ini inisialisasi
        ImageView gambar;
        TextView nama;

        public MakananViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.image_makanan);
            nama = itemView.findViewById(R.id.nama_makanan);
        }
    }
}
