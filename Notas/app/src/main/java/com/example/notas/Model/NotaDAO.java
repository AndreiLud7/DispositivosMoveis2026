package com.example.notas.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDAO {


    SQLiteDatabase database;

    public NotaDAO(Context c){
        database=c.openOrCreateDatabase("minhasnotas", Context.MODE_PRIVATE,null);
        database.execSQL("CREATE TABLE IF NOT EXISTS NOTAS(id INTEGER PRIMARY KEY AUTOINCREMENT,txt TEXT, titulo TEXT)");

    }

    public void inserir (Nota nota){
        ContentValues cv=new ContentValues();
        cv.put("titulo",nota.getTitulo());
        cv.put("txt",nota.getTxt());
        database.insert("notas",null,cv);
    }

    public void atualizarNota(Nota nota){
        ContentValues cv=new ContentValues();
        cv.put("id",nota.getId());
        cv.put("titulo",nota.getTitulo());
        cv.put("txt",nota.getTxt());
        database.update("notas",cv,"id=?",new String[] {nota.getId().toString()});

    }

    public void excluirNota(Nota nota) {
        database.delete("notas","id=?",new String [] {nota.getId().toString()});

    }

    public ArrayList<Nota> listarNotas(){
        Cursor c =database.rawQuery("SELECT * FROM notas",null);
        c.moveToFirst();
        ArrayList<Nota> notasresult = new ArrayList<>();

        while (!c.isAfterLast()){
            Nota n = new Nota(c.getInt(0),c.getString(1),c.getString(2));
            notasresult.add(n);
            c.moveToNext();

        }
        return notasresult;
    }

    public Nota getnota(Integer id) {
        Cursor c = database.rawQuery("SELECT * FROM notas WHERE id= ?",new String[]{id.toString()});
        c.moveToFirst();
        Nota n = new Nota(c.getInt(0),c.getString(1),c.getString(2));
        return n;
    }
}
