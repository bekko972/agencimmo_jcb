package com.example.utilisateur.agencimmojcb.objets;

/**
 * Created by Utilisateur on 09/03/2018.
 */

public class Agent {
    protected String nom = "inconnu";
    protected String prenom = "inconnu";
    protected String login = "inconnu";
    protected String pwd = "inconnu";

    //Constructeur de la classe Agent sans paramètres
    public Agent()
    {
        System.out.println("Création d'un agent sans paramètres");
    }

    //Constructeur de la classe agent avec des paramètres
    public Agent(String nom_agent, String prenom_agent, String login_agent, String pwd_agent)
    {
        System.out.println("Création d'un agent avec paramètres");
        nom = nom_agent;
        prenom = prenom_agent;
        login = login_agent;
        pwd = pwd_agent;
    }

    //Retourne le prénom de l'agent
    public String getPrenom()
    {
        return prenom;
    }

    //Retourne le login de l'agent
    public String getLogin()
    {
        return login;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPrenom(String prenom_agent)
    {
        prenom = prenom_agent;
    }

    public void setLogin(String login_agent)
    {
        login = login_agent;
    }

    public void setPwd(String pwd_agent)
    {
        pwd = pwd_agent;
    }

    public String toString()
    {
        return "\t Agent "+ prenom + " "+ nom;
    }


}
