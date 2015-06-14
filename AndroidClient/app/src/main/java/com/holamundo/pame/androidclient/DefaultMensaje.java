package com.holamundo.pame.androidclient;


import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import net.sourceforge.jtds.jdbc.*;



/**
 * Created by Pame on 14/05/2015.
 */
public class DefaultMensaje {

    private String Servidor;
    private String Fecha;
    private String Cedula;
    private String Nombre;

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        this.Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getServidor() {
        return Servidor;
    }

    public void setServidor(String Servidor) {
        this.Servidor = Servidor;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public DefaultMensaje(String app, String cedula, String nombre) {
        this.Servidor = app;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        this.Fecha = dateFormat.format(cal.getTime());
        this.Cedula = cedula;
        this.Nombre = nombre;
    }

    public void insertMensaje(String DB_server) {
        try {

            String driver = "net.sourceforge.jtds.jdbc.Driver";

            String url = "jdbc:jtds:sqlserver://"+DB_server+";databaseName=BSO;user=BSO;password=321";

            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            Class.forName(driver).newInstance();

            Connection conn = DriverManager.getConnection(url);
            Statement st = conn.createStatement();
            String sql = "insertarMsj ?,?,?,?";
            PreparedStatement preparedStmt = conn.prepareStatement(sql);
            preparedStmt.setString(1, Servidor);
            preparedStmt.setString(2, Fecha);
            preparedStmt.setString(3, Cedula);
            preparedStmt.setString(4, Nombre);
            preparedStmt.execute();
            st.close();
            conn.close();
        } catch (SQLException sqle) {
            System.out.println("Sql exception " + sqle);
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DefaultMensaje.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }



    @Override
    public String toString() {
        return "Servidor: " + Servidor + "Fecha: " + Fecha + "Cedula: " + Cedula + " Nombre: " + Nombre;
    }
}
