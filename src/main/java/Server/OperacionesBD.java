/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class OperacionesBD {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; //
    static final String DB_URL = "jdbc:mysql://localhost:3306/Banco";
    static final String USER = "root";
    static final String PASS = "password_root";
    static Connection conn = null;
    static Statement stmt = null;
    static String SQL ="";
    
    //Método de conexión a la base de datos
    public static boolean conexion() {

        
        boolean conexion = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            conexion = true;
        } catch (Exception e) {
            e.printStackTrace();
            conexion = false;
        }
        return conexion;
    }

    public static void InsertarCliente(int IdCliente, String Nombre, String Apellido, String Fecha_nacimiento, String Genero, String Direccion, int Telefono, int Ciudad, String password) {

        if (!conexion()) {
            System.out.println("Error al conectar a la base de datos");
        } else {
            try {
                conn.setAutoCommit(false);
                SQL = "INSERT INTO Cliente VALUES (" + IdCliente + ", '" +
                       Nombre + "', '" +
                       Apellido + "', '" +
                       Fecha_nacimiento + "', '" +
                       Genero + "', '" + 
                       Direccion + "', " +
                       Telefono + "," + 
                       Ciudad + ", '" + 
                       password + "')";
                
                stmt.executeUpdate(SQL);  
                conn.commit();
                
            } catch (SQLException ex) {
                ex.getSQLState();
            }
        }

    }

}
