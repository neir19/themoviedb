package com.example.nei.themoviedb.Viewmodel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.nei.themoviedb.Model.Movie;
import com.example.nei.themoviedb.Model.Result;
import com.example.nei.themoviedb.Model.ResultSQLiteHelper;

import java.util.List;

public class CreateTableViewmodel {
    private ResultSQLiteHelper resultSQLiteHelper;
    private SQLiteDatabase dbResults;
    private ContentValues dataBD;


    public CreateTableViewmodel(Context context) {
        resultSQLiteHelper = new ResultSQLiteHelper(
                context,
                "resultsBD",
                null,
                1);
        dbResults = resultSQLiteHelper.getWritableDatabase();
    }

    public  void addSQLite(List<Result> results, String n){
        ResultSQLiteHelper resultSQLiteHelper;
        SQLiteDatabase dbResult = null;
        ContentValues dataBD = new ContentValues();

        for(int i=0; i<results.size();i++) {
            boolean flag = true;
            Cursor c = dbResults.rawQuery(
                    "SELECT * FROM results  WHERE  nombre = '" + results.get(i).getTitle() + "' ",
                    null);
            if (c.moveToFirst()) {
               if( c.getString(4)==n){
                   flag= false;
               }

            } else {
                flag = true;
            }

            if (flag == true) {
                dataBD.put("id", results.get(i).getId());
                dataBD.put("voteAverage", results.get(i).getVoteAverage());
                dataBD.put("title", results.get(i).getTitle());
                dataBD.put("overview", results.get(i).getOverview());
                if (n == "popular") {
                    dataBD.put("category", "poopular");
                } else if (n == "up") {
                    dataBD.put("category", "upcoming");
                } else {
                    dataBD.put("category", "top");
                }
                dbResult.insert("results", null, dataBD);

            }

        }

    }

}
