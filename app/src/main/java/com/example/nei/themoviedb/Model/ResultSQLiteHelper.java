package com.example.nei.themoviedb.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.nei.themoviedb.Viewmodel.CreateTableViewmodel;

import java.util.List;

public class ResultSQLiteHelper extends SQLiteOpenHelper {

    String sqlCreateP= "CREATE TABLE resultsPopular ("+
            "id             INTEGER PRIMARY KEY AUTOINCREMENT, "+   //0
            "voteAverage    REAL, "+                                //1
            "title          STRING,"+                               //2
            "overview       STRING)";                               //3
    String sqlCreateT= "CREATE TABLE resultsTop ("+
            "id             INTEGER PRIMARY KEY AUTOINCREMENT, "+   //0
            "voteAverage    REAL, "+                                //1
            "title          STRING,"+                               //2
            "overview       STRING)";                               //3

    String sqlCreateU= "CREATE TABLE resultsUp ("+
            "id             INTEGER PRIMARY KEY AUTOINCREMENT, "+   //0
            "voteAverage    REAL, "+                                //1
            "title          STRING,"+                               //2
            "overview       STRING)";                               //3


    public ResultSQLiteHelper(Context context,
                              String name,
                              SQLiteDatabase.CursorFactory factory,
                              int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreateP);
        db.execSQL(sqlCreateU);
        db.execSQL(sqlCreateT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS resultsPopular");
    db.execSQL("DROP TABLE IF EXISTS resultsTop");
    db.execSQL("DROP TABLE IF EXISTS resultsUp");
    onCreate(db);
    }
}
