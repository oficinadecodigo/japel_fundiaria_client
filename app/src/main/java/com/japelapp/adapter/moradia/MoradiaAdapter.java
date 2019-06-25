package com.japelapp.adapter.moradia;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.japelapp.FormularioActivity;
import com.japelapp.R;
import com.japelapp.entidade.Moradia;

import java.util.List;

public class MoradiaAdapter extends RecyclerView.Adapter<MoradiaViewHolder> {

    private List<Moradia> registros;
    private Context context;

    public MoradiaAdapter(List<Moradia> Moradias) {
        this.registros = Moradias;
    }

    @Override
    public MoradiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MoradiaViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.formulario_pesquisa_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final MoradiaViewHolder holder, final int position) {
        holder.txtEndereco.setText(registros.get(position).getEndereco());
        holder.txtNumero.setText(registros.get(position).getNumero());
        holder.txtComplemento.setText(registros.get(position).getComplemento());
        holder.txtCep.setText(registros.get(position).getCep());
        holder.txtBairro.setText(registros.get(position).getBairro());
        holder.txtCidade.setText(registros.get(position).getCidade());
        holder.btnSelecao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaEdicao(registros.get(position), holder.context);
            }
        });
    }

    private void abrirTelaEdicao(Moradia registro, Context context) {
        Intent intent = new Intent(context, FormularioActivity.class);
        intent.putExtra("registry", registro.getId());
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return registros != null ? registros.size() : 0;
    }

}
