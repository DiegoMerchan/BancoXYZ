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
    static final String PASS = "root";
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
            System.out.println(e);
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
                System.out.println("Iniciando insercion de datos");
                SQL = "INSERT INTO Cliente VALUES (" + IdCliente + ", '" +
                       Nombre + "', '" +
                       Apellido + "', '" +
                       Fecha_nacimiento + "', '" +
                       Genero + "', '" + 
                       Direccion + "', " +
                       Telefono + "," + 
                       Ciudad + ", '" + 
                       password + "')";
                
                System.out.println("insercion terminada");
                stmt.executeUpdate(SQL);  
                conn.commit();
                
            } catch (SQLException ex) {
                System.out.println(ex.getSQLState());
            }
        }

    }
    
    public static boolean ValidarUsuario(int numeroCuenta, String Password){
        
        boolean usuario_valido = false;
        
        if (!conexion()) {
            System.out.println("Error al conectar a la base de datos");
        } else {
            try {
                SQL = "SELECT cliente.Nombre, cliente.Apellido, cuenta.Cliente_idCliente, cuenta.Num, cuenta.contrasena" +
                      "FROM Cuenta cuenta" +
                      "LEFT JOIN Cliente cliente ON cuenta.Cliente_idCliente = cliente.idCliente" +
                      "WHERE cuenta.Num = " + numeroCuenta +
                      "AND cuenta.contrasena = " + Password + ";";
            } catch (Exception e) {
            }
{
                
            }
        }
        
        
        return usuario_valido;
    }

}
