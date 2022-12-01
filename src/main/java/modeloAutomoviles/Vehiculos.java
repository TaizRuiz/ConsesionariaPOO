/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloAutomoviles;

import TipoMotor.TipoMotor;
import TipoMotor.TipoMotor;
import modeloUsuarios.Usuario;


public abstract class Vehiculos {
    protected boolean solicitado;
    protected String marca;
    protected String modelo;
    protected String anio;
    protected TipoMotor tipo;
    
    protected double Kilometraje;
    protected double precio;
    

    public Vehiculos(String marca, String modelo, String anio, TipoMotor tipo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipo = tipo;
        this.precio=precio;
        this.Kilometraje=0.0;
        
      
    }


    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
      

    public double getKilometraje() {
        return Kilometraje;
    }

    public void setKilometraje(double Kilometraje) {
        this.Kilometraje = Kilometraje;
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
        return  "marca=" + marca + ", modelo=" + modelo+" precio:"+this.precio + ", anio=" + anio  ;
    }
    public abstract String toStringDetallado();
    //Muestra si el vehiculo ha sido solicitado o no 
    @Override
    public boolean equals(Object obj) {
        if (this==obj){
          return true;
        }
        if(obj!=null && obj instanceof Vehiculos){
          Vehiculos nv= (Vehiculos) obj;
          return (this.getModelo().equals(nv.getModelo())&& (this.getMarca().equals(nv.getMarca())));
        }
        return false;
        
    }
}
