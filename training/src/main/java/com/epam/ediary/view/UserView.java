package com.epam.ediary.view;

import com.epam.ediary.domain.Credentials;

public interface UserView {


    public Credentials readCredentials();
    public void printInvalidCredentials();

}
