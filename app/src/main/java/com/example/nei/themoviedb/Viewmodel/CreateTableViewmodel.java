package com.example.nei.themoviedb.Viewmodel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.nei.themoviedb.Model.CustomAdapter;
import com.example.nei.themoviedb.Model.Movie;
import com.example.nei.themoviedb.Model.Result;
import com.example.nei.themoviedb.Model.ResultSQLiteHelper;
import com.example.nei.themoviedb.R;

import java.util.ArrayList;
import java.util.List;

public class CreateTableViewmodel {
    ResultSQLiteHelper resultSQLiteHelper;
    SQLiteDatabase dbResultsT, dbResultsU, dbResultsP;
    ContentValues dataBD;
    List<Result> listP,listT,listU= new ArrayList<Result>();


    public CreateTableViewmodel() {
    }

    public void addItem(List<Result> results, String n, Context context) {

        resultSQLiteHelper = new ResultSQLiteHelper(
                context,
                "resultsBD",
                null,
                1);
        if (n == "popular") {
            dbResultsP = resultSQLiteHelper.getWritableDatabase();
            dataBD = new ContentValues();
            for (int i = 0; i < results.size(); i++) {
                dataBD.put("id", results.get(i).getId());
                dataBD.put("voteAverage", results.get(i).getVoteAverage());
                dataBD.put("title", results.get(i).getTitle());
                dataBD.put("overview", results.get(i).getOverview());
                dbResultsP.insert("resultsPopular", null, dataBD);
                dbResultsP.close();

            }

        } else if (n == "up") {
            dbResultsU = resultSQLiteHelper.getWritableDatabase();
            dataBD = new ContentValues();
            for (int i = 0; i < results.size(); i++) {
                dataBD.put("id", results.get(i).getId());
                dataBD.put("voteAverage", results.get(i).getVoteAverage());
                dataBD.put("title", results.get(i).getTitle());
                dataBD.put("overview", results.get(i).getOverview());
                dbResultsU.insert("resultsUp", null, dataBD);
                dbResultsU.close();

            }

        } else {
            dbResultsT = resultSQLiteHelper.getWritableDatabase();
            dataBD = new ContentValues();
            for (int i = 0; i < results.size(); i++) {
                dataBD.put("id", results.get(i).getId());
                dataBD.put("voteAverage", results.get(i).getVoteAverage());
                dataBD.put("title", results.get(i).getTitle());
                dataBD.put("overview", results.get(i).getOverview());
                dbResultsT.insert("resultsTop", null, dataBD);
                dbResultsT.close();

            }
        }


    }

    public void ListSQLite(Context context, String n) {

        resultSQLiteHelper = new ResultSQLiteHelper(
                context,
                "resultsBD",
                null,
                1);
        if (n == "popular") {
            Cursor c = dbResultsP.rawQuery(
                    "SELECT * FROM resultsPopular",
                    null);
            if(c.moveToFirst()){
                do{
                    Result resultP = new Result(
                            c.getInt(0),
                            c.getFloat(1),
                            c.getString(2),
                            c.getString(3));
                    listP.add(resultP);
                }while (c.moveToNext());
                //CustomAdapter.notifyDataSetChanged();
            } else{
                Toast.makeText(context,"No hay Peliculas",Toast.LENGTH_SHORT).show();
            }


        } else if (n == "up") {
            Cursor c = dbResultsP.rawQuery(
                    "SELECT * FROM resultsUp",
                    null);
            if(c.moveToFirst()){
                do{
                    Result resultU = new Result(
                            c.getInt(0),
                            c.getFloat(1),
                            c.getString(2),
                            c.getString(3));
                    listU.add(resultU);
                }while (c.moveToNext());
               // CustomAdapter.notifyDataSetChanged();
            } else{
                Toast.makeText(context,"No hay Peliculas",Toast.LENGTH_SHORT).show();
            }



        } else {
            Cursor c = dbResultsP.rawQuery(
                    "SELECT * FROM resultsTop",
                    null);
            if(c.moveToFirst()){
                do{
                    Result resultT = new Result(
                            c.getInt(0),
                            c.getFloat(1),
                            c.getString(2),
                            c.getString(3));
                    listT.add(resultT);
                }while (c.moveToNext());
                //CustomAdapter.notifyDataSetChanged();
            } else{
                Toast.makeText(context,"No hay Peliculas",Toast.LENGTH_SHORT).show();
            }


        }
    }
}



