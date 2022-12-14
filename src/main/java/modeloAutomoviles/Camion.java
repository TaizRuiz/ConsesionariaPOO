/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloAutomoviles;

import modeloAutomoviles.Vehiculos;
import TipoMotor.TipoMotor;
import TipoMotor.TipoMotor;

public class Camion extends Vehiculos {
    private int numllantas;
    private double capacidadCarga;
    private int numejes;
    public Camion(String marca, String modelo, String anio, TipoMotor tipo,double precio,double capacidadCarga, int numllantas){
        super(marca, modelo, anio, tipo, precio);
        this.capacidadCarga=capacidadCarga;
        if ( numllantas>3 && 9> numllantas){
           this.numllantas=numllantas;
           this.numejes=numllantas/2;
        }
        else{
            this.numllantas=4;
            this.numejes=this.numllantas/2;
        }
    }

    public int getNumllantas() {
        return numllantas;
    }

    public void setNumllantas(int numllantas) {
        this.numllantas = numllantas;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getNumejes() {
        return numejes;
    }

    public void setNumejes(int numejes) {
        this.numejes = numejes;
    }
    @Override
    public String toStringDetallado(){
        String x=this.toString();
        return x+" numero de llantas: "+this.getNumllantas()+" capacidad: "+this.getCapacidadCarga()+" numero de ejes: "+this.getNumejes();
    }
}
