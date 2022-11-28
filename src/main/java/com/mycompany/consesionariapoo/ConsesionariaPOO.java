/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.consesionariapoo;
import TipoMotor.TipoMotor;
import TipoTransmision.TipoTransmision;
import TiposMotos.CategoriaMoto;
import modeloAutomoviles.*;
import modeloUsuarios.*;
import java.util.ArrayList;
import java.util.Scanner;


public class ConsesionariaPOO {
    private static ArrayList<Usuario> lusuarios; 
    private static ArrayList<Vehiculos> vehiculosDisponibles;
    private static String bienvenida;

    public static ArrayList<Vehiculos> getVehiculosDisponibles() {
        return vehiculosDisponibles;
    }
    
    
    public static void main(String[] args) {
        
        
        ConsesionariaPOO Sistema=new ConsesionariaPOO();
        ConsesionariaPOO.InicializarSistema();
        
        String opcion="",opcion2="", opcion3="";
        String entradausuario,entradacontraseña;
        Scanner sc=new Scanner(System.in);
        //Muestra de menu incial 
        do{
           Sistema.mostrarMenu("Inciar Sesion,Salir del programa");
            System.out.println("Ingrese una opcion:");
            opcion=sc.next();
            switch(opcion){
                case "1":
                  
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
                            opcion2="2";
                            Usuario usuario=Sistema.ObtenerUsuario(usuarioIngreso);
                            //menu clientes
                            if (usuario instanceof Clientes){
                                    Clientes c=(Clientes) usuario;
                                    //Si el usuario ya ha comprado mas de un auto tiene un menu 
                                    if (c.getAutosComprados()==0){ 
                                        do { 
                                            System.out.println("Menu Clientes");
                                            Sistema.mostrarMenu("Visualizar Stock, Revisar Buzon, Volver al menu principal");
                                            System.out.println("Seleccione una opcion:");
                                            opcion3=sc.next();
                                            switch(opcion3){ 
                                              case "1":
                                                    int cont=1;
                                                    for (Vehiculos v: vehiculosDisponibles){ 
                                                        if (v.isSolicitado()==false){ 
                                                            System.out.println(cont+" "+v.toString());
                                                            cont++;
                                                            }
                                                        }
                                                        System.out.println("Desea cotizar uno de los vehiculos?");
                                                        System.out.println("Ingrese su respuesta:");
                                                        String respuesta;
                                                        respuesta=sc.next();
                                                        switch(respuesta){ 
                                                            case "si":
                                                                int indice;
                                                                System.out.println("Ingrese el NUMERO correspondiente al auto que desea cotizar:");
                                                                indice=sc.nextInt();
                                                                if (0<=(indice-1)&& (indice-1)<=vehiculosDisponibles.size()){ 
                                                                        Vehiculos vehiculadoCotizacion=vehiculosDisponibles.get(indice-1);
                                                                        System.out.println(vehiculadoCotizacion);
                                                                        break;
                                                                    }
                                                                else{ 
                                                                    System.out.println("La opcion ingresada no existe");
                                                    
                                                                    System.out.println("Esta siendo regresado al menu de clientes");
                                                                    break;
                                                                    }
                                                            case "no":
                                              
                                                                break;
                                                            default:
                                                                System.out.println("Ingrese si o no");
                                                                System.out.println("Esta siendo regresado al menu de clientes");
                                                                break;
                                                                
                                                            }
                                                    break;
                                                case "2":
                                                    System.out.println(c.getBuzonMensajes());
                                                    break;
                                                case "3": 
                                                    opcion3="3";
                                                    break;
                                                default:
                                                    System.out.println("La opcion ingresada no existe");
                                                }
                                            }while(opcion3.equals("3")==false);
                                        }
                                    //Si el usuario es nuevo muestra otro menu 
                                    if (c.getAutosComprados()!=0){ 
                                        do { 
                                            System.out.println("Menu Clientes");
                                            Sistema.mostrarMenu("Visualizar Stock, Revisar Buzon, Volver al menu principal");
                                            System.out.println("Seleccione una opcion:");
                                            opcion3=sc.next();
                                            }while(opcion3.equals("3")==false);
                                        }
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
                           opcion2=sc.next();
                           switch(opcion2){
                               case "1":
                                   System.out.println("Ingrese su nombre de usuario:");
                                    entradausuario=sc.next();
                                    System.out.println("Ingrese su contraseña: ");
                                    entradacontraseña=sc.next();
                                    usuarioIngreso=new Usuario(entradausuario, entradacontraseña);
                                    resultado=Sistema.IniciarSesion(usuarioIngreso);
                                   break;
                               case "2":
                                   opcion2="2";
                                   break;
                               default:
                                   System.out.println("La opcion seleccionada no existe");
                                   
                            }
                        }
                      
                    }while (opcion2.equals("2")==false);
                    break; 
                case "2":
                    opcion="2";
                    //SALE DEL SISTEMA 
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida");
                    break;
            }
            
        }while (opcion.equals("2")==false);
        
        
        
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
        lusuarios.add(new Clientes("Pedro12","Pdr123", "Ana Belen","Teran Rosales", "0911463815", "Licenciada en Educacion Parvularia", 1500));
        lusuarios.add(new Vendedor("MariaLu3","Lu3M8", "Maria Luz","Rendon Rendon"));
        lusuarios.add(new Vendedor("Angel45","12345", "Angel Isaac","Morante Garzon"));
        lusuarios.add(new Clientes("MarioP3","P3r3ZM", "Mario Andres","Perez Teran", "0918563815", "Emprendedor", 3000));
        lusuarios.add(new Clientes("AnaB123","Belem@15", "Ana Belen","Teran Rosales", "0946311815", "Licenciada en Educacion Parvularia", 1500));
        lusuarios.add(new Clientes("Lily789","LMarti45", "Lily Esther","Martinez Sanchez", "1145463815", "ninguna", 700));
        
