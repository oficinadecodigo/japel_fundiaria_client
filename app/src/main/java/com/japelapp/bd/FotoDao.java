package com.japelapp.bd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.japelapp.entidade.Foto;

import java.text.SimpleDateFormat;

public class FotoDao {


    DatabaseHelper databaseHelper;

    public FotoDao(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void deleteAll() {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        writableDatabase.execSQL("delete from pessoa;");
    }

    public void insert(Foto registry) {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        ContentValues contentValues = marshal(registry);
        writableDatabase.insert("foto", "", contentValues);
    }

    public void update(Foto registry) {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        ContentValues contentValues = marshal(registry);
        writableDatabase.update("foto", contentValues, "id=" + registry.getId(), new String[]{});
    }

    public int getMaxId() {
        int id = 0;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select max(id) as id from foto ", new String[]{});
        if (cursor.moveToNext()) {
            id = cursor.getInt(cursor.getColumnIndex("id"));
        }
        cursor.close();
        if (id == 0) {
            id++;
        }
        return id;
    }

    public Foto get() {
        Foto registry = null;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select * from foto;", new String[]{});
        while (cursor.moveToNext()) {
            registry = fill(cursor);
        }
        cursor.close();
        return registry;
    }

    public Foto get(int id) {
        Foto registry = null;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select * from foto where id =" + id, new String[]{});
        if (cursor.moveToFirst()) {
            registry = fill(cursor);
        }
        cursor.close();
        return registry;
    }

    private ContentValues marshal(Foto registry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", registry.getId());
        contentValues.put("tipo", registry.getTipo());
        contentValues.put("descricao", registry.getDescricao());
        contentValues.put("caminho", registry.getCaminho());
        contentValues.put("id_pessoa", registry.getId_pessoa());
        contentValues.put("id_moradia", registry.getId_moradia());
        return contentValues;
    }

    private Foto fill(Cursor cursor) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Foto registry = new Foto();
        registry.setId(cursor.getInt(cursor.getColumnIndex("id")));
        registry.setTipo(cursor.getInt(cursor.getColumnIndex("tipo")));
        registry.setDescricao(cursor.getString(cursor.getColumnIndex("descricao")));
        registry.setCaminho(cursor.getString(cursor.getColumnIndex("caminho")));
        registry.setId_pessoa(cursor.getInt(cursor.getColumnIndex("id_pessoa")));
        registry.setId_moradia(cursor.getInt(cursor.getColumnIndex("id_moradia")));
        return registry;
    }


}
