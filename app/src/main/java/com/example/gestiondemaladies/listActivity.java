package com.example.gestiondemaladies;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gestiondemaladies.persistance.maladie;
import com.example.gestiondemaladies.persistance.maladieDao;

import java.util.List;



public class listActivity extends AppCompatActivity {

    final Context context=this;

    public final String extra_nom="nom";
    public final String extra_desc="desc";
    public final String extra_causes="causes";
    public final String extra_symp="symp";
    public final String extra_trait="trait";

    com.example.gestiondemaladies.persistance.maladie maladie=null;
    com.example.gestiondemaladies.persistance.maladieDao maladieDao = null;
    ListView list = null;

    /*
    Lister les noms des maladies existantes
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        list = (ListView)findViewById(R.id.listview);

        maladieDao = new maladieDao(getApplicationContext());
        maladieDao.Open();

        List<maladie> listM = maladieDao.Lister();
        String list_maladies [] = new String[listM.size()];

        for (int i=0;i<listM.size();i++) {
            list_maladies[i]=listM.get(i).getNom();

        }

        ArrayAdapter<String> monAdapter = new ArrayAdapter<String>(this, R.layout.activity_simple_list_item,list_maladies);

        list.setAdapter(monAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                maladie = maladieDao.getMaladie(((TextView)view).getText().toString());

                Intent intent = new Intent(listActivity.this, resultSActivity.class);
                intent.putExtra(extra_nom, maladie.getNom());
                intent.putExtra(extra_desc, maladie.getDescription());
                intent.putExtra(extra_causes, maladie.getCauses());
                intent.putExtra(extra_symp, maladie.getSymptomes());
                intent.putExtra(extra_trait, maladie.getTraitement());

                startActivity(intent);


            }
        });


        }
    }

