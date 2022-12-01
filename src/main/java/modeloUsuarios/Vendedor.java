/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloUsuarios;

import EstadosSolicitud.EstadosSolicitud;
import Solicitudes.Solicitud;
import Solicitudes.SolicitudVenta;
import modeloUsuarios.Usuario;

public class Vendedor extends Usuario {
    private int idvendedor;
    private int numAutosVendidos;
    public Vendedor(String username,String passsword,String names,String lnames){
        super(username, passsword, names, lnames);
        this.idvendedor+=(this.getIdvendedor()+1);
        this.numAutosVendidos=0;
    }

    public int getNumAutosVendidos() {
        return numAutosVendidos;
    }

    public void setNumAutosVendidos(int numAutosVendidos) {
        this.numAutosVendidos = numAutosVendidos;
    }
    

    public int getIdvendedor() {
        return idvendedor;
    }
    
    public void AceptarSolicitud(SolicitudVenta s) {
        s.setEstado(EstadosSolicitud.ACEPTADA);
        
        
    }
    public void RechazarSolicitud( SolicitudVenta s,String justificacion) {
        s.setEstado(EstadosSolicitud.DENEGADA);
        s.setMotivoRechazo(justificacion);
        
                
    }
    public void agregarAutoVendido(){
        this.numAutosVendidos+=1;
    }
    
    
}
