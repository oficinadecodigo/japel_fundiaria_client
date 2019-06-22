package com.japelapp;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;

import com.japelapp.ui.formulario.FormularioBeneficiarioFragment;
import com.japelapp.ui.formulario.FormularioCompFamFragment;
import com.japelapp.ui.formulario.FormularioConjujeFragment;
import com.japelapp.ui.formulario.FormularioFotosFragment;
import com.japelapp.ui.formulario.FormularioMoradiaFragment;
import com.japelapp.ui.formulario.SectionsPagerAdapter;

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
    EditText beneficiario_sexo;
    EditText beneficiario_raca;
    EditText beneficiario_data_nascimento;
    EditText beneficiario_email;
    EditText beneficiario_nacionalidade;
    EditText beneficiario_numero_cpts;
    EditText beneficiario_pis_pasep;
    EditText beneficiario_numero_cadunico;
    EditText beneficiario_nis;
    EditText beneficiario_escolaridade;
    EditText beneficiario_estado_civil;
    EditText beneficiario_situacao_conjugal;
    EditText beneficiario_profissao;
    EditText beneficiario_renda_formal;
    EditText beneficiario_situacao_renda_formal;
    EditText beneficiario_renda_informal;
    EditText beneficiario_situacao_renda_informal;
    EditText beneficiario_ramo_atividade;
    EditText beneficiario_empregador;
    EditText beneficiario_tempo_servico_emprego_atual;
    EditText beneficiario_valor_fgts;
    EditText beneficiario_telefone_fixo;
    EditText beneficiario_telefone_movel;
    EditText beneficiario_telefone_recado;
    EditText beneficiario_falar_com;
    EditText beneficiario_tempo_residencia_imovel;
    EditText beneficiario_tempo_residencia_municipio;
    EditText beneficiario_interesse_moradia_urbana;
    EditText beneficiario_interesse_moradia_rural;
    EditText beneficiario_interesse_lote;
    EditText beneficiario_interesse_regularizacao_fundiaria;
    EditText beneficiario_deficiencia_auditiva_mudez;
    EditText beneficiario_deficiencia_auditiva_surdez;
    EditText beneficiario_deficiencia_cadeirante;
    EditText beneficiario_deficiencia_fisica;
    EditText beneficiario_deficiencia_intelectual;
    EditText beneficiario_deficiencia_nanismo;
    EditText beneficiario_deficiencia_visual;
    EditText beneficiario_titular_conjuge_mulher_maria_penha;
    EditText beneficiario_proprietario_imovel;
    EditText beneficiario_proprietario_lote;
    EditText beneficiario_proprietario_imovel_precario;
    EditText beneficiario_convenio;
    EditText beneficiario_id_usuario;
    EditText beneficiario_foto_pessoa;
    EditText beneficiario_foto_cpf;
    EditText beneficiario_foto_rg;
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
    EditText conjuje_sexo;
    EditText conjuje_raca;
    EditText conjuje_data_nascimento;
    EditText conjuje_nacionalidade;
    EditText conjuje_numero_cadunico;
    EditText conjuje_nis;
    EditText conjuje_escolaridade;
    EditText conjuje_estado_civil;
    EditText conjuje_situacao_conjugal;
    EditText conjuje_profissao;
    EditText conjuje_renda_formal;
    EditText conjuje_situacao_renda_formal;
    EditText conjuje_renda_informal;
    EditText conjuje_situacao_renda_informal;
    EditText conjuje_ramo_atividade;
    EditText conjuje_empregador;
    EditText conjuje_tempo_servico_emprego_atual;
    EditText conjuje_valor_fgts;
    EditText conjuje_deficiencia_auditiva_mudez;
    EditText conjuje_deficiencia_auditiva_surdez;
    EditText conjuje_deficiencia_cadeirante;
    EditText conjuje_deficiencia_fisica;
    EditText conjuje_deficiencia_intelectual;
    EditText conjuje_deficiencia_nanismo;
    EditText conjuje_deficiencia_visual;
    EditText conjuje_foto_pessoa;
    EditText conjuje_foto_cpf;
    EditText conjuje_foto_rg;
    EditText conjuje_foto_cnh;
    EditText conjuje_foto_carteira_trabalho;
    EditText conjuje_foto_documento_casa;
    EditText conjuje_foto_comprovante_renda;
    EditText conjuje_foto_comprovante_estado_civil;


    //Campos fragment comp fam

    EditText comp_fam_nome;
    EditText comp_fam_parentesco;
    EditText comp_fam_sexo;
    EditText comp_fam_data_nascimento;
    EditText comp_fam_escolaridade;
    EditText comp_fam_profissao;
    EditText comp_fam_renda_formal;
    EditText comp_fam_situacao_renda_formal;
    EditText comp_fam_renda_informal;
    EditText comp_fam_situacao_renda_informal;
    EditText comp_fam_deficiencia_auditiva_mudez;
    EditText comp_fam_deficiencia_auditiva_surdez;
    EditText comp_fam_deficiencia_cadeirante;
    EditText comp_fam_deficiencia_fisica;
    EditText comp_fam_deficiencia_intelectual;
    EditText comp_fam_deficiencia_nanismo;
    EditText comp_fam_deficiencia_visual;


    //Campos fragment moradia

    EditText moradia_quadra;
    EditText moradia_lote;
    EditText moradia_poligonal;
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
    EditText moradia_zona;
    EditText moradia_situacao_propriedade;
    EditText moradia_valor_aluguel;
    EditText moradia_numero_quartos;
    EditText moradia_numero_comodos;
    EditText moradia_tipo_construcao;
    EditText moradia_outro_tipo_construcao;
    EditText moradia_fonte_energia;
    EditText moradia_abastecimento_agua;
    EditText moradia_rede_esgoto;
    EditText moradia_coleta_lixo;
    EditText moradia_separacao_reciclaveis;
    EditText moradia_valor_beneficio_prestacao_continuada;
    EditText moradia_valor_bolsa_familia;
    EditText moradia_outro_beneficio;
    EditText moradia_reside_area_risco;
    EditText moradia_reside_area_insalubre;
    EditText moradia_desabrigado;
    EditText moradia_observacao;
    EditText moradia_foto_comprovante_visita;
    EditText moradia_foto_fachada;
    EditText moradia_foto_comprovante_agua;
    EditText moradia_foto_comprovante_luz;
    EditText moradia_foto_comprovante_iptu;
    EditText moradia_foto_documento_cartografico;


    //Campos fragment fotos

    private void inicializarComponentes() {
        fragmentBeneficiario = (FormularioBeneficiarioFragment) sectionsPagerAdapter.getItem(0);
        fragmentConjuje = (FormularioConjujeFragment) sectionsPagerAdapter.getItem(1);
        fragmentCompFam = (FormularioCompFamFragment) sectionsPagerAdapter.getItem(2);
        fragmentMoradia = (FormularioMoradiaFragment) sectionsPagerAdapter.getItem(3);
        fragmentFotos = (FormularioFotosFragment) sectionsPagerAdapter.getItem(4);

        //Inicializando componentes do fragment beneficiário
        beneficiario_nome = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_nome);
        beneficiario_cpf = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_cpf);
        beneficiario_rg = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_rg);
        beneficiario_nome_mae = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_nome_mae);
        beneficiario_nome_pai = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_nome_pai);
        beneficiario_sexo = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_sexo);
        beneficiario_raca = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_raca);
        beneficiario_data_nascimento = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_data_nascimento);
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
        beneficiario_id_usuario = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_id_usuario);
        beneficiario_foto_pessoa = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_pessoa);
        beneficiario_foto_cpf = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_cpf);
        beneficiario_foto_rg = fragmentBeneficiario.getView().findViewById(R.id.form_beneficiario_foto_rg);
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
        conjuje_foto_cnh = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_cnh);
        conjuje_foto_carteira_trabalho = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_carteira_trabalho);
        conjuje_foto_documento_casa = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_documento_casa);
        conjuje_foto_comprovante_renda = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_comprovante_renda);
        conjuje_foto_comprovante_estado_civil = fragmentConjuje.getView().findViewById(R.id.form_conjuje_foto_comprovante_estado_civil);

        //Inicializando componentes dos componentes familiares

        comp_fam_nome = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_nome);
        comp_fam_parentesco = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_parentesco);
        comp_fam_sexo = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_sexo);
        comp_fam_data_nascimento = fragmentCompFam.getView().findViewById(R.id.form_comp_fam_data_nascimento);
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        tabs.setTabMode(TabLayout.MODE_SCROLLABLE);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        verificarPermissoes();
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