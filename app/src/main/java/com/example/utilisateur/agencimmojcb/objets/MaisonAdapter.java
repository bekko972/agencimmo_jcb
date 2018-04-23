package com.example.utilisateur.agencimmojcb.objets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.utilisateur.agencimmojcb.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Utilisateur on 17/04/2018.
 */

public class MaisonAdapter extends ArrayAdapter<Maison> {
    public MaisonAdapter(Context context, ArrayList<Maison> immeubles) {
        super(context, 0, immeubles);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Maison maison = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_maisons, parent, false);
        }
        // Lookup view for data population
        ImageView imgMaison = convertView.findViewById(R.id.img_maisons);
        TextView tvEntite = convertView.findViewById(R.id.tvEntite);
        TextView tvType = convertView.findViewById(R.id.tvType);
        TextView tvLieu = convertView.findViewById(R.id.tvLieu);
        TextView tvPrix = convertView.findViewById(R.id.tvPrix);

        // Populate the data into the template view using the data object
        assert maison != null;
        String url_photo = getContext().getString(R.string.url_maisons, maison.getPhoto());
        Picasso.with(getContext()).load(url_photo).into(imgMaison);
        tvEntite.setText(maison.getEntite());
        tvType.setText(maison.getType());
        tvLieu.setText(maison.getLieu());
        String prix_str = String.valueOf(maison.getPrix());
        tvPrix.setText((getContext()).getString(R.string.prix_maisons, prix_str));
        // Return the completed view to render on screen
        return convertView;
    }
}
