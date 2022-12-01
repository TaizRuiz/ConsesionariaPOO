/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloUsuarios;

import EstadosSolicitud.EstadosSolicitud;
import Solicitudes.SolicitudVenta;
import java.util.ArrayList;import modeloAutomoviles.Vehiculos;


public class Supervisor extends Usuario {
   
   private String[] certificaciones; 
    public Supervisor(String username,String passsword,String names,String lnames,String certificados){
    super(username, passsword, names, lnames);
    this.certificaciones=certificados.split(",");
    }

    public String[] getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(String certificaciones) {
        this.certificaciones = certificaciones.split(",");
    }
    public void AceptarSolicitud(SolicitudVenta sol,ArrayList<Vehiculos> stock){
        
        sol.setEstadoAceptacionSupervisor(EstadosSolicitud.ACEPTADA);
        sol.getVendedorAsignado().agregarAutoVendido();
        
    }
    public void rechazarSolicitud(SolicitudVenta sol, ArrayList<Vehiculos> stock,String motivoRechazo){
        sol.setEstadoAceptacionSupervisor(EstadosSolicitud.DENEGADA);
        sol.setMotivoRechazo(motivoRechazo);
        for (Vehiculos v:stock){
            if (v.equals(sol.getVehiculoSolicitud())==true){
                v.setSolicitado(false);
            }
            }
        }
    
}   
