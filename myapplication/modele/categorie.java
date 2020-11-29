package com.example.myapplication.modele;

import java.io.Serializable;

public class categorie implements Serializable {
    private int id;
    private String titre;
    private String Visuel;

    public categorie(int id, String titre, String visuel) {
        this.id = id;
        this.titre = titre;
        Visuel = visuel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getVisuel() {
        return Visuel;
    }

    public void setVisuel(String visuel) {
        Visuel = visuel;
    }
}
