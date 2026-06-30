package com.example.listagem;

import java.util.ArrayList;

public class AnimalController {
    AnimalDAO animalDAO;

    public AnimalController() {
        animalDAO = new AnimalDAO();
    }

    public ArrayList<Animal> listaAnimais() {
        return animalDAO.listaAnimais();
    }

}