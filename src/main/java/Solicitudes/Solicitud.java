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
    protected Usuario receptor;
    protected Vehiculos vehiculoSolicitud;
    protected TipoSolicitud motivo;
    protected EstadosSolicitud estado;
    
    public Solicitud(Usuario emisor, Usuario Receptor, Vehiculos v){
        this.emisor=emisor;
        this.receptor=receptor;
        this.vehiculoSolicitud=v;
    }
    public void Enviar(Usuario usuario){
       
        usuario.getBuzonMensajes().add(this);
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

   

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }

    public EstadosSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadosSolicitud estado) {
        this.estado = estado;
    }

    
    
    
}
