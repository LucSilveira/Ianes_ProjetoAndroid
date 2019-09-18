package ianes.br.com.senai.ianes.Listas;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ianes.br.com.senai.ianes.R;

/**
 * Created by 46923597811 on 18/06/2018.
 */

public class MovimentacoesList extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_movimentacoes, container, false);
        return rootView;
    }
}
