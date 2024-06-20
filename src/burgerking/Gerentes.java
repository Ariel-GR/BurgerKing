package burgerking;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Nicolas Guinzio & Ariel Risoluto.
 */
public class Gerentes extends Persona {

    public Gerentes(String user, String password) {
        setUser(user);
        setPassword(password);
    }

    @Override
    public boolean trabajar(Sistema sistema) {
        EntradaSalida.mostrarTexto("Asignar Roles");
        String solicitud;
        String usuario;
        int opcion;
        
        do {
            opcion = EntradaSalida.leerNro("\n1 - consultar lista de VENDEDORES\n"
                                           +"2 - Consultar lista de COCINEROS\n"
                                           +"3 - Cambiar rol de usuario");
            switch(opcion){
                case 1: 
                    EntradaSalida.mostrarTexto("\tlista VENDEDORES\n");
                    sistema.listaPorRoles("burgerking.Vendedor");
                    break;
                case 2: 
                    EntradaSalida.mostrarTexto("\tlista COCINEROS\n");
                    sistema.listaPorRoles("burgerking.Cocineros");
                    break;
                case 3: 
                    solicitud = EntradaSalida.leerString("Ingrese el nombre del usaurio");
                    usuario = solicitud;
                    try {
                        solicitud = sistema.buscarPorRol(solicitud);
                        if(solicitud.equals("Administrador") || solicitud.equals("Gerente") || solicitud.equals("Inspector") || solicitud == null){
                            EntradaSalida.mostrarTexto("No es posible cambiar el rol del "+usuario+" ya que es un"+solicitud);
                        }else{
                            sistema.modificarRol(usuario,solicitud);
                        }
                        
                        
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Gerentes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
            }
            
        } while (opcion != 0);
        
        
            
        return false;
    }
    
}
