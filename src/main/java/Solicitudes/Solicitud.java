/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solicitudes;
import modeloUsuarios.*;
import modeloAutomoviles.*;
import EstadosSolicitud.*;
public class Solicitud {
    protected Usuario emisor;
    
    protected Vehiculos vehiculoSolicitud;
    protected TipoSolicitud motivo;
    protected EstadosSolicitud estado;
    
    public Solicitud(Usuario emisor, Vehiculos v, TipoSolicitud tipo){
        this.emisor=emisor;
        this.motivo=tipo;
        this.vehiculoSolicitud=v;
        this.estado=EstadosSolicitud.EN_ESPERA;
        
    }
    
  
    
    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public Vehiculos getVehiculoSolicitud() {
        return vehiculoSolicitud;
    }

    public void setVehiculoSolicitud(Vehiculos vehiculoSolicitud) {
        this.vehiculoSolicitud = vehiculoSolicitud;
    }

    public TipoSolicitud getMotivo() {
        return motivo;
    }

    public void setMotivo(TipoSolicitud motivo) {
        this.motivo = motivo;
    }
    
    @Override
    public String toString() {
        return "vehiculo Solicitado =" + vehiculoSolicitud +"\n"+ " tipo de solicitud =" + motivo +"\n"+ "estado de salicitud =" + estado
                +"\n"+ "nombre solicitante =" + this.emisor.getNames()+" "+this.emisor.getLnames();
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
          return true;
        }
        if(obj!=null && obj instanceof Solicitud){
          Solicitud s= (Solicitud) obj;
          return (this.getEmisor().equals(s.getEmisor())&& (this.getVehiculoSolicitud().equals(s.getVehiculoSolicitud())));
        }
        return false;
    }
    public EstadosSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadosSolicitud estado) {
        this.estado = estado;
    }

    
    
    
}
