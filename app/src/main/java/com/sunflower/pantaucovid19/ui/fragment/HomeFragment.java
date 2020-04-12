package com.sunflower.pantaucovid19.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sunflower.pantaucovid19.R;
import com.sunflower.pantaucovid19.base.BaseFragment;
import com.sunflower.pantaucovid19.source.DataRepository;
import com.sunflower.pantaucovid19.source.model.Negara;
import com.sunflower.pantaucovid19.source.model.ResponseProvinsi;
import com.sunflower.pantaucovid19.source.remote.GetRemoteCallback;
import com.sunflower.pantaucovid19.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.sunflower.pantaucovid19.utils.FuncHelper.Func.getTimeNow;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    private RecyclerView provinsiRecyclerView;
    private TextView dshPositif;
    private TextView dshSembuh;
    private TextView dshMeninggal;
    private ProgressBar mProgressbar;
    private DataRepository dataRepository;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataRepository = new DataRepository(getContext());

        provinsiRecyclerView = view.findViewById(R.id.rv_provinsi);
        dshPositif = view.findViewById(R.id.dshPositif);
        dshSembuh = view.findViewById(R.id.dshSembuh);
        dshMeninggal = view.findViewById(R.id.dshMeninggal);
        mProgressbar = view.findViewById(R.id.progressBar);
        TextView waktuHariini = view.findViewById(R.id.tvHariini);

        waktuHariini.setText(getTimeNow());

        getNegara();
        getProvinsi();

    }

    private void getProvinsi() {
        dataRepository.getProvinsi(new GetRemoteCallback<List<ResponseProvinsi>>() {
            @Override
            public void onSuccess(List<ResponseProvinsi> data) {
                ArrayList<ResponseProvinsi> dataProvinsi = new ArrayList<>(data);
                HomeAdapter homeAdapter = new HomeAdapter(dataProvinsi);
                provinsiRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                provinsiRecyclerView.setAdapter(homeAdapter);
            }

            @Override
            public void onFailed(String errorMessage) {
                showToastShort(errorMessage);
            }

            @Override
            public void onShowProgress() {
                showingProgress(mProgressbar);
            }

            @Override
            public void onHideProgress() {
                hidingProgress(mProgressbar);
            }
        });
    }

    private void getNegara() {
        dataRepository.getNegara(new GetRemoteCallback<List<Negara>>() {
            @Override
            public void onSuccess(List<Negara> data) {
                for (int i = 0; i < data.size(); i++) {
                    dshPositif.setText(data.get(i).getPositif());
                    dshSembuh.setText(data.get(i).getSembuh());
                    dshMeninggal.setText(data.get(i).getMeninggal());
                }
            }

            @Override
            public void onFailed(String errorMessage) {
                showToastShort(errorMessage);
            }

            @Override
            public void onShowProgress() {
                showingProgress(mProgressbar);
            }

            @Override
            public void onHideProgress() {
                hidingProgress(mProgressbar);
            }
        });
    }


}
