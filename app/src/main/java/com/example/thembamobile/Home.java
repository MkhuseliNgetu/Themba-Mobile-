package com.example.thembamobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.thembamobile.databinding.FragmentHomeBinding;


public class Home extends Fragment {

    private FragmentHomeBinding binding;



    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        //Creating Fragment
        View HomeWindow = inflater.inflate(R.layout.fragment_home, container, false);


        //binding = FragmentHomeBinding.inflate(inflater, container, false);

        return HomeWindow;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}