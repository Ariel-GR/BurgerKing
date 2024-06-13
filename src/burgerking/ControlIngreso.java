/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgerking;

import java.io.IOException;

/**
 * 
 * @author Nicolas Guinzio & Ariel Risoluto.
 */
public class ControlIngreso {

    Sistema sistema = new Sistema();
    
    private String usuario;
    private String contraseña;
    private boolean validar;

    public void ingresar() {

        try {
            sistema = sistema.deSerializar("base_empleados.txt");
            System.out.println("Bienvenido al sistema de BURGER KING");
            validar = EntradaSalida.siNo("Para ingresar al sistma -si- para salir -no- ");

        } catch (Exception ex) {
            do {
                usuario = EntradaSalida.leerString("\tARRANQUE DE SISTEMA\n\n" + "ingrese un administrador\nUsuario:");
                contraseña = EntradaSalida.leerString("Contraseña:");
                
                /*
                if (!usuario.equals("") && !contraseña.equals("")) {
                    
                    try {
                        sistema.getEmpleado().add(new Administrador(usuario, contraseña));
                        sistema.serializar("base_empleados.txt");
                        System.out.println("---ingreso correcto---\n");
                    } catch (IOException e) {
                    }
                } else {
                    System.out.println("\n***el usuario y/o la contraseña no pueden ser nulos***\n"
                            + "Por favor ingrese nuevamente\n");
                }*/
                if(EntradaSalida.ingresarUsuario(usuario, contraseña, sistema)){
                    try {
                        sistema.getEmpleado().add(new Administrador(usuario, contraseña));
                        sistema.serializar("base_empleados.txt");
                        System.out.println("---ingreso correcto---\n");
                    } catch (IOException e) {
                    }
                }
            } while (contraseña.equals("") || usuario.equals(""));
            System.out.println("El administrador fue ingresado correctamente por favor reincie el sistema");
        }

        while (validar) {
            usuario = EntradaSalida.leerString("Usuraio: ");
            contraseña = EntradaSalida.leerString("Contraseña: ");
            
            /*
            if (!usuario.equals("") && !contraseña.equals("")) {
               
                Persona p = sistema.buscarUsuario(usuario,contraseña);
                if(p == null){
                    System.out.println("usario no encontrado");
                }else{
                    System.out.println("ingreso correcto");
                    validar = p.trabajar(sistema); 
                }  
            } else{
                System.out.println("\n***el usuario y/o la contraseña no pueden ser nulos***\n"
                        + "Por favor ingrese nuevamente\n");
            }*/
            
            if(!EntradaSalida.ingresarUsuario(usuario, contraseña, sistema)){
                System.out.println("ingreso correcto");
                Persona p = sistema.buscarUsuario(usuario,contraseña);
                validar = p.trabajar(sistema);
            }else{
                EntradaSalida.mostrarTexto("usuario no encontrado");
            }
        }

    }
}
