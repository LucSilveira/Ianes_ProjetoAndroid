package ianes.br.com.senai.ianes.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import ianes.br.com.senai.ianes.R;
import ianes.br.com.senai.ianes.holder.MoviViewHolder;
import ianes.br.com.senai.ianes.models.Movimentacao;

/**
 * Created by 46923597811 on 19/06/2018.
 */

public class MovimentacaoAdapter extends RecyclerView.Adapter {

    private List<Movimentacao> listagem;
    private Context context;

    public MovimentacaoAdapter(List<Movimentacao> listagem, Context context){
        this.listagem = listagem;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listagem_movimentacoes, parent, false);
        MoviViewHolder holder = new MoviViewHolder(view, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MoviViewHolder viewHolder = (MoviViewHolder) holder;
        Movimentacao movi = listagem.get(position);
        ((MoviViewHolder)holder).preencher(movi);
    }

    @Override
    public int getItemCount() {
        return listagem.size();
    }

    public void setListagem(List<Movimentacao> lista){
        this.listagem = lista;
        notifyDataSetChanged();
    }
}