/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package burgerking;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ariel
 */
public class Sistema implements Serializable{
    
    private ArrayList<Persona> empleado;

    public Sistema() {
        empleado = new ArrayList<Persona>();
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
        Sistema s = (Sistema)o.readObject();//se debe castear al objeto que se desea leer
        o.close();
        f.close();
        return s;
    }
    
    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);//este objeto SistemaInscripcion
        o.close();
        f.close();
    }
    
    public Persona buscarEmpleado(String usuario, String contraseña){
            Persona p = null;
            int i = 0;
            int tamArray = empleado.size();
            boolean flag = false;
            
            while(i < tamArray){
                p = empleado.get(i);
                
                if(usuario.equals(p.getUser()) && contraseña.equals(p.getPassword())){
                   flag = true;
                   i = tamArray;
                }else{
                    i++; 
                }
            }
            
            return (!flag?p=null:p);
    }
}
