package com.example.nei.themoviedb.Model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nei.themoviedb.R;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> implements View.OnClickListener {

private List<Result> datalist;
private Context context;
private  View.OnClickListener listener;


    public CustomAdapter(List<Result> datalist, Context context) {
        this.datalist = datalist;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());

        View view= layoutInflater.inflate(R.layout.item, parent,false);
        view.setOnClickListener(this);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.CustomViewHolder holder, int position) {
        String URL= "https://image.tmdb.org/t/p/w185_and_h278_bestv2"+datalist.get(position).getPosterPath();
        holder.tname.setText(datalist.get(position).getTitle());
        Picasso.with(context).load(URL).error(R.drawable.ic_launcher_background).into(holder.logo);
    }

    @Override
    public int getItemCount() {

        return datalist.size();

    }
    public  void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!= null){
            listener.onClick(v);
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView tname;
        ImageView logo;
        public CustomViewHolder(View itemView) {
            super(itemView);
            tname   =   itemView.findViewById(R.id.tname);
            logo    =   itemView.findViewById(R.id.logo);
        }
    }


}
