package com.sunflower.pantaucovid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sunflower.pantaucovid19.model.ResponseBody;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ResponseBody> mData;

    public Adapter(Context mContext, ArrayList<ResponseBody> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.list_provinsi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mProvinsi.setText(mData.get(position).getModelData().getProvinsi());
        holder.mKasusPositif.setText(mData.get(position).getModelData().getKasusPositif());
        holder.mKasusNegatif.setText(mData.get(position).getModelData().getKasusNegatif());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mProvinsi;
        private TextView mKasusPositif;
        private TextView mKasusNegatif;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mProvinsi = itemView.findViewById(R.id.provinsi);
            mKasusPositif = itemView.findViewById(R.id.kasusPositif);
            mKasusNegatif = itemView.findViewById(R.id.kasusNegatif);
        }
    }
}
