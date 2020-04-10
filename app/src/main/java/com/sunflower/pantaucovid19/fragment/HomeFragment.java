package com.sunflower.pantaucovid19.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sunflower.pantaucovid19.Adapter;
import com.sunflower.pantaucovid19.R;
import com.sunflower.pantaucovid19.base.BaseFragment;
import com.sunflower.pantaucovid19.model.ModelData;
import com.sunflower.pantaucovid19.model.ResponseBody;
import com.sunflower.pantaucovid19.remote.Api;
import com.sunflower.pantaucovid19.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private ArrayList<ResponseBody> dataProvinsi = new ArrayList<>();
    private Adapter adapter;
    private RecyclerView provinsiRecyclerView;
    private Api api;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        provinsiRecyclerView = view.findViewById(R.id.rv_provinsi);
        provinsiRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataResponse();
    }

    private void dataResponse(){
        Call<List<ResponseBody>> call = RetrofitClient.getApiClient(getContext()).create(Api.class).getDataProvinsi();
        call.enqueue(new Callback<List<ResponseBody>>() {
            @Override
            public void onResponse(Call<List<ResponseBody>> call, Response<List<ResponseBody>> response) {
                if (response.isSuccessful()){
                    dataProvinsi.addAll(response.body());
                    adapter = new Adapter(getActivity(),dataProvinsi);
                    provinsiRecyclerView.setAdapter(adapter);
                    Log.d("dataprovinsi",response.body().toString());
                } else {
                    Toast.makeText(getContext(), "Gagal" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseBody>> call, Throwable t) {

            }
        });
     }
}
