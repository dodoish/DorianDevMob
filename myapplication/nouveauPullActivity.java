package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.myapplication.modele.produit;

public class nouveauPullActivity extends AppCompatActivity {

    private EditText titre;
    private EditText desc;
    private EditText prix;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_pull);
    }

    @Override
    public void onStart() {
        super.onStart();
        this.titre = this.findViewById(R.id.titre);
        this.desc = this.findViewById(R.id.desc);
        this.prix = this.findViewById(R.id.prix);

    }


    public void onClickAjout(View v) {

       if(this.titre.getText().length()!=0 || this.desc.getText().length()!=0 || this.prix.getText().toString().length()!=0){
            String titre=this.titre.getText().toString();
            String desc=this.desc.getText().toString();
            double prix=Double.parseDouble(this.prix.getText().toString());
           produit p=new produit(titre,desc,"pull1",prix,1);
        }
    }
}