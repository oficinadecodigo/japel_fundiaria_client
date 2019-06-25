package com.japelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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

    }

    private void btnCadastrarClick() {
        Intent intent = new Intent(this, FormularioActivity.class);
        startActivity(intent);
    }

}
