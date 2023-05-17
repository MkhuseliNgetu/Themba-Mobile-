package com.example.thembamobile.DataAccessLayer;

import static android.content.ContentValues.TAG;

import android.app.AlertDialog;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Locale;

public class Mongo {

    private String ConnectionToMongoDB;
    private AlertDialog FailedToStartMessage;

    private String SetupDatabase(){

        ConnectionToMongoDB = "mongodb+srv://MNgetu:JkkdNX3hVyE9erMI@cluster0.vwavmzr.mongodb.net/?retryWrites=true&w=majority";

        return ConnectionToMongoDB;
    }

    public void AddAppointment(Document NewAppointment){

        SetupDatabase();

        try(MongoClient ClientToDatabase = MongoClients.create(ConnectionToMongoDB)){
            MongoDatabase ThembaDB = ClientToDatabase.getDatabase("test");
            MongoCollection<Document> Appointments = ThembaDB.getCollection("appointments");



           Appointments.insertOne(NewAppointment);


            if (Appointments.insertOne(NewAppointment).wasAcknowledged()) {

                Log.d(TAG, "Appointment was added successfully");
            } else if (!(Appointments.insertOne(NewAppointment).wasAcknowledged())) {
                Log.d(TAG, "Booking Failed: Appointment already exists");
            }




        }catch(Exception FailedToStartDatabase){


        }
    }
}
