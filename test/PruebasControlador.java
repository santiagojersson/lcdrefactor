/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import refactor.Logica.Controlador;
import refactor.Logica.LCDInit;

/**
 *
 * @author Santiago
 */
public class PruebasControlador {
    
    Controlador controlador = new Controlador();
    LCDInit init= new LCDInit();
    
   @Test
   public void pruebaMetodoProcesarCadenaNoValida(){
       String cadena="1222";
       int espacioDig=2;
       try {
           controlador.procesar(cadena, espacioDig);
       } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("Cadena " + cadena
                    + " no contiene caracter ,"));
       }
   }
   
   @Test
   public void pruebaMetodoProcesarCadenaMayor(){
       String cadena = "12,34,56";
       int espacioDig=2;
       try {
           controlador.procesar(cadena, espacioDig);
       } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("Cadena " + cadena
                    + " contiene mas caracter ,"));
       }
   }
   
   @Test
   public void PruebaMetodoProcesarCadenaMenor(){
       String cadena = "12,";
       int espacioDig=2;
       try {
           controlador.procesar(cadena, espacioDig);
       } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("Cadena " + cadena
                    + " no contiene los parametros requeridos"));
       }
   }
   
   @Test
   public void PruebaMetodoIsNumeric(){
       String cadena_1= "A";
       assertFalse(Controlador.isNumeric(cadena_1));
       String cadena_2= "1";
       assertTrue(Controlador.isNumeric(cadena_2));
   }
   
   @Test
   public void PruebaMetodoManejo(){
       char[] cadena={'1','2','R'};
       try {
           controlador.manejo(cadena);
       } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("Caracter " + cadena[2]
                    + " no es un digito"));
       }
   }
   
   @Test
    public void PruebaMetodoVerificarEspacioEntre0y5(){
        String entrada= "9";
        try {
           init.verificarEspacio(entrada);
       } catch (IllegalArgumentException ex) {
            assertThat(ex.getMessage(), is("El espacio entre "
                        + "digitos debe estar entre 0 y 5"));
       }
        
    }
}
