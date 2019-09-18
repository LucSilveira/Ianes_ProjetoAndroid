package ianes.br.com.senai.ianes.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ianes.br.com.senai.ianes.R;
import ianes.br.com.senai.ianes.holder.AmbientesViewHolder;
import ianes.br.com.senai.ianes.holder.ItemViewHolder;
import ianes.br.com.senai.ianes.models.Ambientes;
import ianes.br.com.senai.ianes.models.Itens;

/**
 * Created by 46923597811 on 19/06/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter {

    private List<Itens> listagem;
    private Context context;

    public ItemAdapter(List<Itens> listagem, Context context){
        this.listagem = listagem;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listagem_itens, parent, false);
        ItemViewHolder holder = new ItemViewHolder(view, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        Itens itens = listagem.get(position);
        ((ItemViewHolder)holder).preencher(itens);
    }

    @Override
    public int getItemCount() {
        return listagem.size();
    }

    public void setListagem(List<Itens> lista){
        this.listagem = lista;
        notifyDataSetChanged();
    }
}