/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgerking;

import static burgerking.EntradaSalida.mostrarTexto;
import burgerking.Pedido;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nicolas Guinzio & Ariel Risoluto.
 */
public class Sistema implements Serializable {

    private ArrayList<Persona> empleado;
    private ArrayList<Pedido> pedidos;

    public Sistema() {
        empleado = new ArrayList<>();
        pedidos = new ArrayList<>();
    }

    public ArrayList<Persona> getEmpleado() {
        return empleado;
    }

    public void setEmpleado(ArrayList<Persona> empleado) {
        this.empleado = empleado;
    }

    public Sistema deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        Sistema s = (Sistema) o.readObject();//se debe castear al objeto que se desea leer
        o.close();
        f.close();
        return s;
    }

    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    public Persona buscarUsuario(String credenciales) {

        for (Persona p : empleado) {
            if (p.encontrarCredenciales(credenciales)) {
                EntradaSalida.mostrarTexto("\n---Usuario Encontrado---\n");
                return p;
            }
        }
        return null;
    }

    public static boolean validarIngreso(String user, String pass) {
        boolean validar = (user.equals("") || pass.equals(""));

        if (validar) {
            EntradaSalida.mostrarTexto("\n***el usuario y/o la contraseña no pueden ser nulos***\n"
                    + "Por favor ingrese nuevamente\n");
        }

        return validar;
    }

    public void listaPorRoles(String referencia) {

        for (int i = 0; i < empleado.size(); i++) {

            try {
                if (empleado.get(i).getClass() == Class.forName(referencia)) {
                    mostrarTexto("\t\t" + empleado.get(i).getUser());
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EntradaSalida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String buscarPorRol(String usuario) throws ClassNotFoundException {

        String rol = null;

        for (int i = 0; i < empleado.size(); i++) {

            if (empleado.get(i).getUser().equals(usuario)) {
                if (empleado.get(i).getClass() == Class.forName("burgerking.Administrador")) {
                    rol = "Administrador";
                } else if (empleado.get(i).getClass() == Class.forName("burgerking.Cocineros")) {
                    rol = "Cocinero";
                } else if (empleado.get(i).getClass() == Class.forName("burgerking.Vendedor")) {
                    rol = "Vendedor";
                } else if (empleado.get(i).getClass() == Class.forName("burgerking.Gerentes")) {
                    rol = "Gerente";
                } else if (empleado.get(i).getClass() == Class.forName("burgerking.Inspectores")) {
                    rol = "Inspector";
                }
            }
        }
        return rol;
    }

    public void modificarRol(String user, String rol) {

        String pass = null;
        int index = 0;

        for (int i = 0; i < empleado.size(); i++) {
            if (empleado.get(i).getUser().equals(user)) {
                pass = empleado.get(i).getPassword();
                index = i;
            }
        }

        switch (rol) {
            case "Vendedor":
                if (EntradaSalida.siNo("Roles disponibles: \n\t+Cocinero\nPara efectuar el cambio ingrese -si- caso contrario -no-:")) {
                    getEmpleado().set(index, new Cocineros(user, pass));
                    try {
                        serializar("base_empleados.txt");
                    } catch (IOException e) {
                        EntradaSalida.mostrarTexto("error grabar archivo");
                    }
                    EntradaSalida.mostrarTexto("\n---MODIFICACION DE ROL REALIZADA---");
                }
                break;
            case "Cocinero":
                if (EntradaSalida.siNo("Roles disponibles: \n\t+Vendedor\nPara efectuar el cambio ingrese -si- caso contrario -no-:")) {
                    getEmpleado().set(index, new Vendedor(user, pass));
                    try {
                        serializar("base_de_datos.txt");
                    } catch (IOException e) {
                        EntradaSalida.mostrarTexto("error grabar archivo");
                    }
                    EntradaSalida.mostrarTexto("\n---MODIFICACION DE ROL REALIZADA---");
                }
                break;
        }
    }

    public boolean altaUsuario() {
        int opcion;
        boolean seguir = false;

        while ((opcion = EntradaSalida.menuAlta()) != 5) {
            String usuarioNuevo = EntradaSalida.leerString("Usuario:");
            String contraseñaNueva = EntradaSalida.leerString("Contraseña:");
            if (!validarIngreso(usuarioNuevo, contraseñaNueva)) {
                Persona p = buscarUsuario(usuarioNuevo + ":" + contraseñaNueva);
                if (p == null) {
                    switch (opcion) {
                        case 1:
                            getEmpleado().add(new Vendedor(usuarioNuevo, contraseñaNueva));
                            EntradaSalida.mostrarTexto("---ingreso correcto del VENDEDOR: " + usuarioNuevo + "---\n");
                            break;
                        case 2:
                            getEmpleado().add(new Cocineros(usuarioNuevo, contraseñaNueva));
                            EntradaSalida.mostrarTexto("---ingreso correcto del COCINERO: " + usuarioNuevo + "---\n");
                            break;
                        case 3:
                            getEmpleado().add(new Gerentes(usuarioNuevo, contraseñaNueva));
                            EntradaSalida.mostrarTexto("---ingreso correcto del GERENTE: " + usuarioNuevo + "---\n");
                            break;
                        case 4:
                            getEmpleado().add(new Inspectores(usuarioNuevo, contraseñaNueva));
                            EntradaSalida.mostrarTexto("---ingreso correcto del INSPECTOR: " + usuarioNuevo + "---\n");
                            break;
                    }
                    try {
                        serializar("base_de_datos.txt");
                    } catch (Exception e) {
                        EntradaSalida.mostrarTexto("error grabar archivo");
                    }

                } else {
                    EntradaSalida.mostrarTexto("\n***No se puede dar de alta, el USUARIO: " + usuarioNuevo + " ya fue ingresado***\n");
                }
            }
        }

        return seguir;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void consultarPedidos(String estado) {
        EntradaSalida.limpiarPantalla();

        boolean hayPedidos = false;
        StringBuilder sb = new StringBuilder();
        sb.append("********** CONSULTA DE PEDIDOS **********\n\n");

        for (Pedido pedido : pedidos) {
            if ("TODOS".equalsIgnoreCase(estado) || pedido.getEstado().equalsIgnoreCase(estado)) {
                hayPedidos = true;
                sb.append("ID del Pedido: ").append(pedido.getId()).append("\n")
                        .append("Fecha: ").append(pedido.getFecha()).append("\n")
                        .append("Precio Total: $").append(pedido.getPrecio()).append("\n")
                        .append("Estado: ").append(pedido.getEstado()).append("\n")
                        .append("Detalles del Pedido:\n");

                for (int i = 0; i < pedido.getHamburguesas().size(); i++) {
                    sb.append("Combo ").append(i + 1).append(":\n");

                    Hamburguesa hamburguesa = pedido.getHamburguesas().get(i);
                    sb.append("Hamburguesa:\n");
                    hamburguesa.mostrarHamburguesa(sb);

                    Bebida bebida = pedido.getBebidas().get(i);
                    sb.append("Bebida: ").append(bebida.getSabor()).append("\n");

                    Papa papa = pedido.getPapas().get(i);
                    sb.append("Papas: ").append(papa.getTamanio()).append("\n\n");
                }

                sb.append("----------------------------------------\n\n");
            }
        }

        if (!hayPedidos) {
            sb.append("No hay pedidos en el estado solicitado en este momento.\n");
        }

        sb.append("***************************************");

        EntradaSalida.mostrarTexto(sb.toString());
    }

    public void mostrarPedidoPorId(String id) {
        Pedido pedido = null;

        // Busco el pedido con el ID 
        for (Pedido p : pedidos) {
            if (p.getId().equals(id)) {
                pedido = p;
                break;
            }
        }

        if (pedido != null) {
            EntradaSalida.mostrarTexto("********** DETALLES DEL PEDIDO **********\n\n");
            EntradaSalida.mostrarTexto("ID del Pedido: " + pedido.getId() + "\t");
            EntradaSalida.mostrarTexto("Fecha: " + pedido.getFecha());
            EntradaSalida.mostrarTexto("Estado: " + pedido.getEstado());
            EntradaSalida.mostrarTexto("Detalles del Pedido:\n");

            for (int i = 0; i < pedido.getHamburguesas().size(); i++) {
                Hamburguesa hamburguesa = pedido.getHamburguesas().get(i);
                EntradaSalida.mostrarTexto("\t-----" + hamburguesa.getCombo() + "-----");

                StringBuilder hamburguesaDetalles = new StringBuilder();
                hamburguesa.mostrarHamburguesa(hamburguesaDetalles);
                EntradaSalida.mostrarTexto(hamburguesaDetalles.toString());

                Bebida bebida = pedido.getBebidas().get(i);
                EntradaSalida.mostrarTexto("Bebida: " + bebida.getSabor() + "\n");

                Papa papa = pedido.getPapas().get(i);
                EntradaSalida.mostrarTexto("Papas: " + papa.getTamanio() + "\n\n");
            }
            EntradaSalida.mostrarTexto("--------------------------------\n");

            EntradaSalida.mostrarTexto("Precio Total: $" + pedido.getPrecio() + "\n");

            EntradaSalida.mostrarTexto("***************************************");
        } else {
            EntradaSalida.mostrarTexto("No se encontró el pedido con el ID: " + id);
        }
    }

    public void actualizarComanda(String id) {
        Pedido pedido = null;

        // Busco el pedido con el ID 
        for (Pedido p : pedidos) {
            if (p.getId().equals(id)) {
                pedido = p;
                break;
            }
        }

        if (pedido != null) {
            // Cambia el estado del pedido a "COMPLETO"
            pedido.setEstado("COMPLETO");
            EntradaSalida.mostrarTexto("Estado del pedido con ID " + id + " actualizado a COMPLETO.");

            // Aquí se puede serializar si se quiere, pero en el caso del cocinero, se realiza en el método `trabajar`
        } else {
            EntradaSalida.mostrarTexto("No se encontró el pedido con el ID: " + id);
        }
    }

}
