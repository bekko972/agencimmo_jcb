package com.example.utilisateur.agencimmojcb.objets;

import java.util.ArrayList;

/**
 * Created by Utilisateur on 09/03/2018.
 */

public class Maison {
    protected String entite = "inconnu";
    protected String nom = "inconnu";
    protected String statut = "inconnu";
    protected String type = "inconnu";
    protected String photo = "inconnu";
    protected String lieu = "inconnu";
    protected int superficie = 0;
    protected int prix = 0;
    protected String description = "inconnu";


    private ArrayList<String> maisons;

   /* public Maison() {
        maisons = new ArrayList<String>();
    }*/



    public Maison()
    {
        System.out.println("Création d'une maison sans paramètres");
    }

    public Maison(String entite_maison, String nom_maison, String statut_maison,  String type_maison, String photo_maison, String lieu_maison, int superficie_maison, int prix_maison, String description_maison)
    {
        System.out.println("Création d'une maison avec paramètres");
        entite = entite_maison;
        nom = nom_maison;
        statut = statut_maison;
        type = type_maison;
        photo = photo_maison;
        lieu = lieu_maison;
        superficie = superficie_maison;
        prix = prix_maison;
        description = description_maison;
    }

    public String getEntite(){
        return entite;
    }

    public String getNom()
    {
        return nom;
    }

    public String getLieu()
    {
        return lieu;
    }

    public int getSuperficie()
    {
        return superficie;
    }

    public int getPrix()
    {
        return prix;
    }

    public String getPhoto()
    {
        return photo;
    }

    public String getType()
    {
        return type;
    }

    public String toString()
    {
        return "\t"+ type+ " "+ nom + " de type "+ type + " - superficie: " + superficie + "m² - prix: " + prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEntite(String entite) {
        this.entite = entite;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
