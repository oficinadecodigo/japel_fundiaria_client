package com.japelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.japelapp.adapter.moradia.MoradiaAdapter;
import com.japelapp.bd.DatabaseHelper;
import com.japelapp.bd.MoradiaDao;
import com.japelapp.bd.PessoaDao;
import com.japelapp.entidade.Moradia;
import com.japelapp.entidade.Pessoa;
import com.japelapp.network.Network;

import java.util.ArrayList;

public class FormularioPesquisaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnCadastrar;
    Button btnEnviButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pesquisa);

        recyclerView = findViewById(R.id.formulario_pesquisa_recicler_view);
        btnCadastrar = findViewById(R.id.formulario_pesquisa_btn_cadastrar);
        btnEnviButton = findViewById(R.id.formulario_pesquisa_btn_enviar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCadastrarClick();
            }
        });

        btnEnviButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnEnviarClick();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    @Override
    protected void onResume() {
        super.onResume();
        pesquisar();
    }

    private void pesquisar() {
        MoradiaDao moradiaDao = new MoradiaDao(new DatabaseHelper(this.getApplicationContext()));
        MoradiaAdapter adapter = new MoradiaAdapter(moradiaDao.get());
        recyclerView.setAdapter(adapter);
    }

    private void btnCadastrarClick() {
        Intent intent = new Intent(this, FormularioActivity.class);
        //intent.putExtra("registry", 1925);
        startActivity(intent);
    }

    private void btnEnviarClick() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                enviar();
            }
        });
    }

    private void enviar() {
        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        MoradiaDao moradiaDao = new MoradiaDao(databaseHelper);
        PessoaDao pessoaDao = new PessoaDao(databaseHelper);
        ArrayList<Moradia> moradias = moradiaDao.get();
        for (Moradia moradia : moradias) {
            Pessoa beneficiario = pessoaDao.get(moradia.getId_pessoa());
            Pessoa conjuje = pessoaDao.getConjuje(moradia.getId_pessoa());
            ArrayList<Pessoa> familiares = pessoaDao.getCompFam(moradia.getId_pessoa());
            String idUsuario = "1";
            String idPessoa = Network.enviarPessoa(beneficiario, "", "");
            Network.enviarMoradia(moradia, idUsuario, idPessoa);
            Network.enviarPessoa(conjuje, idUsuario, idPessoa);
            for (Pessoa familiar : familiares) {
                Network.enviarPessoa(familiar, idUsuario, idPessoa);
            }
        }
    }

}
