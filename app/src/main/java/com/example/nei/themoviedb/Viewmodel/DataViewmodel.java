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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Movie getMovieList() {
        return movie;
    }

    public void setArray(List<Result> array) {
        for(int i=0;i<array.size();i++) {
            this.array.add((Result) array.get(i));
        }

    }

    public List<Result> getArray() {
        return array;
    }
    //    public void generate(final Context context,
//                         final RecyclerView CustomRecyclerView,
//                         final Activity activity,
//                         CustomAdapter adapter,
//                         final String n) {
//        //SQLite
//       // addSQLite(movie, n);
//
//        //View
//        Log.d("size",""+array.size());
//        adapter = new CustomAdapter(array,context);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
//        CustomRecyclerView.setLayoutManager(layoutManager);
//        CustomRecyclerView.setAdapter(adapter);
//        final CustomAdapter finalAdapter = adapter;
//        CustomRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//
//                if(!recyclerView.canScrollVertically(1)){
//                   String ApiKey="02e4b138dacaf8151088a361d6e75d01";
//                   page= page+1;
//
//
//                   if(n =="popular"){
//                        Log.d("number",""+page);
//                        model.recyclerP(context,CustomRecyclerView, activity, finalAdapter,page);
//
//                            }
//
//
//
//                    else if(n=="up"){
//                        model.recyclerU(context,CustomRecyclerView, activity, finalAdapter,page);
//
//                    }
//                    else{
//                        model.recyclerT(context,CustomRecyclerView, activity, finalAdapter,page);
//                    }
//                }
//            }
//        });
//        CustomRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//        });
//
//        adapter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(activity.getApplication(), ViewActivity.class);
//
//                Log.d("puntuacion", "" + movie.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getVoteAverage());
//
//                intent.putExtra("name", movie.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getTitle());
//                intent.putExtra("score", movie.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getVoteAverage().toString());
//                intent.putExtra("picture", movie.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getPosterPath());
//                intent.putExtra("overview", movie.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getOverview());
//                context.startActivity(intent);
//
//            }
//        });
//    }







//    public  void addSQLite(Movie movie, String n){
//        ResultSQLiteHelper resultSQLiteHelper;
//        SQLiteDatabase dbResult = null;
//        ContentValues dataBD = new ContentValues();
//
//        for(int i=0; i<movie.getResults().size();i++){
//
//            dataBD.put("id",movie.getResults().get(i).getId());
//            dataBD.put("voteAverage", movie.getResults().get(i).getVoteAverage());
//            dataBD.put("title", movie.getResults().get(i).getTitle());
//            dataBD.put("overview", movie.getResults().get(i).getOverview());
//            if(n=="popular"){
//                dataBD.put("category","poopular");
//            }else
//            if(n=="up"){
//                dataBD.put("category","upcoming");
//            }else{
//                dataBD.put("category","top");
//            }
//            dbResult.insert("results",null,dataBD);
//
//        }
//        Log.d("size","data"+dbResult.getMaximumSize());
//
//
//    }
}
