/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloAutomoviles;

import TipoMotor.TipoMotor;
import TipoMotor.TipoMotor;


public abstract class Vehiculos {
    protected boolean solicitado;
    protected String marca;
    protected String modelo;
    protected String anio;
    protected TipoMotor tipo;
    protected double precio;

    public Vehiculos(String marca, String modelo, String anio, TipoMotor tipo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipo = tipo;
        this.precio=precio;
      
    }

    public boolean isSolicitado() {
        return solicitado;
    }

    public void setSolicitado(boolean solicitado) {
        this.solicitado = solicitado;
    }
    
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public TipoMotor getTipo() {
        return tipo;
    }

    public void setTipo(TipoMotor tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return  "marca=" + marca + ", modelo=" + modelo + ", anio=" + anio  ;
    }
    public abstract String toStringDetallado();
    //Muestra si el vehiculo ha sido solicitado o no 
    
}
