package burgerking;
/**
 * 
 * @author Nicolas Guinzio & Ariel Risoluto.
 */
public class Inspectores extends Persona{

    public Inspectores(String user, String password) {
        setUser(user);
        setPassword(password);
    }

    @Override
    public boolean trabajar(Sistema sistema) {
        EntradaSalida.mostrarTexto("ver datos...");
        return false;
    }
    
    
   
}
