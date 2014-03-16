/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pablo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pablo López
 */
public class ExpresionesRegulares {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        String prueba="revierte tu peso";
//        Pattern p=Pattern.compile("("+prueba+")+");
//        Matcher m=p.matcher("revierte tu peso");
//        if(m.find()==true){
//            System.out.println("Posee spam");            
//        }
//        else{
//            System.out.println("Libre de spam");
//        }
        Lista lista=new Lista();
        try (BufferedReader lectorArchivo = new BufferedReader(new FileReader("Prueba.txt"))) {
            String mostrar = lectorArchivo.readLine();
            while (mostrar != null) {
                String[] dividir=mostrar.split("#");
                ArrayList<String> frases=new ArrayList<>();
                String[] dividirFrases=dividir[1].split(",");
                for(int i=0;i<dividirFrases.length;i++){
                    frases.add(dividirFrases[i]);
                }           
                
                lista.agregar(dividir[0], frases);
                mostrar = lectorArchivo.readLine();        
            }
//            lista.recorrer();
            ArrayList<String> probar=lista.buscarSpam("dinero extra tarjetas de credito agrandamiento");
            if(probar.isEmpty()==true){
            System.out.println("Libre de spam");
                
                
            }
            else{
            System.out.println("Posee spam: "); 
            Iterator<String> recorrerSpam=probar.iterator();
            while(recorrerSpam.hasNext()==true){
                System.out.println(recorrerSpam.next());
            }
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExpresionesRegulares.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExpresionesRegulares.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
