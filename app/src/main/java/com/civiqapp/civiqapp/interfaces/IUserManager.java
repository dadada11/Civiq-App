package com.civiqapp.civiqapp.interfaces;

import com.google.firebase.auth.FirebaseUser;
import java.util.List;

/**
 * Created by keya on 7/27/2017.
 */

public interface IUserManager
{
    IUser createUser(FirebaseUser firebaseUser);
    IUser getUser(FirebaseUser firebaseUser);
    void deleteUser(FirebaseUser firebaseUser);
    // ^ deletes both firebaseuser user and iuser user
    List<IUser> getAllUsers();
    // ^ make iterable in the future
 }
