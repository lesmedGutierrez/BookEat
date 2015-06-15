package com.holamundo.pame.androidclient;


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;


/**
 * Created by Pame on 14/05/2015.
 */
public class ConexionDB {

    //private String host = "192.168.2.4";
    public int code = 0;
    private String host = "25.89.59.137";




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



    @Override
    public String toString() {
        return null;
        //return "Servidor: " + Servidor + "Fecha: " + Fecha + "Cedula: " + Cedula + " Nombre: " + Nombre;
    }
}
