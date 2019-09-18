package ianes.br.com.senai.ianes.holder;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;

import ianes.br.com.senai.ianes.R;
import ianes.br.com.senai.ianes.adapter.AmbienteAdapter;
import ianes.br.com.senai.ianes.adapter.ItemAdapter;
import ianes.br.com.senai.ianes.models.Ambientes;
import ianes.br.com.senai.ianes.models.Itens;

/**
 * Created by 46923597811 on 19/06/2018.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder{

    private final ItemAdapter itemAdapter;
    private final TextView idI;
    private final TextView pat;
    private final TextView loca;
   // private final TextView date;
    private long itemId;

    public ItemViewHolder(View view, ItemAdapter itemAdapter) {
        super(view);
        this.itemAdapter = itemAdapter;
        this.idI = itemView.findViewById(R.id.idItem);
        this.pat = itemView.findViewById(R.id.nomePat);
        this.loca = itemView.findViewById(R.id.localItem);
        //this.date = itemView.findViewById(R.id.dataItem);
    }

    public void preencher(Itens itens) {
        itemId = itens.getId();
        idI.setText(itens.getId().toString());
        pat.setText(itens.getAssociado().getNome().toString());
        loca.setText(itens.getLocalizacao().getNome().toString());
        /*if (itens.getData_movimentou() != null) {
            date.setText(DateFormat.getDateInstance(DateFormat.MEDIUM).format(itens.getData_movimentou()));
        }*/
    }
}