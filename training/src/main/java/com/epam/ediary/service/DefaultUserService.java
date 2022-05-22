package com.epam.ediary.service;

import com.epam.ediary.domain.*;
import com.epam.ediary.presistence.DataStore;

import java.util.List;
import java.util.Objects;


public class DefaultUserService implements UserService{

   final private DataStore dataStore;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public DefaultUserService(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public User authenticate(Credentials credentials) throws AuthenticationException {
        List<Teacher> teachers = dataStore.getTeachers();
        List<Student> students = dataStore.getStudents();


        boolean matchFound = false;

        for (Teacher u:teachers) {


            if(Objects.equals(credentials.getPassword(), u.getCredentials().getPassword()) &&
                    Objects.equals(credentials.getLoginName(), u.getCredentials().getLoginName())){

                matchFound=true;
               return u;


            }

        }


            for (Student u : students ) {
                if(Objects.equals(credentials.getPassword(), u.getCredentials().getPassword()) &&
                        Objects.equals(credentials.getLoginName(), u.getCredentials().getLoginName())){

                    matchFound=true;
                    return u;


                }
            }


        if (!matchFound){
            throw new AuthenticationException();
        }

        return new User();
    }
}
