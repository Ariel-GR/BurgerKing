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
    private int cont = 0;

    public void ingresar() {

        try {
            sistema = sistema.deSerializar("base_de_datos.txt");
            System.out.println("Bienvenido al sistema de BURGER KING");
            validar = EntradaSalida.siNo("Para ingresar al sistma -si- para salir -no- ");

        } catch (Exception ex) {
            EntradaSalida.mostrarTexto("\tARRANQUE DE SISTEMA\n\n");
            do {
                usuario = EntradaSalida.leerString("ingrese un administrador\nUsuario:");
                contraseña = EntradaSalida.leerString("Contrasenia:"); 
            }while (sistema.validarIngreso(usuario, contraseña));
            
            try {
                        sistema.getEmpleado().add(new Administrador(usuario, contraseña));
                        sistema.serializar("base_de_datos.txt");
                        EntradaSalida.mostrarTexto("El administrador fue ingresado correctamente por favor reincie el sistema");
                    } catch (IOException e) {}
        }

        while (validar) {
            usuario = EntradaSalida.leerString("Usuario: ");
            contraseña = EntradaSalida.leerString("Contrasenia: ");

            if(!sistema.validarIngreso(usuario, contraseña)){
                Persona p = sistema.buscarUsuario(usuario+":"+contraseña);
                if(p == null){
                    EntradaSalida.mostrarTexto("\nUsuario NO encontrado\n");
                    cont++;
                System.out.println(cont);
                if(cont == 5){
                    validar = false;
                    EntradaSalida.mostrarTexto("NUMERO DE INTENTOS EXCEDIDO\n"
                                               +"POR FAVOR COMUNIQUESE CON UN ADMINISTRADOR \n"
                                               + "O VERIFIQUE SUS CREDENCIALES");
                }
                }else{
                    validar = p.trabajar(sistema);
                    if(EntradaSalida.siNo("¿Desea volver ingresar ? si/no")){
                        validar = true;
                    }  
                }
            }
     
        }
        EntradaSalida.mostrarTexto("Sea finalizado el programa.");
    }
}
