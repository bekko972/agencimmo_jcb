package com.example.utilisateur.agencimmojcb.objets;

/**
 * Created by Utilisateur on 09/03/2018.
 */

public class Maison {
    private String entite = "inconnu";
    private String nom = "inconnu";
    //private String statut = "inconnu";
    private String type = "inconnu";
    private String photo = "inconnu";
    private String lieu = "inconnu";
    private int superficie = 0;
    private int prix = 0;
    //private String description = "inconnu";

    public Maison()
    {
        System.out.println("Création d'une maison sans paramètres");
    }

    public Maison(String entite_maison, String nom_maison, String statut_maison,  String type_maison, String photo_maison, String lieu_maison, int superficie_maison, int prix_maison, String description_maison)
    {
        System.out.println("Création d'une maison avec paramètres");
        entite = entite_maison;
        nom = nom_maison;
        //statut = statut_maison;
        type = type_maison;
        photo = photo_maison;
        lieu = lieu_maison;
        superficie = superficie_maison;
        prix = prix_maison;
        //description = description_maison;
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

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
