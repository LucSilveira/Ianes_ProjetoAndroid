package ianes.br.com.senai.ianes.models;

import java.util.Date;

/**
 * Created by 46923597811 on 15/06/2018.
 */

public class Itens {

    private Long identificacao;

    private Date data_movimentou;

    private Ambientes localizacao;
    private Usuario cadastrador;
    private Patrimonio associado;

    public Long getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Long identificacao) {
        this.identificacao = identificacao;
    }

    public Date getData_movimentou() {
        return data_movimentou;
    }

    public void setData_movimentou(Date data_movimentou) {
        this.data_movimentou = data_movimentou;
    }

    public Itens(Long identificacao, Date data_movimentacao, Ambientes localizacao, Usuario cadastrador, Patrimonio associado) {
        this.identificacao = identificacao;
        this.data_movimentou = data_movimentacao;
        this.localizacao = localizacao;
        this.cadastrador = cadastrador;
        this.associado = associado;
    }

    public Itens(Long identificacao, Patrimonio associado) {
        this.identificacao = identificacao;
        this.associado = associado;
    }

    @Override
    public String toString() {
        return "Item: " + identificacao +" do "+ associado;
    }

    public Long getId() {
        return identificacao;
    }

    public void setId(Long identificacao) {
        this.identificacao= identificacao;
    }



    public Ambientes getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Ambientes localizacao) {
        this.localizacao = localizacao;
    }

    public Usuario getCadastrador() {
        return cadastrador;
    }

    public void setCadastrador(Usuario cadastrador) {
        this.cadastrador = cadastrador;
    }

    public Patrimonio getAssociado() {
        return associado;
    }

    public void setAssociado(Patrimonio associado) {
        this.associado = associado;
    }
}
