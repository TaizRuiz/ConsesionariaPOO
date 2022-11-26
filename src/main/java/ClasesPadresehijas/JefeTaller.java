/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPadresehijas;
    
import java.util.ArrayList;

public class JefeTaller extends Usuario {
    private ArrayList<String> certificaciones; 
    public JefeTaller(String username,String passsword,String lastnames,String names, String lnames,ArrayList<String> certificados){
    super(username, passsword, names, lnames);
    this.certificaciones=certificados;
    }

    public ArrayList<String> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(ArrayList<String> certificaciones) {
        this.certificaciones = certificaciones;
    }
    
}
