package com.example.nei.themoviedb.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nei.themoviedb.Model.CustomAdapter;
import com.example.nei.themoviedb.Model.Movie;
import com.example.nei.themoviedb.Viewmodel.DataViewmodel;
import com.example.nei.themoviedb.Viewmodel.MyViewmodel;
import com.example.nei.themoviedb.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {
    private RecyclerView CustomRecyclerView;
    private CustomAdapter adapter;
    MyViewmodel model= new MyViewmodel();
    DataViewmodel dataViewmodel;



//    String ApiKey = "02e4b138dacaf8151088a361d6e75d01";
//    int page =1;

    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        CustomRecyclerView = view.findViewById(R.id.customRecyclerView);
         model.recyclerT(getContext(),CustomRecyclerView,getActivity(),adapter,1);;


                 //(getContext(),CustomRecyclerView,getActivity(),adapter);
         return view;
    }

}
