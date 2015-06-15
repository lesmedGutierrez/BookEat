package com.holamundo.pame.androidclient;

/**
 * Created by Lesmed® on 15/06/2015.
 */
public class UserAccount {
    public int UserAccountID;
    public String FirstName;
    public String Lastname;
    public String Password;
    public String Email;

    public UserAccount(int id ,String fn, String ln, String em, String pass){
        this.UserAccountID = id;
        this.FirstName = fn;
        this.Lastname = ln;
        this.Email = em;
        this.Password = pass;



    }

}
