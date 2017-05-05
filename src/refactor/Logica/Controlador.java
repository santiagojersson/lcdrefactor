
package refactor.Logica;

import refactor.Objetos.Digito;
import refactor.Logica.ImpresorLCD;
import refactor.Objetos.Segmento;

/**
 *
 * @author Santiago
 */
public class Controlador {
    
    private Segmento segmento;
    private Digito digito;
    public static ImpresorLCD impresor;
    
    public Controlador(){
        this.segmento= new Segmento();
        this.digito= new Digito();
        this.impresor= new ImpresorLCD();
    }
    
    
    
    
    public void procesar(String comando, int espacioDig){
        String[] parametros;
       
        int tam;

        if (!comando.contains(",")) {
            throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene caracter ,");
        }
        
        //Se hace el split de la cadena
        parametros = comando.split(",");
        
        //Valida la cantidad de parametros
        if(parametros.length>2)
        {
           throw new IllegalArgumentException("Cadena " + comando
                    + " contiene mas caracter ,"); 
        }
        
        //Valida la cantidad de parametros
        if(parametros.length<2)
        {
           throw new IllegalArgumentException("Cadena " + comando
                    + " no contiene los parametros requeridos"); 
        }
        
        //Valida que el parametro size sea un numerico
        if(isNumeric(parametros[0]))
        {
            tam = Integer.parseInt(parametros[0]);
            
            // se valida que el size este entre 1 y 10
            if(tam <1 || tam >10)
            {
                throw new IllegalArgumentException("El parametro size ["+tam
                        + "] debe estar entre 1 y 10");
            }
        }
        else
        {
            throw new IllegalArgumentException("Parametro Size [" + parametros[0]
                    + "] no es un numero");
        }

        // Realiza la impresion del numero
        imprimirNumero(tam, parametros[1],espacioDig);
    }
    
    private void imprimirNumero(int size, String numeroImp, int espacio) 
    {
        
        char[] digitos;
        
        impresor.setParametros(size,numeroImp,espacio);
        // crea el arreglo de digitos
        digitos = numeroImp.toCharArray();
        manejo(digitos);
        // Imprime matriz
        for (int i = 0; i < impresor.totalFilas; i++) {
            for (int j = 0; j < impresor.totalColum; j++) {
                System.out.print(impresor.matrizImpr[i][j]);
            }
            System.out.println();
        }
    }
    
    
     /**
     *
     * Metodo encargado manejar el proceso de llenado en la matriz
     *
     * @param digitoso caracteres a imprimir
     */  
    public void manejo(char[] digitos){
        
        int pivotX = 0;
        for (char digito : digitos) {
            //Valida que el caracter sea un digito
            
            
            if( ! Character.isDigit(digito))
            {
                throw new IllegalArgumentException("Caracter " + digito
                    + " no es un digito");
            }
            int numero = Integer.parseInt(String.valueOf(digito));
            
            this.segmento.calcularPuntosFijos(pivotX);
            this.digito.adicionarDigito(numero);
            this.segmento.adicionarSegmento();
            pivotX = pivotX + this.impresor.columDig + this.impresor.space;
            
        }
    
    }
    
    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
