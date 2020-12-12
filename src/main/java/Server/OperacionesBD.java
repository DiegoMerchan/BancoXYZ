/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Connection.ClienteBanco;
import Connection.CuentaBanco;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

    public static void InsertarCliente(ClienteBanco n, ObjectOutputStream s) throws IOException {

        if (!conexion()) {
            System.out.println("Error al conectar a la base de datos");
        } else {
            try {
                conn.setAutoCommit(false);
                System.out.println("Iniciando insercion de datos");
                SQL = "INSERT INTO Cliente VALUES (" +
                       n.getIdCliente() + ", '" +
                       n.getNombre() + "', '" +
                       n.getApellido() + "', '" +
                       n.getFecha_nacimiento() + "', '" +
                       n.getGenero() + "', '" + 
                       n.getDireccion() + "', " +
                       n.getTelefono() + "," + 
                       n.getCiudad() + ");";
                
               
                stmt.executeUpdate(SQL);  
                conn.commit();
                System.out.println("CLIENTE GUARDADO CON EXITO");
                s.writeObject("msn desde el servidor: Cliente creado con exito");
                
                
                
            } catch (SQLException ex) {
                try {
                    System.out.println(ex.getMessage());
                    System.out.println("ERROR LOS DATOS NO SE GUARDARON");
                    s.writeObject("msn desde el servidor: Error, el cliente no se creo");
                    conn.rollback();
                    
                } catch (SQLException ex1) {
                    Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
            }finally{
                 System.out.println("Transaccion terminada");
            }
        }   

    }
    
    public static void InsertarCuenta(CuentaBanco n, ObjectOutputStream s) throws IOException {

        if (!conexion()) {
            System.out.println("Error al conectar a la base de datos");
        } else {
            try {
                conn.setAutoCommit(false);
                System.out.println("Iniciando insercion de datos");
                SQL = "INSERT INTO cuenta VALUES(" +
                        n.getNum()+","+
                        n.getSaldo()+","+
                        n.getIdCliente()+",'"+
                        n.getContrasena()+"')";
                stmt.executeUpdate(SQL);  
                conn.commit();
                System.out.println("CUENTA CREADA CON EXITO");
                s.writeObject("msn desde el servidor: Cuenta creada con exito");
   
            } catch (SQLException ex) {
                try {
                    System.out.println(ex.getMessage());
                    System.out.println("ERROR LOS DATOS NO SE GUARDARON");
                    s.writeObject("msn desde el servidor: Error, la cuenta no se creo");
                    conn.rollback();
                    
                } catch (SQLException ex1) {
                    Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex1);
                }
                
            }finally{
                 System.out.println("Transaccion terminada");
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
