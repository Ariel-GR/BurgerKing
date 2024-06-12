/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgerking;

import java.io.IOException;

/**
 *
 * @author Ariel
 */
public class Administrador extends Persona {

    public Administrador(String user, String password) {
        setUser(user);
        setPassword(password);
    }
    
    @Override
    public boolean trabajar(Sistema sistema) {
        System.out.println("Bienvenido Administrador: ");
        int opcion;
        boolean validar = false;

        do {
            opcion = EntradaSalida.leerNro(
                    "1- Ingresar Vendedor\n"
                    + "2-Ingresar Cocinero\n"
                    + "3-Ingresar Gerente\n"
                    + "4-Ingresar Inpector\n"
                    + "5-Salir");

            switch (opcion) {
                case 1:
                    String vendedorUser = EntradaSalida.leerString("Alta de VENDEDOR\nUsuario:");
                    String vendedorPassword = EntradaSalida.leerString("Contraseña:");
                    if (!vendedorUser.equals("") && !vendedorPassword.equals("")) {
                        Persona p = sistema.buscarEmpleado(vendedorUser,vendedorPassword);
                        if(p != null){
                            EntradaSalida.mostrarTexto("El usuario ya fue ingresado");
                        }else{
                            sistema.getEmpleado().add(new Vendedor(vendedorUser,vendedorPassword));
                            System.out.println("ingreso correcto");
                        }                       
                    } else {
                        System.out.println("\n***el usuario y/o la contraseña no pueden ser nulos***\n"
                                + "Por favor ingrese nuevamente\n");
                    }
                    break;
                case 5: validar = false ;
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
