package com.example.gestiondemaladies;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestiondemaladies.persistance.maladie;
import com.example.gestiondemaladies.persistance.maladieDao;

import java.util.List;



public class searchActivity extends AppCompatActivity {
    final Context context=this;
    EditText nom = null;
    Button search=null;

    com.example.gestiondemaladies.persistance.maladieDao maladieDao =null;
    com.example.gestiondemaladies.persistance.maladie maladie = null;

   public final String extra_nom="nom";
   public final String extra_desc="desc";
   public final String extra_causes="causes";
   public final String extra_symp="symp";
   public final String extra_trait="trait";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_search);



/*
Effectuer la recherche sur le nom de la maladie saisi
 */
        search =(Button)findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nom = (EditText) findViewById(R.id.nom);

                maladie = new maladie();
                maladieDao = new maladieDao(getApplicationContext());
                maladieDao.Open();

                maladie = maladieDao.getMaladie(nom.getText().toString());


                if (maladie == null) {

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                    alertDialogBuilder.setTitle("Warning");
                    alertDialogBuilder
                            .setMessage("No information for this malady !!!")
                            .setCancelable(false)
                            .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, just close
                                    // the dialog box and do nothing
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }else {
                    Intent i = new Intent(searchActivity.this, resultSActivity.class);
                    i.putExtra(extra_nom, maladie.getNom());
                    i.putExtra(extra_desc, maladie.getDescription());
                    i.putExtra(extra_causes, maladie.getCauses());
                    i.putExtra(extra_symp, maladie.getSymptomes());
                    i.putExtra(extra_trait, maladie.getTraitement());

                    startActivity(i);
                    maladieDao.Close();
                }
            }
        });

    }
}
