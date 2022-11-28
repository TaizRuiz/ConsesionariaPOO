/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloUsuarios;

import modeloUsuarios.Usuario;

public class Clientes extends Usuario{
    private String ncedula;
    private String ocupacion;
    private double income;
    private int autosComprados;
    public Clientes(String username,String passsword,String names,String lnames,String cedula,String ocupacion,double income){
        super(username, passsword, names, lnames);
        this.ncedula=cedula;
        this.ocupacion=ocupacion;
        this.income=income;
        this.autosComprados=0;
        
    }

    public int getAutosComprados() {
        return autosComprados;
    }

    public void setAutosComprados(int autosComprados) {
        this.autosComprados = autosComprados;
    }
    
    

    public String getNcedula() {
        return ncedula;
    }

    public void setNcedula(String ncedula) {
        this.ncedula = ncedula;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }
   
    
}
