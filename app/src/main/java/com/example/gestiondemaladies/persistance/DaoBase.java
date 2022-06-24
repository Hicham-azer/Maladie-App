package com.example.gestiondemaladies.persistance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by el ansari on 08/01/2017.
 */

public class DaoBase {

    private DatabaseHandler databaseHandler = null;
    private final int version = 1;
    private final String nomBDD="database.db";
    SQLiteDatabase mbdd = null;

    public DaoBase(Context context){

        databaseHandler = new DatabaseHandler(context, nomBDD, null, version);


    }

    public SQLiteDatabase Open(){

        mbdd=databaseHandler.getWritableDatabase();
        return mbdd;
    }


    public void Close(){

        mbdd.close();
    }

    public SQLiteDatabase getMbdd(){
        return mbdd;
    }
}




