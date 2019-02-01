package com.example.nei.themoviedb.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class ResultSQLiteHelper extends SQLiteOpenHelper {

    String sqlCreate= "CREATE TABLE results ("+
            "id             INTEGER PRIMARY KEY AUTOINCREMENT, "+
            " voteCount     STRING,"+
            "video          BOOLEAN,"+
            "voteCount      INTEGER,"+
            "voteAverage    FLOAT, "+
            "title          STRING,"+
            "popularity     FLOAT,"+
            //"posterPath    STRING,"+
            "originalLanguage STRING,"+
            "originalTitle   STRING,"+
            "genreIds     LIST<INTEGER>,"+
            //"backdropPath    STRING,"+
            "adult  BOOLEAN,"+
            "overview    STRING,"+
            "releaseDate     STRING)";

    public ResultSQLiteHelper(Context context,
                              String name,
                              SQLiteDatabase.CursorFactory factory,
                              int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS results");
    db.execSQL(sqlCreate);
    }
}
