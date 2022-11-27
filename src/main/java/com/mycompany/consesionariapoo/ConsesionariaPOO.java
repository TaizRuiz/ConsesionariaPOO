/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.consesionariapoo;
import ClasesPadresehijas.*;
import java.util.ArrayList;
public class ConsesionariaPOO {
    private ArrayList<Usuario> lusuarios; 
    private ArrayList<Vehiculos> vehiculosDisponibles;
    private String bienvenida;
    
    
    public static void main(String[] args) {
        ConsesionariaPOO Sistema=new ConsesionariaPOO();
        Sistema.InicializarSistema();
    }
    public ConsesionariaPOO(){
        bienvenida="Bienvenid@ a nuestro sistema.A continuacion se le mostrara el menu ";
        lusuarios=new ArrayList<>();
        vehiculosDisponibles=new ArrayList<>();
    }
    public void InicializarSistema(){
        //Mensaje de bienvenida
        System.out.println(bienvenida);
        //Ingreso de datos de los usuarios
        lusuarios.add(new Clientes("Pedro123","Pedro 123", "Pedro Luis","Sanchez Sanchez", "0914463815", "Ingeniero", 15000));
        lusuarios.add(new JefeTaller("Pablo12","Pablo12", "Pablo Luis","Martinez Martinez"," Mecanico en Hidraulica,Certificado en mecanica preventiva"));
        lusuarios.add(new Supervisor ("Maria12","Mar1a", "Maria Luisa","Bernal Sanchez", "Licenciatura en administracion, Licenciatura en control de calidad"));
        lusuarios.add(new Clientes("AnaB123","Belem@15", "Ana Belen","Teran Rosales", "0911463815", "Licenciada en Educacion Parvularia", 1500));
        lusuarios.add(new Vendedor("MariaLu3","Lu3M8", "Maria Luz","Rendon Rendon"));
        lusuarios.add(new Vendedor("Angel45","12345", "Angel Isaac","Morante Garzon"));
        lusuarios.add(new Clientes("MarioP3","P3r3ZM", "Mario Andres","Perez Teran", "0918563815", "Emprendedor", 3000));
        lusuarios.add(new Clientes("AnaB123","Belem@15", "Ana Belen","Teran Rosales", "0946311815", "Licenciada en Educacion Parvularia", 1500));
        lusuarios.add(new Clientes("Lily789","LMarti45", "Lily Esther","Martinez Sanchez", "1145463815", "ninguna", 700));
        
        //Ingreso de datos de los vehiculos que estan disponibles en la concesionaria 
    }
}

