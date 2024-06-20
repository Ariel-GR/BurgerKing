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
public class Administrador extends Persona {

    public Administrador(String user, String password) {
        setUser(user);
        setPassword(password);
    }
    
    @Override
    public boolean trabajar(Sistema sistema) {
        System.out.println("Bienvenido Administrador\n\n");
        
        int opcion;
        boolean validar = false;
        String usuarioNuevo;
        String contraseñaNueva;
        
        do {
            opcion = EntradaSalida.leerNro(
                    "\tMENU\n"
                    + "1 - Ingresar Vendedor\n"
                    + "2 - Ingresar Cocinero\n"
                    + "3 - Ingresar Gerente\n"
                    + "4 - Ingresar Inpector\n"
                    + "5 - Finalizar Carga");

            switch (opcion) {
                case 1:
                    usuarioNuevo = EntradaSalida.leerString("Alta de VENDEDOR\nUsuario:");
                    contraseñaNueva = EntradaSalida.leerString("Contraseña:");
                    
                    if(!sistema.validarIngreso(usuarioNuevo,contraseñaNueva)){
                        Persona p = sistema.buscarUsuario(usuarioNuevo+":"+contraseñaNueva);
                        if(p == null){
                            sistema.getEmpleado().add(new Vendedor(usuarioNuevo,contraseñaNueva));
                            System.out.println("---ingreso correcto del VENDEDOR: "+usuarioNuevo+"---\n");
                        }else{
                            EntradaSalida.mostrarTexto("\n***No se puede dar de alta, el USUARIO: "+usuarioNuevo+" ya fue ingresado***\n");
                        }
                    }
                    break;
                case 2:
                    usuarioNuevo = EntradaSalida.leerString("Alta de COCINERO\nUsuario:");
                    contraseñaNueva = EntradaSalida.leerString("Contraseña:");
                    
                    if(!sistema.validarIngreso(usuarioNuevo,contraseñaNueva)){
                        Persona p = sistema.buscarUsuario(usuarioNuevo+":"+contraseñaNueva);
                        if(p == null){
                            sistema.getEmpleado().add(new Cocineros(usuarioNuevo,contraseñaNueva));
                            System.out.println("---ingreso correcto del VENDEDOR: "+usuarioNuevo+"---\n");
                        }else{
                            EntradaSalida.mostrarTexto("\n***No se puede dar de alta, el USUARIO: "+usuarioNuevo+" ya fue ingresado***\n");
                        }
                    }
                    break;
                case 3:
                    usuarioNuevo = EntradaSalida.leerString("Alta de GERENTE\nUsuario:");
                    contraseñaNueva = EntradaSalida.leerString("Contraseña:");
                    
                    if(!sistema.validarIngreso(usuarioNuevo,contraseñaNueva)){
                        Persona p = sistema.buscarUsuario(usuarioNuevo+":"+contraseñaNueva);
                        if(p == null){
                            sistema.getEmpleado().add(new Gerentes(usuarioNuevo,contraseñaNueva));
                            System.out.println("---ingreso correcto del VENDEDOR: "+usuarioNuevo+"---\n");
                        }else{
                            EntradaSalida.mostrarTexto("\n***No se puede dar de alta, el USUARIO: "+usuarioNuevo+" ya fue ingresado***\n");
                        }
                    }
                    break;
                case 4:
                    usuarioNuevo = EntradaSalida.leerString("Alta de INSPECTOR\nUsuario:");
                    contraseñaNueva = EntradaSalida.leerString("Contraseña:");
                    
                    if(!sistema.validarIngreso(usuarioNuevo,contraseñaNueva)){
                        Persona p = sistema.buscarUsuario(usuarioNuevo+":"+contraseñaNueva);
                        if(p == null){
                            sistema.getEmpleado().add(new Inspectores(usuarioNuevo,contraseñaNueva));
                            System.out.println("---ingreso correcto del VENDEDOR: "+usuarioNuevo+"---\n");
                        }else{
                            EntradaSalida.mostrarTexto("\n***No se puede dar de alta, el USUARIO: "+usuarioNuevo+" ya fue ingresado***\n");
                        }
                    }
                    break;
            }
            
            if(opcion>=1 && opcion<5){
                try{
                    sistema.serializar("base_empleados.txt");
                }catch(Exception e){
                    System.out.println("error grabar archivo");
                }
            }      
        } while (opcion != 5);
        
         return validar;
    }
}
