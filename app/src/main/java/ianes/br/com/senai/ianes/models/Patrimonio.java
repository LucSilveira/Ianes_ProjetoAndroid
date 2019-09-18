package ianes.br.com.senai.ianes.models;

import java.util.Date;

/**
 * Created by 46923597811 on 15/06/2018.
 */

public class Patrimonio {

    private Long id;
    private String nome;
    private Date data_cadastro;
    private Categoria possui;
    private Usuario cadastrador;

    public Patrimonio(Long id, Date data_cadastro, Categoria possui, Usuario cadastrador) {
        this.id = id;
        this.data_cadastro = data_cadastro;
        this.possui = possui;
        this.cadastrador = cadastrador;
    }

    @Override
    public String toString() {
        return "Patrimonio: " + nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Categoria getPossui() {
        return possui;
    }

    public void setPossui(Categoria possui) {
        this.possui = possui;
    }

    public Usuario getCadastrador() {
        return cadastrador;
    }

    public void setCadastrador(Usuario cadastrador) {
        this.cadastrador = cadastrador;
    }
}
