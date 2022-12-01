/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloAutomoviles;

/**
 *
 * @author USUARIO
 */
import EstadosSolicitud.*;
import modeloUsuarios.*;
public class VehiculosTaller {
    private EstadosMecanico estadoinicialtaller;
    private Clientes owner;
    private Vehiculos vehiculo;
    public VehiculosTaller(Clientes ow,Vehiculos vh){
        this.estadoinicialtaller=EstadosMecanico.EN_ESPER_ADMISION;
        this.owner=ow;
        this.vehiculo=vh;
    }

    @Override
    public String toString() {
        return "  estadoinicialtaller=" + estadoinicialtaller + ", owner=" + owner + ", vehiculo=" + vehiculo ;
    }
    
    public EstadosMecanico getEstadoinicialtaller() {
        return estadoinicialtaller;
    }

    public void setEstadoinicialtaller(EstadosMecanico estadoinicialtaller) {
        this.estadoinicialtaller = estadoinicialtaller;
    }

    public Clientes getOwner() {
        return owner;
    }

    public void setOwner(Clientes owner) {
        this.owner = owner;
    }

    public Vehiculos getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculos vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
