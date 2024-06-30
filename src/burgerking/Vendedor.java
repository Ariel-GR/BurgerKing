package burgerking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Vendedor extends Persona {

    private static final int OPCION_COMBO_SIMPLE = 1;
    private static final int OPCION_COMBO_DOBLE = 2;
    private static final int OPCION_COMBO_TRIPLE = 3;
    private static final int OPCION_INGREDIENTE_CARNE = 1;
    private static final int OPCION_INGREDIENTE_CEBOLLA = 2;
    private static final int OPCION_INGREDIENTE_LECHUGA = 3;
    private static final int OPCION_INGREDIENTE_TOMATE = 4;
    private static final int OPCION_INGREDIENTE_QUESO = 5;
    private static final int OPCION_SALIR = 6;

    public Vendedor(String user, String password) {
        setUser(user);
        setPassword(password);
    }

    @Override
    public boolean trabajar(Sistema sistema) {
        EntradaSalida.mostrarTexto("Tomar pedido...");
        tomarPedido(sistema);
        return true;  // Retorna true para indicar que el trabajo se completo
    }

    private void tomarPedido(Sistema sistema) {
        Pedido pedido = new Pedido(EntradaSalida.leerString("Ingrese el nombre del cliente:"));
        int i = 0;
        boolean flag = true;

        do {
            int opcionCombo = EntradaSalida.leerNro("Bienvenido al sistema de pedidos.\n"
                    + "Por favor, seleccione el combo que desea ordenar:\n"
                    + "1. Combo Simple\n"
                    + "2. Combo Doble\n"
                    + "3. Combo Triple\n");

            switch (opcionCombo) {
                case OPCION_COMBO_SIMPLE:
                    EntradaSalida.mostrarTexto("Ha seleccionado el Combo Simple.");
                    pedido.agregarComboSimple();
                    break;
                case OPCION_COMBO_DOBLE:
                    EntradaSalida.mostrarTexto("Ha seleccionado el Combo Doble.");
                    pedido.agregarComboDoble();
                    break;
                case OPCION_COMBO_TRIPLE:
                    EntradaSalida.mostrarTexto("Ha seleccionado el Combo Triple.");
                    pedido.agregarComboTriple();
                    break;
                default:
                    EntradaSalida.mostrarTexto("Opcion invalida.");
                    return;
            }

            ArrayList<Hamburguesa> hamburguesas = pedido.getHamburguesas();
            ArrayList<Bebida> bebidas = pedido.getBebidas();
            ArrayList<Papa> papas = pedido.getPapas();

            Hamburguesa hamburguesa = hamburguesas.get(i);

            String agregar_ingredientes_pregunta = EntradaSalida.leerString("Desea agregar un ingrediente? si/no");
            if (agregar_ingredientes_pregunta.equalsIgnoreCase("si")) {
                modificarIngrediente(hamburguesa, true, pedido);  // Agregar ingredientes

            }
            String quitar_ingredientes_pregunta = EntradaSalida.leerString("Desea quitar un ingrediente? si/no");
            if (quitar_ingredientes_pregunta.equalsIgnoreCase("si")) {

                modificarIngrediente(hamburguesa, false, pedido); // Quitar ingredientes

            }

            Bebida bebida = bebidas.get(i);
            seleccionarBebida(bebida, pedido);

            Papa papa = papas.get(i);
            modificarTamanioPapas(papa,pedido);

            bebidas.set(i, bebida);
            papas.set(i, papa);
            hamburguesas.set(i, hamburguesa);
            pedido.setBebidas(bebidas);
            pedido.setHamburguesas(hamburguesas);
            pedido.setPapas(papas);

            if (EntradaSalida.leerString("Desea agregar otro combo (si/no):").equals("si")) {
                i++;
            } else {
                flag = false;
            }

        } while (flag);

        EntradaSalida.mostrarTexto("Pedido completado.");
        pedido.mostrarPedido();

        sistema.getPedidos().add(pedido);

        try {
            sistema.serializar("base_de_datos.txt");
        } catch (IOException ex) {
            Logger.getLogger(Vendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void modificarIngrediente(Hamburguesa hamburguesa, boolean agregar, Pedido pedido) {

        while (true) {
            String opcion = EntradaSalida.leerString("""
                                                 Seleccione un ingrediente:
                                                 1_Carne
                                                 2_Cebolla
                                                 3_Lechuga
                                                 4_Tomate
                                                 5_Queso
                                                 6_Volver >""");

            int opcionIngrediente;
            try {
                opcionIngrediente = Integer.parseInt(opcion);
            } catch (NumberFormatException e) {
                EntradaSalida.mostrarTexto("Entrada invalida. Por favor ingrese un numero.");
                continue;
            }

            if (opcionIngrediente < 1 || opcionIngrediente > 6) {
                EntradaSalida.mostrarTexto("El numero seleccionado no corresponde a un ingrediente.");
                continue;
            }

            switch (opcionIngrediente) {
                case OPCION_INGREDIENTE_CARNE:
                    if (agregar) {
                        hamburguesa.setCarne(hamburguesa.getCarne() + 1);
                        EntradaSalida.mostrarTexto("Tu hamburguesa ahora tiene " + hamburguesa.getCarne() + " medallones de carne.\n");
                        pedido.setPrecio(20);

                    } else if (hamburguesa.getCarne() > 0) {
                        hamburguesa.setCarne(hamburguesa.getCarne() - 1);
                        EntradaSalida.mostrarTexto("Tu hamburguesa ahora tiene " + hamburguesa.getCarne() + " medallones de carne.");
                    } else {
                        EntradaSalida.mostrarTexto("No se pueden quitar mas medallones de carne.");
                    }
                    break;
                case OPCION_INGREDIENTE_CEBOLLA:
                    if (agregar) {
                        hamburguesa.setCebolla(hamburguesa.getCebolla() + 1);
                        EntradaSalida.mostrarTexto("Tu hamburguesa ahora tiene " + hamburguesa.getCebolla() + " laminas de cebolla.");
                        pedido.setPrecio(10);

                    } else if (hamburguesa.getCebolla() > 0) {
                        hamburguesa.setCebolla(hamburguesa.getCebolla() - 1);
                        EntradaSalida.mostrarTexto("Tu hamburguesa ahora tiene " + hamburguesa.getCebolla() + " laminas de cebolla.");
                    } else {
                        EntradaSalida.mostrarTexto("No se pueden quitar mas laminas de cebolla.");
                    }
                    break;
                case OPCION_INGREDIENTE_LECHUGA:
                    if (agregar) {
                        hamburguesa.setLechuga(hamburguesa.getLechuga() + 1);
                        EntradaSalida.mostrarTexto("Tu hamburguesa ahora tiene " + hamburguesa.getLechuga() + " hojas de lechuga.");
                        pedido.setPrecio(10);

                    } else if (hamburguesa.getLechuga() > 0) {
                        hamburguesa.setLechuga(hamburguesa.getLechuga() - 1);
                        EntradaSalida.mostrarTexto("Tu hamburguesa ahora tiene " + hamburguesa.getLechuga() + " hojas de lechuga.");
                    } else {
                        EntradaSalida.mostrarTexto("No se pueden quitar mas hojas de lechuga.");
                    }
                    break;
                case OPCION_INGREDIENTE_QUESO:
                    if (agregar) {
                        hamburguesa.setTomate(hamburguesa.getTomate() + 1);
                        EntradaSalida.mostrarTexto("Tu hamburguesa ahora tiene " + hamburguesa.getTomate() + " laminas de tomate.");
                        pedido.setPrecio(10);

                    } else if (hamburguesa.getTomate() > 0) {
                        hamburguesa.setTomate(hamburguesa.getTomate() - 1);
                        EntradaSalida.mostrarTexto("Tu hamburguesa ahora tiene " + hamburguesa.getTomate() + " laminas de tomate.");
                    } else {
                        EntradaSalida.mostrarTexto("No se pueden quitar mas laminas de tomate.");
                    }
                    break;
                case OPCION_INGREDIENTE_TOMATE:
                    if (agregar) {
                        hamburguesa.setQueso(hamburguesa.getQueso() + 1);
                        EntradaSalida.mostrarTexto("Tu hamburguesa ahora tiene " + hamburguesa.getQueso() + " laminas de queso.");
                        pedido.setPrecio(10);

                    } else if (hamburguesa.getQueso() > 0) {
                        hamburguesa.setQueso(hamburguesa.getQueso() - 1);
                        EntradaSalida.mostrarTexto("Tu hamburguesa ahora tiene " + hamburguesa.getQueso() + " laminas de queso.");
                    } else {
                        EntradaSalida.mostrarTexto("No se pueden quitar mas laminas de queso.");
                    }
                    break;
                case OPCION_SALIR:

                    break;
            }
            
            EntradaSalida.mostrarTexto("Precio actual: $" + pedido.getPrecio());
            String seguir = EntradaSalida.leerString("¿Desea modificar otro ingrediente? (si/no)");
            if (seguir.equalsIgnoreCase("no")) {
                break;
            }
        }
    }

    private void seleccionarBebida(Bebida bebida, Pedido pedido) {
        while (true) {
            int seleccion = EntradaSalida.leerNro("Seleccione su bebida:\n"
                    + "1_Agua\n"
                    + "2_Coca-Cola\n"
                    + "3_Cerveza\n");

            switch (seleccion) {
                case 1:
                    bebida.setSabor("Agua");
                    EntradaSalida.mostrarTexto("Has seleccionado Agua.");
                    pedido.setPrecio(10);

                    return;
                case 2:
                    bebida.setSabor("Coca-Cola");
                    EntradaSalida.mostrarTexto("Has seleccionado Coca-Cola.");
                    pedido.setPrecio(15);

                    return;
                case 3:
                    bebida.setSabor("Cerveza");
                    EntradaSalida.mostrarTexto("Has seleccionado Cerveza.");
                    pedido.setPrecio(20);

                    return;
                default:
                    EntradaSalida.mostrarTexto("Opcion invalida. Por favor seleccione una opcion valida.");
            }
            EntradaSalida.mostrarTexto("Precio actual: $" + pedido.getPrecio());
        }
        
    }

    private void modificarTamanioPapas(Papa papa,Pedido pedido) {
        while (true) {
            String tamanioActual = papa.getTamanio();
            EntradaSalida.mostrarTexto("Tamanio actual de las papas: " + tamanioActual);

            int opcion = EntradaSalida.leerNro("Desea modificar el tamanio de las papas?\n"
                    + "Seleccione una opcion:\n"
                    + "1_Mediano\n"
                    + "2_Grande\n"
                    + "3_No modificar\n");

            switch (opcion) {
                case 1:
                    if (tamanioActual.equals("Regular")) {
                        papa.setTamanio("Mediano");
                        EntradaSalida.mostrarTexto("Has cambiado el tamanio a Mediano.");
                        pedido.setPrecio(5);
                    } else {
                        EntradaSalida.mostrarTexto("No puedes reducir el tamanio a Mediano.");
                    }
                    return;
                case 2:
                    if (tamanioActual.equals("Regular") || tamanioActual.equals("Mediano")) {
                        papa.setTamanio("Grande");
                        pedido.setPrecio(10);
                        EntradaSalida.mostrarTexto("Has cambiado el tamanio a Grande.");
                    } else {
                        EntradaSalida.mostrarTexto("No puedes cambiar el tamanio a Grande desde " + tamanioActual + ".");
                    }
                    return;
                case 3:
                    EntradaSalida.mostrarTexto("No se han realizado cambios en el tamanio.");
                    return;
                default:
                    EntradaSalida.mostrarTexto("Opcion invalida. Por favor seleccione una opcion valida.");
            }
            EntradaSalida.mostrarTexto("Precio actual: $" + pedido.getPrecio());
        }
    }
}
