
package burgerking;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;

/**
 *
 * @author nicol
 */
public class Pedido implements Serializable {
    private String id;
    private LocalDate fecha;
    private ArrayList<Hamburguesa> hamburguesas;
    private ArrayList<Bebida> bebidas;
    private ArrayList<Papas> papas;

    // Constructor
    public Pedido(String id) {
        this.id = id;
        this.fecha = LocalDate.now();
        this.hamburguesas = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.papas = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public ArrayList<Hamburguesa> getHamburguesas() {
        return hamburguesas;
    }

    public void setHamburguesas(ArrayList<Hamburguesa> hamburguesas) {
        this.hamburguesas = hamburguesas;
    }

    public ArrayList<Bebida> getBebidas() {
        return bebidas;
    }

    public void setBebidas(ArrayList<Bebida> bebidas) {
        this.bebidas = bebidas;
    }

    public ArrayList<Papas> getPapas() {
        return papas;
    }

    public void setPapas(ArrayList<Papas> papas) {
        this.papas = papas;
    }
    
    public void pedidoSimple(){
        Hamburguesa hamburguesa = new Hamburguesa(1,1,1,1,1);
        Bebida bebida = new Bebida();
        Papas papas = new Papas("Regulares");
    }
    
    public void pedidoDoble(){
        Hamburguesa hamburguesa = new Hamburguesa(2,2,2,2,2);
        Bebida bebida = new Bebida();
        Papas papas = new Papas("Regulares");
    }
    
    public void pedidoTriple(){
        Hamburguesa hamburguesa = new Hamburguesa(3,3,3,3,3);
        Bebida bebida = new Bebida();
        Papas papas = new Papas("Regulares");
    }

}
