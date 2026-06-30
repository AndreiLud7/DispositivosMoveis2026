package com.example.listagem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AdapterAnimal extends ArrayAdapter<Animal> {
    Context lcontext;

    public AdapterAnimal(@NonNull Context context, int resource, @NonNull List<Animal> objects) {
        super(context, resource, objects);
        lcontext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //INflar layout
        LayoutInflater layoutInflater = LayoutInflater.from(lcontext);
        View view = layoutInflater.inflate(R.layout.item, parent, false);



        TextView tvNome = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView tvDescricao = view.findViewById(R.id.tvmassa);

        Animal a = getItem(position);

        tvNome.setText(a.nome);
        imageView.setImageResource(a.foto);
        tvDescricao.setText(a.descricao);

        return view;
    }
}