package com.example.gestiondemaladies.persistance;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by el ansari on 08/01/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {


    /**
     * Création de la table DOCTEUR
     */
    public static final String DOCTEUR_KEY="id";
    public static final String DOCTEUR_LOGIN="login";
    public static final String DOCTEUR_PASSWORD="password";


    public static final String DOCTEUR_TABLE="docteur";

    public final String CREATE_DOCTEUR_TABLE= " CREATE TABLE " + DOCTEUR_TABLE + " ( "
            + DOCTEUR_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DOCTEUR_LOGIN + " VARCHAR(255),  " +
            DOCTEUR_PASSWORD + " VARCHAR(255) );" ;

    /**
     * Création de la table MALADIE
     */
    public static final String MALADIE_KEY="code";
    public static final String MALADIE_NOM="nom";
    public static final String MALADIE_DESCRIPTION="description";
    public static final String MALADIE_CAUSES="causes";
    public static final String MALADIE_SYMPTOMES="symptomes";
    public static final String MALADIE_TRAITEMENT="traitement";


    public static final String MALADIE_TABLE="maladie";

    public final String CREATE_MALADIE_TABLE= " CREATE TABLE " + MALADIE_TABLE + " ( "
            + MALADIE_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MALADIE_NOM + " VARCHAR(255),  " +
            MALADIE_DESCRIPTION + " VARCHAR(1000), " + MALADIE_CAUSES + " VARCHAR(1000), " + MALADIE_SYMPTOMES + " VARCHAR(1000), " +
            MALADIE_TRAITEMENT + " VARCHAR(1000) );" ;

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_DOCTEUR_TABLE);
        db.execSQL(CREATE_MALADIE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

