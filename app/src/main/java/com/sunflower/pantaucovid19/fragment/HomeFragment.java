package com.sunflower.pantaucovid19.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sunflower.pantaucovid19.R;
import com.sunflower.pantaucovid19.base.BaseFragment;
import com.sunflower.pantaucovid19.model.Model;
import com.sunflower.pantaucovid19.model.ModelData;
import com.sunflower.pantaucovid19.remote.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TextView tVresult;
    private ArrayList<ModelData> dataProvinsi = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tVresult = view.findViewById(R.id.textview_result);
        dataResponse();
    }

    private void dataResponse(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.kawalcorona.com/indonesia/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<List<ModelData>> call = api.getDataProvinsi();
        call.enqueue(new Callback<List<ModelData>>() {
            @Override
            public void onResponse(Call<List<ModelData>> call, Response<List<ModelData>> response) {
                dataProvinsi = new ArrayList<>(response.body());
            }

            @Override
            public void onFailure(Call<List<ModelData>> call, Throwable t) {

            }
        });
     }
}
