package com.japelapp.adapter.moradia;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.japelapp.R;

public class MoradiaViewHolder extends RecyclerView.ViewHolder {

    public Context context;
    public TextView txtEndereco;
    public TextView txtNumero;
    public TextView txtComplemento;
    public TextView txtCep;
    public TextView txtBairro;
    public TextView txtCidade;
    public Button btnSelecao;

    public MoradiaViewHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        txtEndereco = itemView.findViewById(R.id.formulario_pesquisa_item_endereco);
        txtNumero = itemView.findViewById(R.id.formulario_pesquisa_item_numero);
        txtComplemento = itemView.findViewById(R.id.formulario_pesquisa_item_complemento);
        txtCep = itemView.findViewById(R.id.formulario_pesquisa_item_cep);
        txtBairro = itemView.findViewById(R.id.formulario_pesquisa_item_bairro);
        txtCidade = itemView.findViewById(R.id.formulario_pesquisa_item_cidade);
        btnSelecao = itemView.findViewById(R.id.formulario_pesquisa_item_btn_editar);
    }
}
