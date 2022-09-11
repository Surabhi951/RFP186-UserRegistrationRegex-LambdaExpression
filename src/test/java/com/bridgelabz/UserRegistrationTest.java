package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserRegistrationTest {
    static UserRegistrationRegex userRegistration;

    @BeforeAll
    public static void initialize() {
        userRegistration = new UserRegistrationRegex();
    }

    @Test
    public void givenFirstName_WhenValid_ShouldReturnsTrue() throws InvalidUserDetailsException {
        boolean result = userRegistration.firstName.validate("Surabhi");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenFirstName_WhenInValid_ShouldThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class, ()-> userRegistration.firstName.validate("surabhi"));
    }

    @Test
    public void givenLastName_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result = userRegistration.lastName.validate("Bhagat");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenLastName_WhenInValid_ShouldReturnThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class, ()-> userRegistration.firstName.validate("pq"));
    }

    @Test
    public void givenEmail_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.email.validate("xyz123@gmail.com");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenEmail_WhenInValid_ShouldReturnThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.email.validate("Xyz.co.in"));
    }

    @Test
    public void givenMobileNumber_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.mobileNo.validate("91 8695462369");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenMobileNumber_WhenInValid_ShouldReturnFalseThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.mobileNo.validate("8659421369"));
    }

    @Test
    public void givenPasswordRule1_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.passwordRule1.validate("abc@xyz123");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPasswordRule1_WhenInValid_ShouldReturnFalseThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.passwordRule1.validate("abc@123"));
    }

    @Test
    public void givenPasswordRule2_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.passwordRule2.validate("Abc@1234");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPasswordRule2_WhenInValid_ShouldReturnThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.passwordRule2.validate("abc@1234"));
    }

    @Test
    public void givenPasswordRule3_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.passwordRule3.validate("xyz@abc1.com");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPasswordRule3_WhenInValid_ShouldReturnFalseThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.passwordRule3.validate("xyz@abcd"));
    }

    @Test
    public void givenPasswordRule4_WhenValid_ShouldReturnTrue() throws InvalidUserDetailsException {
        boolean result=userRegistration.passwordRule4.validate("xyz@1234");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenPasswordRule4_WhenInValid_ShouldReturnFalseThrowsInvalidUserDetailsException() {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.passwordRule4.validate("xyz123ab"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc@yahoo.com" ,"abc-100@yahoo.com" ,"abc.100@yahoo.com" , "abc111@abc.com" ,"abc-100@abc.net" , "abc.100@abc.com.au" , "abc@1.com"})
    public void givenEmail_WhenValid_ShouldReturnTrue(String email) throws InvalidUserDetailsException {
        Assertions.assertTrue(userRegistration.email.validate(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc","abc@.com.my","abc123@gmail.a","abc123@.com","abc123@.com.com","abc()*@gmail.com","abc@%*.com","abc..2002@gmail.com","abc.@gmail.com","abc@abc@gmail.com",  "abc@gmail.com.1a"})
    public void givenEmail_WhenInValid_ShouldReturnThrowsInvalidUserDetailsException(String email) {
        Assertions.assertThrows(InvalidUserDetailsException.class,()->userRegistration.email.validate(email));
    }
}
