package com.example.kaiqu.exerciciopdm;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.kaiqu.exerciciopdm.entidades.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Contatos extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ArrayAdapter<Pessoa> itens;
    private ListView contatos;

    static List<String> anaCarla = new ArrayList<String>();
    static List<String> joaoPaulo = new ArrayList<String>();
    static List<String> viniciusPod = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);

        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        pessoas.add(new Pessoa("Ana Carla"));
        pessoas.add(new Pessoa("João Paulo"));
        pessoas.add(new Pessoa("Vinicius POD"));

        itens = new ArrayAdapter<Pessoa>(this, android.R.layout.simple_expandable_list_item_1, pessoas);
        //itens.getView(0, ).setb
        contatos = (ListView) findViewById(R.id.listView);
        contatos.setAdapter(itens);

        contatos.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it = new Intent(this, Mensagem.class);
        Pessoa contato = (Pessoa) parent.getItemAtPosition(position);
        it.putExtra("contato", contato);
        startActivity(it);
    }
}
