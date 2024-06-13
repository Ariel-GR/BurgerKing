package burgerking;
/**
 * 
 * @author Nicolas Guinzio & Ariel Risoluto.
 */
public class Vendedor extends Persona {

    public Vendedor(String user, String password) {
        setUser(user);
        setPassword(password);
    }

    @Override
    public boolean trabajar(Sistema sistema) {
        System.out.println("vender...");
        return false;
    }

}
