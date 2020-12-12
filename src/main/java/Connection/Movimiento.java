
package Connection;

import java.io.Serializable;

public class Movimiento implements Serializable {
    
    private String fecha;
    private String concepto;
    private double valor;
    private int tipo;
    private int cuenta;
    private int idCliente;

    public Movimiento() {
    }

    public Movimiento(String fecha, String concepto, double valor, int tipo, int cuenta, int idCliente) {
        this.fecha = fecha;
        this.concepto = concepto;
        this.valor = valor;
        this.tipo = tipo;
        this.cuenta = cuenta;
        this.idCliente = idCliente;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the cuenta
     */
    public int getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
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
    
    
    
    
}
