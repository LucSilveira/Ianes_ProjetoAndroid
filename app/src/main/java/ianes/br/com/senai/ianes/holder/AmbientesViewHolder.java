package ianes.br.com.senai.ianes.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ianes.br.com.senai.ianes.R;
import ianes.br.com.senai.ianes.adapter.AmbienteAdapter;
import ianes.br.com.senai.ianes.models.Ambientes;

/**
 * Created by 46923597811 on 18/06/2018.
 */

public class AmbientesViewHolder extends RecyclerView.ViewHolder{

    private final AmbienteAdapter ambienteAdapter;
    private final TextView nome;
    private final TextView idA;
    private long ambienteId;

    public AmbientesViewHolder(View view, AmbienteAdapter ambienteAdapter) {
        super(view);
        this.ambienteAdapter = ambienteAdapter;
        this.nome = itemView.findViewById(R.id.nomeAmbiente);
        this.idA = itemView.findViewById(R.id.idAmbiente);
    }

    public void preencher(Ambientes ambientes) {
        ambienteId = ambientes.getId();
        nome.setText(ambientes.getNome());
        idA.setText(ambientes.getId().toString());
    }
}
