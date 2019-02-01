package com.example.nei.themoviedb;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nei.themoviedb.Model.CustomAdapter;
import com.example.nei.themoviedb.Model.Movie;
import com.example.nei.themoviedb.Model.Result;
import com.example.nei.themoviedb.service.GetDataService;
import com.example.nei.themoviedb.service.RetrofitClientInstance;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {
    private RecyclerView CustomRecyclerView;
    private CustomAdapter adapter;
    private Button bbackp, bnextp;
    private TextView tpagep;
    String ApiKey= "02e4b138dacaf8151088a361d6e75d01";
    int page =1;


    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_popular,container,false);
        CustomRecyclerView= view.findViewById(R.id.customRecyclerView);
        recyclerP(ApiKey, page);
        bbackp=view.findViewById(R.id.bbackp);
        bbackp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page>1){
                    page= page-1;
                    recyclerP(ApiKey,page);

                }
            }
        });
        tpagep= view.findViewById(R.id.tpagep);
        bnextp=view.findViewById(R.id.bnxtp);
        bnextp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page=page+1;
                recyclerP(ApiKey,page);
            }
        });
        return view;

    }
    private void recyclerP(String apiKey, int page) {
        GetDataService service= RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        retrofit2.Call call = service.getPopulaMovies(apiKey,page);
        Log.d("url..", ""+call.request().url().toString());
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(retrofit2.Call call, Response response) {
                generate((Movie) response.body());
            }

            @Override
            public void onFailure(retrofit2.Call call, Throwable t) {

            }
        });
    }


    private void generate(final Movie body) {


        adapter= new CustomAdapter(body.getResults(),getContext());

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
        CustomRecyclerView.setLayoutManager(layoutManager);
        CustomRecyclerView.setAdapter(adapter);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent( getActivity().getApplication(),ViewActivity.class );

                Log.d("puntuacion",""+body.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getVoteAverage());

                intent.putExtra("name",body.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getTitle());
                intent.putExtra("score",body.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getVoteAverage().toString());
                intent.putExtra("picture",body.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getPosterPath());
                intent.putExtra("overview",body.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getOverview());
                startActivity(intent);

            }
        });
        tpagep.setText(""+page);

    }

}
