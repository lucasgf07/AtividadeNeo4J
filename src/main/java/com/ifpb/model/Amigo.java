package com.ifpb.model;

import java.time.LocalDate;

public class Amigo {
    private int idAmigo;
    private int idAmigo2;
    private LocalDate data;

    public Amigo() {

    }

    public Amigo(int idAmigo, int idAmigo2, LocalDate data) {
        this.idAmigo = idAmigo;
        this.idAmigo2 = idAmigo2;
        this.data = data;
    }

    public int getIdAmigo() {
        return idAmigo;
    }

    public void setIdAmigo(int idAmigo) {
        this.idAmigo = idAmigo;
    }

    public int getIdAmigo2() {
        return idAmigo2;
    }

    public void setIdAmigo2(int idAmigo2) {
        this.idAmigo2 = idAmigo2;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Amigo{" +
                "idAmigo=" + idAmigo +
                ", idAmigo2=" + idAmigo2 +
                ", data=" + data +
                '}';
    }
}
