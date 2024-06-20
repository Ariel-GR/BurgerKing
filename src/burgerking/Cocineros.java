package burgerking;
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
        return false;
    }
    
    
}
