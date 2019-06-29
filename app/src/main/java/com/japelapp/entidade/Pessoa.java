package com.japelapp.entidade;

import java.util.Date;

public class Pessoa {

    private int id;
    private String nome;
    private String cpf;
    private String rg;
    private String nome_mae;
    private String nome_pai;
    private int parentesco;
    private int sexo;
    private int raca;
    private Date data_nascimento;
    private String email;
    private int nacionalidade;
    private String numero_cpts;
    private String pis_pasep;
    private String numero_cadunico;
    private String nis;
    private int escolaridade;
    private int estado_civil;
    private int situacao_conjugal;
    private String profissao;
    private double renda_formal;
    private int situacao_renda_formal;
    private double renda_informal;
    private int situacao_renda_informal;
    private int ramo_atividade;
    private String empregador;
    private int tempo_servico_emprego_atual;
    private double valor_fgts;
    private String telefone_fixo;
    private String telefone_movel;
    private String telefone_recado;
    private String falar_com;
    private int tempo_residencia_imovel;
    private int tempo_residencia_municipio;
    private boolean interesse_moradia_urbana;
    private boolean interesse_moradia_rural;
    private boolean interesse_lote;
    private boolean interesse_regulacao_fundiaria;
    private boolean deficiencia_auditiva_mudez;
    private boolean deficiencia_auditiva_surdez;
    private boolean deficiencia_cadeirante;
    private boolean deficiencia_fisica;
    private boolean deficiencia_intelectual;
    private boolean deficiencia_nanismo;
    private boolean deficiencia_visual;
    private boolean titular_conjuge_mulher_maria_penha;
    private boolean proprietario_imovel;
    private boolean proprietario_lote;
    private boolean proprietario_imovel_precario;
    private boolean convenio;
    private int tipo;
    private int id_pessoa;
    private int id_usuario;

    private String foto_pessoa;
    private String foto_cpf;
    private String foto_rg;
    private String foto_rg_verso;
    private String foto_cnh;
    private String foto_carteira_trabalho;
    private String foto_documento_casa;
    private String foto_comprovante_renda;
    private String foto_comprovante_estado_civil;

    private String id_site;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome_mae() {
        return nome_mae;
    }

    public void setNome_mae(String nome_mae) {
        this.nome_mae = nome_mae;
    }

    public String getNome_pai() {
        return nome_pai;
    }

    public void setNome_pai(String nome_pai) {
        this.nome_pai = nome_pai;
    }

    public int getParentesco() {
        return parentesco;
    }

