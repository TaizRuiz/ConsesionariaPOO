/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloAutomoviles;

import modeloAutomoviles.Vehiculos;
import TipoMotor.TipoMotor;
import TipoMotor.TipoMotor;

public class Automovil extends Vehiculos{
   private final String numllantas="4"; 
   private int numAsientos;
   private boolean camretro;
   public Automovil(String marca, String modelo, String anio, TipoMotor tipo, int numAsientos,boolean camretro){
        super(marca, modelo, anio, tipo);
        this.numAsientos=numAsientos;
        this.camretro=camretro;
        
     }

    public int getNumAsientos() {
        return numAsientos;
    }

    public void setNumAsientos(int numAsientos) {
        this.numAsientos = numAsientos;
    }

    public boolean isCamretro() {
        return camretro;
    }

    public void setCamretro(boolean camretro) {
        this.camretro = camretro;
    }
   
     @Override
     public String toStringDetallado(){
        String x=this.toString();
        String resultado;
        if (this.isCamretro()==true){
                resultado="Si";
            }
        else{
                resultado="No";
            }
        return x+ "numero de llantas: "+ this.numllantas+" numero de asientos:"+ this.getNumAsientos()+" Tiene camara de retro:"+ resultado;
        
     }
}
