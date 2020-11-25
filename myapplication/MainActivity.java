package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.modele.produit;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int noPull;
    private Button bPrecedent;
    private Button bSuivant;
    private TextView petitDesc;
    private TextView grandeDesc;
    private TextView prix;
    private ImageView imgPull;
    private ImageView imgZoom;
    private ImageButton panier;
    private ArrayList<produit> modele = new ArrayList<produit>();
    private Boolean zoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            this.noPull = savedInstanceState.getInt("noPull");
            this.modele = (ArrayList<produit>) savedInstanceState.getSerializable("liste");
            this.zoom = savedInstanceState.getBoolean("zoom");

        } else {
            modele.add(new produit("a noel c\'est moi qui tien les rennes", "un pull qui ravira les petits et les grands.tricoté par de vrai grand mére", "pull1", 17,1));
            modele.add(new produit("test2", "2eci est un test", "pull1", 15,1));
            this.zoom = false;
            noPull = 0;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("noPull", this.noPull);
        outState.putSerializable("liste", this.modele);
        outState.putBoolean("zoom", this.zoom);
    }


    @Override
    public void onStart() {
        super.onStart();
        this.bPrecedent = this.findViewById(R.id.btnGauche);
        this.petitDesc = this.findViewById(R.id.petiteDesc);
        this.bPrecedent = this.findViewById(R.id.btnGauche);
        this.bSuivant = this.findViewById(R.id.btnDroit);
        this.imgPull = this.findViewById(R.id.imgPull);
        this.imgZoom=this.findViewById(R.id.imgZoom);
        this.grandeDesc = this.findViewById(R.id.grandeDesc);
        this.prix = this.findViewById(R.id.prix);
        this.panier = this.findViewById(R.id.imgpanier);
        changement(this.getApplicationContext());
    }

    public void changement(Context context) {
        if (noPull == 0) {
            this.bPrecedent.setClickable(false);
        } else this.bPrecedent.setClickable(true);

        if (noPull == this.modele.size() - 1) {
            this.bSuivant.setClickable(false);
        } else this.bSuivant.setClickable(true);

        if(this.zoom==false){
            this.imgPull.setVisibility(View.VISIBLE);
            this.imgZoom.setVisibility(View.INVISIBLE);
        }
        else{
            this.imgZoom.setVisibility(View.VISIBLE);
            this.imgPull.setVisibility(View.INVISIBLE);
        }

        int img = context.getResources().getIdentifier(
                this.modele.get(noPull).getImage(),
                "drawable",
                context.getPackageName());
        this.imgPull.setImageResource(img);
        this.imgZoom.setImageResource(img);
        this.petitDesc.setText(this.modele.get(noPull).getTitre());
        this.grandeDesc.setText(this.modele.get(noPull).getDescription());
        this.prix.setText(String.valueOf(this.modele.get(noPull).getTarif()));
    }


    public void onClickPrecedent(View v) {
        noPull--;
        this.changement(v.getContext());

    }

    public void onClickSuivant(View v) {
        noPull++;
        this.changement(v.getContext());
    }

    public void onClickPanier(View v) {

        Toast.makeText(this, String.format(getString(noPull,R.string.ajoutPanier)), Toast.LENGTH_LONG).show();
    }

    public void onClickZoom(View v) {
        this.zoom=true;
        this.changement(v.getContext());
    }
    public void onClickDezoom(View v) {
        this.zoom=false;
        this.changement(v.getContext());
    }
}

