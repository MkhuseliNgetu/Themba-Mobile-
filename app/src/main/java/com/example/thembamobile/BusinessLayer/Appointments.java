package com.example.thembamobile.BusinessLayer;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.example.thembamobile.DataAccessLayer.Mongo;

import org.bson.Document;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Appointments {

    public Document NewAppointment;
    private Date AppointmentDate;

    private String PatientPrefix;

    private DateFormat CombinedDateAndTime;


    public Document ConfigureAppointment(String PatientID, String PatientFirstName, String PatientLastName, String SessionDate, String SessionTime){

        PatientPrefix = "PT-";

        AppointmentDate = new Date();
        String DayAndTime = String.join("", SessionDate,SessionTime);

        CombinedDateAndTime = DateFormat.getDateInstance(DateFormat.FULL, Locale.UK);


        NewAppointment = new Document();
        NewAppointment.append("ID",PatientPrefix+PatientID);
        NewAppointment.append("Name",PatientFirstName);
        NewAppointment.append("Surname",PatientLastName);
        NewAppointment.append("DayAndTime",CombinedDateAndTime);

        SendAppointment(NewAppointment);

        return NewAppointment;
    }

    public void SendAppointment(Document NewAppointment){

        if (NewAppointment.isEmpty()) {

            Log.d(TAG, "Appointment was not configured properly. Please retry.");
        } else if (!(NewAppointment.isEmpty())) {

            Mongo MongoDB = new Mongo();

            MongoDB.AddAppointment(NewAppointment);
        }

    }
}
