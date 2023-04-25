package com.example.smilehealthversionthree;

public class UserHelperClass {
    String age, username, email, phoneNo, password;

    public UserHelperClass() {
    }

    public UserHelperClass(String age, String username, String email, String phoneNo, String password) {
        this.age = age;
        this.username = username;
        this.email = email;
        this.phoneNo = phoneNo;
        this.password = password;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
