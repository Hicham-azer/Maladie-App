package com.example.gestiondemaladies;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.widget.EditText;
import android.widget.TextView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class resultSActivity extends AppCompatActivity {

    TextView name = null;
    TextView desc = null;
    TextView causes = null;
    TextView symp = null;
    TextView trait = null;

    final String extra_nom = "nom";
    final String extra_desc = "desc";
    final String extra_causes = "causes";
    final String extra_symp = "symp";
    final String extra_trait = "trait";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_s);

        name = (TextView) findViewById(R.id.nom);
        desc = (TextView) findViewById(R.id.desc);
        causes = (TextView) findViewById(R.id.causes);
        symp = (TextView) findViewById(R.id.symp);
        trait = (TextView) findViewById(R.id.trait);


        // Afficher les informations d'une maladie dont le nom est saisi par le docteur

        Intent intent = getIntent();


        if (intent != null) {

            name.setText(intent.getStringExtra(extra_nom));
            desc.setText(intent.getStringExtra(extra_desc));
            causes.setText(intent.getStringExtra(extra_causes));
            symp.setText(intent.getStringExtra(extra_symp));
            trait.setText(intent.getStringExtra(extra_trait));

        }

    }
}
