package com.example.kaiqu.exerciciopdm;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kaiqu.exerciciopdm.entidades.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class Mensagem extends AppCompatActivity {

    private ArrayAdapter<String> itens;
    private ListView listView ;
    private TextView nomeContato;
    private Pessoa contato;
    private EditText campoMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensagem);

        //Pegando a referencia do listView do activity
        listView = (ListView) findViewById(R.id.listaMensagens);

        //pegando referencia do campo da mensagem
        campoMensagem = (EditText) findViewById(R.id.campoMensagem);

        //Pegando dados vindo do activity anterior(Contatos)
        Bundle bundle = getIntent().getExtras();
        contato = getIntent().getExtras().getParcelable("contato");

        //Setando o nome do canto em seu campo
        nomeContato = (TextView) findViewById(R.id.nomeContato);
        nomeContato.setText(contato.getNome());

        if (contato.getNome().equals("Ana Carla")){
            itens = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Contatos.anaCarla);
            listView.setAdapter(itens);
        }
        else if(contato.getNome().equals("João Paulo")){
            itens = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Contatos.joaoPaulo);
            listView.setAdapter(itens);
        }
        else{
            itens = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Contatos.viniciusPod);
            listView.setAdapter(itens);
        }
    }
    public void enviarMensagem(View view){
        if (contato.getNome().equals("Ana Carla")){
            Contatos.anaCarla.add(campoMensagem.getText().toString());
        }
        else if(contato.getNome().equals("João Paulo")){
            Contatos.joaoPaulo.add(campoMensagem.getText().toString());
        }
        else{
            Contatos.viniciusPod.add(campoMensagem.getText().toString());
        }
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
}
