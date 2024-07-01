package burgerking;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;

public class Pedido implements Serializable {

    private String id;
    private String cliente;
    private LocalDate fecha;
    private float precio;
    private String estado;
    private ArrayList<Hamburguesa> hamburguesas;
    private ArrayList<Bebida> bebidas;
    private ArrayList<Papa> papas;

    // Constructor
    public Pedido(String id) {
        this.id = id;
        this.fecha = LocalDate.now();
        this.cliente = cliente;
        this.precio = 0;  // Inicializar el precio a 0
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

    public void agregarCombo(String nombre, int carne, int cebolla, int lechuga, int tomate, int queso, String tamanioPapa, float precio) {
        Hamburguesa hamburguesa = new Hamburguesa(nombre, carne, cebolla, lechuga, tomate, queso);
        Bebida bebida = new Bebida();
        Papa papa = new Papa(tamanioPapa);
        this.hamburguesas.add(hamburguesa);
        this.bebidas.add(bebida);
        this.papas.add(papa);
        this.precio += precio; // Sumar el precio del combo al precio total del pedido
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    
}
