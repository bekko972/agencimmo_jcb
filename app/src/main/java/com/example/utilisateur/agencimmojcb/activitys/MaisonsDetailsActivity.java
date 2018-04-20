package com.example.utilisateur.agencimmojcb.activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.utilisateur.agencimmojcb.R;
import com.example.utilisateur.agencimmojcb.objets.Agent;

public class MaisonsDetailsActivity extends AppCompatActivity {
    TextView prenomAgent;
    //ListView listeMaisons;
    Agent agent = new Agent();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maisons_details);

        prenomAgent = (TextView) findViewById(R.id.tv_pseudo_vue4);
        AfficherPrenomAgent();
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
}
