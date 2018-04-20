package com.example.utilisateur.agencimmojcb.objets;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.utilisateur.agencimmojcb.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Utilisateur on 17/04/2018.
 */

public class MaisonAdapter extends ArrayAdapter<Maison> {
    public MaisonAdapter(Context context, ArrayList<Maison> immeubles) {
        super(context, 0, immeubles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Maison maison = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_maisons, parent, false);
        }
        // Lookup view for data population
        TextView tvEntite = (TextView) convertView.findViewById(R.id.tvEntite);
        TextView tvType = (TextView) convertView.findViewById(R.id.tvType);
        TextView tvLieu = (TextView) convertView.findViewById(R.id.tvLieu);
        TextView tvPrix = (TextView) convertView.findViewById(R.id.tvPrix);
        // Populate the data into the template view using the data object
        tvEntite.setText(maison.getEntite());
        tvType.setText(maison.getType());
        tvLieu.setText(maison.getLieu());

        String prix_str = String.valueOf(maison.getPrix());
        tvPrix.setText(prix_str + "€");
        // Return the completed view to render on screen
        return convertView;
    }
}
