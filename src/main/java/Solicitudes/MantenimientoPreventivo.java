/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solicitudes;

import EstadosSolicitud.TipoSolicitud;
import modeloAutomoviles.Vehiculos;
import modeloUsuarios.Usuario;
import EstadosSolicitud.EstadosMecanico;
/**
 *
 * @author USUARIO
 */
public class MantenimientoPreventivo extends Solicitud {
    EstadosMecanico estadoEnMecanico;
    double precioMantenimiento;
    public MantenimientoPreventivo(Usuario emisor, Vehiculos v, TipoSolicitud tipo,double precioMantenimiento,EstadosMecanico mecanico){
        super(emisor, v, tipo);
        this.precioMantenimiento=precioMantenimiento;
    }

    public EstadosMecanico getEstadoEnMecanico() {
        return estadoEnMecanico;
    }

    public void setEstadoEnMecanico(EstadosMecanico estadoEnMecanico) {
        this.estadoEnMecanico = estadoEnMecanico;
    }
    
    public double getPrecioMantenimiento() {
        return precioMantenimiento;
    }

    public void setPrecioMantenimiento(double precioMantenimiento) {
        this.precioMantenimiento = precioMantenimiento;
    }
   
    
}
