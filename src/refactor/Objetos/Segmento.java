
package refactor.Objetos;

import refactor.Logica.Controlador;
import refactor.Logica.ImpresorLCD;
import java.util.Iterator;

/**
 *
 * @author Santiago
 */
public class Segmento extends ImpresorLCD{
    
    private  int[] pf1;
    private  int[] pf2;
    private  int[] pf3;
    private  int[] pf4;
    private  int[] pf5;
    
    private final char POSICION_X = 'X';
    private final char POSICION_Y = 'Y';
    private final String CARACTER_VERTICAL = "|";
    private final String CARACTER_HORIZONTAL = "-";
    
    
    public Segmento(){
        // Inicializa variables
        this.pf1 = new int[2];
        this.pf2 = new int[2];
        this.pf3 = new int[2];
        this.pf4 = new int[2];
        this.pf5 = new int[2];
    }
    
    
   public void calcularPuntosFijos(int pivotX){
       
       this.pf1[0] = 0;
       this.pf1[1] = 0 + pivotX;
            
       this.pf2[0] = (Controlador.impresor.filasDig / 2);
       this.pf2[1] = 0 + pivotX;

       this.pf3[0] = (Controlador.impresor.filasDig - 1);
       this.pf3[1] = 0 + pivotX;

       this.pf4[0] = (Controlador.impresor.columDig - 1);
       this.pf4[1] = (Controlador.impresor.filasDig / 2) + pivotX;

       this.pf5[0] = 0;
       this.pf5[1] = (Controlador.impresor.columDig - 1) + pivotX;

       pivotX = pivotX + Controlador.impresor.columDig + space;
      
   }
   
    public void adicionarSegmento() {
        Iterator<Integer> iterator = Controlador.impresor.segList.iterator();

        while (iterator.hasNext()) {
            seleccionarSegmento(iterator.next());
        }
        
    }

    private void seleccionarSegmento(Integer segmento) {
        switch (segmento) {
            case 1:
                Controlador.impresor.adicionarLinea( this.pf1,
                        Controlador.impresor.size, this.CARACTER_VERTICAL);
                break;
            case 2:
                Controlador.impresor.adicionarLinea( this.pf2,
                        Controlador.impresor.size, this.CARACTER_VERTICAL);
                break;
            case 3:
                Controlador.impresor.adicionarLinea( this.pf5,
                        Controlador.impresor.size, this.CARACTER_VERTICAL);
                break;
            case 4:
                Controlador.impresor.adicionarLinea( this.pf4,
                        Controlador.impresor.size, this.CARACTER_VERTICAL);
                break;
            case 5:
                Controlador.impresor.adicionarLinea(this.pf1,
                        Controlador.impresor.size, this.CARACTER_HORIZONTAL);
                break;
            case 6:
                Controlador.impresor.adicionarLinea(this.pf2,
                        Controlador.impresor.size, this.CARACTER_HORIZONTAL);
                break;
            case 7:
                Controlador.impresor.adicionarLinea(this.pf3,
                        Controlador.impresor.size, this.CARACTER_HORIZONTAL);
                break;
            default:
                break;
        }
    }
    
    
}
