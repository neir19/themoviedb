package com.example.nei.themoviedb.Viewmodel;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.nei.themoviedb.Model.CustomAdapter;
import com.example.nei.themoviedb.Model.Movie;
import com.example.nei.themoviedb.Model.Result;
import com.example.nei.themoviedb.service.GetDataService;
import com.example.nei.themoviedb.service.RetrofitClientInstance;
import com.example.nei.themoviedb.view.ViewActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewmodel extends ViewModel {

    DataViewmodel dataViewmodel = new DataViewmodel();
    CreateTableViewmodel table;
    int page = 1;


    public  void recyclerP(final Context context,
                          final RecyclerView CustomRecyclerView,
                          final Activity activity,
                          final CustomAdapter adapter,
                          int page) {
        String ApiKey = "02e4b138dacaf8151088a361d6e75d01";
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        retrofit2.Call call = service.getPopulaMovies(ApiKey, page);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call call, Response response) {
                dataViewmodel.setMovie((Movie) response.body());
                dataViewmodel.setArray((List<Result>) ((Movie) response.body()).getResults());
                generate(context, CustomRecyclerView, activity, adapter, "popular");
            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });

    }

    public void recyclerT(final Context context,
                          final RecyclerView CustomRecyclerView,
                          final Activity activity,
                          final CustomAdapter adapter,
                          int page) {
        String ApiKey = "02e4b138dacaf8151088a361d6e75d01";

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        retrofit2.Call call = service.getTopMovies(ApiKey, page);
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(retrofit2.Call call, Response response) {



                dataViewmodel.setMovie((Movie) response.body());
                dataViewmodel.setArray((List<Result>) ((Movie) response.body()).getResults());
                generate(context, CustomRecyclerView, activity, adapter, "top");

            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {
            }
        });
    }

    public void recyclerU(final Context context,
                          final RecyclerView CustomRecyclerView,
                          final Activity activity,
                          final CustomAdapter adapter,
                          int page) {
        String ApiKey = "02e4b138dacaf8151088a361d6e75d01";
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        retrofit2.Call call = service.getUpcomingMovies(ApiKey, page);

        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(retrofit2.Call call, Response response) {


                dataViewmodel.setMovie((Movie) response.body());
                dataViewmodel.setArray((List<Result>) ((Movie) response.body()).getResults());
                generate(context, CustomRecyclerView, activity, adapter, "up");

            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {

            }
        });
    }

    public void generate(final Context context,
                         final RecyclerView CustomRecyclerView,
                         final Activity activity,
                         CustomAdapter adapter,
                         final String n) {
        //SQLite
        //genera error
        //table.addItem(dataViewmodel.getArray(),n,context);

        //View
        Log.d("tam","size "+dataViewmodel.getArray().size());
        adapter = new CustomAdapter(dataViewmodel.getArray(), context);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        CustomRecyclerView.setLayoutManager(layoutManager);
        CustomRecyclerView.setAdapter(adapter);
        if(page>1) {
            CustomRecyclerView.getLayoutManager().scrollToPosition((page * 20) - 15);
        }
        final CustomAdapter finalAdapter = adapter;
        CustomRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (!recyclerView.canScrollVertically(1)) {
                    String ApiKey = "02e4b138dacaf8151088a361d6e75d01";
                    page = page + 1;


                    if (n == "popular") {
                        Log.d("number", "" + page);
                        recyclerP(context, CustomRecyclerView, activity, finalAdapter, page);

                    } else if (n == "up") {
                        recyclerU(context, CustomRecyclerView, activity, finalAdapter, page);

                    } else {
                        recyclerT(context, CustomRecyclerView, activity, finalAdapter, page);
                    }
                }
            }
        });
        CustomRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
        });

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity.getApplication(), ViewActivity.class);


                intent.putExtra("name", dataViewmodel.getArray().get(CustomRecyclerView.getChildAdapterPosition(v)).getTitle());
                intent.putExtra("score", dataViewmodel.getArray().get(CustomRecyclerView.getChildAdapterPosition(v)).getVoteAverage().toString());
                intent.putExtra("picture", dataViewmodel.getArray().get(CustomRecyclerView.getChildAdapterPosition(v)).getPosterPath());
                intent.putExtra("overview", dataViewmodel.getArray().get(CustomRecyclerView.getChildAdapterPosition(v)).getOverview());
                context.startActivity(intent);

            }
        });

    }
}
