package ianes.br.com.senai.ianes.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ianes.br.com.senai.ianes.R;
import ianes.br.com.senai.ianes.adapter.ItemAdapter;
import ianes.br.com.senai.ianes.adapter.MovimentacaoAdapter;
import ianes.br.com.senai.ianes.models.Itens;
import ianes.br.com.senai.ianes.models.Movimentacao;

/**
 * Created by 46923597811 on 19/06/2018.
 */

public class MoviViewHolder  extends RecyclerView.ViewHolder{

    private final MovimentacaoAdapter moviAdapter;
    private final TextView idM;
    private final TextView org;
    private final TextView dest;
    private final TextView date;
    private long moviId;

    public MoviViewHolder(View view, MovimentacaoAdapter moviAdapter) {
        super(view);
        this.moviAdapter = moviAdapter;
        this.idM = itemView.findViewById(R.id.idMovi);
        this.org = itemView.findViewById(R.id.origemItem);
        this.dest = itemView.findViewById(R.id.destinoItem);
        this.date = itemView.findViewById(R.id.dataItem);
    }

    public void preencher(Movimentacao movi) {
        moviId = movi.getId();
        idM.setText(movi.getId().toString());
        org.setText(movi.getOrigem().toString());
        dest.setText(movi.getDestino().toString());
        date.setText(movi.getData_movimentacao().toString());
        //(itens.getData_movimentou() != null) {
            //date.setText(DateFormat.getDateInstance(DateFormat.MEDIUM).format(itens.getData_movimentou()));
        //}
    }
}