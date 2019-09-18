package ianes.br.com.senai.ianes.models;

import android.renderscript.ScriptIntrinsicYuvToRGB;

/**
 * Created by 46923597811 on 14/06/2018.
 */

public class Usuario {

    private Long id;
    private String email;
    private String senha;
    private String nome;

    private Usuario(){}

    public Usuario(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    public Usuario(Long id, String email, String senha, String nome) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}