package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.modele.CategorieAdapter;
import com.example.myapplication.modele.categorie;

import java.util.ArrayList;

public class CategoriesActivity extends AppCompatActivity
    implements AdapterView.OnItemClickListener{
    private ArrayList<categorie> listeCategorie=new ArrayList<categorie>();
    private ListView lvCategorie;



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
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}