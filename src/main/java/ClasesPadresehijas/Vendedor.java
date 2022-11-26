/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPadresehijas;

public class Vendedor extends Usuario {
    private String idvendedor;
    public Vendedor(String username,String passsword,String names,String lnames,String idvendedor){
        super(username, passsword, names, lnames);
        this.idvendedor=idvendedor;
    }

    public String getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(String idvendedor) {
        this.idvendedor = idvendedor;
    }
    
    
}
