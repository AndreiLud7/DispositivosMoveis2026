package com.example.listagem;

import java.util.ArrayList;

public class AnimalDAO {
    ArrayList<Animal> listaAnimais;

    public AnimalDAO() {
        listaAnimais = new ArrayList<>();
        listaAnimais.add(new Animal("Leão", R.drawable.leao, "Rei da selva"));
        listaAnimais.add(new Animal("Elefante", R.drawable.elefante, "Maior mamífero terrestre"));
        listaAnimais.add(new Animal("Tigre", R.drawable.tigre, "Felino muito veloz"));
        listaAnimais.add(new Animal("Lobo", R.drawable.lobo, "Vive em alcateias"));
        listaAnimais.add(new Animal("Girafa", R.drawable.girafa, "Animal mais alto do mundo"));
        listaAnimais.add(new Animal("Zebra", R.drawable.zebra, "Possui listras pretas e brancas"));

    }

    public ArrayList<Animal> listaAnimais() {
        return listaAnimais;
    }

}