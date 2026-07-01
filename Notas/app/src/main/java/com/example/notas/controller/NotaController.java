package com.example.notas.controller;

import android.content.Context;
import com.example.notas.Model.Nota;
import com.example.notas.Model.NotaDAO;

import java.util.ArrayList;

public class NotaController {
    NotaDAO notadao;
    public NotaController(Context c) {
        notadao = new NotaDAO(c);

    }


    public void cadastrarNota(Nota nota) {
        if(nota.getTitulo().length()>3){
            notadao.inserir(nota);
        }
    }

    public void editarNota(Nota nota){
        if(nota.getTitulo().length()>3){
            notadao.atualizarNota(nota);
        }
    }

    public void excluirNota(Nota nota){
        notadao.excluirNota(nota);
    }

    public ArrayList<Nota> listarNotas(){
        return notadao.listarNotas();
    }

    public Nota getNota(int id){
        return notadao.getnota(id);
    }


}


