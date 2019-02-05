package com.example.nei.themoviedb.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nei.themoviedb.Model.CustomAdapter;
import com.example.nei.themoviedb.Viewmodel.MyViewmodel;
import com.example.nei.themoviedb.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class UpcomingFragment extends Fragment {
    private RecyclerView CustomRecyclerView;
    private CustomAdapter adapter;
    MyViewmodel model=new MyViewmodel();




    public UpcomingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upcoming, container, false);
        CustomRecyclerView = view.findViewById(R.id.customRecyclerView);
        model.recyclerU(getContext(),CustomRecyclerView,getActivity(),adapter,1);


        return view;
    }
}


