package com.spedison.course.service;

public class ValidationPassword {

    public boolean isValidPassword(String user, String password){
        if(user.equals("edison") && password.equals("123"))
            return true;
        return false;
    }

}
