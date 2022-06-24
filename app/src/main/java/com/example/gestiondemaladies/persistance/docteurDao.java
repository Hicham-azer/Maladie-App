package com.example.gestiondemaladies.persistance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by el ansari on 08/01/2017.
 */

public class docteurDao extends DaoBase {

    public docteurDao(Context context){

        super(context);

    }


    public long Ajouter (docteur d) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHandler.DOCTEUR_LOGIN , d.getLogin());
        values.put(DatabaseHandler.DOCTEUR_PASSWORD , d.getPassword());


        long id =mbdd.insert(DatabaseHandler.DOCTEUR_TABLE, null, values);
        return id;

    }

    public List<docteur> Lister(){
        Cursor c = mbdd.rawQuery(" select * from " + DatabaseHandler.DOCTEUR_TABLE , null);
        List<docteur> listM = new ArrayList<>();
        c.moveToFirst();

        docteur doc = null;
        if(c.getCount()>0) {
            while (!c.isAfterLast()) {

                doc = new docteur();
                doc.setId(c.getInt(0));
                doc.setLogin(c.getString(1));
                doc.setPassword(c.getString(2));


                listM.add(doc);
                c.moveToNext();
            }
        }

        return listM;
    }

}
