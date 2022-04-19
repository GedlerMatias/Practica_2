
package JuegoMemoria;

import Pokemones.ListaPokemones;
import Pokemones.Pokemones;
import java.awt.Color;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaMemoria extends JFrame{
    JLabel [] imagenes = new JLabel[151];
    private int contador;
    private JPanel panel;
    private JLabel prueba;
    private JTextField pruebaTexto;
    private Pokemones [] listaPokemones = new Pokemones[151];
    private Pokemones pokemonDelJugador;
    ListaPokemones generarPokemones = new ListaPokemones();
    
    public VentanaMemoria(){
        //guardar las imagenes de los pokemones
        imagenes = generarPokemones.imagenesPokemones();
        //configurar panel 
        setTitle("EXPLORANDO...");
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        
        iniciarComponentes();
    }
    
    public void iniciarComponentes(){
        
        panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(Color.red);
        panel.setLayout(null);
        getContentPane().add(panel);
        
        
        iniciarJuegoMemoria();
    }
    
    public void iniciarJuegoMemoria(){
        int numRandom1, numRandom2;
        Random random = new Random();
        numRandom1=random.nextInt(151);
        numRandom2 = numRandom1;
        
        System.out.println(numRandom1+ "---" + numRandom2);
        //https://www.youtube.com/watch?v=3yYX1QkK448
        //COPIAR LA MATRIZ DE NUMEROS ALEATORIOS REPETIDOS PARA HACER EL JUEGO
        
        
    }
}
