package com.ifpb.model;

import java.time.LocalDate;

public class Seguidor {
    private int seguidor;
    private int usuario;
    private LocalDate since;

    public Seguidor(int seguidor, int usuario, LocalDate since) {
        this.seguidor = seguidor;
        this.usuario = usuario;
        this.since = since;
    }

    public int getSeguidor() {
        return seguidor;
    }

    public void setSeguidor(int seguidor) {
        this.seguidor = seguidor;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public LocalDate getSince() {
        return since;
    }

    public void setSince(LocalDate since) {
        this.since = since;
    }

    @Override
    public String toString() {
        return "Seguidor{" +
                "seguidor=" + seguidor +
                ", usuario=" + usuario +
                ", since=" + since +
                '}';
    }
}

