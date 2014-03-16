/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pablo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Pablo López
 * @author Miguel Diaz
 */
public class Nodo {
    String categoria;
    Nodo anterior;
    Nodo siguiente;
    ArrayList<String> frases;

    public ArrayList<String> getFrases() {
        return frases;
    }

    public void setFrases(ArrayList<String> frases) {
        this.frases = frases;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Constructor vacio, asigna a los atributos del objeto actual "0" o "null"
     * dependiendo del caso
     */
    public Nodo() {
    }  
    public Nodo(String categoria, ArrayList<String> frases, Nodo anterior, Nodo siguiente){
        this.categoria=categoria;
        this.frases=frases;
        this.anterior = anterior;
        this.siguiente = siguiente;
        
    }
    /**
     * Retorna el nodo predecesor del objeto actual
     * @return nodo predecesor
     */
    public Nodo getAnterior() {
        return anterior;
    }
    /**
     * Asigna al valor anterior del objeto actual el nodo entrante
     * @param anterior nodo predecesor del objeto actual
     */
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
     /**
     * Retorna el nodo sucesor del objeto actual
     * @return nodo sucesor
     */
    public Nodo getSiguiente() {
        return siguiente;
    }
    /**
     * Asigna al valor siguiente del objeto actual el nodo entrante
     * @param siguiente nodo sucesor del objeto actual
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
