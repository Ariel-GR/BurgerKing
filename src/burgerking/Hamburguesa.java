/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgerking;

/**
 *
 * @author nicol
 */
public class Hamburguesa {
    private int carne;
    private int cebolla;   
    private int lechuga;
    private int tomate;
    private int queso;

    public Hamburguesa(int carne,int cebolla,int lechuga, int tomate, int queso){
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
    
    
    
}
