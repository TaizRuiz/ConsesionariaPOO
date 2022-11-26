/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPadresehijas;


public abstract class Vehiculos {
    
    protected String marca;
    protected String modelo;
    protected String anio;
    protected TipoMotor tipo;

    public Vehiculos(String marca, String modelo, String anio, TipoMotor tipo) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.tipo = tipo;
      
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
        return  "marca=" + marca + ", modelo=" + modelo + ", anio=" + anio + ", tipo=" + tipo ;
    }
    public abstract String toStringDetallado();
    
    
}
