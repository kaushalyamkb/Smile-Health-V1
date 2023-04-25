package com.example.smilehealthversionthree;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    TextInputLayout regAge, regUsername, regEmail, regPhone, regPassword;
    Button regBtn, regToLoginBtn;

    //fire data
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private Boolean validateAge(){
        String val = regAge.getEditText().getText().toString();
        if(val.isEmpty()){
            regAge.setError("Field cannot be empty");
            return false;
        }
        else{
            regAge.setError(null);
            regAge.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateUsername(){
        String val = regUsername.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if(val.isEmpty()){
            regUsername.setError("Field cannot be empty");
            return false;
        } else if (val.length()>=15) {
            regUsername.setError("UserName too long");
            return false;
        } else if (val.length()<=3) {
            regUsername.setError("UserName too short");
            return false;
        }
        else if (!val.matches(noWhiteSpace)) {
            regUsername.setError("White Spaces not allowed");
            return false;
        }
        else{
            regUsername.setError(null);
            regUsername.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateEmail() {
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            regEmail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Invalid email address");
            return false;
        } else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePhone(){
        String val = regPhone.getEditText().getText().toString();
        if(val.isEmpty()){
            regPhone.setError("Field cannot be empty");
            return false;
        }
        else if (val.length()>10) {
            regPhone.setError("Invalid Number type for Sri Lanka");
            return false;
        }
        else if (val.length()<10) {
            regPhone.setError("Invalid Number type for Sri Lanka");
            return false;
        }
        else{
            regPhone.setError(null);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val = regPassword.getEditText().getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";
        if (val.isEmpty()) {
            regPassword.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(passwordVal)) {
            regPassword.setError("Password is too weak");
            return false;
        } else {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //hook all the input values
        regAge = findViewById(R.id.reg_age);
        regUsername = findViewById(R.id.reg_username);
        regEmail = findViewById(R.id.reg_email);
        regPhone = findViewById(R.id.reg_phone);
        regPassword = findViewById(R.id.reg_password);
        regBtn = findViewById(R.id.reg_btn);
        regToLoginBtn = findViewById(R.id.reg_to_login);

        //save data on firebase onclick
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference( "users");
//
                //get all values

                String age = regAge.getEditText().getText().toString();
                String username = regUsername.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String phoneNo = regPhone.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();


                UserHelperClass helperClass = new UserHelperClass(age, username, email, phoneNo, password);

                reference.child(username).setValue(helperClass);
                if(!validateAge() |!validatePassword() | !validatePhone() | !validateEmail() | !validateUsername())
                {
                    return;
                }
                Intent intent = new Intent(SignUp.this, Login.class);
                startActivity(intent);
            }
        });
    }


//    public void registerUser(View view) {
//        if(!validateAge() | !validatePassword() | !validatePhone() | !validateEmail() | !validateUsername()){
//            return;
//        }
////                String age = regAge.getEditText().getText().toString();
////                String username = regUsername.getEditText().getText().toString();
////                String email = regEmail.getEditText().getText().toString();
////                String phoneNo = regPhone.getEditText().getText().toString();
////                String password = regPassword.getEditText().getText().toString();
////
////
////                UserHelperClass helperClass = new UserHelperClass(age, username, email, phoneNo, password);
////
////                reference.child(phoneNo).setValue(helperClass);
//    }
}
