package com.example.utilisateur.agencimmojcb.activitys;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.utilisateur.agencimmojcb.R;
import com.example.utilisateur.agencimmojcb.agencimmojcb972;
import com.example.utilisateur.agencimmojcb.objets.Agent;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.Objects;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends Activity {
    EditText login = null;
    EditText pwd = null;
    String prenomAgent;
    Button valider = null;

    Agent agent = new Agent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.ed_pseudo_vue1); //identification du login
        pwd = findViewById(R.id.ed_password);   //identification du mot de passe
        valider = findViewById(R.id.btn_valider);  //identification du bouton
        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View valider) {
                if (login.length() == 0 || pwd.length() == 0) {
                    Toast.makeText(agencimmojcb972.getAppContext(), "Vous devez renseigner tous les champs !", Toast.LENGTH_LONG).show();
                }
                else {
                    String chaine1 = login.getText().toString();     //récupération du login
                    String chaine2 = pwd.getText().toString();     //récupération du mot de passe

                    new AuthentificationAgents(chaine1,chaine2).execute();
                    //System.out.println(retourAuthentification);
                }
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    public class AuthentificationAgents extends AsyncTask<String, String, String> {

        OkHttpClient client = new OkHttpClient();

        private String user;
        private String password;

        private AuthentificationAgents(String user, String password) {
            this.user = user;
            this.password = password;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(agencimmojcb972.getAppContext(), "Connexion en cours", Toast.LENGTH_SHORT).show();
        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        protected String doInBackground(String... params) {
            RequestBody formBody = new FormBody.Builder()
                    .add("userid", String.valueOf(user))
                    .add("password", String.valueOf(password))
                    .build();

            Request request = new Request.Builder()     //Envoi requête de connexion au serveur PHP
                    .url("http://192.168.21.69:81/agenceimmo/mobile/mobile_login.php")
                    .post(formBody)
                    .build();

            Response response;
            try {
                response = client.newCall(request).execute();
                if (!response.isSuccessful())
                    throw new IOException("Unexpected code " + response);
                String jsonInString = null;//Réponse Serveur
                if (response.body() != null) {
                    jsonInString = Objects.requireNonNull(response.body()).string();
                }
                System.out.println(jsonInString);

                return jsonInString;

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String reponseServeur) {
            //Toast.makeText(agencimmojcb972.getAppContext(), "Le traitement asynchrone est terminé", Toast.LENGTH_SHORT).show();
            System.out.println(reponseServeur);
            String codeErreur = StringToJson(reponseServeur);
            VerifAuthentification(codeErreur);
        }
    }

    public String StringToJson(String reponseServeur) {
        //Conversion de la réponse serveur en JSON
        JsonObject objet = new JsonParser().parse(reponseServeur).getAsJsonObject();

        //Récupération du code d'erreur et du prénom
        String codeErreur = objet.get("error").getAsString();
        prenomAgent = objet.get("prenom").getAsString();

        agent.setPrenom(prenomAgent);

        System.out.println(codeErreur);

        return codeErreur;
    }

    //Action à faire pour chaque code d'erreur
    public void VerifAuthentification(String codeErreur) {
        switch (codeErreur) {
            case "utilisateur inconnu": {
                Toast.makeText(agencimmojcb972.getAppContext(), "Utilisateur inconnu", Toast.LENGTH_LONG).show();
                break;
            }

            case "mot de passe incorrect": {
                Toast.makeText(agencimmojcb972.getAppContext(), "Mot de passe incorrect", Toast.LENGTH_LONG).show();
                break;
            }

            case "connexion ok": {
                NaviguerVue2();
                break;
            }
        }
    }

    protected void NaviguerVue2()
    {
        Intent intent = new Intent();
        intent.setClass(this, EspaceAgentsActivity.class);
        intent.putExtra("prenom", agent.getPrenom());
        startActivity(intent);
    }
}




