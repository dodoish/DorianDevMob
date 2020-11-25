package com.example.myapplication.modele;

import java.io.Serializable;

public class produit implements Serializable {
    private String titre;
    private int idCat;
    private String description;
    private String image;
    private int tarif;

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public produit(String titre, String desc, String img, int tarif, int idCat) {
        this.titre=titre;
        this.description=desc;
        this.image=img;
        this.tarif=tarif;
        this.idCat=idCat;

    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }
}
