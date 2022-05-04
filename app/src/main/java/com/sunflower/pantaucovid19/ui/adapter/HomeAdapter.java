package com.sunflower.pantaucovid19.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunflower.pantaucovid19.R;
import com.sunflower.pantaucovid19.source.model.ResponseProvinsi;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private ArrayList<ResponseProvinsi> mData;

    public HomeAdapter(ArrayList<ResponseProvinsi> mData) {
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
        holder.mProvinsi.setText(mData.get(position).getProvinsi().getProvinsi());
        holder.mKasusPositif.setText(mData.get(position).getProvinsi().getKasusPositif());
        holder.mKasusMeninggal.setText(mData.get(position).getProvinsi().getKasusMeninggal());
        holder.mKasusSembuh.setText(mData.get(position).getProvinsi().getKasusSembuh());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mProvinsi;
        private final TextView mKasusPositif;
        private final TextView mKasusMeninggal;
        private final TextView mKasusSembuh;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mProvinsi = itemView.findViewById(R.id.provinsi);
            mKasusPositif = itemView.findViewById(R.id.kasusPositif);
            mKasusMeninggal = itemView.findViewById(R.id.kasusMeninggal);
            mKasusSembuh = itemView.findViewById(R.id.kasusSembuh);
        }
    }
}
