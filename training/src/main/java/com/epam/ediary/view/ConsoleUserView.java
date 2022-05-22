package com.epam.ediary.view;
import java.util.Scanner;
import com.epam.ediary.domain.Credentials;

public class ConsoleUserView implements UserView{

    public ConsoleUserView() {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }





    @Override
    public Credentials readCredentials() {
        Credentials credentials = new Credentials();
        Scanner scn = new Scanner(System.in);

        System.out.print("Login name:");
        credentials.setLoginName(scn.next());

        System.out.print("Password:");
        credentials.setPassword(scn.next());


        return credentials;
    }

    @Override
    public void printInvalidCredentials() {
        System.out.println("Login failed, invalid credentials");

    }
}
