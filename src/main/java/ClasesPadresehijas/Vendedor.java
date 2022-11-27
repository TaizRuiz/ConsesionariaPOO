/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPadresehijas;

public class Vendedor extends Usuario {
    private int idvendedor;
    public Vendedor(String username,String passsword,String names,String lnames){
        super(username, passsword, names, lnames);
        this.idvendedor=idvendedor++;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    
    
}
