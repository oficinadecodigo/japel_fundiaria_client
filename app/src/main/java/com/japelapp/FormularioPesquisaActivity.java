package com.japelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.DocumentsProvider;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.japelapp.adapter.moradia.MoradiaAdapter;
import com.japelapp.bd.DatabaseHelper;
import com.japelapp.bd.MoradiaDao;
import com.japelapp.bd.PessoaDao;
import com.japelapp.entidade.Moradia;
import com.japelapp.entidade.Pessoa;
import com.japelapp.network.Network;

import java.io.File;
import java.io.FileInputStream;
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
        MoradiaAdapter adapter = new MoradiaAdapter(moradiaDao.getNaoEnviados());
        recyclerView.setAdapter(adapter);
    }

    private void btnCadastrarClick() {
        Intent intent = new Intent(this, FormularioActivity.class);
        intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        //intent.putExtra("registry", 1925);
        startActivity(intent);
    }

    private void btnEnviarClick() {
        AsyncTask.execute(new Runnable() {
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
            String idPessoa = beneficiario.getId_site();
            if (nuloOuVazio(beneficiario.getId_site())) {
                mostarMensagemUi("Enviando beneficiário");
                idPessoa = Network.enviarPessoa(beneficiario, idUsuario, "1");
                beneficiario.setId_site(idPessoa);
                pessoaDao.update(beneficiario);
            }
            if (nuloOuVazio(moradia.getId_site())) {
                mostarMensagemUi("Enviando moradia");
                String idMoradia = Network.enviarMoradia(moradia, idUsuario, idPessoa);
                moradia.setId_site(idMoradia);
                moradiaDao.update(moradia);
            }
            if (nuloOuVazio(conjuje.getId_site()) && conjuje.isExiste()) {
                mostarMensagemUi("Enviando conjuje");
                String idCOnjuje = Network.enviarPessoa(conjuje, idUsuario, idPessoa);
                conjuje.setId_site(idCOnjuje);
                pessoaDao.update(conjuje);
            }
            for (Pessoa familiar : familiares) {
                if (nuloOuVazio(familiar.getId_site())) {
                    mostarMensagemUi("Enviando familiar");
                    String idFamiliar = Network.enviarPessoa(familiar, idUsuario, idPessoa);
                    familiar.setId_site(idFamiliar);
                    pessoaDao.update(familiar);
                }
            }
            String document = "content://com.android.providers.media.documents";
            //Fotos beneficiario
            if (!nuloOuVazio(beneficiario.getFoto_pessoa())) {
                mostarMensagemUi("Enviando foto pessoa beneficiário");
                Network.enviarFotos(beneficiario.getId_site() + "pessoa", beneficiario.getFoto_pessoa());
            }
            if (!nuloOuVazio(beneficiario.getFoto_cpf())) {
                mostarMensagemUi("Enviando foto CPF beneficiário");
                Network.enviarFotos(beneficiario.getId_site() + "cpf", beneficiario.getFoto_cpf());
            }
            if (!nuloOuVazio(beneficiario.getFoto_rg())) {
                mostarMensagemUi("Enviando foto RG beneficiário");
                Network.enviarFotos(beneficiario.getId_site() + "rg", beneficiario.getFoto_rg());
            }
            if (!nuloOuVazio(beneficiario.getFoto_rg_verso())) {
                mostarMensagemUi("Enviando foto verso RG beneficiário");
                Network.enviarFotos(beneficiario.getId_site() + "rg_verso", beneficiario.getFoto_rg_verso());
            }
            if (!nuloOuVazio(beneficiario.getFoto_cnh())) {
                mostarMensagemUi("Enviando foto CNH beneficiário");
                Network.enviarFotos(beneficiario.getId_site() + "cnh", beneficiario.getFoto_cnh());
            }
            if (!nuloOuVazio(beneficiario.getFoto_carteira_trabalho())) {
                mostarMensagemUi("Enviando foto carteira trab. beneficiário");
                Network.enviarFotos(beneficiario.getId_site() + "carteira_trab", beneficiario.getFoto_carteira_trabalho());
            }
            if (!nuloOuVazio(beneficiario.getFoto_documento_casa())) {
                mostarMensagemUi("Enviando foto documento casa beneficiário");
                Network.enviarFotos(beneficiario.getId_site() + "documento_casa", beneficiario.getFoto_documento_casa());
            }
            if (!nuloOuVazio(beneficiario.getFoto_comprovante_renda())) {
                mostarMensagemUi("Enviando foto comprovante renda beneficiário");
                Network.enviarFotos(beneficiario.getId_site() + "comprovante_renda", beneficiario.getFoto_comprovante_renda());
            }
            if (!nuloOuVazio(beneficiario.getFoto_comprovante_estado_civil())) {
                mostarMensagemUi("Enviando foto comprovante est. civil beneficiário");
                Network.enviarFotos(beneficiario.getId_site() + "comprovante_est_civil", beneficiario.getFoto_comprovante_estado_civil());
            }
            //Fotos conjuje
            if (!nuloOuVazio(conjuje.getFoto_pessoa())) {
                mostarMensagemUi("Enviando foto pessoa conjuje");
                Network.enviarFotos(conjuje.getId_site() + "pessoa", conjuje.getFoto_pessoa());
            }
            if (!nuloOuVazio(conjuje.getFoto_cpf())) {
                mostarMensagemUi("Enviando foto CPF beneficiário");
                Network.enviarFotos(conjuje.getId_site() + "cpf", conjuje.getFoto_cpf());
            }
            if (!nuloOuVazio(conjuje.getFoto_rg())) {
                mostarMensagemUi("Enviando foto RG beneficiário");
                Network.enviarFotos(conjuje.getId_site() + "rg", conjuje.getFoto_rg());
            }
            if (!nuloOuVazio(conjuje.getFoto_rg_verso())) {
                mostarMensagemUi("Enviando foto verso RG beneficiário");
                Network.enviarFotos(conjuje.getId_site() + "rg_verso", conjuje.getFoto_rg_verso());
            }
            if (!nuloOuVazio(conjuje.getFoto_cnh())) {
                mostarMensagemUi("Enviando foto CNH beneficiário");
                Network.enviarFotos(conjuje.getId_site() + "cnh", conjuje.getFoto_cnh());
            }
            if (!nuloOuVazio(conjuje.getFoto_carteira_trabalho())) {
                mostarMensagemUi("Enviando foto carteira trab. beneficiário");
                Network.enviarFotos(conjuje.getId_site() + "carteira_trab", conjuje.getFoto_carteira_trabalho());
            }
            if (!nuloOuVazio(conjuje.getFoto_documento_casa())) {
                mostarMensagemUi("Enviando foto documento casa beneficiário");
                Network.enviarFotos(conjuje.getId_site() + "documento_casa", conjuje.getFoto_documento_casa());
            }
            if (!nuloOuVazio(conjuje.getFoto_comprovante_renda())) {
                mostarMensagemUi("Enviando foto comprovante renda beneficiário");
                Network.enviarFotos(conjuje.getId_site() + "comprovante_renda", conjuje.getFoto_comprovante_renda());
            }
            if (!nuloOuVazio(conjuje.getFoto_comprovante_estado_civil())) {
                mostarMensagemUi("Enviando foto comprovante est. civil beneficiário");
                Network.enviarFotos(conjuje.getId_site() + "comprovante_est_civil", conjuje.getFoto_comprovante_estado_civil());
            }
            //Fotos moradia
            if (!nuloOuVazio(moradia.getFoto_comprovante_visita())) {
                mostarMensagemUi("Enviando foto comprovante visita moradia");
                Network.enviarFotos(moradia.getId_site() + "comprovante_visita", moradia.getFoto_comprovante_visita());
            }
            if (!nuloOuVazio(moradia.getFoto_fachada())) {
                mostarMensagemUi("Enviando foto fachada moradia");
                Network.enviarFotos(moradia.getId_site() + "fachada", moradia.getFoto_fachada());
            }
            if (!nuloOuVazio(moradia.getFoto_comprovante_agua())) {
                mostarMensagemUi("Enviando foto comprovante agua");
                Network.enviarFotos(moradia.getId_site() + "comprovante_agua", moradia.getFoto_comprovante_agua());
            }
            if (!nuloOuVazio(moradia.getFoto_comprovante_luz())) {
                mostarMensagemUi("Enviando foto comprovante luz moradia");
                Network.enviarFotos(moradia.getId_site() + "comprovante_luz", moradia.getFoto_comprovante_luz());
            }
            if (!nuloOuVazio(moradia.getFoto_comprovante_iptu())) {
                mostarMensagemUi("Enviando foto comprovante iptu moradia");
                Network.enviarFotos(moradia.getId_site() + "comprovante_iptu", moradia.getFoto_comprovante_iptu());
            }
            if (!nuloOuVazio(moradia.getFoto_documento_cartografico())) {
                mostarMensagemUi("Enviando foto documento cartográfico visita moradia");
                Network.enviarFotos(moradia.getId_site() + "documento_cartografico", moradia.getFoto_documento_cartografico());
            }
        }
    }

    private boolean nuloOuVazio(String string) {
        if (string == null) {
            return true;
        }
        if (string.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    private void mostarMensagemUi(String mensagem) {
        final Activity context = this;
        final String mensagemExibir = mensagem;
        context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, mensagemExibir, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
