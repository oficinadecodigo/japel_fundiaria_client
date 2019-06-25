package com.japelapp.bd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.japelapp.entidade.Moradia;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MoradiaDao {
    DatabaseHelper databaseHelper;

    public MoradiaDao(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void deleteAll() {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        writableDatabase.execSQL("delete from moradia;");
    }

    public void insert(Moradia registry) {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        ContentValues contentValues = marshal(registry);
        writableDatabase.insert("moradia", "", contentValues);
    }

    public void update(Moradia registry) {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        ContentValues contentValues = marshal(registry);
        writableDatabase.update("moradia", contentValues, "id=" + registry.getId(), new String[]{});
    }

    public int getMaxId() {
        int id = 0;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select max(id) as id from moradia ", new String[]{});
        if (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"));
        }
        cursor.close();
        if (id == 0) {
            id++;
        }
        return id;
    }

    public Moradia get(int id) {
        Moradia registry = null;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select * from moradia where id = " + id, new String[]{});
        if (cursor.moveToNext()) {
            registry = fill(cursor);
        }
        cursor.close();
        return registry;
    }

    public Moradia getPorBeneficiario(int id) {
        Moradia registry = null;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select * from moradia where id_pessoa = " + id, new String[]{});
        if (cursor.moveToNext()) {
            registry = fill(cursor);
        }
        cursor.close();
        return registry;
    }

    public ArrayList<Moradia> get() {
        ArrayList<Moradia> registros = new ArrayList<>();
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select * from moradia;", new String[]{});
        while (cursor.moveToNext()) {
            registros.add(fill(cursor));
        }
        cursor.close();
        return registros;
    }

    private ContentValues marshal(Moradia registry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", registry.getId());
        contentValues.put("quadra", registry.getQuadra());
        contentValues.put("lote", registry.getLote());
        contentValues.put("poligonal", registry.getPoligonal());
        contentValues.put("endereco", registry.getEndereco());
        contentValues.put("numero", registry.getNumero());
        contentValues.put("complemento", registry.getComplemento());
        contentValues.put("cep", registry.getCep());
        contentValues.put("bairro", registry.getBairro());
        contentValues.put("cidade", registry.getCidade());
        contentValues.put("uf", registry.getUf());
        contentValues.put("area_construida", registry.getArea_construida());
        contentValues.put("matricula_imovel", registry.getMatricula_imovel());
        contentValues.put("medida_frente", registry.getMedida_frente());
        contentValues.put("medida_direita", registry.getMedida_direita());
        contentValues.put("medida_esquerda", registry.getMedida_esquerda());
        contentValues.put("medida_fundo", registry.getMedida_fundo());
        contentValues.put("numero_lote_fundo", registry.getNumero_lote_fundo());
        contentValues.put("numero_lote_direita", registry.getNumero_lote_direita());
        contentValues.put("numero_lote_esquerda", registry.getNumero_lote_esquerda());
        contentValues.put("rua_frente", registry.getRua_frente());
        contentValues.put("rua_direita", registry.getRua_direita());
        contentValues.put("rua_esquerda", registry.getRua_esquerda());
        contentValues.put("rua_fundo", registry.getRua_fundo());
        contentValues.put("selagem", registry.getSelagem());
        contentValues.put("latitude", registry.getLatitude());
        contentValues.put("longitude", registry.getLongitude());
        contentValues.put("altitude", registry.getAltitude());
        contentValues.put("zona", registry.getZona());
        contentValues.put("situacao_propriedade", registry.getSituacao_propriedade());
        contentValues.put("valor_aluguel", registry.getValor_aluguel());
        contentValues.put("numero_quarto", registry.getNumero_quarto());
        contentValues.put("numero_comodos", registry.getNumero_comodos());
        contentValues.put("tipo_construcao", registry.getTipo_construcao());
        contentValues.put("outro_tipo_construcao", registry.getOutro_tipo_construcao());
        contentValues.put("fonte_energia", registry.isFonte_energia());
        contentValues.put("abastecimento_agua", registry.isAbastecimento_agua());
        contentValues.put("rede_esgoto", registry.isRede_esgoto());
        contentValues.put("coleta_lixo", registry.isColeta_lixo());
        contentValues.put("separacao_reciclaveis", registry.isSeparacao_reciclaveis());
        contentValues.put("valor_beneficio_prestacao_continuada", registry.getValor_beneficio_prestacao_continuada());
        contentValues.put("valor_bolsa_familia", registry.getValor_bolsa_familia());
        contentValues.put("outro_beneficio", registry.getOutro_beneficio());
        contentValues.put("area_risco", registry.isArea_risco());
        contentValues.put("insalubre", registry.isInsalubre());
        contentValues.put("desabrigado", registry.isDesabrigado());
        contentValues.put("observacao", registry.getObservacao());
        contentValues.put("id_pessoa", registry.getId_pessoa());
        contentValues.put("id_usuario", registry.getId_usuario());
        return contentValues;
    }

    private Moradia fill(Cursor cursor) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Moradia registry = new Moradia();
        registry = new Moradia();
        registry.setId(cursor.getInt(cursor.getColumnIndex("id")));
        registry.setQuadra(cursor.getString(cursor.getColumnIndex("quadra")));
        registry.setLote(cursor.getString(cursor.getColumnIndex("lote")));
        registry.setPoligonal(cursor.getInt(cursor.getColumnIndex("poligonal")));
        registry.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
        registry.setNumero(cursor.getString(cursor.getColumnIndex("numero")));
        registry.setComplemento(cursor.getString(cursor.getColumnIndex("complemento")));
        registry.setCep(cursor.getString(cursor.getColumnIndex("cep")));
        registry.setBairro(cursor.getString(cursor.getColumnIndex("bairro")));
        registry.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
        registry.setUf(cursor.getString(cursor.getColumnIndex("uf")));
        registry.setArea_construida(cursor.getString(cursor.getColumnIndex("area_construida")));
        registry.setMatricula_imovel(cursor.getString(cursor.getColumnIndex("matricula_imovel")));
        registry.setMedida_frente(cursor.getDouble(cursor.getColumnIndex("medida_frente")));
        registry.setMedida_direita(cursor.getDouble(cursor.getColumnIndex("medida_direita")));
        registry.setMedida_esquerda(cursor.getDouble(cursor.getColumnIndex("medida_esquerda")));
        registry.setMedida_fundo(cursor.getDouble(cursor.getColumnIndex("medida_fundo")));
        registry.setNumero_lote_fundo(cursor.getDouble(cursor.getColumnIndex("numero_lote_fundo")));
        registry.setNumero_lote_direita(cursor.getString(cursor.getColumnIndex("numero_lote_direita")));
        registry.setNumero_lote_esquerda(cursor.getString(cursor.getColumnIndex("numero_lote_esquerda")));
        registry.setRua_frente(cursor.getString(cursor.getColumnIndex("rua_frente")));
        registry.setRua_direita(cursor.getString(cursor.getColumnIndex("rua_direita")));
        registry.setRua_esquerda(cursor.getString(cursor.getColumnIndex("rua_esquerda")));
        registry.setRua_fundo(cursor.getString(cursor.getColumnIndex("rua_fundo")));
        registry.setSelagem(cursor.getString(cursor.getColumnIndex("selagem")));
        registry.setLatitude(cursor.getString(cursor.getColumnIndex("latitude")));
        registry.setLongitude(cursor.getString(cursor.getColumnIndex("longitude")));
        registry.setAltitude(cursor.getString(cursor.getColumnIndex("altitude")));
        registry.setZona(cursor.getInt(cursor.getColumnIndex("zona")));
        registry.setSituacao_propriedade(cursor.getInt(cursor.getColumnIndex("situacao_propriedade")));
        registry.setValor_aluguel(cursor.getDouble(cursor.getColumnIndex("valor_aluguel")));
        registry.setNumero_quarto(cursor.getInt(cursor.getColumnIndex("numero_quarto")));
        registry.setNumero_comodos(cursor.getInt(cursor.getColumnIndex("numero_comodos")));
        registry.setTipo_construcao(cursor.getInt(cursor.getColumnIndex("tipo_construcao")));
        registry.setOutro_tipo_construcao(cursor.getString(cursor.getColumnIndex("outro_tipo_construcao")));
        registry.setFonte_energia(cursor.getInt(cursor.getColumnIndex("fonte_energia")) == 1);
        registry.setAbastecimento_agua(cursor.getInt(cursor.getColumnIndex("abastecimento_agua")) == 1);
        registry.setRede_esgoto(cursor.getInt(cursor.getColumnIndex("rede_esgoto")) == 1);
        registry.setColeta_lixo(cursor.getInt(cursor.getColumnIndex("coleta_lixo")) == 1);
        registry.setSeparacao_reciclaveis(cursor.getInt(cursor.getColumnIndex("separacao_reciclaveis")) == 1);
        registry.setValor_beneficio_prestacao_continuada(cursor.getDouble(cursor.getColumnIndex("valor_beneficio_prestacao_continuada")));
        registry.setValor_bolsa_familia(cursor.getDouble(cursor.getColumnIndex("valor_bolsa_familia")));
        registry.setOutro_beneficio(cursor.getDouble(cursor.getColumnIndex("outro_beneficio")));
        registry.setArea_risco(cursor.getInt(cursor.getColumnIndex("area_risco")) == 1);
        registry.setInsalubre(cursor.getInt(cursor.getColumnIndex("insalubre")) == 1);
        registry.setDesabrigado(cursor.getInt(cursor.getColumnIndex("desabrigado")) == 1);
        registry.setObservacao(cursor.getString(cursor.getColumnIndex("observacao")));
        registry.setId_pessoa(cursor.getInt(cursor.getColumnIndex("id_pessoa")));
        registry.setId_usuario(cursor.getInt(cursor.getColumnIndex("id_usuario")));
        return registry;
    }

}
