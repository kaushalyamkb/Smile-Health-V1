package com.example.smilehealthversionthree;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;

public class UserProfile extends AppCompatActivity {
    TextInputLayout age, email, phoneNo, password;
    TextView username, fullname;
    private Button updateuser, printuser;

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        updateuser = (Button) findViewById(R.id.update_profile);
        updateuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEror();
            }
        });
        printuser = (Button) findViewById(R.id.pdfdwn);
        printuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openEror();
            }
        });

        age = findViewById(R.id.age_profile);
        email = findViewById(R.id.email_profile);
        phoneNo = findViewById(R.id.phone_no_profile);
        password = findViewById(R.id.password_profile);
//        username = findViewById(R.id.username_profile);

        showAllUserData();

        //usernameLabel = findViewById(R.id.username_field);
        bottomNavigationView = findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.acc);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.notify:
                        startActivity(new Intent(getApplicationContext(),Notification_loggedin.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.homebtmnav:
                        startActivity(new Intent(getApplicationContext(),HomeLoggedin.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.acc:
                        return true;
                }
                return false;
            }
        });
    }



    private void showAllUserData() {
        Intent intent = getIntent();
        String user_username = intent.getStringExtra("username");
        String user_age = intent.getStringExtra("age");
        String user_email = intent.getStringExtra("email");
        String user_phoneNo = intent.getStringExtra("phoneNo");
        String user_password = intent.getStringExtra("password");

        //fullNameLabel.setText(user_name);

//        username.setText(user_username);
        age.getEditText().setText(user_age);
        email.getEditText().setText(user_email);
        phoneNo.getEditText().setText(user_phoneNo);
        password.getEditText().setText(user_password);

       // email.setText(String.valueOf(user_email));
        

//        age = findViewById(R.id.age_profile);

//        email = findViewById(R.id.email_profile);
//        phoneNo = findViewById(R.id.phone_no_profile);
//        password = findViewById(R.id.password_profile);
//        fullname = findViewById(R.id.fullname);

        //usernameLabel = findViewById(R.id.username_field);


    }

   public void openEror(){
        Intent intent = new Intent(this, ViewError.class);
        startActivity(intent);
   }


}