package com.example.nei.themoviedb.Viewmodel;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.nei.themoviedb.Model.CustomAdapter;
import com.example.nei.themoviedb.Model.Movie;
import com.example.nei.themoviedb.Model.Result;
import com.example.nei.themoviedb.Model.ResultSQLiteHelper;
import com.example.nei.themoviedb.service.GetDataService;
import com.example.nei.themoviedb.service.RetrofitClientInstance;
import com.example.nei.themoviedb.view.ViewActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewmodel extends ViewModel {
    private Movie movie;
    private List<Result> array;
    //MyViewmodel model= new MyViewmodel();
    int page =1;
    private ResultSQLiteHelper resultSQLiteHelper;
    private SQLiteDatabase dbResult;




    public DataViewmodel() {
        this.array= new ArrayList<Result>();
        }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setArray(List<Result> array) {
        for(int i=0;i<array.size();i++) {
            this.array.add((Result) array.get(i));
        }

    }

    public List<Result> getArray() {
        return array;
    }

}
