package com.example.utilisateur.agencimmojcb.activitys;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maisons);

        prenomAgent = (TextView) findViewById(R.id.tv_pseudo_vue3);
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
                String reponseVoirMaisons = voirMaisons.get("http://192.168.1.13:81/agenceimmo/mobile/mobile_maisons.php");
                System.out.println(reponseVoirMaisons);

                return reponseVoirMaisons;

            /*Gson g = new Gson();
            Maison maisonsALouer= g.fromJson(reponseVoirMaisons, Maison.class);
            System.out.println(maisonsALouer);*/

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
            //System.out.println(StringToJsonArray.)

            listeMaisons.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    NaviguerVueMaisons();
                }
            });


        }
    }



    //Conversion de la réponse serveur en JSON Array puis affichage dans un tableau
    public void StringToJsonArray02(String reponseServeur) {

        //Transformation de la réponse serveur en Objets JAVA
        Gson g = new Gson();
        Maison maisons[] = g.fromJson(reponseServeur, Maison[].class);

        //Copie des informations des classes en vue affichage
        ArrayList<Maison> newMaisons =  new ArrayList<Maison>();
        for(Maison m: maisons) {
            System.out.println(m);
            newMaisons.add(m);
        }

        MaisonAdapter itemsAdapter = new MaisonAdapter(this, newMaisons);

        // Attach the adapter to a ListView
        listeMaisons = (ListView) findViewById(R.id.lv_maisons);
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

        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i<jsonArray.length(); i++) {
            try {
                list.add( jsonArray.getString(i) );
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        //System.out.println(list);

        //Affichage d'une liste simple
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        // Attach the adapter to a ListView
        listeMaisons = (ListView) findViewById(R.id.lv_maisons);
        listeMaisons.setAdapter(itemsAdapter);
    }

    protected void NaviguerVueMaisons()
    {
        Intent intent = new Intent();
        intent.setClass(this, MaisonsDetailsActivity.class);
        intent.putExtra("prenom", agent.getPrenom());
        startActivity(intent);
    }
}
