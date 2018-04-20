package com.example.utilisateur.agencimmojcb.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.utilisateur.agencimmojcb.R;
import com.example.utilisateur.agencimmojcb.objets.Agent;

public class EspaceAgentsActivity extends AppCompatActivity {
    TextView prenomAgent;
    Button maisons;
    Agent agent = new Agent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.espace_agents);

        prenomAgent = (TextView) findViewById(R.id.tv_pseudo_vue2);
        AfficherPrenomAgent();

        maisons = (Button) findViewById(R.id.btn_maisons_vue2);
        maisons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NaviguerVueMaisons();
            }
        });


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

    protected void NaviguerVueMaisons()
    {
        Intent intent = new Intent();
        intent.setClass(this, MaisonsActivity.class);
        intent.putExtra("prenom", agent.getPrenom());
        startActivity(intent);
    }

}
