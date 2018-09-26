package com.ifpb.model;

import java.time.LocalDate;

public class Publicacao {
    private String nomeUsuario;
    private int idPublicacao;
    private int idUsuario;
    private String conteudo;
    private LocalDate data;

    public Publicacao() {

    }

    public Publicacao(String nomeUsuario, int idPublicacao, int idUsuario, String conteudo, LocalDate data) {
        this.nomeUsuario = nomeUsuario;
        this.idPublicacao = idPublicacao;
        this.idUsuario = idUsuario;
        this.conteudo = conteudo;
        this.data = data;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(int idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "nomeUsuario='" + nomeUsuario + '\'' +
                ", idPublicacao=" + idPublicacao +
                ", idUsuario=" + idUsuario +
                ", conteudo='" + conteudo + '\'' +
                ", data=" + data +
                '}';
    }
}
