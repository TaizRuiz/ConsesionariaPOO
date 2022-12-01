/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloUsuarios;
import Solicitudes.*;
import modeloAutomoviles.*;
import modeloUsuarios.Usuario;
import EstadosSolicitud.TipoSolicitud;
import java.util.ArrayList;

public class Clientes extends Usuario{
    private String ncedula;
    private String ocupacion;
    private double income;
    
    private ArrayList<Integer> SolicitudesEnviadas;
    private ArrayList<VehiculosTaller> VehiculosComprados;
    public Clientes(String username,String passsword,String names,String lnames,String cedula,String ocupacion,double income){
        super(username, passsword, names, lnames);
        this.ncedula=cedula;
        this.ocupacion=ocupacion;
        this.income=income;
        this.VehiculosComprados=new ArrayList<>();
        this.SolicitudesEnviadas=new ArrayList<>();
       
    }

    public ArrayList<Integer> getSolicitudesEnviadas() {
        return SolicitudesEnviadas;
    }
    
    public SolicitudVenta SolicitarCotizacion(Usuario emisor, Vehiculos v, TipoSolicitud tipo) { 
        return new SolicitudVenta(emisor, v, tipo);
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

    public ArrayList<VehiculosTaller> getVehiculosComprados() {
        return VehiculosComprados;
    }

    public void setVehiculosComprados(ArrayList<VehiculosTaller> VehiculosComprados) {
        this.VehiculosComprados = VehiculosComprados;
    }
   
    
}
