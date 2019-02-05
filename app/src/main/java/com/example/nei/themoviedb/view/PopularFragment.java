package com.example.nei.themoviedb.view;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ProgressBar;

import com.example.nei.themoviedb.BuildConfig;
import com.example.nei.themoviedb.Model.CustomAdapter;
import com.example.nei.themoviedb.Model.Movie;
import com.example.nei.themoviedb.PaginationAdapter;
import com.example.nei.themoviedb.Model.Result;

import com.example.nei.themoviedb.R;
import com.example.nei.themoviedb.Viewmodel.MyViewmodel;
import com.example.nei.themoviedb.service.GetDataService;
import com.example.nei.themoviedb.service.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PopularFragment extends Fragment {
    private RecyclerView CustomRecyclerView;
    private CustomAdapter adapter;
    int page = 1;
    ProgressBar progressBar;
    MyViewmodel model= new MyViewmodel();




    public PopularFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_popular, container, false);
        CustomRecyclerView = view.findViewById(R.id.customRecyclerView);
        progressBar = view.findViewById(R.id.progress);
        model.recyclerP(getContext(),CustomRecyclerView,getActivity(),adapter,1);





        return view;

    }


}




























        //        adapter = new PaginationAdapter(getContext());
//        linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
//        rv.setLayoutManager(linearLayoutManager);
//
//        rv.setItemAnimator(new DefaultItemAnimator());
//
//        rv.setAdapter(adapter);
//
//        rv.addOnScrollListener(new PaginationScrollListener(linearLayoutManager) {
//            @Override
//            protected void loadMoreItems() {
//                isLoading = true;
//                currentPage += 1;
//
//                // mocking network delay for API call
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        loadNextPage();
//                    }
//                }, 1000);
//            }
//
//            @Override
//            public int getTotalPageCount() {
//                return TOTAL_PAGES;
//            }
//
//            @Override
//            public boolean isLastPage() {
//                return isLastPage;
//            }
//
//            @Override
//            public boolean isLoading() {
//                return isLoading;
//            }
//        });
//
//        //init service and load data
//        movieService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
//
//        loadFirstPage();
//        return view;
//    }
//
//
//    private void loadFirstPage() {
//        callTopRatedMoviesApi().enqueue(new Callback<Movie>() {
//            @Override
//            public void onResponse(Call<Movie> call, Response<Movie> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<Movie> call, Throwable t) {
//
//            }
//        });
//
//
//
//    }
//
//    /**
//     * @param response extracts List<{@link Movie>} from response
//     * @return
//     */
//    private List<Result> fetchResults(Response<Movie> response) {
//        Movie topRatedMovies = response.body();
//        return topRatedMovies.getResults();
//    }
//
//    private void loadNextPage() {
//
//
//        callTopRatedMoviesApi().enqueue(new Callback<Movie>() {
//            @Override
//            public void onResponse(Call<Movie> call, Response<Movie> response) {
//                adapter.removeLoadingFooter();
//                isLoading = false;
//
//                List<Result> results = fetchResults(response);
//                adapter.addAll(results);
//
//                if (currentPage != TOTAL_PAGES) adapter.addLoadingFooter();
//                else isLastPage = true;
//            }
//
//            @Override
//            public void onFailure(Call<Movie> call, Throwable t) {
//                t.printStackTrace();
//                // TODO: 08/11/16 handle failure
//            }
//        });
//    }
//
//
//    /**
//     * Performs a Retrofit call to the top rated movies API.
//     * Same API call for Pagination.
//     * As {@link #currentPage} will be incremented automatically
//     * by @{@link PaginationScrollListener} to load next page.
//     */
//    private Call<Movie> callTopRatedMoviesApi() {
//        return movieService.getPopulaMovies(
//                BuildConfig.APPLICATION_ID,
//                currentPage
//        );
//    }


        //        CustomRecyclerView= view.findViewById(R.id.customRecyclerView);
//        movie= viewmodel.recyclerP();
//        adapter= new CustomAdapter(movie.getResults(),getContext());
//
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
//        CustomRecyclerView.setLayoutManager(layoutManager);
//        CustomRecyclerView.setAdapter(adapter);


//    private void generate(final Movie body) {
//
//
//        adapter= new CustomAdapter(body.getResults(),getContext());
//
//        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
//        CustomRecyclerView.setLayoutManager(layoutManager);
//        CustomRecyclerView.setAdapter(adapter);
//
//
//
//        adapter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent( getActivity().getApplication(),ViewActivity.class );
//
//                Log.d("puntuacion",""+body.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getVoteAverage());
//
//                intent.putExtra("name",body.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getTitle());
//                intent.putExtra("score",body.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getVoteAverage().toString());
//                intent.putExtra("picture",body.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getPosterPath());
//                intent.putExtra("overview",body.getResults().get(CustomRecyclerView.getChildAdapterPosition(v)).getOverview());
//                startActivity(intent);
//
//            }
//        });

