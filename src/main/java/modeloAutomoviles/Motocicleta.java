/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloAutomoviles;

import modeloAutomoviles.Vehiculos;
import TiposMotos.CategoriaMoto;
import TipoMotor.TipoMotor;

public class Motocicleta extends Vehiculos {
    private final String numllantas="2";
    CategoriaMoto categoria;
    public Motocicleta(String marca, String modelo, String anio, TipoMotor tipo, CategoriaMoto cate){
        super(marca, modelo, anio, tipo);
        this.categoria=cate;
     }

    public CategoriaMoto getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaMoto categoria) {
        this.categoria = categoria;
    }
    
    @Override
     public String toStringDetallado(){
        String x= this.toString();
        return x+ " numero de llantas:"+ this.numllantas+" categoria:"+ this.getCategoria();
     }
}
