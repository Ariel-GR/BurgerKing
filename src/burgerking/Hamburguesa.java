/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgerking;

import java.io.Serializable;

/**
 *
 * @author nicol
 */
public class Hamburguesa implements Serializable {

    private String combo;
    private int carne;
    private int cebolla;
    private int lechuga;
    private int tomate;
    private int queso;

    public Hamburguesa(String combo, int carne, int cebolla, int lechuga, int tomate, int queso) {
        this.combo = combo;
        this.carne = carne;
        this.cebolla = cebolla;
        this.lechuga = lechuga;
        this.queso = queso;
        this.tomate = tomate;
    }

    public int getCarne() {
        return carne;
    }

    public void setCarne(int carne) {
        this.carne = carne;
    }

    public int getCebolla() {
        return cebolla;
    }

    public String getCombo() {
        return combo;
    }

    public void setCombo(String combo) {
        this.combo = combo;
    }

    public void setCebolla(int cebolla) {
        this.cebolla = cebolla;
    }

    public int getLechuga() {
        return lechuga;
    }

    public void setLechuga(int lechuga) {
        this.lechuga = lechuga;
    }

    public int getTomate() {
        return tomate;
    }

    public void setTomate(int tomate) {
        this.tomate = tomate;
    }

    public int getQueso() {
        return queso;
    }

    public void setQueso(int queso) {
        this.queso = queso;
    }

    public void mostrarHamburguesa(StringBuilder sb) {
        int baseCantidad = 0;
        if (getCombo().equalsIgnoreCase("Combo Simple")) {
            baseCantidad = 1;
        } else if (getCombo().equalsIgnoreCase("Combo Doble")) {
            baseCantidad = 2;
        } else if (getCombo().equalsIgnoreCase("Combo Triple")) {
            baseCantidad = 3;
        }

        int carneExtra = getCarne() - baseCantidad;
        int cebollaExtra = getCebolla() - baseCantidad;
        int lechugaExtra = getLechuga() - baseCantidad;
        int tomateExtra = getTomate() - baseCantidad;
        int quesoExtra = getQueso() - baseCantidad;

        sb.append(getCombo() + "\n")
        .append(String.format("%-10s %-10s %-10s %-10s %-10s\n", "Carne", "Cebolla", "Lechuga", "Tomate", "Queso"))
        .append(String.format("%-10d %-10d %-10d %-10d %-10d\n",
                (carneExtra > 0 ? carneExtra : 0),
                (cebollaExtra > 0 ? cebollaExtra : 0),
                (lechugaExtra > 0 ? lechugaExtra : 0),
                (tomateExtra > 0 ? tomateExtra : 0),
                (quesoExtra > 0 ? quesoExtra : 0)))
        .append("\n");
    }

}
