/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactor.Objetos;

import refactor.Logica.Controlador;
import refactor.Logica.ImpresorLCD;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import refactor.Objetos.Numero;

/**
 *
 * @author Santiago
 */
public class Digito extends ImpresorLCD{
    
    private Map<Integer, Numero> map = new HashMap<>();
    
    public Digito(){
        map.put(1, Numero.Uno);
        map.put(2, Numero.Dos);
        map.put(3, Numero.Tres);
        map.put(4, Numero.Cuatro);
        map.put(5, Numero.Cinco);
        map.put(6, Numero.Seis);
        map.put(7, Numero.Siete);
        map.put(8, Numero.Ocho);
        map.put(9, Numero.Nueve);
        map.put(0, Numero.Cero);
    }
    
    public void adicionarDigito(int numero) {
        List<Integer> segmentosList = new ArrayList<>();

        Controlador.impresor.segList= map.get(numero).getList(numero);
        
        
    }

}
