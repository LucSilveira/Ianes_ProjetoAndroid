package ianes.br.com.senai.ianes.models;

import java.util.Date;

/**
 * Created by 46923597811 on 15/06/2018.
 */

public class Movimentacao {

    private Long id;
    private Date data_movimentacao;
    private Usuario movimenta;
    private Ambientes origem;
    private Ambientes destino;
    private Itens idetificacao;

    public Movimentacao(Long id, Date data_movimentacao, Usuario movimenta, Ambientes origem, Ambientes destino, Itens idetificacao) {
        this.id = id;
        this.data_movimentacao = data_movimentacao;
        this.movimenta = movimenta;
        this.origem = origem;
        this.destino = destino;
        this.idetificacao = idetificacao;
    }

    public Movimentacao(Ambientes destino, Itens idetificacao) {
        this.destino = destino;
        this.idetificacao = idetificacao;
    }

    @Override
    public String toString() {
        return "Movimentacao{" +
                "id=" + id +
                ", data_movimentacao=" + data_movimentacao +
                ", movimenta=" + movimenta +
                ", origem=" + origem +
                ", destino=" + destino +
                ", idetificacao=" + idetificacao +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_movimentacao() {
        return data_movimentacao;
    }

    public void setData_movimentacao(Date data_movimentacao) {
        this.data_movimentacao = data_movimentacao;
    }

    public Usuario getMovimenta() {
        return movimenta;
    }

    public void setMovimenta(Usuario movimenta) {
        this.movimenta = movimenta;
    }

    public Ambientes getOrigem() {
        return origem;
    }

    public void setOrigem(Ambientes origem) {
        this.origem = origem;
    }

    public Ambientes getDestino() {
        return destino;
    }

    public void setDestino(Ambientes destino) {
        this.destino = destino;
    }

    public Itens getIdetificacao() {
        return idetificacao;
    }

    public void setIdetificacao(Itens idetificacao) {
        this.idetificacao = idetificacao;
    }
}
