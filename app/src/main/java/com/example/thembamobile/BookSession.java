package com.example.thembamobile;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.thembamobile.BusinessLayer.Appointments;
import com.example.thembamobile.databinding.FragmentBooksessionBinding;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BookSession extends Fragment {

    private FragmentBooksessionBinding binding;

    private EditText PatientNameInputField;
    private EditText PatientSurnameInputField;
    private EditText PatientIDInputField;
    private EditText SessionDateInputField;
    private EditText SessionTimeInputField;



    private Appointments AppointmentsProcessing;

    private ExecutorService HandleMyFunctions;

    private Handler ReportBackAboutMyFunctions;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View BookSessionFragment = inflater.inflate(R.layout.fragment_booksession, container,false);

        PatientNameInputField = BookSessionFragment.findViewById(R.id.PatientName);
        PatientSurnameInputField= BookSessionFragment.findViewById(R.id.PatientSurname);
        PatientIDInputField = BookSessionFragment.findViewById(R.id.PatientID);
        SessionDateInputField = BookSessionFragment.findViewById(R.id.SessionDate);
        SessionTimeInputField = BookSessionFragment.findViewById(R.id.SessionTime);

        AppointmentsProcessing = new Appointments();

        AddAppointment(BookSessionFragment);
        return BookSessionFragment;

    }

    public void AddAppointment(View view){

        ImageButton FinaliseSessionInputField = view.findViewById(R.id.FinaliseSession);
        FinaliseSessionInputField.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                HandleMyFunctions = Executors.newSingleThreadExecutor();
                ReportBackAboutMyFunctions = new Handler(Looper.getMainLooper());


                HandleMyFunctions.execute(() ->{
                    boolean b = PatientNameInputField.getText().toString().equals("") &&
                            PatientSurnameInputField.getText().toString().equals("") &&
                            PatientIDInputField.getText().toString().equals("") &&
                            SessionDateInputField.getText().toString().equals("") &&
                            SessionTimeInputField.getText().toString().equals("");

                    if (b) {

                    } else if (!b) {

                        AppointmentsProcessing.ConfigureAppointment(PatientNameInputField.getText().toString(),PatientSurnameInputField.getText().toString(),
                                PatientIDInputField.getText().toString(),SessionDateInputField.getText().toString(),SessionTimeInputField.getText().toString());
                    }

                    ReportBackAboutMyFunctions.post(() ->{

                        Log.d(TAG, "Appointment has been handed over successfully");
                    });

                });

            }
        });


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