package com.example.egdd.ui.fragments.listenfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.egdd.R;
import com.example.egdd.http.listenhttp.ListenBean;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {

    public TwoFragment(ListenBean listenBean) {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false);
    }
}
