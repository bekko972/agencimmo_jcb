package com.example.utilisateur.agencimmojcb.activitys;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.utilisateur.agencimmojcb.GetRequete;
import com.example.utilisateur.agencimmojcb.R;
import com.example.utilisateur.agencimmojcb.agencimmojcb972;
import com.example.utilisateur.agencimmojcb.objets.Agent;
import com.example.utilisateur.agencimmojcb.objets.Maison;
import com.example.utilisateur.agencimmojcb.objets.MaisonAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class MaisonsActivity extends AppCompatActivity {
    TextView prenomAgent;
    ListView listeMaisons;
    Agent agent = new Agent();
    Maison maisons[] = new Maison[0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maisons);

        prenomAgent = findViewById(R.id.tv_pseudo_vue3);
        AfficherPrenomAgent();

        new AfficherMaisons().execute();
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

    //Conversion de la réponse serveur en JSON Array puis affichage dans un tableau
    public void StringToJsonArray02(String reponseServeur) {

        //Transformation de la réponse serveur en Objets JAVA
        Gson g = new Gson();
        maisons = g.fromJson(reponseServeur, Maison[].class);

        //System.out.println(maisons[2].getNom());

        //Copie des informations des classes en vue affichage
        ArrayList<Maison> newMaisons = new ArrayList<>();
        for(Maison m: maisons) {
            System.out.println(m);
            newMaisons.add(m);
        }

        MaisonAdapter itemsAdapter = new MaisonAdapter(this, newMaisons);

        // Attach the adapter to a ListView
        listeMaisons = findViewById(R.id.lv_maisons);
        listeMaisons.setAdapter(itemsAdapter);
    }

    //Conversion de la réponse serveur en JSON Array puis affichage dans un tableau en mode simple
    public void StringToJsonArray(String reponseServeur) {

        JsonParser jsonParser = new JsonParser();
        JsonArray arrayFromString = jsonParser.parse(reponseServeur).getAsJsonArray();
        //System.out.println(arrayFromString.toString());

        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(arrayFromString.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayList<String> list = new ArrayList<>();
        assert jsonArray != null;
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                list.add( jsonArray.getString(i) );
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(list);

        //Affichage d'une liste simple
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);

        // Attach the adapter to a ListView
        listeMaisons = findViewById(R.id.lv_maisons);
        listeMaisons.setAdapter(itemsAdapter);
    }

    @SuppressLint("StaticFieldLeak")
    public class AfficherMaisons extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(agencimmojcb972.getAppContext(), "Début du traitement asynchrone", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... arg0) {

            try {
                GetRequete voirMaisons = new GetRequete();
                String reponseVoirMaisons = voirMaisons.get("http://192.168.21.69:81/agenceimmo/mobile/mobile_maisons.php");
                System.out.println(reponseVoirMaisons);

                return reponseVoirMaisons;

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            //Toast.makeText(agencimmojcb972.getAppContext(), "Le traitement asynchrone est terminé", Toast.LENGTH_SHORT).show();
            //StringToJsonArray(result);
            StringToJsonArray02(result);

            //Gestion de la maison sélectionnée
            listeMaisons.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    //Object maisonChoisie = parent.getItemAtPosition(position);

                    NaviguerVueMaisons(position);
                }
            });
        }
    }

    protected void NaviguerVueMaisons(int maison_selectionnee)
    {
        Intent intent = new Intent();
        System.out.println(maisons[maison_selectionnee].getNom());
        intent.setClass(this, MaisonsDetailsActivity.class);
        intent.putExtra("prenom", agent.getPrenom());
        intent.putExtra("entite", maisons[maison_selectionnee].getEntite());
        intent.putExtra("nom", maisons[maison_selectionnee].getNom());
        intent.putExtra("lieu", maisons[maison_selectionnee].getLieu());
        intent.putExtra("superficie", maisons[maison_selectionnee].getSuperficie());
        intent.putExtra("photo", maisons[maison_selectionnee].getPhoto());
        intent.putExtra("type", maisons[maison_selectionnee].getType());
        intent.putExtra("prix", maisons[maison_selectionnee].getPrix());
        startActivity(intent);
    }
}
