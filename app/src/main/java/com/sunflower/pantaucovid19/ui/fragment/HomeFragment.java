package com.sunflower.pantaucovid19.ui.fragment;

import static com.sunflower.pantaucovid19.utils.FuncHelper.Func.getTimeNow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sunflower.pantaucovid19.R;
import com.sunflower.pantaucovid19.base.BaseFragment;
import com.sunflower.pantaucovid19.databinding.FragmentHomeBinding;
import com.sunflower.pantaucovid19.source.DataRepository;
import com.sunflower.pantaucovid19.source.model.Negara;
import com.sunflower.pantaucovid19.source.model.ResponseProvinsi;
import com.sunflower.pantaucovid19.source.remote.GetRemoteCallback;
import com.sunflower.pantaucovid19.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    private DataRepository dataRepository;

    @NonNull
    @Override
    public FragmentHomeBinding setupViewBinding(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup) {
        return FragmentHomeBinding.inflate(layoutInflater, viewGroup, false);
    }

    @Override
    public void setupOnViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        dataRepository = new DataRepository(getContext());
        getBinding().tvHariini.setText(getTimeNow());

        getNegara();
        getProvinsi();
        swipeAction();
    }

    private void swipeAction() {
        getBinding().refreshRVProvinsi.setOnRefreshListener(() -> {
            getProvinsi();
            getBinding().refreshRVProvinsi.setRefreshing(false);
        });
        getBinding().refreshRVProvinsi.setColorSchemeResources(R.color.colorPrimary);

    }

    private void getProvinsi() {
        dataRepository.getProvinsi(new GetRemoteCallback<List<ResponseProvinsi>>() {
            @Override
            public void onSuccess(List<ResponseProvinsi> data) {
                ArrayList<ResponseProvinsi> dataProvinsi = new ArrayList<>(data);
                HomeAdapter homeAdapter = new HomeAdapter(dataProvinsi);
                getBinding().rvProvinsi.setLayoutManager(new LinearLayoutManager(getContext()));
                getBinding().rvProvinsi.setAdapter(homeAdapter);
            }

            @Override
            public void onFailed(String errorMessage) {
                showToastShort(errorMessage);
            }

            @Override
            public void onShowProgress() {
                showingProgress(getBinding().progressBar);
            }

            @Override
            public void onHideProgress() {
                hidingProgress(getBinding().progressBar);
            }
        });
    }

    private void getNegara() {
        dataRepository.getNegara(new GetRemoteCallback<>() {
            @Override
            public void onSuccess(List<Negara> data) {
                for (int i = 0; i < data.size(); i++) {
                    getBinding().dshPositif.setText(data.get(i).getPositif());
                    getBinding().dshSembuh.setText(data.get(i).getSembuh());
                    getBinding().dshMeninggal.setText(data.get(i).getMeninggal());
                }
            }

            @Override
            public void onFailed(String errorMessage) {
                showToastShort(errorMessage);
            }

            @Override
            public void onShowProgress() {
                showingProgress(getBinding().progressBar);
            }

            @Override
            public void onHideProgress() {
                hidingProgress(getBinding().progressBar);
            }
        });
    }

}