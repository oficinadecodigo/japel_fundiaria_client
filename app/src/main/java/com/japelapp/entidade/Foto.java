package com.japelapp.entidade;

public class Foto {

    private int id;
    private int tipo;
    private String descricao;
    private String caminho;
    private int id_pessoa;
    private int id_moradia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public int getId_moradia() {
        return id_moradia;
    }

    public void setId_moradia(int id_moradia) {
        this.id_moradia = id_moradia;
    }
}
