package com.sunflower.pantaucovid19.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunflower.pantaucovid19.R;
import com.sunflower.pantaucovid19.model.ResponseBody;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<ResponseBody> mData;

    public Adapter(ArrayList<ResponseBody> mData) {
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.list_provinsi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mProvinsi.setText(mData.get(position).getModelDataProvinsi().getProvinsi());
        holder.mKasusPositif.setText(mData.get(position).getModelDataProvinsi().getKasusPositif());
        holder.mKasusMeninggal.setText(mData.get(position).getModelDataProvinsi().getKasusMeninggal());
        holder.mKasusSembuh.setText(mData.get(position).getModelDataProvinsi().getKasusSembuh());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mProvinsi;
        private TextView mKasusPositif;
        private TextView mKasusMeninggal;
        private TextView mKasusSembuh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mProvinsi = itemView.findViewById(R.id.provinsi);
            mKasusPositif = itemView.findViewById(R.id.kasusPositif);
            mKasusMeninggal = itemView.findViewById(R.id.kasusMeninggal);
            mKasusSembuh = itemView.findViewById(R.id.kasusSembuh);
        }
    }
}
