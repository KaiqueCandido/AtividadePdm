package com.example.kaiqu.exerciciopdm;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private String senhapadrao = "123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void evtButtonAcessar(View v) {
        EditText editTextSenha = (EditText) findViewById(R.id.senha);
        String senhainserida = editTextSenha.getText().toString();

        if (senhapadrao.equals(senhainserida)){
            startActivity(new Intent(this, Contatos.class));
        }
        else{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Falha!");
            builder.setMessage("Falha ao tentar entrar!");
            builder.create().show();
        }
    }
}
