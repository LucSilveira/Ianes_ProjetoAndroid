package ianes.br.com.senai.ianes.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import ianes.br.com.senai.ianes.R;
import ianes.br.com.senai.ianes.holder.AmbientesViewHolder;
import ianes.br.com.senai.ianes.models.Ambientes;

/**
 * Created by 46923597811 on 18/06/2018.
 */

public class AmbienteAdapter extends RecyclerView.Adapter {

    private List<Ambientes> listagem;
    private Context context;

    public AmbienteAdapter(List<Ambientes> listagem, Context context){
        this.listagem = listagem;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listagem_ambiente, parent, false);
        AmbientesViewHolder holder = new AmbientesViewHolder(view, this);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AmbientesViewHolder viewHolder = (AmbientesViewHolder) holder;
        Ambientes ambientes = listagem.get(position);
        ((AmbientesViewHolder)holder).preencher(ambientes);
    }

    @Override
    public int getItemCount() {
        return listagem.size();
    }

    public void setListagem(List<Ambientes> lista){
        this.listagem = lista;
        notifyDataSetChanged();
    }
}