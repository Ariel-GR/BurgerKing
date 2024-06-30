package burgerking;

import java.util.ArrayList;

/**
 * 
 * @author Nicolas Guinzio & Ariel Risoluto.
 */
public class Cocineros extends Persona {

    public Cocineros(String user, String password) {
        setUser(user);
        setPassword(password);
    }

    @Override
    public boolean trabajar(Sistema sistema) {
        EntradaSalida.mostrarTexto("Tomar pedido y Cocinar");
        
        
        ArrayList<Pedido> pedidos = sistema.getPedidos();
        for (int i = 0; i< pedidos.size();i++) {
           Pedido pedido = pedidos.get(i);
           pedido.mostrarPedido();
            
        }
        return false;
    }
    
    
    
    
}
