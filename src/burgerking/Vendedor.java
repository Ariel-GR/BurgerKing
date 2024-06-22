package burgerking;

/**
 * 
 * @author Nicolas Guinzio & Ariel Risoluto.
 */
import java.util.Scanner;

public class Vendedor extends Persona {
    private static final String[] INGREDIENTES_DISPONIBLES = {"Lechuga", "Tomate", "Cebolla", "Queso", "Tocino"};
    private Scanner scanner;
    public Vendedor(String user, String password) {
        setUser(user);
        setPassword(password);
        new Scanner(System.in);
    }

    @Override
    public boolean trabajar(Sistema sistema) {
        System.out.println("Tomar pedido...");
        tomarPedido();
        return false;
    }
    
    private void tomarPedido() {
    Scanner scanner = new Scanner(System.in);
    
   
    System.out.println("Bienvenido al sistema de pedidos.");
    System.out.println("Por favor, seleccione el combo que desea ordenar:");
    System.out.println("1. Combo Simple");
    System.out.println("2. Combo Doble");
    System.out.println("3. Combo Triple");

    int opcionCombo = scanner.nextInt();

    switch (opcionCombo) {
        case 1:
            System.out.println("Ha seleccionado el Combo Simple.");
            break;
        case 2:
            System.out.println("Ha seleccionado el Combo Doble.");
            break;
        case 3:
            System.out.println("Ha seleccionado el Combo Triple.");
            break;
        default:
            System.out.println("Opción inválida.");
            return;
    }
    
     // Mostrar lista de ingredientes disponibles
    System.out.println("\n\nIngredientes disponibles:");
    for (int i = 0; i < INGREDIENTES_DISPONIBLES.length; i++) {
        System.out.println((i + 1) + ". " + INGREDIENTES_DISPONIBLES[i]);
    }
    // Permitir al cliente agregar ingredientes
    System.out.println("¿Desea agregar ingredientes? (s/n)");
    char opcionAgregar = scanner.next().charAt(0);
    if (opcionAgregar == 's') {
        System.out.println("Seleccione el número del ingrediente que desea agregar:");
        int opcionIngrediente = scanner.nextInt();
        // Lógica para agregar el ingrediente seleccionado
    }

    // Permitir al cliente quitar ingredientes
    System.out.println("¿Desea quitar ingredientes? (s/n)");
    char opcionQuitar = scanner.next().charAt(0);
    if (opcionQuitar == 's') {
        System.out.println("Seleccione el número del ingrediente que desea quitar:");
        int opcionIngrediente = scanner.nextInt();
        // Lógica para quitar el ingrediente seleccionado
    }

    System.out.println("¿Desea cambiar el sabor de la gaseosa? (s/n)");
    char opcionGaseosa = scanner.next().charAt(0);
    if (opcionGaseosa == 's') {
        // Lógica para cambiar el sabor de la gaseosa
    }

    System.out.println("¿Desea agregar papas? (s/n)");
    char opcionPapas = scanner.next().charAt(0);
    if (opcionPapas == 's') {
        // Lógica para agregar papas
    }

    System.out.println("Pedido completado.");
}

}
