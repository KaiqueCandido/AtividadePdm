package com.example.kaiqu.exerciciopdm.entidades;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by kaiqu on 20/07/2016.
 */
public class Pessoa implements Parcelable {

    private String nome;


    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Pessoa() {
    }

    protected Pessoa(Parcel in) {
        nome = in.readString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public static final Creator<Pessoa> CREATOR = new Creator<Pessoa>() {
        @Override
        public Pessoa createFromParcel(Parcel in) {
            return new Pessoa(in);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(nome);
    }




}
