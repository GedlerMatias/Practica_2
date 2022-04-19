
package Tienda;

import Pokemones.ListaPokemones;
import Pokemones.Pokemones;
import java.awt.Color;
import java.awt.Font;
import Jugador.Jugador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaTienda extends JFrame{
    private Pokemones [] pokemones= new Pokemones[151];
    private Pokemones [] pokemonesJugador = new Pokemones[10];
    private ListaPokemones generarPokemones = new ListaPokemones();
    private int contadorPokemones = 0;
    private JTextField capturarOpcion;
    private int dinero;
    private JPanel panel;
    private JComboBox listaMascotasBox;
    private int numPokemon;
    private JLabel confirmarCompra;
    private JButton compra;
    private JButton salirTienda;
    private int y = 600;
    private JLabel etiquetaDinero;

    public VentanaTienda() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("BIENVENIDO A LA TIENDA");
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        
        
    }

    public Pokemones [] iniciarComponentes(int dinero, Pokemones [] pokemonesJugador){
        this.dinero = dinero;
        this.pokemonesJugador=pokemonesJugador;
        //lista de los 151 pokemones
        pokemones = generarPokemones.crearPokemones();
        panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(Color.red);
        panel.setLayout(null);
        getContentPane().add(panel);
        
        insertarEtiquetas();
        insertarBotones();
        insertarTexfields();
        accionarListeners();
        return pokemonesJugador;
    }
    
    public void insertarEtiquetas(){
        JLabel etiquetaTitulo = new JLabel("TIENDA:");
        etiquetaTitulo.setBounds(700, 0, 200, 43);
        etiquetaTitulo.setFont(new Font("serif", Font.PLAIN, 40));
        etiquetaTitulo.setForeground(Color.WHITE);
        panel.add(etiquetaTitulo);
        
        etiquetaDinero = new JLabel("ORO: " + dinero);
        etiquetaDinero.setBounds(1280, 10, 170, 40);
        etiquetaDinero.setFont(new Font("serif", Font.PLAIN, 30));
        etiquetaDinero.setOpaque(true);
        etiquetaDinero.setForeground(Color.BLACK);
        etiquetaDinero.setBackground(Color.CYAN);
        panel.add(etiquetaDinero);
        
        JLabel etiquetaNombresPokemones = new JLabel("PRECIO: 50 ORO c/u");
        etiquetaNombresPokemones.setBounds(100, 150, 300, 40);
        etiquetaNombresPokemones.setFont(new Font("serif", Font.PLAIN, 30));
        etiquetaNombresPokemones.setOpaque(true);
        etiquetaNombresPokemones.setForeground(Color.WHITE);
        etiquetaNombresPokemones.setBackground(Color.ORANGE);
        panel.add(etiquetaNombresPokemones);
        
        JLabel etiquetaCompra = new JLabel("INGRESA EL NUMERO DEL POKEMON:");
        etiquetaCompra.setBounds(30, 300, 550, 40);
        etiquetaCompra.setFont(new Font("serif", Font.PLAIN, 30));
        etiquetaCompra.setOpaque(true);
        etiquetaCompra.setForeground(Color.BLACK);
        etiquetaCompra.setBackground(Color.white);
        panel.add(etiquetaCompra);
        
    }
    
    public void insertarBotones(){
        String [] nombresMascotas = {};
        listaMascotasBox = new JComboBox(nombresMascotas);
        listaMascotasBox.setBounds(160, 230, 120, 35);
        panel.add(listaMascotasBox);
        int i =0;
        while(i < 151){
            listaMascotasBox.addItem((i+1)+ ". " + pokemones[i].getNombre());
            i++;
        }
        
        
        compra = new JButton("COMPRAR");
        compra.setBounds(90, 450, 250, 40);
        compra.setOpaque(true);
        compra.setBackground(java.awt.Color.BLUE);
        compra.setForeground(Color.WHITE);
        panel.add(compra);
        
        salirTienda = new JButton("REGRESAR");
        salirTienda.setBounds(650, 700, 250, 40);
        salirTienda.setOpaque(true);
        salirTienda.setBackground(java.awt.Color.BLUE);
        salirTienda.setForeground(Color.WHITE);
        panel.add(salirTienda);
        
        
    }
    
    public void insertarTexfields(){
        capturarOpcion = new JTextField();
        capturarOpcion.setBounds(130, 400, 200, 30);
        panel.add(capturarOpcion);
    }
   
    public void accionarListeners(){
        ActionListener  activarCompra = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                String numPokemonString;
                confirmarCompra = new JLabel();
                confirmarCompra.setBounds(130, y, 350, 35);
                 confirmarCompra.setText(""); 
                panel.add(confirmarCompra);
                numPokemonString=capturarOpcion.getText();
                numPokemon = Integer.parseInt(numPokemonString);
                if (numPokemon >= 1 && numPokemon <= 151){
                      if (dinero >= 50 && contadorPokemones < 10){  
                        //mostrar en un jlabel que no se `puede
                        confirmarCompra.setText("COMPRASTE A:" + pokemones[numPokemon-1].getNombre());
                        pokemonesJugador[contadorPokemones] = pokemones[numPokemon-1];
                        y = y + 35;
                        dinero = dinero - 50;
                        etiquetaDinero.setText("ORO: " + dinero);
                        System.out.println(numPokemon);
                        
                      } else{
                          confirmarCompra.setText("NO TIENES ORO/ESPACIO PARA COMPRAR");
                          
                      }

                } else{
                    System.out.println("error, numero invalido");    
                } 
            }
        };
        compra.addActionListener(activarCompra);
        
    
    }
    
    public int regresarDinero(){
        return dinero;
    }
}