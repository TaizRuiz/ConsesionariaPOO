/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPadresehijas;

public class Clientes extends Usuario{
    private String ncedula;
    private String ocupacion;
    private double income;
    public Clientes(String username,String passsword,String names,String lnames,String cedula,String ocupacion,double income){
        super(username, passsword, names, lnames);
        this.ncedula=cedula;
        this.ocupacion=ocupacion;
        this.income=income;
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
