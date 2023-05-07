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
    private Button FindCounselorsButton;
    private Button BookSessionButton;

    private View HomeWindow;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {



        HomeWindow = inflater.inflate(R.layout.fragment_home, container, false);
        //binding = FragmentHomeBinding.inflate(inflater, container, false);

        //Initialize buttons
        //FindCounselorsButton = HomeWindow.findViewById(R.id.FindCounselorsButton);
        //BookSessionButton = HomeWindow.findViewById(R.id.BookSessionButton);

        //Add logic to buttons
        /*FindCounselorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Home.this)
                        .navigate(R.id.openCounselorSearch);
            }
        });

       BookSessionButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               NavHostFragment.findNavController(Home.this)
                       .navigate(R.id.OpenBookingSession);
           }
       });*/

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