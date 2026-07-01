package com.example.notas;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.notas.Model.Nota;
import com.example.notas.controller.NotaController;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    NotaController notaController;
    ListView listview;

    ArrayList<Nota> notas;
    ArrayList<String> tituloNotas;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.listView);
        notaController = new NotaController(getApplicationContext());
        fab = findViewById(R.id.floatingActionButton);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CadastrarActivity.class);
                startActivity(i);
            }
        });

        atualizaLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaLista();
    }

    public void atualizaLista() {
        notas = notaController.listarNotas();
        tituloNotas = getTituloNotas(notas);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, tituloNotas);
        listview.setAdapter(adapter);
    }

    public ArrayList<String> getTituloNotas(ArrayList<Nota> lnotas) {
        ArrayList<String> result = new ArrayList<>();
        for (Nota nota : lnotas) {
            result.add(nota.getTitulo());
        }
        return result;
    }
}
