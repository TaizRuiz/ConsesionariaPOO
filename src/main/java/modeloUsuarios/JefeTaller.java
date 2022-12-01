/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloUsuarios;
    
import EstadosSolicitud.EstadosMecanico;
import java.util.ArrayList;
import modeloAutomoviles.*;
import modeloAutomoviles.VehiculosTaller;

public class JefeTaller extends Usuario {
    private ArrayList<VehiculosTaller> VehiculoPorEntregar;
    private ArrayList<VehiculosTaller> VehiculosMantenimientos;
    private String[] certificaciones;
    public JefeTaller(String username,String passsword,String names,String lnames,String certificados){
    super(username, passsword, names, lnames);
    VehiculoPorEntregar=new ArrayList<>();
    VehiculosMantenimientos=new ArrayList<>();
    this.certificaciones=certificados.split(",");
    }

    public String[] getCertificaciones() {
        return certificaciones;
    }

    public ArrayList<VehiculosTaller> getVehiculoPorEntregar() {
        return VehiculoPorEntregar;
    }

    public void setVehiculoPorEntregar(ArrayList<VehiculosTaller> VehiculoPorEntregar) {
        this.VehiculoPorEntregar = VehiculoPorEntregar;
    }

    public ArrayList<VehiculosTaller> getVehiculosMantenimientos() {
        return VehiculosMantenimientos;
    }

    public void setVehiculosMantenimientos(ArrayList<VehiculosTaller> VehiculosMantenimientos) {
        this.VehiculosMantenimientos = VehiculosMantenimientos;
    }

    public void entregarVehiculo(VehiculosTaller v){
        v.setEstadoinicialtaller(EstadosMecanico.ENTREGADO);
        System.out.println("********************");
        System.out.println("El vehiculo se ha entregado con exito ");
        
    }
    public void setCertificaciones(String certificaciones) {
        this.certificaciones=certificaciones.split(",");
    }
    
}
