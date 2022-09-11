package com.bridgelabz;

import java.util.Scanner;

public class UserRegistrationRegexMain {
    public static void main(String[] args) throws InvalidUserDetailsException {
        UserRegistrationRegex userRegistrationRegex = new UserRegistrationRegex();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first name");
        userRegistrationRegex.firstName.validate(sc.next());

        System.out.println("Enter last name");
        userRegistrationRegex.lastName.validate(sc.next());

        System.out.println("Enter email");
        userRegistrationRegex.email.validate(sc.next());

        System.out.println("Enter mobile number");
        sc.nextLine();
        userRegistrationRegex.mobileNo.validate(sc.nextLine());

        System.out.println("Enter password minimum 8 character");
        userRegistrationRegex.passwordRule1.validate(sc.next());

        System.out.println("Enter atleast one uppercase letter in password");
        userRegistrationRegex.passwordRule2.validate(sc.next());

        System.out.println("Enter atleast one numeric number in password");
        userRegistrationRegex.passwordRule3.validate(sc.next());

        System.out.println("Enter exactly one special character in password");
        userRegistrationRegex.passwordRule4.validate(sc.next());
    }
}
