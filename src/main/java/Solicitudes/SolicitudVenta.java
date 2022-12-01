/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solicitudes;

import EstadosSolicitud.*;
import modeloAutomoviles.Vehiculos;
import modeloUsuarios.*;

/**
 *
 * @author USUARIO
 */
public class SolicitudVenta extends Solicitud {
    private String motivoRechazo;
    private Vendedor vendedorAsignado;
    private  EstadosSolicitud estadoAceptacionSupervisor;
    public SolicitudVenta(Usuario emisor, Vehiculos v, TipoSolicitud tipo){
       super(emisor, v, tipo);
       motivoRechazo=" ";
       estadoAceptacionSupervisor=EstadosSolicitud.EN_ESPERA;
       this.vendedorAsignado=new Vendedor("", "", "", "");
       
       
    }

    public EstadosSolicitud getEstadoAceptacionSupervisor() {
        return estadoAceptacionSupervisor;
    }

    public void setEstadoAceptacionSupervisor(EstadosSolicitud estadoAceptacionSupervisor) {
        this.estadoAceptacionSupervisor = estadoAceptacionSupervisor;
    }
    
    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public Vendedor getVendedorAsignado() {
        return vendedorAsignado;
    }

    public void setVendedorAsignado(Vendedor vendedorAsignado) {
        this.vendedorAsignado = vendedorAsignado;
    }
     @Override
    public String toString() {
        String x=super.toString();
        return x+"\n"+"Asignado a:"+this.getVendedorAsignado().getNames()+" "+this.getVendedorAsignado().getLnames();
    }
//"\n"
}
