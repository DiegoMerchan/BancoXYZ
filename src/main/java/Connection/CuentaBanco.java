package Connection;

import java.io.Serializable;

public class CuentaBanco implements Serializable {

    private int num;
    private double saldo;
    private int idCliente;
    private String Contrasena;

    public CuentaBanco(int num, double saldo, int idCliente, String Contrasena) {
        this.num = num;
        this.saldo = saldo;
        this.idCliente = idCliente;
        this.Contrasena = Contrasena;
    }

    public CuentaBanco() {
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
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
