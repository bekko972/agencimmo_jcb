package com.example.utilisateur.agencimmojcb.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.utilisateur.agencimmojcb.R;
import com.example.utilisateur.agencimmojcb.objets.Agent;
import com.example.utilisateur.agencimmojcb.objets.Maison;
import com.squareup.picasso.Picasso;

public class MaisonsDetailsActivity extends AppCompatActivity {
    TextView prenomAgent;
    TextView nomMaison;
    TextView entiteMaison;
    TextView lieuMaison;
    TextView superficieMaison;
    TextView typeMaison;
    TextView prixMaison;
    ImageView photoMaison;

    //ListView listeMaisons;
    Agent agent = new Agent();
    Maison maison = new Maison();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maisons_details);

        prenomAgent = findViewById(R.id.tv_pseudo_vue4);
        nomMaison = findViewById(R.id.tv_nomMaison_vue4);
        entiteMaison = findViewById(R.id.tv_entiteMaison_vue4);
        lieuMaison = findViewById(R.id.tv_lieuMaison_vue4);
        typeMaison = findViewById(R.id.tv_typeMaison_vue4);
        superficieMaison = findViewById(R.id.tv_superficieMaison_vue4);
        prixMaison = findViewById(R.id.tv_prixMaison_vue4);
        photoMaison = findViewById(R.id.img_photoMaison);

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

                String lieu = extras.getString("lieu");
                if(lieu!=null)
                {
                    lieuMaison.setText(String.format("%s",lieu));
                    maison.setLieu(lieuMaison.getText().toString());
                }

                int superficie = extras.getInt("superficie");
                String str_superficie = (String.valueOf(superficie));
                superficieMaison.setText(this.getString(R.string.superficie, str_superficie));
                maison.setSuperficie(superficie);

                String type = extras.getString("type");
                if(type!=null)
                {
                    typeMaison.setText(String.format("%s",type));
                    maison.setType(typeMaison.getText().toString());
                }

                int prix = extras.getInt("prix");
                String str_prix = (String.valueOf(prix));
                prixMaison.setText(this.getString(R.string.prix_maisons, str_prix));
                maison.setPrix(prix);

                String photo = extras.getString("photo");
                if (type != null) {
                    String url_photo = "http://192.168.21.69:81/agenceimmo/" + photo;
                    //System.out.println(url_photo);
                    Picasso.with(this).load(url_photo).into(photoMaison);
                    //photoMaison.setImageURI(Uri.parse(url_photo));
                    maison.setType(url_photo);
                }
            }
        }
    }
}
