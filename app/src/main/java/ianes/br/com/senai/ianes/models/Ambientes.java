package ianes.br.com.senai.ianes.models;

/**
 * Created by 46923597811 on 15/06/2018.
 */

public class Ambientes {

    private Long id;
    private String nome;

    public Ambientes(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Ambiente: "+ nome;
    }

    public Ambientes(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
