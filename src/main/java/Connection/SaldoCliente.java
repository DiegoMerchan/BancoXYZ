package Connection;

import java.io.Serializable;


public class SaldoCliente implements Serializable{
    
    private int numeroCuenta;
    private int idCliente;
    private String Contrasena;

    public SaldoCliente(int numeroCuenta, int idCliente, String Contrasena) {
        this.numeroCuenta = numeroCuenta;
        this.idCliente = idCliente;
        this.Contrasena = Contrasena;
    }

    public SaldoCliente() {
    }

    /**
     * @return the numeroCuenta
     */
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return the idCliente
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * @param idCliente the idCliente to set
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * @return the Contrasena
     */
    public String getContrasena() {
        return Contrasena;
    }

    /**
     * @param Contrasena the Contrasena to set
     */
    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
    
    
}
