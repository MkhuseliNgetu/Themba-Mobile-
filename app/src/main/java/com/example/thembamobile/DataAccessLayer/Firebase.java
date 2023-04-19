package com.example.thembamobile.DataAccessLayer;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase {

    private FirebaseDatabase ThembaDB;
    private DatabaseReference ConnectionToThembaDB;

    public void SetupCloudDB(){

    ThembaDB = FirebaseDatabase.getInstance();
    ConnectionToThembaDB = ThembaDB.getReference("Appoinmeent");
    }
}
