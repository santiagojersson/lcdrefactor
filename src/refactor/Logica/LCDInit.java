package refactor.Logica;


import refactor.Logica.Controlador;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class LCDInit {
    
    List<String> listaComando = new ArrayList<>();
    int espacioDig;
    
    public LCDInit() {
    }

    public void iniciar() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Espacio entre Digitos (0 a 5): ");
            String entrada = buffer.readLine();

            verificarEspacio(entrada);
            
            do
                {
                    System.out.print("Entrada: ");
                    entrada = buffer.readLine();
                    if(!entrada.equalsIgnoreCase("0,0"))
                    {
                        listaComando.add(entrada);
                    }
                }while (!entrada.equalsIgnoreCase("0,0")); 
            
            Controlador controlador= new Controlador();
            Iterator<String> iterator = listaComando.iterator();
            while (iterator.hasNext()) 
            {
                try 
                {
                    controlador.procesar(iterator.next(), espacioDig);
                } catch (Exception ex) 
                {
                    System.out.println("Error: "+ex.getMessage());
                }
            }

        } catch (Exception ex) {
            System.out.println("Error: "+ex.getMessage());
        }

    }

    public void verificarEspacio(String espacio) {
        
        if (Controlador.isNumeric(espacio)) {
            espacioDig = Integer.parseInt(espacio);

            // se valida que el espaciado este entre 0 y 5
            if (espacioDig < 0 || espacioDig > 5) {
                throw new IllegalArgumentException("El espacio entre "
                        + "digitos debe estar entre 0 y 5");
            }

        } else {
            throw new IllegalArgumentException("Cadena " + espacio
                    + " no es un entero");
        }
    }
}
