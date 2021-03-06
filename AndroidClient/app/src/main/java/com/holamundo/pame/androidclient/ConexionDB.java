package com.holamundo.pame.androidclient;


import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;


/**
 * Created by Pame on 14/05/2015.
 */
public class ConexionDB {

    //private String host = "192.168.2.4";
    public int code = 0;
    private String host = "172.26.7.58";
    public void insertUser(String nom, String ape, String em, String contra) {

        final String nombre = nom;
        final String apellido = ape;
        final String email = em;
        final String contraseña = contra;


        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {

                    try {

                        String driver = "net.sourceforge.jtds.jdbc.Driver";

                        String url = "jdbc:jtds:sqlserver://"+host+";databaseName=BookEat;user=sa;password=12345";

                        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                        Class.forName(driver).newInstance();

                        Connection conn = DriverManager.getConnection(url);
                        Statement st = conn.createStatement();
                        String comando = "insert into UserAccount(Firstname, Lastname, Email, Password) values " +
                                "( '" +  nombre +"','" + apellido + "','" + email + "','" + contraseña + "')" ;
                        //String sql = "insert into UserAccount(Firstname,Lastname,Email,Password) values ('?','?','?','?')";
                        PreparedStatement preparedStmt = conn.prepareStatement(comando);
                        //preparedStmt.setString(1, nombre);
                        //preparedStmt.setString(2, apellido);
                        //preparedStmt.setString(3, email);
                        //preparedStmt.setString(4, contraseña);

                        preparedStmt.execute();

                        st.close();
                        conn.close();
                    } catch (SQLException sqle) {
                        System.out.println("Sql exception " + sqle);
                    }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }catch (Exception e){
                        e.printStackTrace();
                    }


                    //Your code goes here
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }


    public UserAccount loginUser(String em, String contra) {

        final String email = em;
        final String contraseña = contra;
        final UserAccount ua = new UserAccount(-1,"","", "", "");

        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {

                    try {
                        String driver = "net.sourceforge.jtds.jdbc.Driver";
                        String url = "jdbc:jtds:sqlserver://"+host+";databaseName=BookEat;user=sa;password=12345";

                        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                        Class.forName(driver).newInstance();

                        Connection conn = DriverManager.getConnection(url);
                        Statement st = conn.createStatement();
                        String comando = "select * from UserAccount where email='" +
                                 email+"'" ;
                        //String sql = "insert into UserAccount(Firstname,Lastname,Email,Password) values ('?','?','?','?')";
                        PreparedStatement preparedStmt = conn.prepareStatement(comando);
                        //preparedStmt.setString(1, nombre);
                        //preparedStmt.setString(2, apellido);
                        //preparedStmt.setString(3, email);
                        //preparedStmt.setString(4, contraseña);

                        ResultSet resultSet = preparedStmt.executeQuery();

                        while (resultSet.next()){
                            String firstName = resultSet.getString("Firstname");
                            String lastName = resultSet.getString("Lastname");
                            String email = resultSet.getString("Email");
                            String pass = resultSet.getString("Password");
                            int id = resultSet.getInt("UserAccountID");
                            ua.Email = email;
                            ua.Password = pass;
                            ua.FirstName = firstName;
                            ua.Lastname = lastName;
                            ua.UserAccountID = id;
                        }
                        st.close();
                        conn.close();
                    } catch (SQLException sqle) {
                        System.out.println("Sql exception " + sqle);
                    }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    //Your code goes here
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();
        while(thread.isAlive()){
            //System.out.println( "Thread de login vivo");
            try {
                new Thread().wait(500);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }catch (Exception e){
            }
        }
        return ua;

    }


    public ArrayList<UserAccount> booking(final int UserAccountID) {



        final ArrayList<UserAccount> listUA = new ArrayList<UserAccount>() ;
        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {

                    try {
                        String driver = "net.sourceforge.jtds.jdbc.Driver";
                        String url = "jdbc:jtds:sqlserver://"+host+";databaseName=BookEat;user=sa;password=12345";

                        //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
                        Class.forName(driver).newInstance();

                        Connection conn = DriverManager.getConnection(url);
                        Statement st = conn.createStatement();
                        String comando = "select b.Guests, b.BookingDate, b.ArrivalDate, b.SpecialRequests,r.Name " +
                                "from Booking b, Restaurant r where UserAccountID="+ UserAccountID+ " and b.RestaurantID = r.RestaurantID";

                        //String sql = "insert into UserAccount(Firstname,Lastname,Email,Password) values ('?','?','?','?')";
                        PreparedStatement preparedStmt = conn.prepareStatement(comando);
                        //preparedStmt.setString(1, nombre);
                        //preparedStmt.setString(2, apellido);
                        //preparedStmt.setString(3, email);
                        //preparedStmt.setString(4, contraseña);

                        ResultSet resultSet = preparedStmt.executeQuery();

                        while (resultSet.next()){
                            String firstName = resultSet.getString("Firstname");
                            String lastName = resultSet.getString("Lastname");
                            String email = resultSet.getString("Email");
                            String pass = resultSet.getString("Password");
                            int id = resultSet.getInt("UserAccountID");

                            UserAccount ua2=new UserAccount(id,firstName,lastName,email,pass);
                            listUA.add(ua2);


                        }


                        st.close();
                        conn.close();
                    } catch (SQLException sqle) {
                        System.out.println("Sql exception " + sqle);
                    }
                    catch (ClassNotFoundException ex) {
                        Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }catch (Exception e){
                        e.printStackTrace();
                    }


                    //Your code goes here
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });


        thread.start();

        while(thread.isAlive()){
            //System.out.println( "Thread de login vivo");
            try {
                new Thread().wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (Exception e){

            }
        }
        return listUA;

    }


    @Override
    public String toString() {
        return null;
        //return "Servidor: " + Servidor + "Fecha: " + Fecha + "Cedula: " + Cedula + " Nombre: " + Nombre;
    }
}
