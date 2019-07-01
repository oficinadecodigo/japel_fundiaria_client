package com.japelapp.bd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.japelapp.entidade.Usuario;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class UsuarioDao {

    DatabaseHelper databaseHelper;

    public UsuarioDao(DatabaseHelper databaseHelper) {
        this.databaseHelper = databaseHelper;
    }

    public void deleteAll() {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        writableDatabase.execSQL("delete from usuario;");
    }

    public void insert(Usuario registry) {
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        ContentValues contentValues = marshal(registry);
        writableDatabase.insert("usuario", "", contentValues);
    }

    public Usuario get(int id) {
        Usuario registry = null;
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select * from usuario;", new String[]{});
        if (cursor.moveToNext()) {
            registry = fill(cursor);
        }
        cursor.close();
        return registry;
    }

    public ArrayList<Usuario> get() {
        ArrayList<Usuario> registros = new ArrayList<>();
        SQLiteDatabase writableDatabase = this.databaseHelper.getWritableDatabase();
        Cursor cursor = writableDatabase.rawQuery("select * from usuario;", new String[]{});
        while (cursor.moveToNext()) {
            registros.add(fill(cursor));
        }
        cursor.close();
        return registros;
    }

    private ContentValues marshal(Usuario registry) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", registry.getId());
        contentValues.put("nome", registry.getNome());
        contentValues.put("email", registry.getEmail());
        contentValues.put("login", registry.getLogin());
        contentValues.put("senha", registry.getSenha());
        contentValues.put("administrador", registry.isAdministrador() ? 1 : 0);
        return contentValues;
    }

    private Usuario fill(Cursor cursor) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Usuario registry = new Usuario();
        registry.setId(cursor.getInt(cursor.getColumnIndex("id")));
        registry.setNome(cursor.getString(cursor.getColumnIndex("nome")));
        registry.setEmail(cursor.getString(cursor.getColumnIndex("email")));
        registry.setLogin(cursor.getString(cursor.getColumnIndex("login")));
        registry.setSenha(cursor.getString(cursor.getColumnIndex("senha")));
        registry.setAdministrador(cursor.getInt(cursor.getColumnIndex("administrador")) == 1);
        return registry;
    }

}
