/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package refactor.Logica;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Santiago
 */
public class ImpresorLCD {
    
    public String[][] matrizImpr;
    public int size;
    
    
   
    // Calcula el numero de filasDig
    public int filasDig;
    public int columDig;
    public int totalFilas;
    public int totalColum;
    public int space;
    
    // Establece los segmentos de cada numero
    public List<Integer> segList = new ArrayList<>();
    
    
    
    public void adicionarLinea(int[] punto,
        int size, String caracter) {
        char opc= caracter.charAt(0);
        switch(opc){
            case '-': 
                for (int y = 1; y <= size; y++) 
                {   
                    int valor = punto[1] + y;
                    this.matrizImpr[punto[0]][valor] = caracter;
                    
                }
                break;
            case '|':
                for (int i = 1; i <= size; i++) 
                {
                    int valor = punto[0] + i;
                    this.matrizImpr[valor][punto[1]] = caracter;
                }
                break;
        }
    
    }
    
    public void setParametros(int size, String numeroImp,int espacio){
        this.size= size;
        this.space=espacio;
        
        
        // Calcula el numero de filas cada digito
        this.filasDig = (2 * this.size) + 3;
        
        // Calcula el numero de columna de cada digito
        this.columDig = this.size + 2;
       
        // Calcula el total de filas de la matriz en la que se almacenaran los digitos
        this.totalFilas = this.filasDig;
       
        // Calcula el total de columnas de la matriz en la que se almacenaran los digitos
        this.totalColum = (this.columDig * numeroImp.length())
                + (espacio * numeroImp.length());
      
        // crea matriz para almacenar los numero a imprimir
        this.matrizImpr = new String[this.totalFilas][this.totalColum];
        
        
        // Inicializa matriz
        for (int i = 0; i < this.totalFilas; i++) {
            for (int j = 0; j < this.totalColum; j++) {
                this.matrizImpr[i][j] = " ";
            }
        }
    }
}
