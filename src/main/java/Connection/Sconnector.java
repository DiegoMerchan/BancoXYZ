package Connection;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Sconnector {

    private final int PUERTO = 5000; //Puerto para la conexión del socket
    private final String HOST = "localhost"; //Host local para la comunicacion
    protected String mensajeServidor; //Mensajes entrantes en el servidor
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected DataOutputStream DatoSalidaServidor, DatoSalidaCliente; //Flujo de datos de salida
    protected ObjectOutputStream salidaServidor, salidaCliente; //Flujo de Objetos de salida
    protected ObjectInputStream entradaServidor, entradaCliente; //Flujo objetos de entreda

    public Sconnector(String tipo) throws IOException //Constructor con if si vamos a crear cliente o servidos
    {
        if (tipo.equalsIgnoreCase("servidor")) {
            ss = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
            cs = new Socket(); //Socket para el cliente
        } else {
            cs = new Socket(HOST, PUERTO); //Socket para el cliente en localhost en puerto 1234
        }
    }

}