    public void setParentesco(int parentesco) {
        this.parentesco = parentesco;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getRaca() {
        return raca;
    }

    public void setRaca(int raca) {
        this.raca = raca;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(int nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNumero_cpts() {
        return numero_cpts;
    }

    public void setNumero_cpts(String numero_cpts) {
        this.numero_cpts = numero_cpts;
    }

    public String getPis_pasep() {
        return pis_pasep;
    }

    public void setPis_pasep(String pis_pasep) {
        this.pis_pasep = pis_pasep;
    }

    public String getNumero_cadunico() {
        return numero_cadunico;
    }

    public void setNumero_cadunico(String numero_cadunico) {
        this.numero_cadunico = numero_cadunico;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public int getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(int escolaridade) {
        this.escolaridade = escolaridade;
    }

    public int getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(int estado_civil) {
        this.estado_civil = estado_civil;
    }

    public int getSituacao_conjugal() {
        return situacao_conjugal;
    }

    public void setSituacao_conjugal(int situacao_conjugal) {
        this.situacao_conjugal = situacao_conjugal;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public double getRenda_formal() {
        return renda_formal;
    }

    public void setRenda_formal(double renda_formal) {
        this.renda_formal = renda_formal;
    }

    public int getSituacao_renda_formal() {
        return situacao_renda_formal;
    }

    public void setSituacao_renda_formal(int situacao_renda_formal) {
        this.situacao_renda_formal = situacao_renda_formal;
    }

    public double getRenda_informal() {
        return renda_informal;
    }

    public void setRenda_informal(double renda_informal) {
        this.renda_informal = renda_informal;
    }

    public int getSituacao_renda_informal() {
        return situacao_renda_informal;
    }

    public void setSituacao_renda_informal(int situacao_renda_informal) {
        this.situacao_renda_informal = situacao_renda_informal;
    }

    public int getRamo_atividade() {
        return ramo_atividade;
    }

    public void setRamo_atividade(int ramo_atividade) {
        this.ramo_atividade = ramo_atividade;
    }

    public String getEmpregador() {
        return empregador;
    }

    public void setEmpregador(String empregador) {
        this.empregador = empregador;
    }

    public int getTempo_servico_emprego_atual() {
        return tempo_servico_emprego_atual;
    }

    public void setTempo_servico_emprego_atual(int tempo_servico_emprego_atual) {
        this.tempo_servico_emprego_atual = tempo_servico_emprego_atual;
    }

    public double getValor_fgts() {
        return valor_fgts;
    }

    public void setValor_fgts(double valor_fgts) {
        this.valor_fgts = valor_fgts;
    }

    public String getTelefone_fixo() {
        return telefone_fixo;
    }

    public void setTelefone_fixo(String telefone_fixo) {
        this.telefone_fixo = telefone_fixo;
    }

    public String getTelefone_movel() {
        return telefone_movel;
    }

    public void setTelefone_movel(String telefone_movel) {
        this.telefone_movel = telefone_movel;
    }

    public String getTelefone_recado() {
        return telefone_recado;
    }

    public void setTelefone_recado(String telefone_recado) {
        this.telefone_recado = telefone_recado;
    }

    public String getFalar_com() {
        return falar_com;
    }

    public void setFalar_com(String falar_com) {
        this.falar_com = falar_com;
    }

    public int getTempo_residencia_imovel() {
        return tempo_residencia_imovel;
    }

    public void setTempo_residencia_imovel(int tempo_residencia_imovel) {
        this.tempo_residencia_imovel = tempo_residencia_imovel;
    }

    public int getTempo_residencia_municipio() {
        return tempo_residencia_municipio;
    }

    public void setTempo_residencia_municipio(int tempo_residencia_municipio) {
        this.tempo_residencia_municipio = tempo_residencia_municipio;
    }

    public boolean isInteresse_moradia_urbana() {
        return interesse_moradia_urbana;
    }

    public void setInteresse_moradia_urbana(boolean interesse_moradia_urbana) {
        this.interesse_moradia_urbana = interesse_moradia_urbana;
    }

    public boolean isInteresse_moradia_rural() {
        return interesse_moradia_rural;
    }

    public void setInteresse_moradia_rural(boolean interesse_moradia_rural) {
        this.interesse_moradia_rural = interesse_moradia_rural;
    }

    public boolean isInteresse_lote() {
        return interesse_lote;
    }

    public void setInteresse_lote(boolean interesse_lote) {
        this.interesse_lote = interesse_lote;
    }

    public boolean isInteresse_regulacao_fundiaria() {
        return interesse_regulacao_fundiaria;
    }

    public void setInteresse_regulacao_fundiaria(boolean interesse_regulacao_fundiaria) {
        this.interesse_regulacao_fundiaria = interesse_regulacao_fundiaria;
    }

    public boolean isDeficiencia_auditiva_mudez() {
        return deficiencia_auditiva_mudez;
    }

    public void setDeficiencia_auditiva_mudez(boolean deficiencia_auditiva_mudez) {
        this.deficiencia_auditiva_mudez = deficiencia_auditiva_mudez;
    }

    public boolean isDeficiencia_auditiva_surdez() {
        return deficiencia_auditiva_surdez;
    }

    public void setDeficiencia_auditiva_surdez(boolean deficiencia_auditiva_surdez) {
        this.deficiencia_auditiva_surdez = deficiencia_auditiva_surdez;
    }

    public boolean isDeficiencia_cadeirante() {
        return deficiencia_cadeirante;
    }

    public void setDeficiencia_cadeirante(boolean deficiencia_cadeirante) {
        this.deficiencia_cadeirante = deficiencia_cadeirante;
    }

    public boolean isDeficiencia_fisica() {
        return deficiencia_fisica;
    }

    public void setDeficiencia_fisica(boolean deficiencia_fisica) {
        this.deficiencia_fisica = deficiencia_fisica;
    }

    public boolean isDeficiencia_intelectual() {
        return deficiencia_intelectual;
    }

    public void setDeficiencia_intelectual(boolean deficiencia_intelectual) {
        this.deficiencia_intelectual = deficiencia_intelectual;
    }

    public boolean isDeficiencia_nanismo() {
        return deficiencia_nanismo;
    }

    public void setDeficiencia_nanismo(boolean deficiencia_nanismo) {
        this.deficiencia_nanismo = deficiencia_nanismo;
    }

    public boolean isDeficiencia_visual() {
        return deficiencia_visual;
    }

    public void setDeficiencia_visual(boolean deficiencia_visual) {
        this.deficiencia_visual = deficiencia_visual;
    }

    public boolean isTitular_conjuge_mulher_maria_penha() {
        return titular_conjuge_mulher_maria_penha;
    }

    public void setTitular_conjuge_mulher_maria_penha(boolean titular_conjuge_mulher_maria_penha) {
        this.titular_conjuge_mulher_maria_penha = titular_conjuge_mulher_maria_penha;
    }

    public boolean isProprietario_imovel() {
        return proprietario_imovel;
    }

    public void setProprietario_imovel(boolean proprietario_imovel) {
        this.proprietario_imovel = proprietario_imovel;
    }

    public boolean isProprietario_lote() {
        return proprietario_lote;
    }

    public void setProprietario_lote(boolean proprietario_lote) {
        this.proprietario_lote = proprietario_lote;
    }

    public boolean isProprietario_imovel_precario() {
        return proprietario_imovel_precario;
    }

    public void setProprietario_imovel_precario(boolean proprietario_imovel_precario) {
        this.proprietario_imovel_precario = proprietario_imovel_precario;
    }

    public boolean isConvenio() {
        return convenio;
    }

    public void setConvenio(boolean convenio) {
        this.convenio = convenio;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Pessoa)) {
            return false;
        }
        return ((Pessoa) obj).getId() == getId();
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getFoto_pessoa() {
        return foto_pessoa;
    }

    public void setFoto_pessoa(String foto_pessoa) {
        this.foto_pessoa = foto_pessoa;
    }

    public String getFoto_cpf() {
        return foto_cpf;
    }

    public void setFoto_cpf(String foto_cpf) {
        this.foto_cpf = foto_cpf;
    }

    public String getFoto_rg() {
        return foto_rg;
    }

    public void setFoto_rg(String foto_rg) {
        this.foto_rg = foto_rg;
    }

    public String getFoto_rg_verso() {
        return foto_rg_verso;
    }

    public void setFoto_rg_verso(String foto_rg_verso) {
        this.foto_rg_verso = foto_rg_verso;
    }

    public String getFoto_cnh() {
        return foto_cnh;
    }

    public void setFoto_cnh(String foto_cnh) {
        this.foto_cnh = foto_cnh;
    }

    public String getFoto_carteira_trabalho() {
        return foto_carteira_trabalho;
    }

    public void setFoto_carteira_trabalho(String foto_carteira_trabalho) {
        this.foto_carteira_trabalho = foto_carteira_trabalho;
    }

    public String getFoto_documento_casa() {
        return foto_documento_casa;
    }

    public void setFoto_documento_casa(String foto_documento_casa) {
        this.foto_documento_casa = foto_documento_casa;
    }

    public String getFoto_comprovante_renda() {
        return foto_comprovante_renda;
    }

    public void setFoto_comprovante_renda(String foto_comprovante_renda) {
        this.foto_comprovante_renda = foto_comprovante_renda;
    }

    public String getFoto_comprovante_estado_civil() {
        return foto_comprovante_estado_civil;
    }

    public void setFoto_comprovante_estado_civil(String foto_comprovante_estado_civil) {
        this.foto_comprovante_estado_civil = foto_comprovante_estado_civil;
    }

    public String getId_site() {
        return id_site;
    }

    public void setId_site(String id_site) {
        this.id_site = id_site;
    }
}
