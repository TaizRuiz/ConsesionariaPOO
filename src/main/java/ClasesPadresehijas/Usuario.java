/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesPadresehijas;

import java.util.Objects;
import java.util.logging.Logger;

public class Usuario {
    protected String username;
    protected String passsword;
    protected String names;
    protected String lnames;

    public Usuario(String username, String passsword, String names, String lnames) {
        this.username = username;
        this.passsword = passsword;
        this.names = names;
        this.lnames = lnames;
    }
    public Usuario(String username, String passsword) {
        this.username = username;
        this.passsword = passsword;
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLnames() {
        return lnames;
    }

    public void setLnames(String lnames) {
        this.lnames = lnames;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj){
          return true;
        }
        if(obj!=null && obj instanceof Usuario){
          Usuario nuser= (Usuario) obj;
          return (this.getUsername().equals(nuser.getUsername())&& (this.getPasssword().equals(nuser.getPasssword())));
        }
        return false;
        
    }

    @Override
    public String toString() {
        return  "names=" + names + ", lnames=" + lnames ;
    }
    
    

}
