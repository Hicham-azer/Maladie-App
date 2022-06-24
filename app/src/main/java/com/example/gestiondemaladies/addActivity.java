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


public class addActivity extends AppCompatActivity {

    EditText nom = null;
    EditText desc = null;
    EditText causes = null;
    EditText symp = null;
    EditText trait = null;
    Button b = null;

    com.example.gestiondemaladies.persistance.maladie maladie =null;
    com.example.gestiondemaladies.persistance.maladieDao maladieDao = null;

    String tmp;
    final Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nom = (EditText)findViewById(R.id.nom);
        desc = (EditText)findViewById(R.id.desc);
        causes = (EditText)findViewById(R.id.causes);
        symp = (EditText)findViewById(R.id.symp);
        trait = (EditText)findViewById(R.id.trait);

        b=(Button)findViewById(R.id.add);

        /*
        AJOUTER UNE MALADIE
         */

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maladie = new maladie(nom.getText().toString(),desc.getText().toString(),causes.getText().toString(),symp.getText().toString(),trait.getText().toString());

                maladieDao = new maladieDao(getApplicationContext());

                maladieDao.Open();
                if(!nom.getText().toString().isEmpty() && !desc.getText().toString().isEmpty()
                        && !causes.getText().toString().isEmpty() && !symp.getText().toString().isEmpty() && !trait.getText().toString().isEmpty()) {

                    maladieDao.Ajouter(maladie);


                    tmp = "Malady added !!";

                    nom.setText("");
                    desc.setText("");
                   causes.setText("");
                    symp.setText("");
                    trait.setText("");
                }else
                    tmp = "Please fill in all fields !!";

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setTitle("Warning");
                alertDialogBuilder
                        .setMessage(tmp)
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


                    maladieDao.Close();

            }
        });

    }
}
