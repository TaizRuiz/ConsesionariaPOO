/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPadresehijas;

public class Tractor extends Vehiculos {
   private final String numllantas="4";
    private boolean usoAgricola;
    private TipoTransmision transmision;
    public Tractor(String marca, String modelo, String anio, TipoMotor tipo, String numllantas,boolean esUsoAgricola, TipoTransmision transmision){
        super(marca, modelo, anio, TipoMotor.DIESEL);
        this.usoAgricola=esUsoAgricola;
        this.transmision=transmision;
    }
    @Override
    public String toStringDetallado(){
        String resultado;
        String x= this.toString();
        if (this.isusoAgricola()==true){
            resultado="Si";
        }
        else{
            resultado="No";
        }
        
        return x+" numero de llantas: "+this.numllantas+" es para uso agricola:"+ resultado+ " Tipo de transmision: "+this.getTransmision();
    }

    public boolean isusoAgricola() {
        return usoAgricola;
    }

    public void setisusoAgricola(boolean esUsoAgricola) {
        this.usoAgricola = esUsoAgricola;
    }

    public TipoTransmision getTransmision() {
        return transmision;
    }

    public void setTransmision(TipoTransmision transmision) {
        this.transmision = transmision;
    }
    
}
