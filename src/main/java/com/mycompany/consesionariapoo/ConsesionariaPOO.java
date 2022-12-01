/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.consesionariapoo;
import EstadosSolicitud.EstadosMecanico;
import EstadosSolicitud.EstadosSolicitud;
import EstadosSolicitud.TipoSolicitud;
import TipoMotor.TipoMotor;
import TipoTransmision.TipoTransmision;
import TiposMotos.CategoriaMoto;
import modeloAutomoviles.*;
import modeloUsuarios.*;
import java.util.ArrayList;
import java.util.Scanner;
import Solicitudes.*;
import java.lang.Math.*;
import java.util.Random;
import Solicitudes.*;
public class ConsesionariaPOO {
    private static ArrayList<Usuario> lusuarios=new ArrayList<>(); 
    private static ArrayList<Vehiculos> vehiculosDisponibles=new ArrayList<>();
    private static String bienvenida="Bienvenid@ a nuestro sistema";
    private static ArrayList<Solicitud> solicitudesEnviadas=new ArrayList<>();
    public static ArrayList<Vehiculos> getVehiculosDisponibles() {
        return vehiculosDisponibles;
    }
    
    
    public static void main(String[] args) {
        
        
        InicializarSistema();
        
        String opcion="",opcion2="", opcion3="",opcion4="",opcion5,opcion6="",opcion7="",motivoRechazo="",opcion8="",opcion9="",opcion10="",opcion11="",opcion12="";
        String entradausuario,entradacontraseña;
        Scanner sc=new Scanner(System.in);
        //Muestra de menu incial 
        do{
            System.out.println("        Menu Principal");
            System.out.println("----------------------");
            mostrarMenu("Inciar Sesion,Salir del programa");
            System.out.println("Ingrese una opcion:");
            System.out.println("----------------------");
            opcion=sc.nextLine();
            
            switch(opcion){
                case "1":
                  
                    //Hace log in
                    System.out.println("Ingrese su nombre de usuario:");
                    entradausuario=sc.nextLine();
                    System.out.println("Ingrese su contraseña: ");
                    entradacontraseña=sc.nextLine();
                    do {
                     boolean resultado;
                     
                    Usuario usuarioIngreso=new Usuario(entradausuario, entradacontraseña);
                    resultado=IniciarSesion(usuarioIngreso);
                    if (resultado==true){
                            System.out.println("Bienvenid@, ha ingresado correctamente");
                            opcion2="2";
                            Usuario usuario=ObtenerUsuario(usuarioIngreso);
                            //menu clientes
                            if (usuario instanceof Clientes){
                                    Clientes c=(Clientes) usuario;
                                    //Si el usuario ya ha comprado mas de un auto tiene un menu 
                                        do { 
                                            System.out.println("----------------------");
                                            System.out.println("    Menu Clientes   ");
                                            System.out.println("----------------------");
                                            mostrarMenu("Visualizar Stock, Revisar Solicitudes de cotizacion,Mantenimientos,Salir y volver al menu principal");
                                            System.out.println("Seleccione una opcion:");
                                            opcion3=sc.nextLine();
                                            switch(opcion3){ 
                                              case "1":
                                                  System.out.println("Vehiculos adquiridos por el usuario");
                                                  System.out.println(c.getVehiculosComprados());
                                                        mostrarStockDisponible();
                                                        System.out.println("Desea cotizar uno de los vehiculos?");
                                                        System.out.println("Ingrese su respuesta:");
                                                        String respuesta;
                                                        respuesta=sc.nextLine();
                                                        switch(respuesta){ 
                                                            case "si":
                                                                int indice;
                                                                System.out.println("----------------------");
                                                                System.out.println("Ingrese el NUMERO correspondiente al auto que desea cotizar:");
                                                                System.out.println("----------------------");
                                                                
                                                                indice=sc.nextInt(); sc.nextLine();
                                                                if (0<=(indice-1)&& (indice-1)<=vehiculosDisponibles.size()){ 
                                                                        Vehiculos vehiculadoCotizacion=vehiculosDisponibles.get(indice-1);
                                                                       
                                                                        //el usuario crea la solicitud 
                                                                        SolicitudVenta solicitud =c.SolicitarCotizacion(c, vehiculadoCotizacion, TipoSolicitud.COTIZACION);
                                                                        //el sistema verifica que la solicitidud no este repetida y procede a enviarla 
                                                                        if (!(c.getSolicitudesEnviadas().contains(indice))){
                                                                                c.getSolicitudesEnviadas().add(indice);
                                                                                c.getBuzonMensajes().add(solicitud);
                                                                                asignarCotizacionVendedor(solicitud);
                                                                                
                                                                            } 
                                                                        else{
                                                                                System.out.println("No puede enviar la misma solicitud dos veces");
                                                                            } 
      
                                                                        System.out.println("Esta volviendo al menu de Clientes");
                                                                        break;
                                                                    }
                                                                else{ 
                                                                    System.out.println("La opcion ingresada no existe");
                                                    
                                                                    System.out.println("Esta siendo regresado al menu de clientes...");
                                                                    break;
                                                                    }
                                                            case "no":
                                              
                                                                break;
                                                            default:
                                                                System.out.println("Ingrese si o no");
                                                                System.out.println("Esta siendo regresado al menu de clientes...");
                                                                break;
                                                                
                                                            }
                                                    break;
                                                case "2":
                                                    int cont=1;
                                                    for (Solicitud s: c.getBuzonMensajes()){ 
                                                        System.out.println("*********************"+cont+"******************************");
                                                        SolicitudVenta sv=(SolicitudVenta)s;
                                                        if (sv.getEstado()==EstadosSolicitud.DENEGADA){ 
                                                            System.out.println("Su solicitud:");
                                                            System.out.println("----------------------");
                                                            System.out.println(sv);
                                                            System.out.println("----------------------");
                                                            System.out.println("Ha sido rechazada debido a:"+sv.getMotivoRechazo());
                                                           
                                                            }
                                                        if (sv.getEstado()==EstadosSolicitud.ACEPTADA && sv.getEstadoAceptacionSupervisor()==EstadosSolicitud.EN_ESPERA ){ 
                                                            System.out.println("Su solicitud ha sido aceptada. Ahora tiene acceso a descripciones especificas del vehiculo");
                                                            System.out.println("----------------------");
                                                            System.out.println(s.getVehiculoSolicitud().toStringDetallado());
                                                            System.out.println("----------------------");
                                                             
                                                                System.out.println("----------------------");
                                                                mostrarMenu("Solicitar Compra,Continuar");
                                                                System.out.println("----------------------");
                                                               System.out.println("Ingrese su opcion:");
                                                                
                                                                
                                                            do{
                                                                opcion7=sc.nextLine(); 
                                                                switch(opcion7){
                                                                    case "1":
                                                                        asignarVentaSupervisor(sv);
                                                                        System.out.println("-----------------------------------------------------");
                                                                        System.out.println("Su solicitud de compra ha sido enviada al supervisor ");
                                                                        System.out.println("-----------------------------------------------------");
                                                                        sv.setEstadoAceptacionSupervisor(EstadosSolicitud.ENVIADA);
                                                                        break;
                                                                        
                                                                    case "2":
                                                                        opcion7="2";
                                                                        break;
              
                                                                    default:
                                                                        opcion7="2";
                                                                        break;
                                                                }
                                                            }while (opcion7.equals("2")==false);
                                                            }
                                                            if (sv.getEstadoAceptacionSupervisor()==EstadosSolicitud.ACEPTADA){
                                                                System.out.println("Su solicitud:");
                                                                System.out.println("----------------------------");
                                                                System.out.println(sv);
                                                                System.out.println("----------------------------");
                                                                System.out.println("Ha sido aceptada, porfavor acerquese al taller de la consesionaria a retirar su vehiculo");
                                                                 System.out.println("        ---------------------");
                                                                System.out.println("        Gracias por preferirnos");
                                                                System.out.println("        ---------------------");
                                                               
                                                            }
                                                             if (sv.getEstadoAceptacionSupervisor()==EstadosSolicitud.DENEGADA){
                                                                System.out.println("Su solicitud:");
                                                                System.out.println("----------------------------");
                                                                System.out.println(sv);
                                                                System.out.println("----------------------------");
                                                                System.out.println("Ha sido negada, debido a: "+sv.getMotivoRechazo());
                                                               
                                                               
                                                            }
                                                            if (sv.getEstado()==EstadosSolicitud.EN_ESPERA){
                                                                System.out.println("Su solicitud:");
                                                                System.out.println("----------------------------");
                                                                System.out.println(sv);
                                                                System.out.println("----------------------------");
                                                                System.out.println("Sigue en Espera");
                                                            }
                                                        cont++;
                                                        }
                                                    for (Solicitud sv:c.getBuzonMensajes()){
                                                        if (sv.getEstado()==EstadosSolicitud.DENEGADA){
                                                            c.getBuzonMensajes().remove(sv);
                                                        }
                                                    }
                                                    break;
                                                case "3":
                                                   
                                                    if (!c.getVehiculosComprados().isEmpty()){
                                                        do {
                                                            
                                                        
                                                        System.out.println("Revisar Estado de Vehiculo en Taller,Solicitar Mantenimiento Preventivo, Solicitar Mantenimiento de Emergencia, volver al menu de clientes");
                                                        System.out.println("Ingrese una opcion:");
                                                        opcion12=sc.nextLine();
                                                        switch(opcion12){
                                                            case "1":
                                                                //Revisa el estado los vehiculos que ya tiene en el taller
                                                                for (VehiculosTaller vehiculoCliente: c.getVehiculosComprados()){
                                                                    if (vehiculoCliente.getEstadoinicialtaller()!=EstadosMecanico.EN_ESPER_ADMISION && vehiculoCliente.getEstadoinicialtaller()!=EstadosMecanico.ENTREGADO){
                                                                        System.out.println("||"+vehiculoCliente+"||");
                                                                    }
                                                                }
                                                                 break;
                                                            case "2":
                                                                //Solicita mantenimiento preventivo
                                                                for (VehiculosTaller vehiculoCliente: c.getVehiculosComprados()){
                                                                    if (vehiculoCliente.getEstadoinicialtaller()==EstadosMecanico.EN_ESPER_ADMISION ){
                                                                        System.out.println("||"+vehiculoCliente+"||");
                                                                        mostrarMenu("Solicitar Mantenimiento Preventivo,Volver al menu de clientes");
                                                                    }
                                                                }
                                                            case "4": 
                                                                opcion12="4";
                                                                break;
                                                            default:
                                                                System.out.println("La opcion ingresada no existe");
                                                                break;
                                                            
                                                        }
                                                        }while(opcion12.equals("4")==false);
                                                        
                                                    }
                                                    if (c.getVehiculosComprados().isEmpty()){
                                                        System.out.println("------------------------------------------------------");
                                                        System.out.println("Usted no ha adquirido vehiculos en esta concesionaria");
                                                        System.out.println("------------------------------------------------------");
                                                        break;
                                                    }
                                               
                                                case "4": 
                                                    opcion3="4";
                                                    break;
                                                default:
                                                    System.out.println("La opcion ingresada no existe");
                                                    break;
                                                }
                                            }while(opcion3.equals("4")==false);
                                }
                            //Si el usuario es un supervisor 
                            if (usuario instanceof Supervisor){
                                Supervisor admin=(Supervisor) usuario;
                                    do{
                                        System.out.println("----------------------");
                                        System.out.println("    Menu Supervisor");
                                        System.out.println("----------------------");
                                        mostrarMenu("Revisar solicitudes de Compra,Salir y Volver al menu principal");
                                        System.out.println("Ingrese una opcion: ");  
                                        opcion8=sc.nextLine();
                                        switch (opcion8){
                                            case "1":
                                                for (Solicitud s:admin.getBuzonMensajes()){
                                                    SolicitudVenta sv= (SolicitudVenta)s;
                                                    if (sv.getEstadoAceptacionSupervisor()==EstadosSolicitud.ENVIADA){
                                                        System.out.println("----------------------");
                                                        System.out.println(sv);
                                                        System.out.println("----------------------");
                                                        mostrarMenu("Aceptar,Rechazar");
                                                        System.out.println("Ingrese su opcion:");
                                                        opcion9=sc.nextLine();
                                                        switch(opcion9){
                                                            case "1":
                                                                admin.AceptarSolicitud(sv,vehiculosDisponibles);
                                                                EnviaraTaller(sv);
                                                                
                                                                break;
                                                            case "2":
                                                                System.out.println("Ingrese la razon por la cual rechaza la solicitud: ");
                                                                motivoRechazo=sc.nextLine();
                                                                admin.rechazarSolicitud(sv,vehiculosDisponibles,motivoRechazo);
                                                                 break;
                                                            default: 
                                                                System.out.println("Esta volviendo al menu de vendedor");
                                                                 break;
                                                        }
                                                        
                                                    }
                                                }
                                                
                                                
                                                    
                                                break;
                                               
                                            case "2":
                                               break;
                                            default:
                                                System.out.println("La opcion ingresada no existe");
                                                break;
                                        }
                                       }while(opcion8.equals("2")==false);
                                }
                            //Si el usuario es un vendedor
                            if (usuario instanceof Vendedor){
                                Vendedor v=(Vendedor) usuario;
                                //Muestra el menu de vendedor 
                                    do{
                                        System.out.println("----------------------");
                                        System.out.println("    Menu Vendedor");
                                        System.out.println("----------------------");
                                        mostrarMenu("Revisar solicitudes de cotizacion,Visualizar stock,Salir y Volver al menu principal");
                                        System.out.println("Ingrese una opcion: ");  
                                        opcion4=sc.nextLine();
                                        switch (opcion4){
                                            case "1":
                                                //System.out.println(v.getBuzonMensajes().size());
                                                int cont1=1;
                                                for (Solicitud s:v.getBuzonMensajes()){
                                                    System.out.println("*****************************"+cont1+"***************************************");
                                                    SolicitudVenta sv= (SolicitudVenta)s;
                                                    if (sv.getEstado()==EstadosSolicitud.EN_ESPERA){
                                                        System.out.println("----------------------");
                                                        System.out.println(sv);
                                                        System.out.println("----------------------");
                                                        mostrarMenu("Aceptar,Rechazar");
                                                        System.out.println("Ingrese su opcion:");
                                                        opcion5=sc.nextLine();
                                                        switch(opcion5){
                                                            case "1":
                                                                v.AceptarSolicitud(sv);
                                                                break;
                                                            case "2":
                                                                System.out.println("Ingrese la razon por la cual rechaza la solicitud: ");
                                                                motivoRechazo=sc.nextLine();
                                                                v.RechazarSolicitud(sv,motivoRechazo);
                                                                 break;
                                                            default: 
                                                                System.out.println("Esta volviendo al menu de vendedor");
                                                                 break;
                                                        }
                                                        
                                                    }
                                                    cont1++;
                                                }
                                                
                                                break;
                                            case "2":
                                                int cont=1;
                                                    System.out.println("----------------------");
                                                   for (Vehiculos vehiculo: vehiculosDisponibles){
                                                               System.out.println(cont +" "+vehiculo.toStringDetallado());
                                                               cont++;
                                                           } 
                                                     
                                                   System.out.println("----------------------");
                                                   break;
                                            case "3":
                                                opcion4="3";
                                                break;
                                            default:
                                                System.out.println("La opcion ingresada no existe");
                                                break;
                                        }
                                       }while(opcion4.equals("3")==false);
                                    
     
                                }
                            if (usuario instanceof JefeTaller){
                                    //Menu Jefe de Taller
                                    JefeTaller jefetaller=(JefeTaller) usuario;
                                    do{
                                        System.out.println("----------------------");
                                        System.out.println("    Menu Jefe de Taller");
                                        System.out.println("----------------------");
                                        mostrarMenu("Revisar Autos por entregar, Revisar autos en mantenimiento,Salir y Volver al menu principal");
                                        System.out.println("Ingrese una opcion: ");  
                                        opcion10=sc.nextLine();
                                        switch (opcion10){
                                            case "1":
                                                for (VehiculosTaller jf:jefetaller.getVehiculoPorEntregar()){
                                                    if (jf.getEstadoinicialtaller()==EstadosMecanico.TERMINADO){
                                                        System.out.println(jf);
          
                                                            System.out.println("---------------------------");
                                                            mostrarMenu("Entregar,Continuar");
                                                            System.out.println("----------------------------");
                                                            System.out.println("Ingrese su elecion:");
                                                            opcion11=sc.nextLine();
                                                            switch(opcion11){
                                                                case "1":
                                                                    //Hace la entrega al usuario
                                                                    jefetaller.entregarVehiculo(jf);
                                                                 
                                                                    //Borra el objeto de los autos por entregar y de la lista de la consesionaria
                                                                    break;
                                                                case "2":
                                                                    System.out.println("Se salto un vehiculo");
                                                                    break;
                                                                    
                                                            }
                                                        
                                                    }
                                                }
                                                
                                                
                                            
                                               
                                            case "2":
                                                //Autos por entregar
                                               break;
                                            
                                            case "3":
                                                opcion10="4";
                                            default:
                                                System.out.println("La opcion ingresada no existe");
                                        }
                                       }while(opcion10.equals("4")==false);
                                }
                                }
                            
                            
                        
                    if (resultado==false){
                           System.out.println("Las credenciales ingresadas no son correctas");
                           mostrarMenu("Seguir intentado,Salir y volver al menu principal");
                           System.out.println("Ingrese su seleccion:");
                           opcion2=sc.nextLine();
                           switch(opcion2){
                               case "1":
                                   System.out.println("Ingrese su nombre de usuario:");
                                    entradausuario=sc.nextLine();
                                    System.out.println("Ingrese su contraseña: ");
                                    entradacontraseña=sc.nextLine();
                                    usuarioIngreso=new Usuario(entradausuario, entradacontraseña);
                                    resultado=IniciarSesion(usuarioIngreso);
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
    
    
    public static void InicializarSistema(){
        //Mensaje de bienvenida
        System.out.println(bienvenida);
        //Ingreso de datos de los usuarios
        
        lusuarios.add(new JefeTaller("Pablo123","Pablo12", "Pablo Luis","Martinez Martinez"," Mecanico en Hidraulica,Certificado en mecanica preventiva"));
        lusuarios.add(new Supervisor ("Maria12","Mar1a", "Maria Luisa","Bernal Sanchez", "Licenciatura en administracion, Licenciatura en control de calidad"));
        lusuarios.add(new Clientes("Pedro12","Pdr123", "Ana Belen","Teran Rosales", "0911463815", "Licenciada en Educacion Parvularia", 1500));
        lusuarios.add(new Vendedor("MariaLu3","Lu3M8", "Maria Luz","Rendon Rendon"));
        lusuarios.add(new Vendedor("Angel45","12345", "Angel Isaac","Morante Garzon"));
        lusuarios.add(new Clientes("Mario","Perez", "Mario Andres","Perez Teran", "0918563815", "Emprendedor", 3000));
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
    public static void mostrarMenu(String opcionesMenu){
        int cont=1;
        String[] items=opcionesMenu.split(",");
        for (String opcion: items){
            System.out.println(cont+" "+opcion);
            cont++;
        }
    }
    //metodo de inicio de sesion
    public static boolean IniciarSesion(Usuario usu){
     for (Usuario u:lusuarios){
        
            if (u.equals(usu)==true) {
                
                return true; 
            }
        } 
     return false;
    }
    //metodo para obtener el indice del usuario dentro del arrrayList de usuario y asi poder verificar que tipo de usuario es
    public static Usuario ObtenerUsuario(Usuario usu){
             
            for (Usuario u:lusuarios){
            if (u.equals(usu)==true) {
                int indice=lusuarios.indexOf(u);
                return lusuarios.get(indice);
                }  
            
            } 
            return usu;
    }
    public static  void mostrarStockDisponible(){
        int cont=1;
        System.out.println("----------------------");
        for (Vehiculos v: vehiculosDisponibles){
            if (v.isSolicitado()==false){
                    System.out.println(cont +" "+v.toString());
                } 
            cont++;
                }  
        System.out.println("----------------------");
             
        }  
    public static void EnviaraTaller(SolicitudVenta solicitud){
        JefeTaller jefeTaller=new JefeTaller("","","","","");
 
        for (Usuario u :lusuarios){
                    if (u instanceof JefeTaller){
                        jefeTaller=(JefeTaller) u;
                        
                    } 
                } 
        VehiculosTaller vehiculoingresado=new VehiculosTaller((Clientes)solicitud.getEmisor(), solicitud.getVehiculoSolicitud());
        jefeTaller.getVehiculoPorEntregar().add(vehiculoingresado);
        vehiculoingresado.setEstadoinicialtaller(EstadosMecanico.TERMINADO);
        for (Usuario u :lusuarios){
                    if (u.equals(solicitud.getEmisor())){
                        Clientes cl=(Clientes) u;
                        cl.getVehiculosComprados().add(vehiculoingresado);
                    } 
                } 
        
        

        
        System.out.println("Su solicitud ha sido enviada al jefe de taller");
       
      } 
    public static void asignarCotizacionVendedor(SolicitudVenta sol){
            //La solicitud la instancia el cliente 
            //Sacar solo a los vendedores de la listade usuarios 
            Usuario vendedorRandom;
            ArrayList<Vendedor> vendedores=new ArrayList<>();
            for (Usuario u :lusuarios){
                    if (u instanceof Vendedor){
                        Vendedor v=(Vendedor) u;
                        vendedores.add(v);
                     
                    } 
                } 
            
            //De esos objetos sacar uno aleatoriamente
            int numero = (int)(Math.random()*(vendedores.size()));
            //Vendedor Random
            vendedorRandom=vendedores.get(numero);
            //Sacar objeto real 
            if (lusuarios.contains(vendedorRandom)){
                int indice=lusuarios.indexOf(vendedorRandom);
                lusuarios.get(indice).getBuzonMensajes().add(sol);
                sol.setVendedorAsignado((Vendedor)lusuarios.get(indice));
                System.out.println("Su solicitud ha sido asignada a :"+lusuarios.get(indice).getNames()+" El estado actual de su solicitud es: "+sol.getEstado());
                } 
            
            
        } 
    public static void asignarVentaSupervisor(SolicitudVenta sol){
            //La solicitud la instancia el cliente 
            //Sacar solo a los vendedores de la listade usuarios 
            Supervisor supervisorLocal=new Supervisor("","", "", "","");
    
            for (Usuario u :lusuarios){
                    if (u instanceof Supervisor){
                        supervisorLocal=(Supervisor) u;
                    } 
                } 
            for (Vehiculos v :vehiculosDisponibles){
                    if (v.equals(sol.getVehiculoSolicitud())==true){
                        v.setSolicitado(true);
                    } 
                } 
            
            //Sacar objeto real 
            if (lusuarios.contains(supervisorLocal)){
                int indice=lusuarios.indexOf(supervisorLocal);
                lusuarios.get(indice).getBuzonMensajes().add(sol);
                System.out.println("Su solicitud ha sido asignada a :"+lusuarios.get(indice).getNames()+" El estado actual de su solicitud es: "+sol.getEstadoAceptacionSupervisor());
                }  
            
        } 
            
    }    


