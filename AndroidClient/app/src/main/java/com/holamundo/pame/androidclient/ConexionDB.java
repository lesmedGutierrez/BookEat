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

    private String host = "192.168.2.4";



    public void insertUser(String nombre, String apellido, String email, String contraseña) {
        try {

            String driver = "net.sourceforge.jtds.jdbc.Driver";

            String url = "jdbc:jtds:sqlserver://"+host+";databaseName=BSO;user=BSO;password=321";

            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            Class.forName(driver).newInstance();

            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            String comando = "insert into UserAccount values" + nombre + apellido+ email+ contraseña;
            /*String sql = "insertarMsj ?,?,?,?";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, Servidor);
            preparedStmt.setString(2, Fecha);
            preparedStmt.setString(3, Cedula);
            preparedStmt.setString(4, Nombre);

            preparedStmt.execute();*/

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
        }
    }



    @Override
    public String toString() {
        //return "Servidor: " + Servidor + "Fecha: " + Fecha + "Cedula: " + Cedula + " Nombre: " + Nombre;
    }
}
