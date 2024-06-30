package burgerking;

import java.io.Serializable;
import java.util.ArrayList;
import java.time.LocalDate;

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
        this.id = id;
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

    public void mostrarPedido() {
        EntradaSalida.limpiarPantalla();

        StringBuilder sb = new StringBuilder();
        sb.append("******************* BURGER KING *******************\n")
                .append("Fecha: ").append(fecha).append("\n")
                .append("ID: ").append(id).append("\n\n")
                .append("Detalles del Pedido:\n");

        for (int i = 0; i < hamburguesas.size(); i++) {

            Hamburguesa hamburguesa = hamburguesas.get(i);
            sb.append("Pedido: ");
            hamburguesa.mostrarHamburguesa(sb);

            Bebida bebida = bebidas.get(i);
            sb.append("Bebida: ").append(bebida.getSabor()).append("\n");

            Papa papa = papas.get(i);
            sb.append("Papas: ").append(papa.getTamanio()).append("\n\n");
        }

        sb.append("Precio Total: $").append(getPrecio()).append("\n")
                .append("***************************************************");
        EntradaSalida.mostrarTexto(sb.toString());
    }

    
}