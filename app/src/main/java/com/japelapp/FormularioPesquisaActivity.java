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

public class FormularioPesquisaActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pesquisa);

        recyclerView = findViewById(R.id.formulario_pesquisa_recicler_view);
        btnCadastrar = findViewById(R.id.formulario_pesquisa_btn_cadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCadastrarClick();
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

}
