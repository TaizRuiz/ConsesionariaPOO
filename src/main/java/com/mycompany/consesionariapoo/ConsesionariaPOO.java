/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.consesionariapoo;
import modeloAutomoviles.*;
import modeloUsuarios.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ConsesionariaPOO {
    private static ArrayList<Usuario> lusuarios; 
    private ArrayList<Vehiculos> vehiculosDisponibles;
    private static String bienvenida;
    
    
    public static void main(String[] args) {
        
        
        ConsesionariaPOO Sistema=new ConsesionariaPOO();
        ConsesionariaPOO.InicializarSistema();
       
        
        int opcion,opcion2=0;
        String entradausuario,entradacontraseña;
        Scanner sc=new Scanner(System.in);
        //Muestra de menu incial 
        do{
           Sistema.mostrarMenu("Inciar Sesion,Salir del programa");
            System.out.println("Ingrese una opcion:");
            opcion=sc.nextInt();
            switch(opcion){
                case 1:
                  
                    //Hace log in
                    System.out.println("Ingrese su nombre de usuario:");
                    entradausuario=sc.next();
                    System.out.println("Ingrese su contraseña: ");
                    entradacontraseña=sc.next();
                    do {
                     boolean resultado;
                     
                    Usuario usuarioIngreso=new Usuario(entradausuario, entradacontraseña);
                    resultado=Sistema.IniciarSesion(usuarioIngreso);
                    if (resultado==true){
                            System.out.println("Bienvenid@, ha ingresado correctamente");
                            opcion2=2;
                            Usuario usuario=Sistema.ObtenerUsuario(usuarioIngreso);
                            if (usuario instanceof Clientes){
                                    System.out.println("Mostrar menu clientes");
                                }
                            if (usuario instanceof Supervisor){
                                    System.out.println("Mostrar menu super");
                                }
                            if (usuario instanceof Vendedor){
                                    System.out.println("Mostrar menu vendedor");
                                }
                            if (usuario instanceof JefeTaller){
                                    System.out.println("Mostrar menu jefetaller");
                                }
                            
                            
                        }
                    if (resultado==false){
                           System.out.println("Las credenciales ingresadas no son correctas");
                           Sistema.mostrarMenu("Seguir intentado,volver al menu principal");
                           System.out.println("Ingrese su seleccion:");
                           opcion2=sc.nextInt();
                           switch(opcion2){
                               case 1:
                                   System.out.println("Ingrese su nombre de usuario:");
                                    entradausuario=sc.next();
                                    System.out.println("Ingrese su contraseña: ");
                                    entradacontraseña=sc.next();
                                    usuarioIngreso=new Usuario(entradausuario, entradacontraseña);
                                    resultado=Sistema.IniciarSesion(usuarioIngreso);
                                   break;
                               case 2:
                                   opcion2=2;
                                   break;
                               default:
                                   System.out.println("Intente nuevamente");
                                   
                            }
                        }
                      
                    }while (opcion2!=2);
                    break; 
                case 2:
                    //SALE DEL SISTEMA 
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida");
                    break;
            }
            
        }while (opcion!=2);
        
        
        
    }
    public ConsesionariaPOO(){
        bienvenida="Bienvenid@ a nuestro sistema.A continuacion se le mostrara el menu ";
        lusuarios=new ArrayList<>();
        vehiculosDisponibles=new ArrayList<>();
    }
    public static void InicializarSistema(){
        //Mensaje de bienvenida
        System.out.println(bienvenida);
        //Ingreso de datos de los usuarios
        
        lusuarios.add(new JefeTaller("Pablo123","Pablo12", "Pablo Luis","Martinez Martinez"," Mecanico en Hidraulica,Certificado en mecanica preventiva"));
        lusuarios.add(new Supervisor ("Maria12","Mar1a", "Maria Luisa","Bernal Sanchez", "Licenciatura en administracion, Licenciatura en control de calidad"));
        lusuarios.add(new Clientes("AnaB123","Belem@15", "Ana Belen","Teran Rosales", "0911463815", "Licenciada en Educacion Parvularia", 1500));
        lusuarios.add(new Vendedor("MariaLu3","Lu3M8", "Maria Luz","Rendon Rendon"));
        lusuarios.add(new Vendedor("Angel45","12345", "Angel Isaac","Morante Garzon"));
        lusuarios.add(new Clientes("MarioP3","P3r3ZM", "Mario Andres","Perez Teran", "0918563815", "Emprendedor", 3000));
        lusuarios.add(new Clientes("AnaB123","Belem@15", "Ana Belen","Teran Rosales", "0946311815", "Licenciada en Educacion Parvularia", 1500));
        lusuarios.add(new Clientes("Lily789","LMarti45", "Lily Esther","Martinez Sanchez", "1145463815", "ninguna", 700));
        
        //Ingreso de datos de los vehiculos que estan disponibles en la concesionaria 
    }
    public void mostrarMenu(String opcionesMenu){
        int cont=1;
        String[] items=opcionesMenu.split(",");
        for (String opcion: items){
            System.out.println(cont+" "+opcion);
            cont++;
        }
    }
    public boolean IniciarSesion(Usuario usu){
     for (Usuario u:lusuarios){
        
            if (u.equals(usu)==true) {
                
                return true; 
            }
        } 
     return false;
    }
    public Usuario ObtenerUsuario(Usuario usu){
             
            for (Usuario u:lusuarios){
            if (u.equals(usu)==true) {
                int indice=lusuarios.indexOf(u);
                return lusuarios.get(indice);
                }  
            
            } 
            return usu;
    }
}

