package burgerking;

import java.io.IOException;
import java.util.ArrayList;

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
        ArrayList<Pedido> pedidos = sistema.getPedidos();
        EntradaSalida.mostrarTexto("Bienvenido Cocinero: " + getUser() + "\n");
        Boolean sesion = true;

        while (sesion) {
            int eleccion_cocinero = EntradaSalida.leerNro("CONSULTAR PEDIDOS: \n"
                    + "1_INCOMPLETOS\n"
                    + "2_COMPLETOS\n"
                    + "3_TODOS\n"
                    + "4_DESPACHAR PEDIDO\n"
                    + "5_CERRAR SESION\n");

            switch (eleccion_cocinero) {
                case 1:
                    sistema.consultarPedidos("INCOMPLETO");
                    break;
                case 2:
                    sistema.consultarPedidos("COMPLETO");
                    break;
                case 3:
                    sistema.consultarPedidos("TODOS");
                    break;
                case 4:
                    String idPedido = EntradaSalida.leerString("Ingrese el ID del pedido listo para despachar: ");
                    sistema.actualizarComanda(idPedido);  // Llama al metodo para actualizar el estado

                    // Serializa el sistema para guardar el cambio
                    try {
                        sistema.serializar("base_de_datos.txt");
                    } catch (IOException e) {
                        EntradaSalida.mostrarTexto("Error al guardar los cambios en el archivo.");
                    }
                    break;
                case 5:
                    sesion = false;
                    break;
                default:
                    EntradaSalida.mostrarTexto("Opcion no valida. Por favor, elija una opcion del 1 al 5.");
                    break;
            }
        }

        return false;
    }

}
