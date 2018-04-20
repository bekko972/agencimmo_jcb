package com.example.utilisateur.agencimmojcb;

import android.os.AsyncTask;

import java.io.IOException;


/**
 * Created by Utilisateur on 01/04/2018.
 */

public class Connexion extends AsyncTask<Void, Integer, Void> {

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }

    @Override
        protected void onPreExecute() {
        super.onPreExecute();
        //Toast.makeText(this, "Début du traitement asynchrone", Toast.LENGTH_LONG).show();
    }

       /* @Override
        protected void onProgressUpdate(Integer... values){
        super.onProgressUpdate(values);
         Mise à jour de la ProgressBar
         mProgressBar.setProgress(values[0]);
    }*/

      /*  @Override
        protected String doInBackground(String... arg0) {

        try {
            GetRequete connexionBdd = new GetRequete();
            String reponseConnexionBdd = connexionBdd.get("http://192.168.235.1:81/agenceimmo/mobile/mobile_login.php");
            System.out.println(reponseConnexionBdd);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

        @Override
        protected void onPostExecute(Void result) {
        //Toast.makeText(getApplicationContext(), "Le traitement asynchrone est terminé", Toast.LENGTH_LONG).show();
    }*/
}
