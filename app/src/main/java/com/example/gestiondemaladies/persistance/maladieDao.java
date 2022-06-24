package com.example.gestiondemaladies.persistance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by el ansari on 08/01/2017.
 */

public class maladieDao extends DaoBase {

    public maladieDao(Context context){

        super(context);

    }

    public long Ajouter (maladie m) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.MALADIE_NOM , m.getNom());
        values.put(DatabaseHandler.MALADIE_DESCRIPTION , m.getDescription());
        values.put(DatabaseHandler.MALADIE_CAUSES , m.getCauses());
        values.put(DatabaseHandler.MALADIE_SYMPTOMES , m.getSymptomes());
        values.put(DatabaseHandler.MALADIE_TRAITEMENT , m.getTraitement());

        long id =mbdd.insert(DatabaseHandler.MALADIE_TABLE, null, values);
        return id;

    }


    public List<maladie> Lister(){
        Cursor c = mbdd.rawQuery(" select * from " + DatabaseHandler.MALADIE_TABLE , null);
        List<maladie> listM = new ArrayList<>();
        c.moveToFirst();

        maladie maladie = null;
        if(c.getCount()>0) {
            if (c.moveToFirst()) {
                do {

                    maladie = new maladie();

                    maladie.setCode(c.getInt(0));
                    maladie.setNom(c.getString(1));
                    maladie.setDescription(c.getString(2));
                    maladie.setCauses(c.getString(3));
                    maladie.setSymptomes(c.getString(4));
                    maladie.setTraitement(c.getString(5));

                    listM.add(maladie);
                }while (c.moveToNext());
            }
        }

        return listM;

    }

    public maladie getMaladie(String nom){
        Cursor c = mbdd.rawQuery(" select * from " + DatabaseHandler.MALADIE_TABLE  + " where nom = ? ",
                new String[]{nom});

        c.moveToFirst();

        maladie maladie = null;

        if(c.getCount()>0) {
            maladie = new maladie();
            maladie.setCode(c.getInt(0));
            maladie.setNom(c.getString(1));
            maladie.setDescription(c.getString(2));
            maladie.setCauses(c.getString(3));
            maladie.setSymptomes(c.getString(4));
            maladie.setTraitement(c.getString(5));

        }


        return maladie;
    }
}


