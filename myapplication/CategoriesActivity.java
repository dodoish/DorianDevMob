package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.myapplication.modele.CategorieAdapter;
import com.example.myapplication.modele.categorie;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity
    implements AdapterView.OnItemClickListener{
    private ArrayList<categorie> listeCategorie=new ArrayList<categorie>();
    private ListView lvCategorie;
    private RadioButton cbVente;
    private RadioButton cbCat;
    private TextView totalPanier;
    private double prixPanier=0;
    private static final int MAIN_VENTE=0;
    private static final int MAIN_CATALOGUE=1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        this.listeCategorie.add(new categorie(1,"pull","pull1"));
        this.listeCategorie.add(new categorie(2,"echarpe","echarpe"));
    }


    @Override
    public void onStart(){
        super.onStart();
        this.lvCategorie=this.findViewById(R.id.lvCat);
        ArrayAdapter<categorie> adaptateur=new CategorieAdapter(
                this,
                this.listeCategorie);
        this.lvCategorie.setAdapter(adaptateur);
        this.lvCategorie.setOnItemClickListener(this);
        this.cbVente=this.findViewById(R.id.rbVente);
        this.totalPanier=this.findViewById(R.id.TotalPanier);
        this.cbCat=this.findViewById(R.id.rbCatalogue);
        this.cbVente.setChecked(true);
        this.cbCat.setChecked(false);

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(resultCode==MainActivity.RETOUR){

            if(requestCode==MAIN_VENTE){
                this.prixPanier+=intent.getDoubleExtra("panier",0);
                this.UpdatePanier(this.getApplicationContext());
            }
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    Intent intent=new Intent(CategoriesActivity.this,MainActivity.class);
    intent.putExtra("idCateg",this.listeCategorie.get(position).getId());
    if(this.cbVente.isChecked()==true){
        intent.putExtra("Vente",MAIN_VENTE);
        startActivityForResult(intent,MAIN_VENTE);
    }
    else{
        intent.putExtra("Vente",MAIN_CATALOGUE);
        startActivityForResult(intent,MAIN_CATALOGUE);
    }

    }

    public void onClickVente(View v){
        this.cbCat.setChecked(false);
    }
    public void onClickCat(View v){
        this.cbVente.setChecked(false);
    }
    public void UpdatePanier(Context context){
        this.totalPanier.setText("le coût total du panier est "+this.prixPanier);
    }
}
