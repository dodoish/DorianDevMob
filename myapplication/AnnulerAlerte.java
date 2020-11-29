package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;



public class AnnulerAlerte extends DialogFragment {
    public static final int RETOUR = 0;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Activity activite= getActivity();

        AlertDialog.Builder builder;

        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP) {

            builder=new AlertDialog.Builder(activite,android.R.style.Theme_Material_Dialog_Alert);
        }else {
            builder = new AlertDialog.Builder(activite);
        }

        builder.setMessage(R.string.confirm_phrase).setTitle(R.string.confirm_titre);

       //DialogInterface.OnClickListener ecouteur= (DialogInterface.OnClickListener) activite;

        builder.setPositiveButton(R.string.confirm_oui,new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent=new Intent();
                activite.setResult(RETOUR,intent);
                activite.finish();
            }
        });
        builder.setNegativeButton(R.string.confirm_non,null);

        return builder.create();

    }

}
