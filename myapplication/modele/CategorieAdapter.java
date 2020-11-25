package com.example.myapplication.modele;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;

public class CategorieAdapter extends ArrayAdapter<categorie> {
    private ArrayList<categorie> listeCategorie;

    public CategorieAdapter(Context context, ArrayList<categorie> liste){
        super(context,0,liste);
        this.listeCategorie=liste;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.item_list_categories,parent,false);

            TextView tv=convertView.findViewById(R.id.ilcTitre);
            tv.setText(this.listeCategorie.get(position).getTitre());

            ImageView img = convertView.findViewById(R.id.ilcVisuel);
            int id=getContext().getResources().getIdentifier(
                    this.listeCategorie.get(position).getVisuel(),
                    "drawable",
                    getContext().getPackageName());
            img.setImageResource(id);

        }
        return convertView;
    }
}
