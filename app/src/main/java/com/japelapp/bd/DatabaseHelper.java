package com.japelapp.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper<E> extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "japel_fundiaria";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        createDatabaseTables(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void close() {
        super.close();
    }

    private void createDatabaseTables(SQLiteDatabase writableDatabase) {
        //SQLiteDatabase writableDatabase = getWritableDatabase();
        //writableDatabase.beginTransaction();
        writableDatabase.execSQL(
                "CREATE TABLE usuario(\n" +
                        "  id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                        "  nome VARCHAR(100), \n" +
                        "  email VARCHAR(200), \n" +
                        "  login VARCHAR(50), \n" +
                        "  senha VARCHAR(100), \n" +
                        "  administrador BOOLEAN);"
        );
        writableDatabase.execSQL(
                "CREATE TABLE pessoa(\n" +
                        "  id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, \n" +
                        "  nome VARCHAR(100), \n" +
                        "  cpf VARCHAR(20), \n" +
                        "  rg VARCHAR(20), \n" +
                        "  nome_mae VARCHAR(100), \n" +
                        "  nome_pai VARCHAR(100), \n" +
                        "  parentesco INTEGER, \n" +
                        "  sexo INTEGER, \n" +
                        "  raca INTEGER, \n" +
                        "  data_nascimento DATE, \n" +
                        "  email VARCHAR(100), \n" +
                        "  nacionalidade INTEGER, \n" +
                        "  numero_cpts VARCHAR(30), \n" +
                        "  pis_pasep VARCHAR(30), \n" +
                        "  numero_cadunico VARCHAR(30), \n" +
                        "  nis VARCHAR(30), \n" +
                        "  escolaridade INTEGER, \n" +
                        "  estado_civil INTEGER, \n" +
                        "  situacao_conjugal INTEGER, \n" +
                        "  profissao VARCHAR(70), \n" +
                        "  renda_formal DOUBLE(4, 2), \n" +
                        "  situacao_renda_formal INTEGER, \n" +
                        "  renda_informal DOUBLE(4, 2), \n" +
                        "  situacao_renda_informal INTEGER, \n" +
                        "  ramo_atividade INTEGER, \n" +
                        "  empregador VARCHAR(100), \n" +
                        "  tempo_servico_emprego_atual INTEGER, \n" +
                        "  valor_fgts DOUBLE(4, 2), \n" +
                        "  telefone_fixo VARCHAR(20), \n" +
                        "  telefone_movel VARCHAR(20), \n" +
                        "  telefone_recado VARCHAR(20), \n" +
                        "  falar_com VARCHAR(100), \n" +
                        "  tempo_residencia_imovel INTEGER, \n" +
                        "  tempo_residencia_municipio INTEGER, \n" +
                        "  interesse_moradia_urbana BOOLEAN, \n" +
                        "  interesse_moradia_rural BOOLEAN, \n" +
                        "  interesse_lote BOOLEAN, \n" +
                        "  interesse_regulacao_fundiaria BOOLEAN, \n" +
                        "  deficiencia_auditiva_mudez BOOLEAN, \n" +
                        "  deficiencia_auditiva_surdez BOOLEAN, \n" +
                        "  deficiencia_cadeirante BOOLEAN, \n" +
                        "  deficiencia_fisica BOOLEAN, \n" +
                        "  deficiencia_intelectual BOOLEAN, \n" +
                        "  deficiencia_nanismo BOOLEAN, \n" +
                        "  deficiencia_visual BOOLEAN, \n" +
                        "  titular_conjuge_mulher_maria_penha BOOLEAN, \n" +
                        "  proprietario_imovel BOOLEAN, \n" +
                        "  proprietario_lote BOOLEAN, \n" +
                        "  proprietario_imovel_precario BOOLEAN, \n" +
                        "  convenio INTEGER, \n" +
                        "  tipo INTEGER, \n" +
                        "  foto_pessoa VARCHAR(200), \n" +
                        "  foto_cpf VARCHAR(200), \n" +
                        "  foto_rg VARCHAR(200), \n" +
                        "  foto_rg_verso VARCHAR(200), \n" +
                        "  foto_cnh VARCHAR(200), \n" +
                        "  foto_carteira_trabalho VARCHAR(200), \n" +
                        "  foto_documento_casa VARCHAR(200), \n" +
                        "  foto_comprovante_renda VARCHAR(200), \n" +
                        "  foto_comprovante_estado_civil VARCHAR(200), \n" +
                        "  id_pessoa INTEGER REFERENCES pessoa(id), \n" +
                        "  id_usuario INTEGER REFERENCES usuario(id));"
        );
        writableDatabase.execSQL(
                "CREATE TABLE moradia(\n" +
                        "  id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                        "  quadra VARCHAR(50), \n" +
                        "  lote VARCHAR(50), \n" +
                        "  poligonal INTEGER, \n" +
                        "  endereco VARCHAR(200), \n" +
                        "  numero VARCHAR(10), \n" +
                        "  complemento VARCHAR(200), \n" +
                        "  cep VARCHAR(20), \n" +
                        "  bairro VARCHAR(100), \n" +
                        "  cidade VARCHAR(100), \n" +
                        "  uf CHAR(2), \n" +
                        "  area_construida DOUBLE(5, 2), \n" +
                        "  matricula_imovel VARCHAR(30), \n" +
                        "  medida_frente DOUBLE(4, 2), \n" +
                        "  medida_direita DOUBLE(4, 2), \n" +
                        "  medida_esquerda DOUBLE(4, 2), \n" +
                        "  medida_fundo DOUBLE(4, 2), \n" +
                        "  numero_lote_fundo VARCHAR(20), \n" +
                        "  numero_lote_direita VARCHAR(20), \n" +
                        "  numero_lote_esquerda VARCHAR(20), \n" +
                        "  rua_frente VARCHAR(200), \n" +
                        "  rua_direita VARCHAR(200), \n" +
                        "  rua_esquerda VARCHAR(200), \n" +
                        "  rua_fundo VARCHAR(200), \n" +
                        "  selagem VARCHAR(50), \n" +
                        "  latitude VARCHAR(50), \n" +
                        "  longitude VARCHAR(50), \n" +
                        "  altitude VARCHAR(50), \n" +
                        "  zona INTEGER, \n" +
                        "  situacao_propriedade INTEGER, \n" +
                        "  valor_aluguel DOUBLE(4, 2), \n" +
                        "  numero_quarto INTEGER, \n" +
                        "  numero_comodos INTEGER, \n" +
                        "  tipo_construcao INTEGER, \n" +
                        "  outro_tipo_construcao VARCHAR(50), \n" +
                        "  fonte_energia BOOLEAN, \n" +
                        "  abastecimento_agua BOOLEAN, \n" +
                        "  rede_esgoto BOOLEAN, \n" +
                        "  coleta_lixo BOOLEAN, \n" +
                        "  separacao_reciclaveis BOOLEAN, \n" +
                        "  valor_beneficio_prestacao_continuada DOUBLE(4, 2), \n" +
                        "  valor_bolsa_familia DOUBLE(4, 2), \n" +
                        "  outro_beneficio DOUBLE(4, 2), \n" +
                        "  area_risco BOOLEAN, \n" +
                        "  insalubre BOOLEAN, \n" +
                        "  desabrigado BOOLEAN, \n" +
                        "  enviado BOOLEAN, \n" +
                        "  observacao VARCHAR(500), \n" +
                        "  foto_comprovante_visita VARCHAR(191), \n" +
                        "  foto_fachada VARCHAR(191), \n" +
                        "  foto_comprovante_agua VARCHAR(191), \n" +
                        "  foto_comprovante_luz VARCHAR(191), \n" +
                        "  foto_comprovante_iptu VARCHAR(191), \n" +
                        "  foto_documento_cartografico VARCHAR(191), \n" +
                        "  id_pessoa INTEGER REFERENCES pessoa(id), \n" +
                        "  id_usuario INTEGER REFERENCES usuario(id));"
        );
        writableDatabase.execSQL(
                "CREATE TABLE foto(\n" +
                        "  id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                        "  tipo INTEGER, \n" +
                        "  descricao VARCHAR(100), \n" +
                        "  caminho VARCHAR(200), \n" +
                        "  id_pessoa INTEGER REFERENCES pessoa(id), \n" +
                        "  id_moradia INTEGER REFERENCES moradia(id));"
        );
        //writableDatabase.endTransaction();
        System.out.println();
    }

}
