package ianes.br.com.senai.ianes.Listas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ianes.br.com.senai.ianes.R;
import ianes.br.com.senai.ianes.adapter.AmbienteAdapter;
import ianes.br.com.senai.ianes.adapter.ItemAdapter;
import ianes.br.com.senai.ianes.config.RetrofitConfig;
import ianes.br.com.senai.ianes.models.Ambientes;
import ianes.br.com.senai.ianes.models.Itens;
import ianes.br.com.senai.ianes.utils.AppUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 46923597811 on 18/06/2018.
 */

public class ItensList extends Fragment{

    private RecyclerView rvItens;
    private List<Itens> itensList = new ArrayList<>();
    private ItemAdapter adapter;
    private Context context;
    private String token;

    @Override
    public void onAttach(Context context) {
        this.context = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_itens, container, false);

        rvItens = rootView.findViewById(R.id.listItens);

        LinearLayoutManager linear = new LinearLayoutManager(getContext());
        rvItens.setLayoutManager(linear);

        adapter = new ItemAdapter(itensList, getContext());
        rvItens.setAdapter(adapter);

        final SharedPreferences shared = context.getSharedPreferences(AppUtils.sharedPref, Context.MODE_PRIVATE);
        token = shared.getString("token", "");

        Call<List<Itens>> call = new RetrofitConfig(token).getRestInterface().listarItens();
        call.enqueue(new Callback<List<Itens>>() {
            @Override
            public void onResponse(Call<List<Itens>> call, Response<List<Itens>> response) {
                if(response.isSuccessful()){
                    itensList = response.body();
                    if(itensList != null){
                        adapter.setListagem(itensList);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Itens>> call, Throwable t) {

            }
        });

        return rootView;
    }
}
