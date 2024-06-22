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
        EntradaSalida.mostrarTexto("Tomar pedido...");
        tomarPedido();
        return false;
    }
    
    
    private void tomarPedido() {

    Pedido pedido = new Pedido(EntradaSalida.leerString("Ingrese el nombre del cliente:"));
        
    int opcionCombo = EntradaSalida.leerNro("Bienvenido al sistema de pedidos.\n"
    + "Por favor, seleccione el combo que desea ordenar:\n"
    + "1. Combo Simple\n"
    + "2. Combo Doble\n"
    + "3. Combo Triple\n");

    switch (opcionCombo) {
        case 1:
            EntradaSalida.mostrarTexto("Ha seleccionado el Combo Simple.");
            pedido.pedidoSimple();
            break;
        case 2:
            EntradaSalida.mostrarTexto("Ha seleccionado el Combo Doble.");
            pedido.pedidoDoble();
            break;
        case 3:
            EntradaSalida.mostrarTexto("Ha seleccionado el Combo Triple.");
            pedido.pedidoTriple();
            break;
        default:
            EntradaSalida.mostrarTexto("Opción inválida.");
            return;
    }
    
     // Mostrar lista de ingredientes disponibles
    //EntradaSalida.mostrarTexto("\n\nIngredientes disponibles:");
    //for (int i = 0; i < INGREDIENTES_DISPONIBLES.length; i++) {
    //    EntradaSalida.mostrarTexto((i + 1) + ". " + INGREDIENTES_DISPONIBLES[i]);
    //}
    
    
    // Permitir al cliente agregar ingredientes
    String opcionAgregar = EntradaSalida.leerString("¿Desea agregar ingredientes? (si/no)");
    if (opcionAgregar.equals("si")) {
        int opcionIngrediente = EntradaSalida.leerNro("Seleccione el número del ingrediente que desea agregar:");
        // Lógica para agregar el ingrediente seleccionado
    }

    // Permitir al cliente quitar ingredientes
    String opcionQuitar = EntradaSalida.leerString("¿Desea quitar ingredientes? (si/no)");
    if (opcionQuitar.equals("si")) {
        int opcionIngrediente = EntradaSalida.leerNro("Seleccione el número del ingrediente que desea quitar:");
        // Lógica para quitar el ingrediente seleccionado
    }

    String opcionGaseosa = EntradaSalida.leerString("¿Desea cambiar el sabor de la gaseosa? (si/no)");
    if (opcionGaseosa.equals("si")) {
        // Lógica para cambiar el sabor de la gaseosa
    }

    String opcionPapas = EntradaSalida.leerString("¿Desea agregar papas? (si/no)");

    if (opcionPapas.equals("si")) {
        // Lógica para agregar papas
    }

    EntradaSalida.mostrarTexto("Pedido completado.");
}

}
