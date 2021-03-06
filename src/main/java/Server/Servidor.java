package Server;

import Connection.ClienteBanco;
import Connection.CuentaBanco;
import Connection.Movimiento;
import Connection.SaldoCliente;
import Connection.Sconnector;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Servidor extends Sconnector {

    ClienteBanco nuevoCliente;
    CuentaBanco nuevaCuenta;
    String tipo;
    Movimiento consignacion, retiro;
    SaldoCliente saldo;

    public Servidor() throws IOException {
        super("servidor"); // iniciamos una instancia de Socket tipo servidor
    }

    public void startServer() throws ClassNotFoundException { // Con este metodo iniciamos el server

        try {
            System.out.println("Esperando conexión en puerto " + ss.getLocalPort()); //Esperando conexión
            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente
            entradaCliente = new ObjectInputStream(cs.getInputStream()); // inicializamos socket
            salidaCliente = new ObjectOutputStream(cs.getOutputStream());
            System.out.println("Cliente en línea");
            tipo = (String) entradaCliente.readObject();
            if ("crearCliente".equals(tipo)) {
                System.out.println("Ejecutando crear cliente...\n");
                crearCliente();
            }
            if ("crearCuenta".equals(tipo)) {
                System.out.println("Ejecutando crear nueva cuenta...\n");
                crearCuenta();
            }

            if ("consignar".equals(tipo)) {
                System.out.println("Ejecutando consignacion...\n");
                consignacion();
            }
            
             if ("retirar".equals(tipo)) {
                System.out.println("Ejecutando retiro...\n");
                retiro();
            }
            if ("saldo".equals(tipo)) {
                System.out.println("Ejecutando consulta de saldo...\n");
                saldo();
            }
             

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //Método para la creación del cliente
    private void crearCliente() throws ClassNotFoundException {

        try {

            nuevoCliente = (ClienteBanco) entradaCliente.readObject();
            System.out.println("Recibido en el servidor un nuevo cliente: " + nuevoCliente.getNombre());
            OperacionesBD.InsertarCliente(nuevoCliente, salidaCliente);
            close();
            System.out.println("Fin de la conexión");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //Método para crear cuenta 
    private void crearCuenta() throws ClassNotFoundException {

        try {

            nuevaCuenta = (CuentaBanco) entradaCliente.readObject();
            System.out.println("Recibido en el servidor una nueva cuenta: " + nuevaCuenta.getNum());
            OperacionesBD.InsertarCuenta(nuevaCuenta, salidaCliente);
            close();
            System.out.println("Fin de la conexión");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    //Método para realizar consignación
    private void consignacion() throws ClassNotFoundException {

        try {

            consignacion = (Movimiento) entradaCliente.readObject();
            System.out.println("Recibido en el servidor una consignacion para :" + consignacion.getCuenta());
            OperacionesBD.consignar(consignacion, salidaCliente);
            close();
            System.out.println("Fin de la conexión");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    
       //Método para realizar retiro
       private void retiro() throws ClassNotFoundException {

        try {

            retiro = (Movimiento) entradaCliente.readObject();
            System.out.println("Recibido en el servidor un retiro de :" + retiro.getIdCliente());
            OperacionesBD.retirar(retiro, salidaCliente);
            close();
            System.out.println("Fin de la conexión");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
       
       
    //Metodo para consultar el saldo
    private void saldo() throws ClassNotFoundException {

        try {

            saldo = (SaldoCliente) entradaCliente.readObject();
            System.out.println("Recibido en el servidor una consulta de saldo: " + saldo.getIdCliente());
            OperacionesBD.saldo(saldo, salidaCliente);
            close();
            System.out.println("Fin de la conexión");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    private void close() {

        try {
            ss.close();//Se finaliza la conexión con el cliente
            entradaCliente.close();
            cs.close();
            salidaCliente.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
