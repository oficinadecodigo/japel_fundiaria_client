package com.japelapp.bd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.japelapp.entidade.Pessoa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PessoaDao {

    DatabaseHelper databaseHelper;

    public PessoaDao(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void deleteAll() {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        writableDatabase.execSQL("delete from pessoa;");
    }

    public void insert(Pessoa registry) {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        ContentValues contentValues = marshal(registry);
        writableDatabase.insert("pessoa", "", contentValues);
    }

    public void update(Pessoa registry) {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        ContentValues contentValues = marshal(registry);
        writableDatabase.update("pessoa", contentValues, "id=" + registry.getId(), new String[]{});
    }

    public ArrayList<Pessoa> getCompFam(int id) {
        ArrayList<Pessoa> registros = new ArrayList<>();
        Pessoa registry = null;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select * from pessoa where parentesco > 0 and id_pessoa = " + id, new String[]{});
        while (cursor.moveToNext()) {
            registros.add(fill(cursor));
        }
        cursor.close();
        return registros;
    }

    public int getMaxId() {
        int id = 0;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select max(id) as id from pessoa ", new String[]{});
        if (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"));
        }
        cursor.close();
        if (id == 0) {
            id++;
        }
        return id;
    }

    public Pessoa getConjuje(int id) {
        Pessoa registry = null;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select * from pessoa where parentesco = -1 and id_pessoa = " + id, new String[]{});
        if (cursor.moveToNext()) {
            registry = fill(cursor);
        }
        cursor.close();
        return registry;
    }

    public Pessoa get(int id) {
        Pessoa registry = null;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select * from pessoa where id = " + id, new String[]{});
        if (cursor.moveToNext()) {
            registry = fill(cursor);
        }
        cursor.close();
        return registry;
    }

    public Pessoa get() {
        Pessoa registry = null;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select * from pessoa;", new String[]{});
        while (cursor.moveToNext()) {
            registry = fill(cursor);
        }
        cursor.close();
        return registry;
    }

    private ContentValues marshal(Pessoa registry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", registry.getId());
        contentValues.put("nome", registry.getNome());
        try {
            contentValues.put("existe", registry.isExiste() ? 1 : 0);
        } catch (Throwable ex) {
        }
        contentValues.put("cpf", registry.getCpf());
        contentValues.put("rg", registry.getRg());
        contentValues.put("nome_mae", registry.getNome_mae());
        contentValues.put("nome_pai", registry.getNome_pai());
        contentValues.put("parentesco", registry.getParentesco());
        contentValues.put("sexo", registry.getSexo());
        contentValues.put("raca", registry.getRaca());
        if (registry.getData_nascimento() != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            contentValues.put("data_nascimento", simpleDateFormat.format(registry.getData_nascimento()));
        }
        contentValues.put("email", registry.getEmail());
        contentValues.put("nacionalidade", registry.getNacionalidade());
        contentValues.put("numero_cpts", registry.getNumero_cpts());
        contentValues.put("pis_pasep", registry.getPis_pasep());
        contentValues.put("numero_cadunico", registry.getNumero_cadunico());
        contentValues.put("nis", registry.getNis());
        contentValues.put("escolaridade", registry.getEscolaridade());
        contentValues.put("estado_civil", registry.getEstado_civil());
        contentValues.put("situacao_conjugal", registry.getSituacao_conjugal());
        contentValues.put("profissao", registry.getProfissao());
        contentValues.put("renda_formal", registry.getRenda_formal());
        contentValues.put("situacao_renda_formal", registry.getSituacao_renda_formal());
        contentValues.put("renda_informal", registry.getRenda_informal());
        contentValues.put("situacao_renda_informal", registry.getSituacao_renda_informal());
        contentValues.put("ramo_atividade", registry.getRamo_atividade());
        contentValues.put("empregador", registry.getEmpregador());
        contentValues.put("tempo_servico_emprego_atual", registry.getTempo_servico_emprego_atual());
        contentValues.put("valor_fgts", registry.getValor_fgts());
        contentValues.put("telefone_fixo", registry.getTelefone_fixo());
        contentValues.put("telefone_movel", registry.getTelefone_movel());
        contentValues.put("telefone_recado", registry.getTelefone_recado());
        contentValues.put("falar_com", registry.getFalar_com());
        contentValues.put("tempo_residencia_imovel", registry.getTempo_residencia_imovel());
        contentValues.put("tempo_residencia_municipio", registry.getTempo_residencia_municipio());
        contentValues.put("interesse_moradia_urbana", registry.isInteresse_moradia_urbana() ? 1 : 0);
        contentValues.put("interesse_moradia_rural", registry.isInteresse_moradia_rural() ? 1 : 0);
        contentValues.put("interesse_lote", registry.isInteresse_lote() ? 1 : 0);
        contentValues.put("interesse_regulacao_fundiaria", registry.isInteresse_regulacao_fundiaria() ? 1 : 0);
        contentValues.put("deficiencia_auditiva_mudez", registry.isDeficiencia_auditiva_mudez() ? 1 : 0);
        contentValues.put("deficiencia_auditiva_surdez", registry.isDeficiencia_auditiva_surdez() ? 1 : 0);
        contentValues.put("deficiencia_cadeirante", registry.isDeficiencia_cadeirante() ? 1 : 0);
        contentValues.put("deficiencia_fisica", registry.isDeficiencia_fisica() ? 1 : 0);
        contentValues.put("deficiencia_intelectual", registry.isDeficiencia_intelectual() ? 1 : 0);
        contentValues.put("deficiencia_nanismo", registry.isDeficiencia_nanismo() ? 1 : 0);
        contentValues.put("deficiencia_visual", registry.isDeficiencia_visual() ? 1 : 0);
        contentValues.put("titular_conjuge_mulher_maria_penha", registry.isTitular_conjuge_mulher_maria_penha() ? 1 : 0);
        contentValues.put("proprietario_imovel", registry.isProprietario_imovel() ? 1 : 0);
        contentValues.put("proprietario_lote", registry.isProprietario_lote() ? 1 : 0);
        contentValues.put("proprietario_imovel_precario", registry.isProprietario_imovel_precario() ? 1 : 0);
        contentValues.put("convenio", registry.getConvenio());
        contentValues.put("tipo", registry.getTipo());

        contentValues.put("foto_pessoa", registry.getFoto_pessoa());
        contentValues.put("foto_cpf", registry.getFoto_cpf());
        contentValues.put("foto_rg", registry.getFoto_rg());
        contentValues.put("foto_rg_verso", registry.getFoto_rg_verso());
        contentValues.put("foto_cnh", registry.getFoto_cnh());
        contentValues.put("foto_carteira_trabalho", registry.getFoto_carteira_trabalho());
        contentValues.put("foto_documento_casa", registry.getFoto_documento_casa());
        contentValues.put("foto_comprovante_renda", registry.getFoto_comprovante_renda());
        contentValues.put("foto_comprovante_estado_civil", registry.getFoto_comprovante_estado_civil());

        contentValues.put("id_pessoa", registry.getId_pessoa());
        contentValues.put("id_usuario", registry.getId_usuario());

        contentValues.put("id_site", registry.getId_site());

        contentValues.put("fgts_receber", registry.getFgts_receber());

        return contentValues;
    }

    private Pessoa fill(Cursor cursor) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Pessoa registry = new Pessoa();
        registry = new Pessoa();
        registry.setId(cursor.getInt(cursor.getColumnIndex("id")));
        try {
            registry.setExiste(cursor.getInt(cursor.getColumnIndex("existe")) == 1);
        } catch (Throwable ex) {
        }
        registry.setNome(cursor.getString(cursor.getColumnIndex("nome")));
        registry.setCpf(cursor.getString(cursor.getColumnIndex("cpf")));
        registry.setRg(cursor.getString(cursor.getColumnIndex("rg")));
        registry.setNome_mae(cursor.getString(cursor.getColumnIndex("nome_mae")));
        registry.setNome_pai(cursor.getString(cursor.getColumnIndex("nome_pai")));
        registry.setParentesco(cursor.getInt(cursor.getColumnIndex("parentesco")));
        registry.setSexo(cursor.getInt(cursor.getColumnIndex("sexo")));
        registry.setRaca(cursor.getInt(cursor.getColumnIndex("raca")));
        try {
            registry.setData_nascimento(simpleDateFormat.parse(cursor.getString(cursor.getColumnIndex("data_nascimento"))));
        } catch (Throwable ex) {
        }
        registry.setEmail(cursor.getString(cursor.getColumnIndex("email")));
        registry.setNacionalidade(cursor.getString(cursor.getColumnIndex("nacionalidade")));
        registry.setNumero_cpts(cursor.getString(cursor.getColumnIndex("numero_cpts")));
        registry.setPis_pasep(cursor.getString(cursor.getColumnIndex("pis_pasep")));
        registry.setNumero_cadunico(cursor.getString(cursor.getColumnIndex("numero_cadunico")));
        registry.setNis(cursor.getString(cursor.getColumnIndex("nis")));
        registry.setEscolaridade(cursor.getInt(cursor.getColumnIndex("escolaridade")));
        registry.setEstado_civil(cursor.getInt(cursor.getColumnIndex("estado_civil")));
        registry.setSituacao_conjugal(cursor.getInt(cursor.getColumnIndex("situacao_conjugal")));
        registry.setProfissao(cursor.getString(cursor.getColumnIndex("profissao")));
        registry.setRenda_formal(cursor.getDouble(cursor.getColumnIndex("renda_formal")));
        registry.setSituacao_renda_formal(cursor.getInt(cursor.getColumnIndex("situacao_renda_formal")));
        registry.setRenda_informal(cursor.getDouble(cursor.getColumnIndex("renda_informal")));
        registry.setSituacao_renda_informal(cursor.getInt(cursor.getColumnIndex("situacao_renda_informal")));
        registry.setRamo_atividade(cursor.getInt(cursor.getColumnIndex("ramo_atividade")));
        registry.setEmpregador(cursor.getString(cursor.getColumnIndex("empregador")));
        registry.setTempo_servico_emprego_atual(cursor.getInt(cursor.getColumnIndex("tempo_servico_emprego_atual")));
        registry.setValor_fgts(cursor.getDouble(cursor.getColumnIndex("valor_fgts")));
        registry.setTelefone_fixo(cursor.getString(cursor.getColumnIndex("telefone_fixo")));
        registry.setTelefone_movel(cursor.getString(cursor.getColumnIndex("telefone_movel")));
        registry.setTelefone_recado(cursor.getString(cursor.getColumnIndex("telefone_recado")));
        registry.setFalar_com(cursor.getString(cursor.getColumnIndex("falar_com")));
        registry.setTempo_residencia_imovel(cursor.getInt(cursor.getColumnIndex("tempo_residencia_imovel")));
        registry.setTempo_residencia_municipio(cursor.getInt(cursor.getColumnIndex("tempo_residencia_municipio")));
        registry.setInteresse_moradia_urbana(cursor.getInt(cursor.getColumnIndex("interesse_moradia_urbana")) == 1);
        registry.setInteresse_moradia_rural(cursor.getInt(cursor.getColumnIndex("interesse_moradia_rural")) == 1);
        registry.setInteresse_lote(cursor.getInt(cursor.getColumnIndex("interesse_lote")) == 1);
        registry.setInteresse_regulacao_fundiaria(cursor.getInt(cursor.getColumnIndex("interesse_regulacao_fundiaria")) == 1);
        registry.setDeficiencia_auditiva_mudez(cursor.getInt(cursor.getColumnIndex("deficiencia_auditiva_mudez")) == 1);
        registry.setDeficiencia_auditiva_surdez(cursor.getInt(cursor.getColumnIndex("deficiencia_auditiva_surdez")) == 1);
        registry.setDeficiencia_cadeirante(cursor.getInt(cursor.getColumnIndex("deficiencia_cadeirante")) == 1);
        registry.setDeficiencia_fisica(cursor.getInt(cursor.getColumnIndex("deficiencia_fisica")) == 1);
        registry.setDeficiencia_intelectual(cursor.getInt(cursor.getColumnIndex("deficiencia_intelectual")) == 1);
        registry.setDeficiencia_nanismo(cursor.getInt(cursor.getColumnIndex("deficiencia_nanismo")) == 1);
        registry.setDeficiencia_visual(cursor.getInt(cursor.getColumnIndex("deficiencia_visual")) == 1);
        registry.setTitular_conjuge_mulher_maria_penha(cursor.getInt(cursor.getColumnIndex("titular_conjuge_mulher_maria_penha")) == 1);
        registry.setProprietario_imovel(cursor.getInt(cursor.getColumnIndex("proprietario_imovel")) == 1);
        registry.setProprietario_lote(cursor.getInt(cursor.getColumnIndex("proprietario_lote")) == 1);
        registry.setProprietario_imovel_precario(cursor.getInt(cursor.getColumnIndex("proprietario_imovel_precario")) == 1);
        registry.setConvenio(cursor.getInt(cursor.getColumnIndex("convenio")));
        registry.setTipo(cursor.getInt(cursor.getColumnIndex("tipo")));

        registry.setFoto_pessoa(cursor.getString(cursor.getColumnIndex("foto_pessoa")));
        registry.setFoto_cpf(cursor.getString(cursor.getColumnIndex("foto_cpf")));
        registry.setFoto_rg(cursor.getString(cursor.getColumnIndex("foto_rg")));
        registry.setFoto_rg_verso(cursor.getString(cursor.getColumnIndex("foto_rg_verso")));
        registry.setFoto_cnh(cursor.getString(cursor.getColumnIndex("foto_cnh")));
        registry.setFoto_carteira_trabalho(cursor.getString(cursor.getColumnIndex("foto_carteira_trabalho")));
        registry.setFoto_documento_casa(cursor.getString(cursor.getColumnIndex("foto_documento_casa")));
        registry.setFoto_comprovante_renda(cursor.getString(cursor.getColumnIndex("foto_comprovante_renda")));
        registry.setFoto_comprovante_estado_civil(cursor.getString(cursor.getColumnIndex("foto_comprovante_estado_civil")));

        registry.setId_pessoa(cursor.getInt(cursor.getColumnIndex("id_pessoa")));
        registry.setId_usuario(cursor.getInt(cursor.getColumnIndex("id_usuario")));

        registry.setId_site(cursor.getString(cursor.getColumnIndex("id_site")));

        registry.setFgts_receber(cursor.getInt(cursor.getColumnIndex("fgts_receber")));

        return registry;
    }

}
