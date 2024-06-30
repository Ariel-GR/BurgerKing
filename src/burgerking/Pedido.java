package burgerking;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.UUID;

public class Pedido implements Serializable {

    private String id;
    private LocalDate fecha;
    private float precio;
    private String estado;
    private ArrayList<Hamburguesa> hamburguesas;
    private ArrayList<Bebida> bebidas;
    private ArrayList<Papa> papas;

    // Constructor
    public Pedido(String id) {
        this.id = id + "-" + UUID.randomUUID().toString(); // Generar ID único usando UUID
        this.fecha = LocalDate.now();
        this.precio = precio;
        this.hamburguesas = new ArrayList<>();
        this.bebidas = new ArrayList<>();
        this.papas = new ArrayList<>();
        this.estado = "INCOMPLETO";
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

    public ArrayList<Papa> getPapas() {
        return papas;
    }

    public void setPapas(ArrayList<Papa> papas) {
        this.papas = papas;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {

        this.precio += precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void agregarComboSimple() {
        Hamburguesa hamburguesa = new Hamburguesa("Combo Simple", 1, 1, 1, 1, 1);
        Bebida bebida = new Bebida();
        Papa papa = new Papa("Regular");
        this.hamburguesas.add(hamburguesa);
        this.bebidas.add(bebida);
        this.papas.add(papa);
        precio = 100;

    }

    public void agregarComboDoble() {
        Hamburguesa hamburguesa = new Hamburguesa("Combo Doble", 2, 2, 2, 2, 2);
        Bebida bebida = new Bebida();
        Papa papa = new Papa("Mediano");
        this.hamburguesas.add(hamburguesa);
        this.bebidas.add(bebida);
        this.papas.add(papa);
        precio = 150;

    }

    public void agregarComboTriple() {
        Hamburguesa hamburguesa = new Hamburguesa("Combo Triple", 3, 3, 3, 3, 3);
        Bebida bebida = new Bebida();
        Papa papa = new Papa("Grande");
        this.hamburguesas.add(hamburguesa);
        this.bebidas.add(bebida);
        this.papas.add(papa);
        precio = 200;
    }
    
}
