package com.japelapp;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.japelapp.bd.DatabaseHelper;
import com.japelapp.bd.MoradiaDao;
import com.japelapp.bd.PessoaDao;
import com.japelapp.entidade.Moradia;
import com.japelapp.entidade.Pessoa;
import com.japelapp.ui.formulario.FormularioBeneficiarioFragment;
import com.japelapp.ui.formulario.FormularioCompFamFragment;
import com.japelapp.ui.formulario.FormularioConjujeFragment;
import com.japelapp.ui.formulario.FormularioFotosFragment;
import com.japelapp.ui.formulario.FormularioMoradiaFragment;
import com.japelapp.ui.formulario.SectionsPagerAdapter;
import com.japelapp.util.Sessao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class FormularioActivity extends AppCompatActivity {

    SectionsPagerAdapter sectionsPagerAdapter;
    ViewPager viewPager;
    TabLayout tabs;

    FloatingActionButton fab;

    private FormularioBeneficiarioFragment fragmentBeneficiario;
    private FormularioConjujeFragment fragmentConjuje;
    private FormularioCompFamFragment fragmentCompFam;
    private FormularioMoradiaFragment fragmentMoradia;
    private FormularioFotosFragment fragmentFotos;

    //Campos do fragment beneficiario

    EditText beneficiario_nome;
    EditText beneficiario_cpf;
    EditText beneficiario_rg;
    EditText beneficiario_nome_mae;
    EditText beneficiario_nome_pai;
    Spinner beneficiario_sexo;
    Spinner beneficiario_raca;
    EditText beneficiario_data_nascimento;
    EditText beneficiario_email;
    Spinner beneficiario_nacionalidade;
    EditText beneficiario_numero_cpts;
    EditText beneficiario_pis_pasep;
    EditText beneficiario_numero_cadunico;
    EditText beneficiario_nis;
    Spinner beneficiario_escolaridade;
    Spinner beneficiario_estado_civil;
    Spinner beneficiario_situacao_conjugal;
    EditText beneficiario_profissao;
    EditText beneficiario_renda_formal;
    Spinner beneficiario_situacao_renda_formal;
    EditText beneficiario_renda_informal;
    Spinner beneficiario_situacao_renda_informal;
    Spinner beneficiario_ramo_atividade;
    EditText beneficiario_empregador;
    EditText beneficiario_tempo_servico_emprego_atual;
    EditText beneficiario_valor_fgts;
    EditText beneficiario_telefone_fixo;
    EditText beneficiario_telefone_movel;
    EditText beneficiario_telefone_recado;
    EditText beneficiario_falar_com;
    EditText beneficiario_tempo_residencia_imovel;
    EditText beneficiario_tempo_residencia_municipio;
    CheckBox beneficiario_interesse_moradia_urbana;
    CheckBox beneficiario_interesse_moradia_rural;
    CheckBox beneficiario_interesse_lote;
    CheckBox beneficiario_interesse_regularizacao_fundiaria;
    CheckBox beneficiario_deficiencia_auditiva_mudez;
    CheckBox beneficiario_deficiencia_auditiva_surdez;
    CheckBox beneficiario_deficiencia_cadeirante;
    CheckBox beneficiario_deficiencia_fisica;
    CheckBox beneficiario_deficiencia_intelectual;
    CheckBox beneficiario_deficiencia_nanismo;
    CheckBox beneficiario_deficiencia_visual;
    CheckBox beneficiario_titular_conjuge_mulher_maria_penha;
    CheckBox beneficiario_proprietario_imovel;
    CheckBox beneficiario_proprietario_lote;
    CheckBox beneficiario_proprietario_imovel_precario;
    CheckBox beneficiario_convenio;
    EditText beneficiario_foto_pessoa;
    EditText beneficiario_foto_cpf;
    EditText beneficiario_foto_rg;
    EditText beneficiario_foto_rg_verso;
    EditText beneficiario_foto_cnh;
    EditText beneficiario_foto_carteira_trabalho;
    EditText beneficiario_foto_documento_casa;
    EditText beneficiario_foto_comprovante_renda;
    EditText beneficiario_foto_comprovante_estado_civil;

    //Campos fragment conjuje

    EditText conjuje_nome;
    EditText conjuje_cpf;
    EditText conjuje_rg;
    EditText conjuje_nome_mae;
    EditText conjuje_nome_pai;
    Spinner conjuje_sexo;
    Spinner conjuje_raca;
    EditText conjuje_data_nascimento;
    Spinner conjuje_nacionalidade;
    EditText conjuje_numero_cadunico;
    EditText conjuje_nis;
    Spinner conjuje_escolaridade;
    Spinner conjuje_estado_civil;
    Spinner conjuje_situacao_conjugal;
    EditText conjuje_profissao;
    EditText conjuje_renda_formal;
    Spinner conjuje_situacao_renda_formal;
    EditText conjuje_renda_informal;
    Spinner conjuje_situacao_renda_informal;
    Spinner conjuje_ramo_atividade;
    EditText conjuje_empregador;
    EditText conjuje_tempo_servico_emprego_atual;
    EditText conjuje_valor_fgts;
    CheckBox conjuje_deficiencia_auditiva_mudez;
    CheckBox conjuje_deficiencia_auditiva_surdez;
    CheckBox conjuje_deficiencia_cadeirante;
    CheckBox conjuje_deficiencia_fisica;
    CheckBox conjuje_deficiencia_intelectual;
    CheckBox conjuje_deficiencia_nanismo;
    CheckBox conjuje_deficiencia_visual;
    EditText conjuje_foto_pessoa;
    EditText conjuje_foto_cpf;
    EditText conjuje_foto_rg;
    EditText conjuje_foto_rg_verso;
    EditText conjuje_foto_cnh;
    EditText conjuje_foto_carteira_trabalho;
    EditText conjuje_foto_documento_casa;
    EditText conjuje_foto_comprovante_renda;
    EditText conjuje_foto_comprovante_estado_civil;


    //Campos fragment comp fam

    Spinner comp_fam_itens;
    Button btn_editar_comp;
    Button btn_criar_comp;
    Button btn_salvar_comp;

    EditText comp_fam_nome;
    Spinner comp_fam_parentesco;
    Spinner comp_fam_sexo;
    EditText comp_fam_data_nascimento;
    Spinner comp_fam_escolaridade;
    EditText comp_fam_profissao;
    EditText comp_fam_renda_formal;
    Spinner comp_fam_situacao_renda_formal;
    EditText comp_fam_renda_informal;
    Spinner comp_fam_situacao_renda_informal;
    CheckBox comp_fam_deficiencia_auditiva_mudez;
    CheckBox comp_fam_deficiencia_auditiva_surdez;
    CheckBox comp_fam_deficiencia_cadeirante;
    CheckBox comp_fam_deficiencia_fisica;
    CheckBox comp_fam_deficiencia_intelectual;
    CheckBox comp_fam_deficiencia_nanismo;
    CheckBox comp_fam_deficiencia_visual;


    //Campos fragment moradia

    EditText moradia_quadra;
    EditText moradia_lote;
    Spinner moradia_poligonal;
    EditText moradia_endereco;
    EditText moradia_numero;
    EditText moradia_complemento;
    EditText moradia_cep;
    EditText moradia_bairro;
    EditText moradia_cidade;
    EditText moradia_uf;
    EditText moradia_area_construida;
    EditText moradia_matricula_imovel;
    EditText moradia_medida_frente;
    EditText moradia_medida_direita;
    EditText moradia_medida_esquerda;
    EditText moradia_medida_fundo;
    EditText moradia_numero_lote_direita;
    EditText moradia_numero_lote_esquerda;
    EditText moradia_numero_lote_fundo;
    EditText moradia_rua_frente;
    EditText moradia_rua_direita;
    EditText moradia_rua_esquerda;
    EditText moradia_rua_fundo;
    EditText moradia_selagem;
    EditText moradia_latitude;
    EditText moradia_longitude;
    EditText moradia_altitude;
    Spinner moradia_zona;
    Spinner moradia_situacao_propriedade;
    EditText moradia_valor_aluguel;
    EditText moradia_numero_quartos;
    EditText moradia_numero_comodos;
    Spinner moradia_tipo_construcao;
    EditText moradia_outro_tipo_construcao;
    CheckBox moradia_fonte_energia;
    CheckBox moradia_abastecimento_agua;
    CheckBox moradia_rede_esgoto;
    CheckBox moradia_coleta_lixo;
    CheckBox moradia_separacao_reciclaveis;
    EditText moradia_valor_beneficio_prestacao_continuada;
    EditText moradia_valor_bolsa_familia;
    EditText moradia_outro_beneficio;
    CheckBox moradia_reside_area_risco;
    CheckBox moradia_reside_area_insalubre;
    CheckBox moradia_desabrigado;
    EditText moradia_observacao;
    EditText moradia_foto_comprovante_visita;
    EditText moradia_foto_fachada;
    EditText moradia_foto_comprovante_agua;
    EditText moradia_foto_comprovante_luz;
    EditText moradia_foto_comprovante_iptu;
    EditText moradia_foto_documento_cartografico;

    Moradia moradia;
    Pessoa beneficiario;
    Pessoa conjuje;
    Pessoa compFamiliar;
    ArrayList<Pessoa> familiares = new ArrayList<>();

    EditText editTextRetornoImagem;

    private void abrirImagemRetornarCampo(EditText editText) {
        editTextRetornoImagem = editText;
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Selecione a imagem"), 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                editTextRetornoImagem.setText(data.getData().getPath());
            }
        }
    }

    private void preencherTela() {
        preencherTelaBeneficiario(beneficiario);
        preencherTelaConjuje(conjuje);
        preencherTelaMoradia(moradia);
        preencherSpinnerFamiliares();
    }

    private void preencherSpinnerFamiliares() {
        ArrayAdapter<Pessoa> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, familiares);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        comp_fam_itens.setAdapter(adapter);
    }

    private void editarCompFam() {
        compFamiliar = null;
        try {
            compFamiliar = (Pessoa) comp_fam_itens.getSelectedItem();
        } catch (Throwable ex) {
        }
        if (compFamiliar == null) {
            Toast.makeText(this, "Não foi possível selecionar o item para editar", Toast.LENGTH_SHORT);
        } else {
            preencherTelaCompFam(compFamiliar);
        }
    }

    private void criarCompFam() {
        PessoaDao pessoaDao = new PessoaDao(new DatabaseHelper(this));
        Pessoa compFamPessoa = new Pessoa();
        compFamPessoa.setId(pessoaDao.getMaxId() + 1);
        compFamPessoa.setId_usuario(Sessao.USUARIO.getId());
        compFamPessoa.setId_pessoa(beneficiario.getId());
        pessoaDao.insert(compFamPessoa);
        familiares.add(compFamPessoa);
        compFamiliar = compFamPessoa;
        preencherSpinnerFamiliares();
    }

    private void salvarCompFam() {
        if (compFamiliar == null) {
            criarCompFam();
        }
        preencherEntidadeCompFam(compFamiliar);
        PessoaDao pessoaDao = new PessoaDao(new DatabaseHelper(this));
        pessoaDao.update(compFamiliar);
        compFamiliar = null;
        limparTelaCompFam();
        preencherSpinnerFamiliares();
    }

    private void inicializarComponentes() {
        //Inicializando componentes do fragment beneficiário
        beneficiario_nome = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_nome);
        beneficiario_cpf = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_cpf);
        beneficiario_rg = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_rg);
        beneficiario_nome_mae = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_nome_mae);
        beneficiario_nome_pai = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_nome_pai);
        beneficiario_sexo = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_sexo);
        beneficiario_raca = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_raca);
        beneficiario_data_nascimento = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_data_nascimento);
        final Calendar myCalendar = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String data = dayOfMonth + "/" + monthOfYear + "/" + year;
                beneficiario_data_nascimento.setText(data);
            }

        };
        beneficiario_data_nascimento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    new DatePickerDialog(getWindow().getContext(), date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                } catch (Throwable ex) {
                }
            }
        });
        beneficiario_email = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_email);
        beneficiario_nacionalidade = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_nacionalidade);
        beneficiario_numero_cpts = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_numero_cpts);
        beneficiario_pis_pasep = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_pis_pasep);
        beneficiario_numero_cadunico = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_numero_cadunico);
        beneficiario_nis = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_nis);
        beneficiario_escolaridade = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_escolaridade);
        beneficiario_estado_civil = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_estado_civil);
        beneficiario_situacao_conjugal = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_situacao_conjugal);
        beneficiario_profissao = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_profissao);
        beneficiario_renda_formal = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_renda_formal);
        beneficiario_situacao_renda_formal = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_situacao_renda_formal);
        beneficiario_renda_informal = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_renda_informal);
        beneficiario_situacao_renda_informal = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_situacao_renda_informal);
        beneficiario_ramo_atividade = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_ramo_atividade);
        beneficiario_empregador = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_empregador);
        beneficiario_tempo_servico_emprego_atual = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_tempo_servico_emprego_atual);
        beneficiario_valor_fgts = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_valor_fgts);
        beneficiario_telefone_fixo = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_telefone_fixo);
        beneficiario_telefone_movel = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_telefone_movel);
        beneficiario_telefone_recado = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_telefone_recado);
        beneficiario_falar_com = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_falar_com);
        beneficiario_tempo_residencia_imovel = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_tempo_residencia_imovel);
        beneficiario_tempo_residencia_municipio = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_tempo_residencia_municipio);
        beneficiario_interesse_moradia_urbana = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_interesse_moradia_urbana);
        beneficiario_interesse_moradia_rural = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_interesse_moradia_rural);
        beneficiario_interesse_lote = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_interesse_lote);
        beneficiario_interesse_regularizacao_fundiaria = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_interesse_regularizacao_fundiaria);
        beneficiario_deficiencia_auditiva_mudez = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_deficiencia_auditiva_mudez);
        beneficiario_deficiencia_auditiva_surdez = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_deficiencia_auditiva_surdez);
        beneficiario_deficiencia_cadeirante = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_deficiencia_cadeirante);
        beneficiario_deficiencia_fisica = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_deficiencia_fisica);
        beneficiario_deficiencia_intelectual = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_deficiencia_intelectual);
        beneficiario_deficiencia_nanismo = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_deficiencia_nanismo);
        beneficiario_deficiencia_visual = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_deficiencia_visual);
        beneficiario_titular_conjuge_mulher_maria_penha = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_titular_conjuge_mulher_maria_penha);
        beneficiario_proprietario_imovel = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_proprietario_imovel);
        beneficiario_proprietario_lote = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_proprietario_lote);
        beneficiario_proprietario_imovel_precario = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_proprietario_imovel_precario);
        beneficiario_convenio = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_convenio);
        beneficiario_foto_pessoa = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_pessoa);
        beneficiario_foto_cpf = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_cpf);
        beneficiario_foto_rg = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_rg);
        beneficiario_foto_rg_verso = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_rg_verso);
        beneficiario_foto_cnh = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_cnh);
        beneficiario_foto_carteira_trabalho = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_carteira_trabalho);
        beneficiario_foto_documento_casa = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_documento_casa);
        beneficiario_foto_comprovante_renda = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_comprovante_renda);
        beneficiario_foto_comprovante_estado_civil = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_comprovante_estado_civil);

        //Iniciaizando os componentes do fragment conjuje

        conjuje_nome = fragmentConjuje.getView().findViewById(R.id.form_conjuje_nome);
        conjuje_cpf = fragmentConjuje.getView().findViewById(R.id.form_conjuje_cpf);
        conjuje_rg = fragmentConjuje.getView().findViewById(R.id.form_conjuje_rg);
        conjuje_nome_mae = fragmentConjuje.getView().findViewById(R.id.form_conjuje_nome_mae);
        conjuje_nome_pai = fragmentConjuje.getView().findViewById(R.id.form_conjuje_nome_pai);
        conjuje_sexo = fragmentConjuje.getView().findViewById(R.id.form_conjuje_sexo);
        conjuje_raca = fragmentConjuje.getView().findViewById(R.id.form_conjuje_raca);
        conjuje_data_nascimento = fragmentConjuje.getView().findViewById(R.id.form_conjuje_data_nascimento);
        final Calendar myCalendar2 = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date2 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar2.set(Calendar.YEAR, year);
                myCalendar2.set(Calendar.MONTH, monthOfYear);
                myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String data = dayOfMonth + "/" + monthOfYear + "/" + year;
                conjuje_data_nascimento.setText(data);
            }

        };
        conjuje_data_nascimento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    new DatePickerDialog(getWindow().getContext(), date2, myCalendar2
                            .get(Calendar.YEAR), myCalendar2.get(Calendar.MONTH),
                            myCalendar2.get(Calendar.DAY_OF_MONTH)).show();
                } catch (Throwable ex) {
                }
            }
        });
        conjuje_nacionalidade = fragmentConjuje.getView().findViewById(R.id.form_conjuje_nacionalidade);
        conjuje_numero_cadunico = fragmentConjuje.getView().findViewById(R.id.form_conjuje_numero_cadunico);
        conjuje_nis = fragmentConjuje.getView().findViewById(R.id.form_conjuje_nis);
        conjuje_escolaridade = fragmentConjuje.getView().findViewById(R.id.form_conjuje_escolaridade);
        conjuje_estado_civil = fragmentConjuje.getView().findViewById(R.id.form_conjuje_estado_civil);
        conjuje_situacao_conjugal = fragmentConjuje.getView().findViewById(R.id.form_conjuje_situacao_conjugal);
        conjuje_profissao = fragmentConjuje.getView().findViewById(R.id.form_conjuje_profissao);
        conjuje_renda_formal = fragmentConjuje.getView().findViewById(R.id.form_conjuje_renda_formal);
        conjuje_situacao_renda_formal = fragmentConjuje.getView().findViewById(R.id.form_conjuje_situacao_renda_formal);
        conjuje_renda_informal = fragmentConjuje.getView().findViewById(R.id.form_conjuje_renda_informal);
        conjuje_situacao_renda_informal = fragmentConjuje.getView().findViewById(R.id.form_conjuje_situacao_renda_informal);
        conjuje_ramo_atividade = fragmentConjuje.getView().findViewById(R.id.form_conjuje_ramo_atividade);
        conjuje_empregador = fragmentConjuje.getView().findViewById(R.id.form_conjuje_empregador);
        conjuje_tempo_servico_emprego_atual = fragmentConjuje.getView().findViewById(R.id.form_conjuje_tempo_servico_emprego_atual);
        conjuje_valor_fgts = fragmentConjuje.getView().findViewById(R.id.form_conjuje_valor_fgts);
        conjuje_deficiencia_auditiva_mudez = fragmentConjuje.getView().findViewById(R.id.form_conjuje_deficiencia_auditiva_mudez);
        conjuje_deficiencia_auditiva_surdez = fragmentConjuje.getView().findViewById(R.id.form_conjuje_deficiencia_auditiva_surdez);
        conjuje_deficiencia_cadeirante = fragmentConjuje.getView().findViewById(R.id.form_conjuje_deficiencia_cadeirante);
        conjuje_deficiencia_fisica = fragmentConjuje.getView().findViewById(R.id.form_conjuje_deficiencia_fisica);
        conjuje_deficiencia_intelectual = fragmentConjuje.getView().findViewById(R.id.form_conjuje_deficiencia_intelectual);
        conjuje_deficiencia_nanismo = fragmentConjuje.getView().findViewById(R.id.form_conjuje_deficiencia_nanismo);
        conjuje_deficiencia_visual = fragmentConjuje.getView().findViewById(R.id.form_conjuje_deficiencia_visual);
        conjuje_foto_pessoa = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_pessoa);
        conjuje_foto_cpf = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_cpf);
        conjuje_foto_rg = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_rg);
        conjuje_foto_rg_verso = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_rg_verso);
        conjuje_foto_cnh = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_cnh);
        conjuje_foto_carteira_trabalho = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_carteira_trabalho);
        conjuje_foto_documento_casa = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_documento_casa);
        conjuje_foto_comprovante_renda = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_comprovante_renda);
        conjuje_foto_comprovante_estado_civil = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_comprovante_estado_civil);

        //Inicializando componentes dos componentes familiares


        comp_fam_itens = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_spinner_itens);
        btn_editar_comp = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_btn_edt);
        btn_criar_comp = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_btn_criar);
        btn_salvar_comp = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_btn_slv);

        btn_editar_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editarCompFam();
            }
        });
        btn_criar_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                criarCompFam();
            }
        });
        btn_salvar_comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarCompFam();
            }
        });

        comp_fam_nome = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_nome);
        comp_fam_parentesco = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_parentesco);
        comp_fam_sexo = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_sexo);
        comp_fam_data_nascimento = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_data_nascimento);
        final Calendar myCalendar3 = Calendar.getInstance();
        final DatePickerDialog.OnDateSetListener date3 = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar3.set(Calendar.YEAR, year);
                myCalendar3.set(Calendar.MONTH, monthOfYear);
                myCalendar3.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String data = dayOfMonth + "/" + monthOfYear + "/" + year;
                comp_fam_data_nascimento.setText(data);
            }

        };
        comp_fam_data_nascimento.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    new DatePickerDialog(getWindow().getContext(), date3, myCalendar3
                            .get(Calendar.YEAR), myCalendar3.get(Calendar.MONTH),
                            myCalendar3.get(Calendar.DAY_OF_MONTH)).show();
                } catch (Throwable ex) {
                }
            }
        });

        comp_fam_escolaridade = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_escolaridade);
        comp_fam_profissao = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_profissao);
        comp_fam_renda_formal = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_renda_formal);
        comp_fam_situacao_renda_formal = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_situacao_renda_formal);
        comp_fam_renda_informal = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_renda_informal);
        comp_fam_situacao_renda_informal = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_situacao_renda_informal);
        comp_fam_deficiencia_auditiva_mudez = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_deficiencia_auditiva_mudez);
        comp_fam_deficiencia_auditiva_surdez = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_deficiencia_auditiva_surdez);
        comp_fam_deficiencia_cadeirante = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_deficiencia_cadeirante);
        comp_fam_deficiencia_fisica = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_deficiencia_fisica);
        comp_fam_deficiencia_intelectual = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_deficiencia_intelectual);
        comp_fam_deficiencia_nanismo = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_deficiencia_nanismo);
        comp_fam_deficiencia_visual = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_deficiencia_visual);

        //Inicializando os componentes da moradia

        moradia_quadra = fragmentMoradia.getView().findViewById(R.id.form_moradia_quadra);
        moradia_lote = fragmentMoradia.getView().findViewById(R.id.form_moradia_lote);
        moradia_poligonal = fragmentMoradia.getView().findViewById(R.id.form_moradia_poligonal);
        moradia_endereco = fragmentMoradia.getView().findViewById(R.id.form_moradia_endereco);
        moradia_numero = fragmentMoradia.getView().findViewById(R.id.form_moradia_numero);
        moradia_complemento = fragmentMoradia.getView().findViewById(R.id.form_moradia_complemento);
        moradia_cep = fragmentMoradia.getView().findViewById(R.id.form_moradia_cep);
        moradia_bairro = fragmentMoradia.getView().findViewById(R.id.form_moradia_bairro);
        moradia_cidade = fragmentMoradia.getView().findViewById(R.id.form_moradia_cidade);
        moradia_uf = fragmentMoradia.getView().findViewById(R.id.form_moradia_uf);
        moradia_area_construida = fragmentMoradia.getView().findViewById(R.id.form_moradia_area_construida);
        moradia_matricula_imovel = fragmentMoradia.getView().findViewById(R.id.form_moradia_matricula_imovel);
        moradia_medida_frente = fragmentMoradia.getView().findViewById(R.id.form_moradia_medida_frente);
        moradia_medida_direita = fragmentMoradia.getView().findViewById(R.id.form_moradia_medida_direita);
        moradia_medida_esquerda = fragmentMoradia.getView().findViewById(R.id.form_moradia_medida_esquerda);
        moradia_medida_fundo = fragmentMoradia.getView().findViewById(R.id.form_moradia_medida_fundo);
        moradia_numero_lote_direita = fragmentMoradia.getView().findViewById(R.id.form_moradia_numero_lote_direita);
        moradia_numero_lote_esquerda = fragmentMoradia.getView().findViewById(R.id.form_moradia_numero_lote_esquerda);
        moradia_numero_lote_fundo = fragmentMoradia.getView().findViewById(R.id.form_moradia_numero_lote_fundo);
        moradia_rua_frente = fragmentMoradia.getView().findViewById(R.id.form_moradia_rua_frente);
        moradia_rua_direita = fragmentMoradia.getView().findViewById(R.id.form_moradia_rua_direita);
        moradia_rua_esquerda = fragmentMoradia.getView().findViewById(R.id.form_moradia_rua_esquerda);
        moradia_rua_fundo = fragmentMoradia.getView().findViewById(R.id.form_moradia_rua_fundo);
        moradia_selagem = fragmentMoradia.getView().findViewById(R.id.form_moradia_selagem);
        moradia_latitude = fragmentMoradia.getView().findViewById(R.id.form_moradia_latitude);
        moradia_longitude = fragmentMoradia.getView().findViewById(R.id.form_moradia_longitude);
        moradia_altitude = fragmentMoradia.getView().findViewById(R.id.form_moradia_altitude);
        moradia_zona = fragmentMoradia.getView().findViewById(R.id.form_moradia_zona);
        moradia_situacao_propriedade = fragmentMoradia.getView().findViewById(R.id.form_moradia_situacao_propriedade);
        moradia_valor_aluguel = fragmentMoradia.getView().findViewById(R.id.form_moradia_valor_aluguel);
        moradia_numero_quartos = fragmentMoradia.getView().findViewById(R.id.form_moradia_numero_quartos);
        moradia_numero_comodos = fragmentMoradia.getView().findViewById(R.id.form_moradia_numero_comodos);
        moradia_tipo_construcao = fragmentMoradia.getView().findViewById(R.id.form_moradia_tipo_construcao);
        moradia_outro_tipo_construcao = fragmentMoradia.getView().findViewById(R.id.form_moradia_outro_tipo_construcao);
        moradia_fonte_energia = fragmentMoradia.getView().findViewById(R.id.form_moradia_fonte_energia);
        moradia_abastecimento_agua = fragmentMoradia.getView().findViewById(R.id.form_moradia_abastecimento_agua);
        moradia_rede_esgoto = fragmentMoradia.getView().findViewById(R.id.form_moradia_rede_esgoto);
        moradia_coleta_lixo = fragmentMoradia.getView().findViewById(R.id.form_moradia_coleta_lixo);
        moradia_separacao_reciclaveis = fragmentMoradia.getView().findViewById(R.id.form_moradia_separacao_reciclaveis);
        moradia_valor_beneficio_prestacao_continuada = fragmentMoradia.getView().findViewById(R.id.form_moradia_valor_beneficio_prestacao_continuada);
        moradia_valor_bolsa_familia = fragmentMoradia.getView().findViewById(R.id.form_moradia_valor_bolsa_familia);
        moradia_outro_beneficio = fragmentMoradia.getView().findViewById(R.id.form_moradia_outro_beneficio);
        moradia_reside_area_risco = fragmentMoradia.getView().findViewById(R.id.form_moradia_reside_area_risco);
        moradia_reside_area_insalubre = fragmentMoradia.getView().findViewById(R.id.form_moradia_reside_area_insalubre);
        moradia_desabrigado = fragmentMoradia.getView().findViewById(R.id.form_moradia_desabrigado);
        moradia_observacao = fragmentMoradia.getView().findViewById(R.id.form_moradia_observacao);
        moradia_foto_comprovante_visita = fragmentMoradia.getView().findViewById(R.id.form_moradia_foto_comprovante_visita);
        moradia_foto_fachada = fragmentMoradia.getView().findViewById(R.id.form_moradia_foto_fachada);
        moradia_foto_comprovante_agua = fragmentMoradia.getView().findViewById(R.id.form_moradia_foto_comprovante_agua);
        moradia_foto_comprovante_luz = fragmentMoradia.getView().findViewById(R.id.form_moradia_foto_comprovante_luz);
        moradia_foto_comprovante_iptu = fragmentMoradia.getView().findViewById(R.id.form_moradia_foto_comprovante_iptu);
        moradia_foto_documento_cartografico = fragmentMoradia.getView().findViewById(R.id.form_moradia_foto_documento_cartografico);


    }

    private void preencherTelaBeneficiario(Pessoa registro) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            beneficiario_nome.setText(registro.getNome());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_cpf.setText(registro.getCpf());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_rg.setText(registro.getRg());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_nome_mae.setText(registro.getNome_mae());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_nome_pai.setText(registro.getNome_pai());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_sexo.setSelection(registro.getSexo() - 1);
        } catch (Throwable ex) {
        }
        try {
            beneficiario_raca.setSelection(registro.getRaca() - 1);
        } catch (Throwable ex) {
        }
        try {
            beneficiario_data_nascimento.setText(sdf.format(registro.getData_nascimento()));
        } catch (Throwable ex) {
        }
        try {
            beneficiario_email.setText(registro.getEmail());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_nacionalidade.setSelection(registro.getNacionalidade() - 1);
        } catch (Throwable ex) {
        }
        try {
            beneficiario_numero_cpts.setText(registro.getNumero_cpts());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_pis_pasep.setText(registro.getPis_pasep());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_numero_cadunico.setText(registro.getNumero_cadunico());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_nis.setText(registro.getNis());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_escolaridade.setSelection(registro.getEscolaridade() - 1);
        } catch (Throwable ex) {
        }
        try {
            beneficiario_estado_civil.setSelection(registro.getEstado_civil() - 1);
        } catch (Throwable ex) {
        }
        try {
            beneficiario_situacao_conjugal.setSelection(registro.getSituacao_conjugal() - 1);
        } catch (Throwable ex) {
        }
        try {
            beneficiario_profissao.setText(registro.getProfissao());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_renda_formal.setText(registro.getRenda_formal() + "");
        } catch (Throwable ex) {
        }
        try {
            beneficiario_situacao_renda_formal.setSelection(registro.getSituacao_renda_formal() - 1);
        } catch (Throwable ex) {
        }
        try {
            beneficiario_renda_informal.setText(registro.getRenda_informal() + "");
        } catch (Throwable ex) {
        }
        try {
            beneficiario_situacao_renda_informal.setSelection(registro.getSituacao_renda_informal() - 1);
        } catch (Throwable ex) {
        }
        try {
            beneficiario_ramo_atividade.setSelection(registro.getRamo_atividade() - 1);
        } catch (Throwable ex) {
        }
        try {
            beneficiario_empregador.setText(registro.getEmpregador());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_tempo_servico_emprego_atual.setText(registro.getTempo_servico_emprego_atual() + "");
        } catch (Throwable ex) {
        }
        try {
            beneficiario_valor_fgts.setText(registro.getValor_fgts() + "");
        } catch (Throwable ex) {
        }
        try {
            beneficiario_telefone_fixo.setText(registro.getTelefone_fixo());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_telefone_movel.setText(registro.getTelefone_movel());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_telefone_recado.setText(registro.getTelefone_recado());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_falar_com.setText(registro.getFalar_com());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_tempo_residencia_imovel.setText(registro.getTempo_residencia_imovel() + "");
        } catch (Throwable ex) {
        }
        try {
            beneficiario_tempo_residencia_municipio.setText(registro.getTempo_residencia_municipio() + "");
        } catch (Throwable ex) {
        }
        try {
            beneficiario_interesse_moradia_urbana.setChecked(registro.isInteresse_moradia_urbana());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_interesse_moradia_rural.setChecked(registro.isInteresse_moradia_rural());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_interesse_lote.setChecked(registro.isInteresse_lote());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_interesse_regularizacao_fundiaria.setChecked(registro.isInteresse_regulacao_fundiaria());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_deficiencia_auditiva_mudez.setChecked(registro.isDeficiencia_auditiva_mudez());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_deficiencia_auditiva_surdez.setChecked(registro.isDeficiencia_auditiva_surdez());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_deficiencia_cadeirante.setChecked(registro.isDeficiencia_cadeirante());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_deficiencia_fisica.setChecked(registro.isDeficiencia_fisica());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_deficiencia_intelectual.setChecked(registro.isDeficiencia_intelectual());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_deficiencia_nanismo.setChecked(registro.isDeficiencia_nanismo());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_deficiencia_visual.setChecked(registro.isDeficiencia_visual());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_titular_conjuge_mulher_maria_penha.setChecked(registro.isTitular_conjuge_mulher_maria_penha());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_proprietario_imovel.setChecked(registro.isProprietario_imovel());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_proprietario_lote.setChecked(registro.isProprietario_lote());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_proprietario_imovel_precario.setChecked(registro.isProprietario_imovel_precario());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_convenio.setChecked(registro.isConvenio());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_foto_pessoa.setText(registro.getFoto_pessoa());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_foto_cpf.setText(registro.getFoto_cpf());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_foto_rg.setText(registro.getFoto_rg());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_foto_rg_verso.setText(registro.getFoto_rg_verso());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_foto_cnh.setText(registro.getFoto_cnh());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_foto_carteira_trabalho.setText(registro.getFoto_carteira_trabalho());
        } catch (Throwable ex) {
        }
        try {
            beneficiario_foto_documento_casa.setText(registro.getFoto_documento_casa());
        } catch (
                Throwable ex) {
        }
        try {
            beneficiario_foto_comprovante_renda.setText(registro.getFoto_comprovante_renda());
        } catch (
                Throwable ex) {
        }
        try {
            beneficiario_foto_comprovante_estado_civil.setText(registro.getFoto_comprovante_estado_civil());
        } catch (
                Throwable ex) {
        }

    }

    private void preencherEntidadeBeneficiario(Pessoa registro) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        registro.setNome(beneficiario_nome.getText().toString());
        registro.setCpf(beneficiario_cpf.getText().toString());
        registro.setRg(beneficiario_rg.getText().toString());
        registro.setNome_mae(beneficiario_nome_mae.getText().toString());
        registro.setNome_pai(beneficiario_nome_pai.getText().toString());
        registro.setSexo(beneficiario_sexo.getSelectedItemPosition() + 1);
        registro.setRaca(beneficiario_raca.getSelectedItemPosition() + 1);
        try {
            registro.setData_nascimento(sdf.parse(beneficiario_data_nascimento.getText().toString()));
        } catch (Throwable ex) {
            registro.setData_nascimento(null);
        }
        registro.setEmail(beneficiario_email.getText().toString());
        registro.setNacionalidade(beneficiario_nacionalidade.getSelectedItemPosition() + 1);
        registro.setNumero_cpts(beneficiario_numero_cpts.getText().toString());
        registro.setPis_pasep(beneficiario_pis_pasep.getText().toString());
        registro.setNumero_cadunico(beneficiario_numero_cadunico.getText().toString());
        registro.setNis(beneficiario_nis.getText().toString());
        registro.setEscolaridade(beneficiario_escolaridade.getSelectedItemPosition() + 1);
        registro.setEstado_civil(beneficiario_estado_civil.getSelectedItemPosition() + 1);
        registro.setSituacao_conjugal(beneficiario_situacao_conjugal.getSelectedItemPosition() + 1);
        registro.setProfissao(beneficiario_profissao.getText().toString());
        try {
            registro.setRenda_formal(Double.parseDouble(beneficiario_renda_formal.getText().toString()));
        } catch (Throwable ex) {
            registro.setRenda_formal(0);
        }
        registro.setSituacao_renda_formal(beneficiario_situacao_renda_formal.getSelectedItemPosition() + 1);
        try {
            registro.setRenda_informal(Double.parseDouble(beneficiario_renda_informal.getText().toString()));
        } catch (Throwable ex) {
            registro.setRenda_informal(0);
        }
        registro.setSituacao_renda_informal(beneficiario_situacao_renda_informal.getSelectedItemPosition() + 1);
        registro.setRamo_atividade(beneficiario_ramo_atividade.getSelectedItemPosition() + 1);
        registro.setEmpregador(beneficiario_empregador.getText().toString());
        try {
            registro.setTempo_servico_emprego_atual(Integer.parseInt(beneficiario_tempo_servico_emprego_atual.getText().toString()));
        } catch (Throwable ex) {
            registro.setTempo_servico_emprego_atual(0);
        }
        try {
            registro.setValor_fgts(Double.parseDouble(beneficiario_valor_fgts.getText().toString()));
        } catch (Throwable ex) {
        }
        registro.setTelefone_fixo(beneficiario_telefone_fixo.getText().toString());
        registro.setTelefone_movel(beneficiario_telefone_movel.getText().toString());
        registro.setTelefone_recado(beneficiario_telefone_recado.getText().toString());
        registro.setFalar_com(beneficiario_falar_com.getText().toString());
        try {
            registro.setTempo_residencia_imovel(Integer.parseInt(beneficiario_tempo_residencia_imovel.getText().toString()));
        } catch (Throwable ex) {
            registro.setTempo_residencia_imovel(0);
        }
        try {
            registro.setTempo_residencia_municipio(Integer.parseInt(beneficiario_tempo_residencia_municipio.getText().toString()));
        } catch (Throwable ex) {
            registro.setTempo_residencia_municipio(0);
        }
        registro.setInteresse_moradia_urbana(beneficiario_interesse_moradia_urbana.isChecked());
        registro.setInteresse_moradia_rural(beneficiario_interesse_moradia_rural.isChecked());
        registro.setInteresse_lote(beneficiario_interesse_lote.isChecked());
        registro.setInteresse_regulacao_fundiaria(beneficiario_interesse_regularizacao_fundiaria.isChecked());
        registro.setDeficiencia_auditiva_mudez(beneficiario_deficiencia_auditiva_mudez.isChecked());
        registro.setDeficiencia_auditiva_surdez(beneficiario_deficiencia_auditiva_surdez.isChecked());
        registro.setDeficiencia_cadeirante(beneficiario_deficiencia_cadeirante.isChecked());
        registro.setDeficiencia_fisica(beneficiario_deficiencia_fisica.isChecked());
        registro.setDeficiencia_intelectual(beneficiario_deficiencia_intelectual.isChecked());
        registro.setDeficiencia_nanismo(beneficiario_deficiencia_nanismo.isChecked());
        registro.setDeficiencia_visual(beneficiario_deficiencia_visual.isChecked());
        registro.setTitular_conjuge_mulher_maria_penha(beneficiario_titular_conjuge_mulher_maria_penha.isChecked());
        registro.setProprietario_imovel(beneficiario_proprietario_imovel.isChecked());
        registro.setProprietario_lote(beneficiario_proprietario_lote.isChecked());
        registro.setProprietario_imovel_precario(beneficiario_proprietario_imovel_precario.isChecked());
        registro.setConvenio(beneficiario_convenio.isChecked());

        registro.setFoto_pessoa(beneficiario_foto_pessoa.getText().toString());
        registro.setFoto_cpf(beneficiario_foto_cpf.getText().toString());
        registro.setFoto_rg(beneficiario_foto_rg.getText().toString());
        registro.setFoto_rg_verso(beneficiario_foto_rg_verso.getText().toString());
        registro.setFoto_cnh(beneficiario_foto_cnh.getText().toString());
        registro.setFoto_carteira_trabalho(beneficiario_foto_carteira_trabalho.getText().toString());
        registro.setFoto_documento_casa(beneficiario_foto_documento_casa.getText().toString());
        registro.setFoto_comprovante_renda(beneficiario_foto_comprovante_renda.getText().toString());
        registro.setFoto_comprovante_estado_civil(beneficiario_foto_comprovante_estado_civil.getText().toString());

    }

    private void preencherTelaConjuje(Pessoa registro) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            conjuje_nome.setText(registro.getNome());
        } catch (Throwable ex) {
        }
        try {
            conjuje_cpf.setText(registro.getCpf());
        } catch (Throwable ex) {
        }
        try {
            conjuje_rg.setText(registro.getRg());
        } catch (Throwable ex) {
        }
        try {
            conjuje_nome_mae.setText(registro.getNome_mae());
        } catch (Throwable ex) {
        }
        try {
            conjuje_nome_pai.setText(registro.getNome_pai());
        } catch (Throwable ex) {
        }
        try {
            conjuje_sexo.setSelection(registro.getSexo() - 1);
        } catch (Throwable ex) {
        }
        try {
            conjuje_raca.setSelection(registro.getRaca() - 1);
        } catch (Throwable ex) {
        }
        try {
            conjuje_data_nascimento.setText(sdf.format(registro.getData_nascimento()));
        } catch (Throwable ex) {
        }
        try {
            conjuje_nacionalidade.setSelection(registro.getNacionalidade() - 1);
        } catch (Throwable ex) {
        }
        try {
            conjuje_numero_cadunico.setText(registro.getNumero_cadunico());
        } catch (Throwable ex) {
        }
        try {
            conjuje_nis.setText(registro.getNis());
        } catch (Throwable ex) {
        }
        try {
            conjuje_escolaridade.setSelection(registro.getEscolaridade() - 1);
        } catch (Throwable ex) {
        }
        try {
            conjuje_estado_civil.setSelection(registro.getEstado_civil() - 1);
        } catch (Throwable ex) {
        }
        try {
            conjuje_situacao_conjugal.setSelection(registro.getSituacao_conjugal() - 1);
        } catch (Throwable ex) {
        }
        try {
            conjuje_profissao.setText(registro.getProfissao());
        } catch (Throwable ex) {
        }
        try {
            conjuje_renda_formal.setText(registro.getRenda_formal() + "");
        } catch (Throwable ex) {
        }
        try {
            conjuje_situacao_renda_formal.setSelection(registro.getSituacao_renda_formal() - 1);
        } catch (Throwable ex) {
        }
        try {
            conjuje_renda_informal.setText(registro.getRenda_informal() + "");
        } catch (Throwable ex) {
        }
        try {
            conjuje_situacao_renda_informal.setSelection(registro.getSituacao_renda_informal() - 1);
        } catch (Throwable ex) {
        }
        try {
            conjuje_ramo_atividade.setSelection(registro.getRamo_atividade() - 1);
        } catch (Throwable ex) {
        }
        try {
            conjuje_empregador.setText(registro.getEmpregador());
        } catch (Throwable ex) {
        }
        try {
            conjuje_tempo_servico_emprego_atual.setText(registro.getTempo_servico_emprego_atual());
        } catch (Throwable ex) {
        }
        try {
            conjuje_valor_fgts.setText(registro.getValor_fgts() + "");
        } catch (Throwable ex) {
        }
        try {
            conjuje_deficiencia_auditiva_mudez.setChecked(registro.isDeficiencia_auditiva_mudez());
        } catch (Throwable ex) {
        }
        try {
            conjuje_deficiencia_auditiva_surdez.setChecked(registro.isDeficiencia_auditiva_surdez());
        } catch (Throwable ex) {
        }
        try {
            conjuje_deficiencia_cadeirante.setChecked(registro.isDeficiencia_cadeirante());
        } catch (Throwable ex) {
        }
        try {
            conjuje_deficiencia_fisica.setChecked(registro.isDeficiencia_fisica());
        } catch (Throwable ex) {
        }
        try {
            conjuje_deficiencia_intelectual.setChecked(registro.isDeficiencia_intelectual());
        } catch (Throwable ex) {
        }
        try {
            conjuje_deficiencia_nanismo.setChecked(registro.isDeficiencia_nanismo());
        } catch (Throwable ex) {
        }
        try {
            conjuje_deficiencia_visual.setChecked(registro.isDeficiencia_visual());
        } catch (Throwable ex) {
        }
        try {
            conjuje_foto_pessoa.setText(registro.getFoto_pessoa());
        } catch (Throwable ex) {
        }
        try {
            conjuje_foto_cpf.setText(registro.getFoto_cpf());
        } catch (Throwable ex) {
        }
        try {
            conjuje_foto_rg.setText(registro.getFoto_rg());
        } catch (Throwable ex) {
        }
        try {
            conjuje_foto_rg_verso.setText(registro.getFoto_rg_verso());
        } catch (Throwable ex) {
        }
        try {
            conjuje_foto_cnh.setText(registro.getFoto_cnh());
        } catch (Throwable ex) {
        }
        try {
            conjuje_foto_carteira_trabalho.setText(registro.getFoto_carteira_trabalho());
        } catch (Throwable ex) {
        }
        try {
            conjuje_foto_documento_casa.setText(registro.getFoto_documento_casa());
        } catch (Throwable ex) {
        }
        try {
            conjuje_foto_comprovante_renda.setText(registro.getFoto_comprovante_renda());
        } catch (Throwable ex) {
        }
        try {
            conjuje_foto_comprovante_estado_civil.setText(registro.getFoto_comprovante_estado_civil());
        } catch (Throwable ex) {
        }

    }

    private void preencherEntidadeConjuje(Pessoa registro) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        registro.setNome(conjuje_nome.getText().toString());
        registro.setCpf(conjuje_cpf.getText().toString());
        registro.setRg(conjuje_rg.getText().toString());
        registro.setNome_mae(conjuje_nome_mae.getText().toString());
        registro.setNome_pai(conjuje_nome_pai.getText().toString());
        registro.setSexo(conjuje_sexo.getSelectedItemPosition() + 1);
        registro.setRaca(conjuje_raca.getSelectedItemPosition() + 1);
        try {
            registro.setData_nascimento(sdf.parse(conjuje_data_nascimento.getText().toString()));
        } catch (Throwable ex) {
        }
        registro.setNacionalidade(conjuje_nacionalidade.getSelectedItemPosition() + 1);
        registro.setNumero_cadunico(conjuje_numero_cadunico.getText().toString());
        registro.setNis(conjuje_nis.getText().toString());
        registro.setEscolaridade(conjuje_escolaridade.getSelectedItemPosition() + 1);
        registro.setEstado_civil(conjuje_estado_civil.getSelectedItemPosition() + 1);
        registro.setSituacao_conjugal(conjuje_situacao_conjugal.getSelectedItemPosition() + 1);
        registro.setProfissao(conjuje_profissao.getText().toString());
        try {
            registro.setRenda_formal(Double.parseDouble(conjuje_renda_formal.getText().toString()));
        } catch (Throwable ex) {
        }
        registro.setSituacao_renda_formal(conjuje_situacao_renda_formal.getSelectedItemPosition() + 1);
        try {
            registro.setRenda_informal(Double.parseDouble(conjuje_renda_informal.getText().toString()));
        } catch (Throwable ex) {
        }
        registro.setSituacao_renda_informal(conjuje_situacao_renda_informal.getSelectedItemPosition() + 1);
        registro.setRamo_atividade(conjuje_ramo_atividade.getSelectedItemPosition() + 1);
        registro.setEmpregador(conjuje_empregador.getText().toString());
        try {
            registro.setTempo_servico_emprego_atual(Integer.parseInt(conjuje_tempo_servico_emprego_atual.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setValor_fgts(Double.parseDouble(conjuje_valor_fgts.getText().toString()));
        } catch (Throwable ex) {
        }
        registro.setDeficiencia_auditiva_mudez(conjuje_deficiencia_auditiva_mudez.isSelected());
        registro.setDeficiencia_auditiva_surdez(conjuje_deficiencia_auditiva_surdez.isSelected());
        registro.setDeficiencia_cadeirante(conjuje_deficiencia_cadeirante.isSelected());
        registro.setDeficiencia_fisica(conjuje_deficiencia_fisica.isSelected());
        registro.setDeficiencia_intelectual(conjuje_deficiencia_intelectual.isSelected());
        registro.setDeficiencia_nanismo(conjuje_deficiencia_nanismo.isSelected());
        registro.setDeficiencia_visual(conjuje_deficiencia_visual.isSelected());
        registro.setFoto_pessoa(conjuje_foto_pessoa.getText().toString());
        registro.setFoto_cpf(conjuje_foto_cpf.getText().toString());
        registro.setFoto_rg(conjuje_foto_rg.getText().toString());
        registro.setFoto_rg_verso(conjuje_foto_rg_verso.getText().toString());
        registro.setFoto_cnh(conjuje_foto_cnh.getText().toString());
        registro.setFoto_carteira_trabalho(conjuje_foto_carteira_trabalho.getText().toString());
        registro.setFoto_documento_casa(conjuje_foto_documento_casa.getText().toString());
        registro.setFoto_comprovante_renda(conjuje_foto_comprovante_renda.getText().toString());
        registro.setFoto_comprovante_estado_civil(conjuje_foto_comprovante_estado_civil.getText().toString());
    }

    private void limparTelaCompFam() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            comp_fam_nome.setText("");
        } catch (Throwable ex) {
        }
        try {
            comp_fam_parentesco.setSelection(0);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_sexo.setSelection(0);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_data_nascimento.setText("");
        } catch (Throwable ex) {
        }
        try {
            comp_fam_escolaridade.setSelection(0);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_profissao.setText("");
        } catch (Throwable ex) {
        }
        try {
            comp_fam_renda_formal.setText("");
        } catch (Throwable ex) {
        }
        try {
            comp_fam_situacao_renda_formal.setSelection(0);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_renda_informal.setText("");
        } catch (Throwable ex) {
        }
        try {
            comp_fam_situacao_renda_informal.setSelection(0);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_auditiva_mudez.setChecked(false);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_auditiva_surdez.setChecked(false);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_cadeirante.setChecked(false);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_fisica.setChecked(false);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_intelectual.setChecked(false);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_nanismo.setChecked(false);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_visual.setChecked(false);
        } catch (Throwable ex) {
        }
    }

    private void preencherTelaCompFam(Pessoa registro) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            comp_fam_nome.setText(registro.getNome());
        } catch (Throwable ex) {
        }
        try {
            comp_fam_parentesco.setSelection(registro.getParentesco() - 1);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_sexo.setSelection(registro.getSexo() - 1);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_data_nascimento.setText(sdf.format(registro.getData_nascimento()));
        } catch (Throwable ex) {
        }
        try {
            comp_fam_escolaridade.setSelection(registro.getEscolaridade() - 1);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_profissao.setText(registro.getProfissao());
        } catch (Throwable ex) {
        }
        try {
            comp_fam_renda_formal.setText(registro.getRenda_formal() + "");
        } catch (Throwable ex) {
        }
        try {
            comp_fam_situacao_renda_formal.setSelection(registro.getSituacao_renda_formal() - 1);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_renda_informal.setText(registro.getRenda_informal() + "");
        } catch (Throwable ex) {
        }
        try {
            comp_fam_situacao_renda_informal.setSelection(registro.getSituacao_renda_informal() - 1);
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_auditiva_mudez.setChecked(registro.isDeficiencia_auditiva_mudez());
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_auditiva_surdez.setChecked(registro.isDeficiencia_auditiva_surdez());
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_cadeirante.setChecked(registro.isDeficiencia_cadeirante());
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_fisica.setChecked(registro.isDeficiencia_fisica());
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_intelectual.setChecked(registro.isDeficiencia_intelectual());
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_nanismo.setChecked(registro.isDeficiencia_nanismo());
        } catch (Throwable ex) {
        }
        try {
            comp_fam_deficiencia_visual.setChecked(registro.isDeficiencia_visual());
        } catch (Throwable ex) {
        }
    }

    private void preencherEntidadeCompFam(Pessoa registro) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        registro.setNome(comp_fam_nome.getText().toString());
        registro.setParentesco(comp_fam_parentesco.getSelectedItemPosition() + 1);
        registro.setSexo(comp_fam_sexo.getSelectedItemPosition() + 1);
        try {
            registro.setData_nascimento(sdf.parse(comp_fam_data_nascimento.getText().toString()));
        } catch (Throwable ex) {
        }
        registro.setEscolaridade(comp_fam_escolaridade.getSelectedItemPosition() + 1);
        registro.setProfissao(comp_fam_profissao.getText().toString());
        try {
            registro.setRenda_formal(Double.parseDouble(comp_fam_renda_formal.getText().toString()));
        } catch (Throwable ex) {
        }
        registro.setSituacao_renda_formal(comp_fam_situacao_renda_formal.getSelectedItemPosition() + 1);
        try {
            registro.setRenda_informal(Double.parseDouble(comp_fam_renda_informal.getText().toString()));
        } catch (Throwable ex) {
        }
        registro.setSituacao_renda_informal(comp_fam_situacao_renda_informal.getSelectedItemPosition() + 1);
        registro.setDeficiencia_auditiva_mudez(comp_fam_deficiencia_auditiva_mudez.isChecked());
        registro.setDeficiencia_auditiva_surdez(comp_fam_deficiencia_auditiva_surdez.isChecked());
        registro.setDeficiencia_cadeirante(comp_fam_deficiencia_cadeirante.isChecked());
        registro.setDeficiencia_fisica(comp_fam_deficiencia_fisica.isChecked());
        registro.setDeficiencia_intelectual(comp_fam_deficiencia_intelectual.isChecked());
        registro.setDeficiencia_nanismo(comp_fam_deficiencia_nanismo.isChecked());
        registro.setDeficiencia_visual(comp_fam_deficiencia_visual.isChecked());
    }

    private void preencherEntidadeMoradia(Moradia registro) {
        try {
            registro.setQuadra(moradia_quadra.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setLote(moradia_lote.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setPoligonal(moradia_poligonal.getSelectedItemPosition() + 1);
        } catch (Throwable ex) {
        }
        try {
            registro.setEndereco(moradia_endereco.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setNumero(moradia_numero.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setComplemento(moradia_complemento.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setCep(moradia_cep.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setBairro(moradia_bairro.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setCidade(moradia_cidade.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setUf(moradia_uf.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setArea_construida(moradia_area_construida.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setMatricula_imovel(moradia_matricula_imovel.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setMedida_frente(Double.parseDouble(moradia_medida_frente.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setMedida_direita(Double.parseDouble(moradia_medida_direita.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setMedida_esquerda(Double.parseDouble(moradia_medida_esquerda.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setMedida_fundo(Double.parseDouble(moradia_medida_fundo.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setNumero_lote_direita(moradia_numero_lote_direita.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setNumero_lote_esquerda(moradia_numero_lote_esquerda.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setNumero_lote_fundo(Double.parseDouble(moradia_numero_lote_fundo.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setRua_frente(moradia_rua_frente.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setRua_direita(moradia_rua_direita.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setRua_esquerda(moradia_rua_esquerda.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setRua_fundo(moradia_rua_fundo.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setSelagem(moradia_selagem.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setLatitude(moradia_latitude.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setLongitude(moradia_longitude.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setAltitude(moradia_altitude.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setZona(moradia_zona.getSelectedItemPosition() + 1);
        } catch (Throwable ex) {
        }
        try {
            registro.setSituacao_propriedade(moradia_situacao_propriedade.getSelectedItemPosition() + 1);
        } catch (Throwable ex) {
        }
        try {
            registro.setValor_aluguel(Double.parseDouble(moradia_valor_aluguel.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setNumero_quarto(Integer.parseInt(moradia_numero_quartos.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setNumero_comodos(Integer.parseInt(moradia_numero_comodos.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setTipo_construcao(moradia_tipo_construcao.getSelectedItemPosition() + 1);
        } catch (Throwable ex) {
        }
        try {
            registro.setOutro_tipo_construcao(moradia_outro_tipo_construcao.getText().toString());
        } catch (Throwable ex) {
        }
        try {
            registro.setFonte_energia(moradia_fonte_energia.isChecked());
        } catch (Throwable ex) {
        }
        try {
            registro.setAbastecimento_agua(moradia_abastecimento_agua.isChecked());
        } catch (Throwable ex) {
        }
        try {
            registro.setRede_esgoto(moradia_rede_esgoto.isChecked());
        } catch (Throwable ex) {
        }
        try {
            registro.setColeta_lixo(moradia_coleta_lixo.isChecked());
        } catch (Throwable ex) {
        }
        try {
            registro.setSeparacao_reciclaveis(moradia_separacao_reciclaveis.isChecked());
        } catch (Throwable ex) {
        }
        try {
            registro.setValor_beneficio_prestacao_continuada(Double.parseDouble(moradia_valor_beneficio_prestacao_continuada.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setValor_bolsa_familia(Double.parseDouble(moradia_valor_bolsa_familia.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setOutro_beneficio(Double.parseDouble(moradia_outro_beneficio.getText().toString()));
        } catch (Throwable ex) {
        }
        try {
            registro.setArea_risco(moradia_reside_area_risco.isChecked());
        } catch (Throwable ex) {
        }
        try {
            registro.setInsalubre(moradia_reside_area_insalubre.isChecked());
        } catch (Throwable ex) {
        }
        try {
            registro.setDesabrigado(moradia_desabrigado.isChecked());
        } catch (Throwable ex) {
        }
        try {
            registro.setObservacao(moradia_observacao.getText().toString());
        } catch (Throwable ex) {
        }
        /*
        registro.setFoto_comprovante_visita(moradia_foto_comprovante_visita.getText().toString());
        registro.setFoto_fachada(moradia_foto_fachada.getText().toString());
        registro.setFoto_comprovante_agua(moradia_foto_comprovante_agua.getText().toString());
        registro.setFoto_comprovante_luz(moradia_foto_comprovante_luz.getText().toString());
        registro.setFoto_comprovante_iptu(moradia_foto_comprovante_iptu.getText().toString());
        registro.setFoto_documento_cartografico(moradia_foto_documento_cartografico.getText().toString());
        */
    }

    private void preencherTelaMoradia(Moradia registro) {

        try {
            moradia_quadra.setText(registro.getQuadra());
        } catch (Throwable ex) {
        }
        try {
            moradia_lote.setText(registro.getLote());
        } catch (Throwable ex) {
        }
        try {
            moradia_poligonal.setSelection(registro.getPoligonal() - 1);
        } catch (Throwable ex) {
        }
        try {
            moradia_endereco.setText(registro.getEndereco());
        } catch (Throwable ex) {
        }
        try {
            moradia_numero.setText(registro.getNumero());
        } catch (Throwable ex) {
        }
        try {
            moradia_complemento.setText(registro.getComplemento());
        } catch (Throwable ex) {
        }
        try {
            moradia_cep.setText(registro.getCep());
        } catch (Throwable ex) {
        }
        try {
            moradia_bairro.setText(registro.getBairro());
        } catch (Throwable ex) {
        }
        try {
            moradia_cidade.setText(registro.getCidade());
        } catch (Throwable ex) {
        }
        try {
            moradia_uf.setText(registro.getUf());
        } catch (Throwable ex) {
        }
        try {
            moradia_area_construida.setText(registro.getArea_construida());
        } catch (Throwable ex) {
        }
        try {
            moradia_matricula_imovel.setText(registro.getMatricula_imovel());
        } catch (Throwable ex) {
        }
        try {
            moradia_medida_frente.setText(registro.getMedida_frente() + "");
        } catch (Throwable ex) {
        }
        try {
            moradia_medida_direita.setText(registro.getMedida_direita() + "");
        } catch (Throwable ex) {
        }
        try {
            moradia_medida_esquerda.setText(registro.getMedida_esquerda() + "");
        } catch (Throwable ex) {
        }
        try {
            moradia_medida_fundo.setText(registro.getMedida_fundo() + "");
        } catch (Throwable ex) {
        }
        try {
            moradia_numero_lote_direita.setText(registro.getNumero_lote_direita());
        } catch (Throwable ex) {
        }
        try {
            moradia_numero_lote_esquerda.setText(registro.getNumero_lote_esquerda());
        } catch (Throwable ex) {
        }
        try {
            moradia_numero_lote_fundo.setText(registro.getNumero_lote_fundo() + "");
        } catch (Throwable ex) {
        }
        try {
            moradia_rua_frente.setText(registro.getRua_frente());
        } catch (Throwable ex) {
        }
        try {
            moradia_rua_direita.setText(registro.getRua_direita());
        } catch (Throwable ex) {
        }
        try {
            moradia_rua_esquerda.setText(registro.getRua_esquerda());
        } catch (Throwable ex) {
        }
        try {
            moradia_rua_fundo.setText(registro.getRua_fundo());
        } catch (Throwable ex) {
        }
        try {
            moradia_selagem.setText(registro.getSelagem());
        } catch (Throwable ex) {
        }
        try {
            moradia_latitude.setText(registro.getLatitude());
        } catch (Throwable ex) {
        }
        try {
            moradia_longitude.setText(registro.getLongitude());
        } catch (Throwable ex) {
        }
        try {
            moradia_altitude.setText(registro.getAltitude());
        } catch (Throwable ex) {
        }
        try {
            moradia_zona.setSelection(registro.getZona() - 1);
        } catch (Throwable ex) {
        }
        try {
            moradia_situacao_propriedade.setSelection(registro.getSituacao_propriedade() - 1);
        } catch (Throwable ex) {
        }
        try {
            moradia_valor_aluguel.setText(registro.getValor_aluguel() + "");
        } catch (Throwable ex) {
        }
        try {
            moradia_numero_quartos.setText(registro.getNumero_quarto() + "");
        } catch (Throwable ex) {
        }
        try {
            moradia_numero_comodos.setText(registro.getNumero_comodos() + "");
        } catch (Throwable ex) {
        }
        try {
            moradia_tipo_construcao.setSelection(registro.getTipo_construcao() - 1);
        } catch (Throwable ex) {
        }
        try {
            moradia_outro_tipo_construcao.setText(registro.getOutro_tipo_construcao());
        } catch (Throwable ex) {
        }
        try {
            moradia_fonte_energia.setChecked(registro.isFonte_energia());
        } catch (Throwable ex) {
        }
        try {
            moradia_abastecimento_agua.setChecked(registro.isAbastecimento_agua());
        } catch (Throwable ex) {
        }
        try {
            moradia_rede_esgoto.setChecked(registro.isRede_esgoto());
        } catch (Throwable ex) {
        }
        try {
            moradia_coleta_lixo.setChecked(registro.isColeta_lixo());
        } catch (Throwable ex) {
        }
        try {
            moradia_separacao_reciclaveis.setChecked(registro.isSeparacao_reciclaveis());
        } catch (Throwable ex) {
        }
        try {
            moradia_valor_beneficio_prestacao_continuada.setText(registro.getValor_beneficio_prestacao_continuada() + "");
        } catch (Throwable ex) {
        }
        try {
            moradia_valor_bolsa_familia.setText(registro.getValor_bolsa_familia() + "");
        } catch (Throwable ex) {
        }
        try {
            moradia_outro_beneficio.setText(registro.getOutro_beneficio() + "");
        } catch (Throwable ex) {
        }
        try {
            moradia_reside_area_risco.setChecked(registro.isArea_risco());
        } catch (Throwable ex) {
        }
        try {
            moradia_reside_area_insalubre.setChecked(registro.isInsalubre());
        } catch (Throwable ex) {
        }
        try {
            moradia_desabrigado.setChecked(registro.isDesabrigado());
        } catch (Throwable ex) {
        }
        try {
            moradia_observacao.setText(registro.getObservacao());
        } catch (Throwable ex) {
        }
        /*
        moradia_foto_comprovante_visita.setText(registro.getfoto_comprovante_visita());
        moradia_foto_fachada.setText(registro.getfoto_fachada());
        moradia_foto_comprovante_agua.setText(registro.getfoto_comprovante_agua());
        moradia_foto_comprovante_luz.setText(registro.getfoto_comprovante_luz());
        moradia_foto_comprovante_iptu.setText(registro.getfoto_comprovante_iptu());
        moradia_foto_documento_cartografico.setText(registro.getfoto_documento_cartografico());
        */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setOffscreenPageLimit(sectionsPagerAdapter.getCount());
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvarDados();
            }
        });
        verificarPermissoes();
        fragmentBeneficiario = (FormularioBeneficiarioFragment) sectionsPagerAdapter.getItem(0);
        fragmentConjuje = (FormularioConjujeFragment) sectionsPagerAdapter.getItem(1);
        fragmentCompFam = (FormularioCompFamFragment) sectionsPagerAdapter.getItem(2);
        fragmentMoradia = (FormularioMoradiaFragment) sectionsPagerAdapter.getItem(3);
        fragmentFotos = (FormularioFotosFragment) sectionsPagerAdapter.getItem(4);
        getWindow().getDecorView().getRootView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (preecherTela) {
                    inicializarComponentes();
                    preencherTela();
                    preecherTela = false;
                }
            }
        });
        //Carrega o ID da moradia
        int idMoradia = 0;
        try {
            idMoradia = (int) getIntent().getExtras().get("registry");
        } catch (Throwable ex) {
        }
        inicializarRegistros(idMoradia);
    }

    boolean preecherTela = true;

    private void inicializarRegistros(int idMoradia) {
        DatabaseHelper databaseHelper = new DatabaseHelper(this.getApplicationContext());
        MoradiaDao moradiaDao = new MoradiaDao(databaseHelper);
        PessoaDao pessoaDao = new PessoaDao(databaseHelper);
        if (idMoradia > 0) {
            moradia = moradiaDao.get(idMoradia);
            beneficiario = pessoaDao.get(moradia.getId_pessoa());
            conjuje = pessoaDao.getConjuje(moradia.getId_pessoa());
            familiares = pessoaDao.getCompFam(moradia.getId_pessoa());
        } else {
            moradia = new Moradia();
            moradia.setId(moradiaDao.getMaxId() + 1);
            moradiaDao.insert(moradia);
            beneficiario = new Pessoa();
            beneficiario.setId(pessoaDao.getMaxId() + 1);
            pessoaDao.insert(beneficiario);
            conjuje = new Pessoa();
            conjuje.setId(pessoaDao.getMaxId() + 1);
            conjuje.setParentesco(-1);
            pessoaDao.insert(conjuje);
            familiares = new ArrayList<>();
        }
        beneficiario.setId_usuario(Sessao.USUARIO.getId());
        pessoaDao.update(beneficiario);
        moradia.setId_pessoa(beneficiario.getId());
        moradia.setId_usuario(Sessao.USUARIO.getId());
        moradiaDao.update(moradia);
        conjuje.setId_pessoa(beneficiario.getId());
        conjuje.setId_usuario(Sessao.USUARIO.getId());
        pessoaDao.update(conjuje);
        for (Pessoa familiar : familiares) {
            familiar.setId_pessoa(beneficiario.getId());
            familiar.setId_usuario(Sessao.USUARIO.getId());
            pessoaDao.update(familiar);
        }
    }

    private void salvarDados() {
        DatabaseHelper databaseHelper = new DatabaseHelper(this.getApplicationContext());
        MoradiaDao moradiaDao = new MoradiaDao(databaseHelper);
        PessoaDao pessoaDao = new PessoaDao(databaseHelper);

        preencherEntidadeMoradia(moradia);
        preencherEntidadeBeneficiario(beneficiario);
        preencherEntidadeConjuje(conjuje);

        moradiaDao.update(moradia);
        pessoaDao.update(beneficiario);
        pessoaDao.update(conjuje);
        for (Pessoa familiar : familiares) {
            pessoaDao.update(familiar);
        }
    }

    private static final int MY_PERMISSIONS_REQUEST_STORAGE = 1;
    private String[] storage_permissions =
            {
                    Manifest.permission.CAMERA,
                    Manifest.permission.INTERNET,
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.RECORD_AUDIO,
                    Manifest.permission.SYSTEM_ALERT_WINDOW,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            };

    private void verificarPermissoes() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_PHONE_STATE) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.RECORD_AUDIO) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.SYSTEM_ALERT_WINDOW) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
                builder.setMessage("Liberar permissões?");
                builder.setTitle("Permissões");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(FormularioActivity.this, storage_permissions, 0);
                        //onContactsClick();
                    }
                });

                builder.show();
            } else {
                ActivityCompat.requestPermissions(this, storage_permissions, 0);
                // onContactsClick();
            }

        }
    }


}