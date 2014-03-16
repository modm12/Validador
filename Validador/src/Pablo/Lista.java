/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pablo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Pablo López
 * @author Miguel Diaz
 * @version 1.2
 */
public class Lista {
    int size;
    Nodo cabeza=new Nodo();
    Nodo cola=new Nodo();

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo getCola() {
        return cola;
    }

    public void setCola(Nodo cola) {
        this.cola = cola;
    }
    /**
     * Metodo que al ser invocado retorna el tamaño del objeto actual
     * @return tamaño del objeto actual
     */
    public int getSize() {
        return size;
    }
    /**
     * Metodo que al ser invocado asigna un valor entero a size (tamaño) del objeto actual
     * @param size nuevo tamaño para el objeto actual
     */
    public void setSize(int size) {
        this.size = size;
    }
    /**
     * Constructor que inicializa tamaño del objeto actual en cero
     * Y enlaza el inicio de la lista con el final
     * @param tamAlfabeto
     */
    public Lista() {
        size=0;
        getCabeza().setSiguiente(getCola());
        getCola().setAnterior(getCabeza());
    }
       
    public void agregar(String categoria, ArrayList<String> frases) {
        if (getSize() == 0) {
            Nodo nuevo = new Nodo(categoria,frases,getCabeza(),getCola());
            getCabeza().setSiguiente(nuevo);
            getCola().setAnterior(nuevo);
                setSize(getSize() + 1);
        } else {
            Nodo iterador = getCabeza().getSiguiente();
            

            if (categoria.compareTo(iterador.getCategoria()) <= 0) {
                if (categoria.compareTo(iterador.getCategoria())< 0) {
                Nodo nuevo = new Nodo(categoria,frases,iterador.getAnterior(), iterador);
                iterador.getAnterior().setSiguiente(nuevo);
                iterador.setAnterior(nuevo);
                setSize(getSize() + 1);
                }
            } else {
                while (categoria.compareTo(iterador.getCategoria())>0&&iterador.getSiguiente() != cola) {
                    iterador = iterador.getSiguiente();
                }
                if (categoria.compareTo(iterador.getCategoria()) >= 0) {
                    if (categoria.compareTo(iterador.getCategoria()) > 0) {
                    Nodo nuevo = new Nodo(categoria,frases,iterador, iterador.getSiguiente());
                    iterador.getSiguiente().setAnterior(nuevo);
                    iterador.setSiguiente(nuevo);
                    setSize(getSize() + 1);
                    }   
                } else {
                    if(categoria.compareTo(iterador.getCategoria()) < 0){
                    Nodo nuevo = new Nodo(categoria,frases,iterador.getAnterior(), iterador);
                    iterador.getAnterior().setSiguiente(nuevo);
                    iterador.setAnterior(nuevo);
                    setSize(getSize() + 1);
                    }
                }
            }

        }
    }
    
    public void recorrer(){
        Nodo iterador=getCabeza().getSiguiente();
        while(iterador!=getCola()){
            Iterator<String> auxiliarE=iterador.getFrases().iterator();
            String transiciones="";
            while(auxiliarE.hasNext()==true){
                transiciones+=auxiliarE.next()+"\n";
            }
            System.out.println("--- "+iterador.getCategoria()+" ---");
            System.out.print(transiciones);
            iterador=iterador.getSiguiente();
        }
    }
    
    public ArrayList<String> buscarSpam(String texto){
        ArrayList<String> valores=new ArrayList<>();
        Nodo iterador=getCabeza().getSiguiente();
        while(iterador!=getCola()){
            Iterator<String> auxiliarE=iterador.getFrases().iterator();
            while(auxiliarE.hasNext()==true){
                String prueba=auxiliarE.next();
                Pattern p=Pattern.compile("("+prueba+")+");
                Matcher m=p.matcher(texto);
                if(m.find()==true){
                    valores.add(iterador.getCategoria());
                }
            }
            iterador=iterador.getSiguiente();
        }
        return valores;
    }
}