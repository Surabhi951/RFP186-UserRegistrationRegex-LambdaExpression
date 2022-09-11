package com.bridgelabz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistrationRegex {

    public Validator firstName = (firstName) -> {
        Pattern pattern = Pattern.compile("^[A-Z]{1}[a-z]{3,}$");
        Matcher match = pattern.matcher(firstName);
        if (match.matches())
            return true;
        else
            throw new InvalidUserDetailsException("First name is Invalid" + firstName);

    };
    public Validator lastName = (lastName) -> {
        Pattern pattern = Pattern.compile("^[A-Z]{1}[a-z]{3,}$");
        Matcher match = pattern.matcher(lastName);
        if (match.matches())
            return true;
        else
            throw new InvalidUserDetailsException("Last name is InValid" +lastName);
    };

    public Validator email = (email) -> {
        Pattern pattern = Pattern.compile("^(?!.*@.*@)[a-z+_-]+(.[a-z0-9])*@[a-z0-9]+(.[a-z])*.[a-z]{2,}$");
        Matcher match = pattern.matcher(email);
        if (match.matches())
            return true;
        else
            throw new InvalidUserDetailsException("Email is InValid");
    };

    public Validator mobileNo = (mobileNo) -> {
        Pattern pattern = Pattern.compile("^[\\d]{2}\\s[\\d]{10}$");
        Matcher match = pattern.matcher(mobileNo);
        if (match.matches())
            return true;
        else
            throw new InvalidUserDetailsException("Mobile number is InValid");
    };

    public Validator passwordRule1 = (passwordRule1) -> {
        Pattern pattern = Pattern.compile("[0-9a-zA-Z@!+_.-]{8,}");
        Matcher match = pattern.matcher(passwordRule1);
        if (match.matches())
            return true;
        else
            throw new InvalidUserDetailsException("Password must have 8 character");
    };

    public Validator passwordRule2 = (passwordRule2) -> {
        Pattern pattern = Pattern.compile("(?=.*[A-Z])[0-9a-zA-Z@!+_.]{8,}");
        Matcher match = pattern.matcher(passwordRule2);
        if (match.matches())
            return true;
        else
            throw new InvalidUserDetailsException("Password must have atleast one uppercase letter");
    };

    public Validator passwordRule3 = (passwordRule3) -> {
        Pattern pattern = Pattern.compile("(?=.*[0-9])[0-9a-zA-Z@!+_.]{8,}");
        Matcher match = pattern.matcher(passwordRule3);
        if (match.matches())
            return true;
        else
            throw new InvalidUserDetailsException("Password must have atleast one numeric number");
    };

    public Validator passwordRule4 = (passwordRule4) -> {
        Pattern pattern = Pattern.compile("(?=.*[+._@!-])[0-9a-zA-Z@!+_.]{8,}");
        Matcher match = pattern.matcher(passwordRule4);
        if (match.matches())
            return true;
        else
            throw new InvalidUserDetailsException("Password must has exactly one special character");
    };
}
