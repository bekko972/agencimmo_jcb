package com.example.utilisateur.agencimmojcb.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.utilisateur.agencimmojcb.R;
import com.example.utilisateur.agencimmojcb.objets.Agent;
import com.example.utilisateur.agencimmojcb.objets.Maison;

public class MaisonsDetailsActivity extends AppCompatActivity {
    TextView prenomAgent;
    TextView nomMaison;
    TextView entiteMaison;
    TextView lieuMaison;
    TextView superficieMaison;
    TextView typeMaison;
    TextView prixMaison;

    //ListView listeMaisons;
    Agent agent = new Agent();
    Maison maison = new Maison();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maisons_details);

        prenomAgent = (TextView) findViewById(R.id.tv_pseudo_vue4);
        nomMaison = (TextView) findViewById(R.id.tv_nomMaison_vue4);
        entiteMaison = (TextView) findViewById(R.id.tv_entiteMaison_vue4);

        AfficherPrenomAgent();
        AfficherMaisonSelectionnee();
    }

    protected void AfficherPrenomAgent()
    {
        Intent intent = getIntent();
        if(intent!=null)
        {
            Bundle extras = intent.getExtras();
            if(extras!=null)
            {
                String prenom = extras.getString("prenom");
                if(prenom!=null)
                {
                    prenomAgent.setText(String.format("%s",prenom));
                    agent.setPrenom(prenomAgent.getText().toString());
                }
            }
        }
    }

    protected void AfficherMaisonSelectionnee()
    {

        Intent intent = getIntent();
        if(intent!=null)
        {
            Bundle extras = intent.getExtras();
            if(extras!=null)
            {
                String entite = extras.getString("entite");
                if(entite!=null)
                {
                    entiteMaison.setText(String.format("%s",entite));
                    maison.setNom(entiteMaison.getText().toString());
                }

                String nom = extras.getString("nom");
                if(nom!=null)
                {
                    nomMaison.setText(String.format("%s",nom));
                    maison.setNom(nomMaison.getText().toString());
                }

                /*String lieu = extras.getString("lieu");
                if(lieu!=null)
                {
                    lieuMaison.setText(String.format("%s",lieu));
                    maison.setLieu(lieuMaison.getText().toString());
                }

                String superficie = extras.getString("superficie");
                if(superficie!=null)
                {
                    superficieMaison.setText(String.format("%s",superficie));
                    maison.setSuperficie(Integer.parseInt(superficieMaison.getText().toString()));
                }

                String type = extras.getString("type");
                if(type!=null)
                {
                    typeMaison.setText(String.format("%s",type));
                    maison.setType(typeMaison.getText().toString());
                }

                String prix = extras.getString("prix");
                if(prix!=null)
                {
                    prixMaison.setText(String.format("%s",prix));
                    maison.setPrix(Integer.parseInt(prixMaison.getText().toString()));
                }*/
            }
        }
    }
}