        //Ingreso de datos de los vehiculos que estan disponibles en la concesionaria 
        vehiculosDisponibles.add(new Automovil("Toyota","Dmax","2015", TipoMotor.DIESEL,25000, 6, false));
        vehiculosDisponibles.add(new Automovil("Aveo","Family","2009", TipoMotor.GASOLINA,50000, 5, false));
        vehiculosDisponibles.add(new Automovil("Aveo","Sail","2017", TipoMotor.GASOLINA,7500, 5, true));
        vehiculosDisponibles.add(new Automovil("Kia","Carnival","2020", TipoMotor.DIESEL, 15000, 8, true));
        vehiculosDisponibles.add(new Automovil("Toyota","Fortuner","2022", TipoMotor.GASOLINA,35000, 6, true));
        vehiculosDisponibles.add(new Tractor("New Holland","T7","2020",50000,TipoMotor.DIESEL ,true,TipoTransmision.MECANICA));
        vehiculosDisponibles.add(new Tractor("John Deere","I5","2019",100000,TipoMotor.DIESEL,false,TipoTransmision.HIDRAULICA));
        vehiculosDisponibles.add(new Tractor("Fendt","I20","2020",452000,TipoMotor.DIESEL,true,TipoTransmision.MECANICA));
        vehiculosDisponibles.add(new Camion("Mercedes Benz", "Freightliner","2018",TipoMotor.DIESEL,150000, 1500, 10));
        vehiculosDisponibles.add(new Camion("Kenworth", "T800","2020",TipoMotor.GASOLINA,100500, 2000, 8));
        vehiculosDisponibles.add(new Camion("Volvo", "Heavy voul","2022",TipoMotor.DIESEL,98000, 300, 6));
        vehiculosDisponibles.add(new Motocicleta("Yadea","Volt Guard 2023", "2022",25000,TipoMotor.GASOLINA, CategoriaMoto.SCOOTER ));
        vehiculosDisponibles.add(new Motocicleta("Yadea","Keenes 2023", "2022",14000,TipoMotor.GASOLINA, CategoriaMoto.DEPORTIVA ));
        vehiculosDisponibles.add(new Motocicleta("Benelli","VKX", "2021",13000,TipoMotor.DIESEL, CategoriaMoto.DEPORTIVA ));
        vehiculosDisponibles.add(new Motocicleta("Yamaha","YZ250F", "2020",20800,TipoMotor.DIESEL, CategoriaMoto.TODO_TERRENO ));
    }
    //metodo para generar menus 
    public void mostrarMenu(String opcionesMenu){
        int cont=1;
        String[] items=opcionesMenu.split(",");
        for (String opcion: items){
            System.out.println(cont+" "+opcion);
            cont++;
        }
    }
    //metodo de inicio de sesion
    public boolean IniciarSesion(Usuario usu){
     for (Usuario u:lusuarios){
        
            if (u.equals(usu)==true) {
                
                return true; 
            }
        } 
     return false;
    }
    //metodo para obtener el indice del usuario dentro del arrrayList de usuario y asi poder verificar que tipo de usuario es
    public Usuario ObtenerUsuario(Usuario usu){
             
            for (Usuario u:lusuarios){
            if (u.equals(usu)==true) {
                int indice=lusuarios.indexOf(u);
                return lusuarios.get(indice);
                }  
            
            } 
            return usu;
    }
    public void mostrarStockDisponible(){
        for (Vehiculos v: vehiculosDisponibles){
                mostrarMenu(v.toString());
                }  
        }  
}

