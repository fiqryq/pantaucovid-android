package com.sunflower.pantaucovid19.fragment;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sunflower.pantaucovid19.R;
import com.sunflower.pantaucovid19.adapter.Adapter;
import com.sunflower.pantaucovid19.base.BaseFragment;
import com.sunflower.pantaucovid19.model.ModelDataNegara;
import com.sunflower.pantaucovid19.model.ResponseBody;
import com.sunflower.pantaucovid19.remote.Api;
import com.sunflower.pantaucovid19.remote.RetrofitClient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private ArrayList<ResponseBody> dataProvinsi = new ArrayList<>();
    private Adapter adapter;
    private RecyclerView provinsiRecyclerView;
    private String hari, waktusekarang;
    private TextView waktuHariini, dshPositif, dshSembuh, dshMeninggal;
    private ProgressBar mProgressbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        provinsiRecyclerView = view.findViewById(R.id.rv_provinsi);
        provinsiRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        waktuHariini = view.findViewById(R.id.tvHariini);
        dshPositif = view.findViewById(R.id.dshPositif);
        dshSembuh = view.findViewById(R.id.dshSembuh);
        dshMeninggal = view.findViewById(R.id.dshMeninggal);
        mProgressbar = view.findViewById(R.id.progressBar);
        mProgressbar.setVisibility(View.VISIBLE);
        getNamaHari();
        getWaktuSekarang();
        dataResponseProvinsi();
        dataResponseNegara();
    }

    private void dataResponseProvinsi() {
        Call<List<ResponseBody>> call = RetrofitClient.getApiClient(getContext()).create(Api.class).getDataProvinsi();
        call.enqueue(new Callback<List<ResponseBody>>() {
            @Override
            public void onResponse(Call<List<ResponseBody>> call, Response<List<ResponseBody>> response) {
                if (response.isSuccessful()) {
                    mProgressbar.setVisibility(View.GONE);
                    dataProvinsi.addAll(response.body());
                    adapter = new Adapter(dataProvinsi);
                    provinsiRecyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Gagal" + response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseBody>> call, Throwable t) {

            }
        });
    }

    private void dataResponseNegara() {
        Call<List<ModelDataNegara>> call = RetrofitClient.getApiClient(getContext()).create(Api.class).getDataNegara();
        call.enqueue(new Callback<List<ModelDataNegara>>() {
            @Override
            public void onResponse(Call<List<ModelDataNegara>> call, Response<List<ModelDataNegara>> response) {
                for (int i = 0; i <response.body().size() ; i++) {
                    dshPositif.setText(response.body().get(i).getPositif());
                    dshSembuh.setText(response.body().get(i).getSembuh());
                    dshMeninggal.setText(response.body().get(i).getMeninggal());
                }
            }

            @Override
            public void onFailure(Call<List<ModelDataNegara>> call, Throwable t) {

            }
        });
    }

    private void getWaktuSekarang() {
        Date date = Calendar.getInstance().getTime();
        String tanggal = (String) DateFormat.format("d", date); // 20
        String monthNumber = (String) DateFormat.format("M", date); // 06
        String year = (String) DateFormat.format("yyyy", date); // 2013

        int month = Integer.parseInt(monthNumber);
        String bulan = null;

        if (month == 1) {
            bulan = "Januari";
        } else if (month == 2) {
            bulan = "Februari";
        } else if (month == 3) {
            bulan = "Maret";
        } else if (month == 4) {
            bulan = "April";
        } else if (month == 5) {
            bulan = "Mei";
        } else if (month == 6) {
            bulan = "Juni";
        } else if (month == 7) {
            bulan = "Juli";
        } else if (month == 8) {
            bulan = "Agustus";
        } else if (month == 9) {
            bulan = "September";
        } else if (month == 10) {
            bulan = "Oktober";
        } else if (month == 11) {
            bulan = "November";
        } else if (month == 12) {
            bulan = "Desember";
        }
        String formatFix = hari + ", " + tanggal + " " + bulan + " " + year;
        waktuHariini.setText(String.valueOf(formatFix));
    }
    private void getNamaHari() {
        Date dateNow = Calendar.getInstance().getTime();
        waktusekarang = (String) android.text.format.DateFormat.format("HH:mm", dateNow);
        hari = (String) android.text.format.DateFormat.format("EEEE", dateNow);
        if (hari.equalsIgnoreCase("sunday")) {
            hari = "minggu";
        } else if (hari.equalsIgnoreCase("monday")) {
            hari = "senin";
        } else if (hari.equalsIgnoreCase("tuesday")) {
            hari = "selasa";
        } else if (hari.equalsIgnoreCase("wednesday")) {
            hari = "rabu";
        } else if (hari.equalsIgnoreCase("thursday")) {
            hari = "kamis";
        } else if (hari.equalsIgnoreCase("friday")) {
            hari = "jumat";
        } else if (hari.equalsIgnoreCase("saturday")) {
            hari = "sabtu";
        }
    }
}
