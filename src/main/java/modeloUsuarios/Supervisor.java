/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloUsuarios;

import java.util.ArrayList;

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
    
}   
